package com.udemy.spring.springselenium;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class User {

    @Autowired
    private Address address;

    @Autowired
    private Salary1 salary1;

//    @Autowired
//    public void setAddress(Address address) {
//        this.address = address;
//    }
//
//@Autowired
//    public void setSalary(Salary salary) {
//        this.salary = salary;
//    }



//    public User(Address address, Salary salary) {
//        this.address = address;
//        this.salary = salary;
//    }

    public void printDetails(){
        System.out.println("Address:" +this.address.getStreet());
        System.out.println("Salary:" +this.salary1.getAmount());
    }
}
