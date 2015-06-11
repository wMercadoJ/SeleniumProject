package com.salesforce.dev.framework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Carlos Gonzales on 6/8/2015.
 */
public class Environment {

    private static Environment environment;
    private Properties properties;

    private Environment() {
        readFile();
    }

    public static Environment getInstance() {
        if (environment == null) {
            environment = new Environment();
        }
        return environment;
    }

    public void readFile() {
        File file = new File("gradle.properties");
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            properties = new Properties();
            properties.load(fileReader);
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getEnv(String key) {
        String env = System.getProperty(key);
        if (env == null) {
            env = properties.getProperty(key);
        }
        return env;
    }

    public String getPrimaryUser() {
        return getEnv("primaryUserName");
    }

    public String getPrimaryPassword() {
        return getEnv("primaryUserPassword");
    }

    public String getBrowser(){
        return getEnv("browser");
    }

}
