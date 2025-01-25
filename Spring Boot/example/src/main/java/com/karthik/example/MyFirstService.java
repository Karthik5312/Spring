package com.karthik.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    /*
    //Field Injection
    @Autowired
    @Qualifier("mySecondBean") // --> We can also use bean name in Qualifier
    private MyFirstClass myFirstClass;
    */

    private final MyFirstClass myFirstClass;

    //Constructor Injection --> most recommended
    public MyFirstService(
            //@Qualifier("bean2") MyFirstClass myFirstClass // If no qualifier used then as per Primary that bean works
            MyFirstClass myFirstClass
    ) {
        this.myFirstClass = myFirstClass;
    }

    /*
    //Method injection
    @Autowired
    public void injectDependency(MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }
    */

    /*
    //Setter Injection
    @Autowired
    public void setMyFirstClass(MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }
    */

    public String tellStory() {
        return "This dependency says : " + myFirstClass.sayHello();
    }

}
