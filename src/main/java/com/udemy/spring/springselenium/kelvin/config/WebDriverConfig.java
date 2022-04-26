package com.udemy.spring.springselenium.kelvin.config;

import com.udemy.spring.springselenium.kelvin.annotation.LazyConfiguration;
import com.udemy.spring.springselenium.kelvin.annotation.ThreadScopeBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

@LazyConfiguration
@Profile("!remote")
public class WebDriverConfig {



@ThreadScopeBean    //@Primary
    @ConditionalOnProperty(name="browser",havingValue="firefox")
    public WebDriver edgeDriver(){
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }


    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver chromeDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }



//    @Bean
//   public ScreenShotUtil screenShotUtil(){
//        return  new ScreenShotUtil();
//    }
}
