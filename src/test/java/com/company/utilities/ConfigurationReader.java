package com.company.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    /**
     this util class is used to read values from configuration.properties file
     */

    private static Properties properties = new Properties();

    static {
        try {
            //Open the file using inputsteram
            FileInputStream fis = new FileInputStream("configuration.properties");

            //load to properties object
            properties.load(fis);

            //close the file after loading. Free up memory
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     Method is used to read value from configuration.properties file
     @param key -> key name in properties file
     @return -> value for the key. retunrs null if key not found
     EX: driver.get(ConfigurationReader.getProperty("url"));
     */

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
