package com.udemy.spring.springselenium.kelvin.config;

import com.udemy.spring.springselenium.kelvin.annotation.ThreadScopeBean;
import com.udemy.spring.springselenium.kelvin.annotation.LazyConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;

import java.net.URL;

@LazyConfiguration
@Profile("remote")
public class RemoteWebDriverConfig {

    @Value("${selenium.grid.url}")
    private URL url;


@ThreadScopeBean
@ConditionalOnProperty(name = "browser",havingValue = "chrome")
public WebDriver remoteChromeDrive(){
return new RemoteWebDriver(this.url, DesiredCapabilities.chrome());
    }

@ThreadScopeBean
@ConditionalOnMissingBean
    public WebDriver remoteFirefoxDrive(){
        return new RemoteWebDriver(this.url, DesiredCapabilities.firefox());
    }

}
