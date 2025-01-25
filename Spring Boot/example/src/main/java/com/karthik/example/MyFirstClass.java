package com.karthik.example;

import org.springframework.stereotype.Component;

//@Component
public class MyFirstClass {

    private String myVar;

    public MyFirstClass(String myVar) {
        this.myVar = myVar;
    }

    public String sayHello() {
        return "This is from MyFirstClass ===> "+myVar;
    }
}
