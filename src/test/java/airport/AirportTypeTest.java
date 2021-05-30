package airport;

import airport.helpers.AirportType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The type AirportType enum methods test.
 * @author Arvind
 */
public class AirportTypeTest {
    private static final Logger logger = LogManager.getLogger(AirportTypeTest.class);

    /**
     * Init.
     */
    @Before
    public void init() {
        logger.info("Airport  type test started.");
    }

    /**
     * Destroy.
     */
    @After
    public void destroy() {
        logger.info("Airport  type test end.");
    }

    /**
     * Test baloon port.
     */
    @Test
    public void testBaloonPort() {
        assertEquals("ballon_port",AirportType.BALLON_PORT.baloonPort());

    }

    /**
     * Test small airport.
     */
    @Test
    public void testSmallAirport() {
        assertEquals("small_airport",AirportType.SMALL_AIRPORT.smallAirport());

    }

    /**
     * Test large airport.
     */
    @Test
    public void testLargeAirport() {
        assertEquals("large_airport",AirportType.LARGE_AIRPORT.largeAirport());

    }

    /**
     * Test medium airport.
     */
    @Test
    public void testMediumAirport() {
        assertEquals("medium_airport",AirportType.MEDIUM_AIRPORT.mediumAirport());

    }

    /**
     * Test closed.
     */
    @Test
    public void testClosed() {
        assertEquals("closed",AirportType.CLOSED.closed());

    }

    /**
     * Test heliport.
     */
    @Test
    public void testHeliport() {
        assertEquals("heliport",AirportType.HELIPORT.heliport());

    }

    /**
     * Test seaplane base.
     */
    @Test
    public void testSeaplaneBase() {
        assertEquals("seaplane_base",AirportType.SEAPLANE_BASE.seaplaneBase());

    }

}

