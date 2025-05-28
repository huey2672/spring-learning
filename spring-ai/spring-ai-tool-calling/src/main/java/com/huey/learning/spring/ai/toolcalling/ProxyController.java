package com.huey.learning.spring.ai.toolcalling;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.concurrent.CompletableFuture;

@RestController
public class ProxyController {

    private static final String TARGET_URL = "https://api-inference.modelscope.cn/v1/chat/completions";
    private static final Set<String> EXCLUDED_HEADERS = Set.of(
            "host", "connection", "content-length", "transfer-encoding", "upgrade");

    @PostMapping("/v1/chat/completions")
    public DeferredResult<Void> vllm(HttpServletRequest request, HttpServletResponse response) {

        DeferredResult<Void> deferredResult = new DeferredResult<>();

        // 读取请求体
        StringBuilder requestBody = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                requestBody.append(line);
            }
        } catch (IOException e) {
            deferredResult.setErrorResult(e);
            return deferredResult;
        }

        // 打印请求头和请求体（可选）
        System.out.println("=== Request Headers ===");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            System.out.println(name + ": " + request.getHeader(name));
        }

        System.out.println("\n=== Request Body ===");
        System.out.println(requestBody);

        // 构建 HttpClient 请求
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create(TARGET_URL))
                .method("POST", HttpRequest.BodyPublishers.ofString(requestBody.toString()));

        // 添加非受限的 headers
        Enumeration<String> reqHeaderNames = request.getHeaderNames();
        while (reqHeaderNames.hasMoreElements()) {
            String name = reqHeaderNames.nextElement();
            if (!EXCLUDED_HEADERS.contains(name.toLowerCase())) {
                requestBuilder.header(name, request.getHeader(name));
            }
        }

        HttpRequest httpRequest = requestBuilder.build();

        // 异步发送请求并处理响应
        CompletableFuture<HttpResponse<InputStream>> future = client.sendAsync(httpRequest, HttpResponse.BodyHandlers.ofInputStream());

        future.thenAccept(res -> {
            try {
                // 设置响应头
                res.headers().map().forEach((key, values) ->
                        values.forEach(value -> response.addHeader(key, value)));

                // 设置状态码
                response.setStatus(res.statusCode());

                // 打印并写入响应体
                try (InputStream inputStream = res.body();
                     OutputStream outputStream = response.getOutputStream()) {

                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    ByteArrayOutputStream responseBodyCapture = new ByteArrayOutputStream();

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                        responseBodyCapture.write(buffer, 0, bytesRead);
                    }

                    System.out.println("\n=== Response Body ===");
                    System.out.println(responseBodyCapture.toString());
                }

                // 异步完成
                deferredResult.setResult(null);
            } catch (IOException e) {
                deferredResult.setErrorResult(e);
            }
        }).exceptionally(ex -> {
            ex.printStackTrace();
            deferredResult.setErrorResult(ex);
            return null;
        });

        return deferredResult;
    }
}
