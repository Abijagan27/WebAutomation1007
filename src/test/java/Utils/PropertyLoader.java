package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

    public class PropertyLoader {
        private Properties properties;

        public PropertyLoader(File filePath) {
            properties = new Properties();
            try (FileInputStream fis = new FileInputStream(filePath)) {
                properties.load(fis);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public String getProperty(String key) {
            return properties.getProperty(key);
        }
    }

