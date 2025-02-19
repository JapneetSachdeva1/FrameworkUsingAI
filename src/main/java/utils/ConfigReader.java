package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader
{
    private static Properties properties;
    private static final String CONFIG_PATH = "src/main/resources/config.properties";

    static {
        try {
            properties = new Properties();
            FileInputStream file = new FileInputStream(CONFIG_PATH);
            properties.load(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load config.properties file");
        }
    }

    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException(key + " not specified in config.properties file");
        }
        return value;
    }
}
