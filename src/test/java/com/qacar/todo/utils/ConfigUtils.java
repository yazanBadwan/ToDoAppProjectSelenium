package com.qacar.todo.utils;

import java.util.Properties;

public class ConfigUtils {
   private Properties properties;
   private static ConfigUtils configUtils;
    private ConfigUtils(){
        //to use terminal to do a dynamic test in different environment
        String env=System.getProperty("env","PRODUCTION");
       // properties = PropertiesUtils.loadProperties("src/test/java/com/qacar/todo/config/production.properties");

        switch (env){
            case "PRODUCTION":
                properties = PropertiesUtils.loadProperties("src/test/java/com/qacar/todo/config/production.properties");
                break;
            case "LOCAL":
                properties = PropertiesUtils.loadProperties("src/test/java/com/qacar/todo/config/local.properties");
                break;
            default:
                throw new RuntimeException("environment is not supported");
        }

    }
    public static ConfigUtils getInstance(){
        if(configUtils == null){
            configUtils=new ConfigUtils();
        }
        return configUtils;
    }

    public String getBaseUrl(){
        String prop= properties.getProperty("baseurl");
        if(prop != null) return prop;
        throw new RuntimeException("Could not find the base url in the property file");


    }
    public String getEmail(){
        String prop= properties.getProperty("email");
        if(prop != null) return prop;
        throw new RuntimeException("Could not find the Email in the property file");


    }
    public String getPassword(){
        String prop= properties.getProperty("password");
        if(prop != null) return prop;
        throw new RuntimeException("Could not find Password in the property file");


    }
}
