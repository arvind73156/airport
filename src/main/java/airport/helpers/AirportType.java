package airport.helpers;

/**
 * The enum Airport type.
 * @author Arvind
 */
public enum AirportType {
    /**
     * Small airport airport type.
     */
    SMALL_AIRPORT,
    /**
     * Large airport airport type.
     */
    LARGE_AIRPORT,
    /**
     * Medium airport airport type.
     */
    MEDIUM_AIRPORT,
    /**
     * Ballon port airport type.
     */
    BALLON_PORT,
    /**
     * Closed airport type.
     */
    CLOSED,
    /**
     * Heliport airport type.
     */
    HELIPORT,
    /**
     * Seaplane base airport type.
     */
    SEAPLANE_BASE;
    private AirportType() {
        this.toString();
    }

    /**
     * Small airport string.
     *
     * @return the string
     */
    public String smallAirport() {
        return SMALL_AIRPORT.name().toLowerCase();
    }

    /**
     * Large airport string.
     *
     * @return the string
     */
    public String largeAirport() {
        return LARGE_AIRPORT.name().toLowerCase();
    }

    /**
     * Medium airport string.
     *
     * @return the string
     */
    public String mediumAirport() {
        return MEDIUM_AIRPORT.name().toLowerCase();
    }

    /**
     * Baloon port string.
     *
     * @return the string
     */
    public String baloonPort() {
        return BALLON_PORT.name().toLowerCase();
    }

    /**
     * Closed string.
     *
     * @return the string
     */
    public String closed() {
        return CLOSED.name().toLowerCase();
    }

    /**
     * Heliport string.
     *
     * @return the string
     */
    public String heliport() {
        return HELIPORT.name().toLowerCase();
    }

    /**
     * Seaplane base string.
     *
     * @return the string
     */
    public String seaplaneBase() {
        return SEAPLANE_BASE.name().toLowerCase();
    }
}
