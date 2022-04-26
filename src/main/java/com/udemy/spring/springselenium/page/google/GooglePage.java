package com.udemy.spring.springselenium.page.google;

import com.udemy.spring.springselenium.kelvin.annotation.Page;
import com.udemy.spring.springselenium.page.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

@Page
public class GooglePage extends Base {

    @Autowired
    private SearchComponent searchComponent;
    @Autowired
    private  SearchResult searchResult;
    public SearchComponent getSearchComponent() {
        return this.searchComponent;
    }

    @Value("${application.url}")
    private String url;
    public void goTo(){

        this.driver.get(url);
    }


    public SearchResult getSearchResult() {
        return this.searchResult;
    }


    @Override
    public boolean isAt() {
        return this.searchComponent.isAt();
    }

    public void close(){
        this.driver.quit();
    }
}
