package airportservice;

/**
 * The interface Airports country service.
 * @author Arvind
 */
public interface AirportsCountryService {

    /**
     * Gets country details by name.
     *
     * @param countryName the country name
     * @return the country details by name
     */
     String getCountryDetailsByName(String countryName);
}
