package airport.helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

public class PropertyHelper {
    private static final Logger logger = LogManager.getLogger(PropertyHelper.class);

    private static final Properties properties = new Properties();
    private PropertyHelper(){

    }
    static {
        try {
            properties.load(PropertyHelper.class
                    .getClassLoader()
                    .getResourceAsStream("application.properties"));
        } catch (IOException e) {
            logger.error("Exception occurred while parsing properties file:",e.getCause());
        }
    }
    public static String getProperty(String key) {
        if (properties.containsKey(key)) {
            return properties.getProperty(key);
        } else {
            return "";
        }
    }
}
