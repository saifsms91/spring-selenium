package com.udemy.spring.springselenium.resource;

import com.udemy.spring.springselenium.SpringBaseTestNGTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ResourceTest extends SpringBaseTestNGTest {

//   // @Value("classpath:data/testdata.csv")
//   @Value("https://www.google.com")
//
//   // @Value("file:C:\\Users\\siddis11\\IdeaProjects\\spring-selenium\\src\\test\\resources\\data\\testdata.csv")
//    private Resource resource;
//
//    @Test
//    public void resourceTest() throws IOException {
//       // Files.readAllLines(resource.getFile().toPath()).forEach(System.out::println);
//
//        System.out.println(
//               new String (resource.getInputStream().toString())
//        );
//    }
@Value("classpath:data/testdata.csv")
private Resource resource;
    @Value("${screenshot.path}")
    private Path path;

    @Autowired
    private ResourceLoader resourceLoader;

    @Test(dataProvider = "getData")
    public void resourceTest(String url, String saveAs) throws IOException {
        FileCopyUtils.copy(
                resourceLoader.getResource(url).getInputStream(),
                Files.newOutputStream(path.resolve(saveAs))
        );
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        return Files.readAllLines(resource.getFile().toPath())
                .stream()
                .map(s -> s.split(","))
                .toArray(Object[][]::new);
    }
}
