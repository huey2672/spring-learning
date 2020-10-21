package com.huey.learning.spring.resources.resourceloader;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;

/**
 * @author huey
 */
public class ResourceLoaderSample {

    public static void main(String[] args) throws IOException {

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:spring/*-beans.xml");

        for (Resource resource : resources) {
            System.out.println(resource.getDescription());
        }

    }

}
