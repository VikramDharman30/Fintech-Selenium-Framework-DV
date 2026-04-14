package config;

import java.io.FileInputStream;
import java.util.Properties;

public class configReader {

    private static Properties prop;

    static {

        try {

            String env = System.getProperty("env");

            if (env == null) {
                env = "stage";
            }

            String path =
                    "src/test/resources/config-" + env + ".properties";

            FileInputStream fis =
                    new FileInputStream(path);

            prop = new Properties();
            prop.load(fis);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public static String getProperty(String key) {

        return prop.getProperty(key);

    }

}