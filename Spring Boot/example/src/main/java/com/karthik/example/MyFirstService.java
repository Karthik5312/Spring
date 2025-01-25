package com.karthik.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
//@PropertySource("classpath:custom.properties")
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom-2.properties")
})
public class MyFirstService {

    /*
    //Field Injection
    @Autowired
    @Qualifier("mySecondBean") // --> We can also use bean name in Qualifier
    private MyFirstClass myFirstClass;
    */

    private final MyFirstClass myFirstClass;

    @Value("${custom.property}")
    private String customProperty;

    @Value("${my.prop}")
    private String customPropertyFromAnotherFile;

    @Value("${custom-2.property}")
    private String custom_2_PropertyFromAnotherFile;

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

    private Environment environment;

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getJavaVersion() {
        return "Java version is : " + environment.getProperty("java.version");
    }

    public String getOsName() {
        return "OS is : " + environment.getProperty("os.name");
    }

    public String readProp() {
        return "Value of my.custom.property : " + environment.getProperty("my.custom.property");
    }

    public String tellStory() {
        return "This dependency says : " + myFirstClass.sayHello();
    }

    public String getCustomPropertyFromAnotherFile() {
        return "Value of my.prop from custom.properties : " + customPropertyFromAnotherFile;
    }

    public String getCustomProperty() {
        return "Value of custom.property from application.properties : " + customProperty;
    }

    public String getCustom_2_PropertyFromAnotherFile() {
        return "Value of custom-2.property from custom.properties : " + custom_2_PropertyFromAnotherFile;
    }
}
