package com.udemy.spring.springselenium;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Television {

    @Value("${tv.name:sony}")
    private String name;

    public Television(){
        System.out.println("Inside the constructor:" + this.name);
    }

    @PostConstruct
    private void init(){
        System.out.println("Inside the constructor:" + this.name);
        System.out.println("Tv is turned on.....");
    }

    public void playMovie(){

        for (int i = 1; i <6 ; i++) {
            System.out.println("Playing scene" + i);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @PreDestroy
    public void turnOff(){
        System.out.println("The tv is turn off...");
    }
}
