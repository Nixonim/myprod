package util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    private static final Properties PROPERTIES = new Properties();


    static {
        loadProperties();
    }
    private static void loadProperties() {
        try (InputStream properties = PropertiesUtil.class.getClassLoader().getResourceAsStream("properties")) {
            PROPERTIES.load(properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String get (String prop) {
        return PROPERTIES.getProperty(prop);
    }


}
