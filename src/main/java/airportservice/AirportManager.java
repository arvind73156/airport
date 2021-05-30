package airportservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;


/**
 * The type Airport manager.
 * @author Arvind
 * @version 1.0
 */
public class AirportManager{

    private static final Logger logger = LogManager.getLogger(AirportManager.class);

    /**
     * The Airport manager service.
     */
    AirportManagerService airportManagerService;

    /**
     * The Airports country service.
     */
    AirportsCountryService airportsCountryService;

    /**
     * The Continents service.
     */
    ContinentsService continentsService;
    /**
     * The Airport runway service.
     */
    AirportRunwayService airportRunwayService;


    /**
     * Instantiates a new Airport manager.
     *
     * @param airportManagerService  the airport manager service
     * @param airportsCountryService the airports country service
     * @param continentsService      the continents service
     * @param airportRunwayService   the airport runway service
     *
     */
    public AirportManager(AirportManagerService airportManagerService,
                          AirportsCountryService airportsCountryService,
                          ContinentsService continentsService,AirportRunwayService airportRunwayService){
        this.airportManagerService=airportManagerService;
        this.airportsCountryService=airportsCountryService;
        this.continentsService=continentsService;
        this.airportRunwayService=airportRunwayService;
    }


    /**
     * List airports list.
     *
     * @return the list
     */
    public List<String> listAirports(){
        logger.info("Enter inside listAirports() method.");

        return this.airportManagerService.listAirports();
    }


    /**
     * List airports by name list.
     *
     * @param airportName the airport name
     * @return the list
     */
    public List<String> listAirportsByName(String airportName) {
        logger.info("Enter inside findAirportsByName() method for airport:{}",airportName);
        return this.airportManagerService.listAirportsByName(airportName);
    }


    /**
     * List airports by country list.
     *
     * @param country the country
     * @return the list
     */
    public List<String> listAirportsByCountry(String country) {
        logger.info("Enter inside findAirportsByCountry() for country:{}",country);
        String countryDetails =this.airportsCountryService.getCountryDetailsByName(country);
        return this.airportManagerService.listAirportsByCountry(countryDetails);
    }


    /**
     * List airports by size list.
     *
     * @param size the size
     * @return the list
     */
    public List<String> listAirportsBySize(String size) {
        logger.info("Enter inside findAirportsBySize() with size:{}",size);

        return this.airportManagerService.listAirportsBySize(size);
    }


    /**
     * List airports by runways list.
     *
     * @param runway the runway
     * @return the list
     */
    public List<String> listAirportsByRunways(String runway) {
        logger.info("Enter inside findAirportsByRunways() for runway:{}",runway);
        String runwayCode =this.airportRunwayService.getRunwayCodeByName(runway);
        return this.airportManagerService.listAirportsByRunways(runwayCode);
    }


    /**
     * List airports by continents list.
     *
     * @param continentName the continent name
     * @return the list
     */
    public List<String> listAirportsByContinents(String continentName) {
        logger.info("Enter inside findAirportsByContinents() method for continent:{}",continentName);

        String continentCode= continentsService.getContinentByName(continentName);

        return this.airportManagerService.listAirportsByContinents(continentCode);
    }


    /**
     * List all regions list.
     *
     * @return the list
     */
    public List<String> listAllRegions(){

       return this.airportManagerService.listAllRegions();
    }


    /**
     * List all countries list.
     *
     * @return the list
     */
    public List<String> listAllCountries(){

        return this.airportManagerService.listAllCountries();
    }


    /**
     * List all navaids list.
     *
     * @return the list
     */
    public List<String> listAllNavaids(){

        return this.airportManagerService.listAllNavaids();
    }


    /**
     * Get random airport string.
     *
     * @return the string
     */
    public String getRandomAirport(){

        return this.airportManagerService.getRandomAirport();
    }

}
