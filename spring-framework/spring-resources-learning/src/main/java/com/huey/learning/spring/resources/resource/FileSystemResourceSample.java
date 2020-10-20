package com.huey.learning.spring.resources.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @author zhengzs
 */
public class FileSystemResourceSample {

    public static void main(String[] args) throws IOException {
        Resource resource = new FileSystemResource("/etc/hosts");
        InputStream inStream = resource.getInputStream();
        String content = IOUtils.toString(inStream, Charset.defaultCharset());
        System.out.println(content);
    }

}
