package airportservice;

import java.util.List;

/**
 * The interface Airport manager service.
 * @author Arvind
 */
public interface AirportManagerService {
    /**
     * List airports list.
     *
     * @return the list
     */
    public List<String> listAirports();

    /**
     * List airports by name list.
     *
     * @param airportName the airport name
     * @return the list
     */
    public List<String> listAirportsByName(String airportName);

    /**
     * List airports by country list.
     *
     * @param country the country
     * @return the list
     */
    public List<String> listAirportsByCountry(String country);

    /**
     * List airports by size list.
     *
     * @param size the size
     * @return the list
     */
    public List<String> listAirportsBySize(String size);

    /**
     * List airports by runways list.
     *
     * @param runway the runway
     * @return the list
     */
    public List<String> listAirportsByRunways(String runway);

    /**
     * List airports by helipads list.
     *
     * @param helipad the helipad
     * @return the list
     */
    public List<String> listAirportsByHelipads(String helipad);

    /**
     * List airports by continents list.
     *
     * @param continent the continent
     * @return the list
     */
    public List<String> listAirportsByContinents(String continent);

    /**
     * List all regions list.
     *
     * @return the list
     */
    public List<String> listAllRegions();

    /**
     * List all countries list.
     *
     * @return the list
     */
    public List<String> listAllCountries();

    /**
     * List all navaids list.
     *
     * @return the list
     */
    public List<String> listAllNavaids();

    /**
     * Gets random airport.
     *
     * @return the random airport
     */
    public String getRandomAirport();

}
