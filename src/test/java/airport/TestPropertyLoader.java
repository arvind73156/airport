package airport;

import airport.helpers.PropertyHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

/**
 * The type Test property loader.
 * @author Arvind
 */
public class TestPropertyLoader {
    private static final Logger logger = LogManager.getLogger(TestPropertyLoader.class);

    private static final Properties properties = new Properties();
    private TestPropertyLoader(){

    }
    static {
        try {
            properties.load(PropertyHelper.class
                    .getClassLoader()
                    .getResourceAsStream("application-test.properties"));
        } catch (IOException e) {
            logger.error("Exception occurred while parsing properties file:",e.getCause());
        }
    }


    /**
     * Gets property.
     *
     * @param key the key
     * @return the property
     */
    public static String getProperty(String key) {
        if (properties.containsKey(key)) {
            return properties.getProperty(key);
        } else {
            return "";
        }
    }
}
