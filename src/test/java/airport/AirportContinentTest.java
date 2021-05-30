package airport;

import airport.helpers.AirportContinent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * The type Airport continent test.
 * @author Arvind
 */
public class AirportContinentTest {
    private static final Logger logger = LogManager.getLogger(AirportContinentTest.class);

    /**
     * Init.
     */
    @Before
    public void init(){
    logger.info("Test case started.");
    }

    /**
     * Destroy.
     */
    @After
    public void destroy(){
    logger.info("Test case ended.");
    }

    /**
     * Test get enum by string.
     */
    @Test
    public void testGetEnumByString(){
        assertEquals("AS",AirportContinent.getEnumByString("Asia"));
    }
}
