package com.udemy.spring.springselenium.props;

import com.udemy.spring.springselenium.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class propsTest extends SpringBaseTestNGTest {

    @Autowired
    private ResourceLoader loader;
    @Test
    public void propTest() throws IOException {
     Properties properties = PropertiesLoaderUtils.loadAllProperties(String.valueOf(loader.getResource("classpath:my.properties")));

        System.out.println(
                properties
        );
    }
}
