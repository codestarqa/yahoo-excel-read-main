package com.yahoo.properties_reader;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadingProperties {
    private static volatile ReadingProperties propInstance;

    private ReadingProperties() {

    }

    public static synchronized ReadingProperties getInstance(){
        if (propInstance == null){
            propInstance = new ReadingProperties();
        }
        return propInstance;
    }

    public String getProperty(String propertyName){

        Properties prop = new Properties();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/test_runners_and_properties_files/config.properties");
            prop.load(inputStream);
            if (prop.getProperty(propertyName) != null){
                return prop.getProperty(propertyName);
            }
        } catch (Exception e) {
            System.out.println("Property not found");
        }
        return null;
    }
}
