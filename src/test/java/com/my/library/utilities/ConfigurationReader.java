package com.my.library.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();
    //it is inaccessible from outside
    // it is static I want it to start first

    static {


        try {

            //open file in java memory
            FileInputStream file = new FileInputStream("configuration.properties");

            //load the file into properties object
            properties.load(file);
            file.close();

        } catch (IOException e) {
            System.out.println("file not found in configurationReader class");
            e.printStackTrace();
        }

    }

    //I wnat this method return me the "value" (string)
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);

    }
}
