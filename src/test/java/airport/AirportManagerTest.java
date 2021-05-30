package airport;

import airportservice.AirportManager;
import airportservice.AirportManagerService;
import airportservice.AirportRunwayService;
import airportservice.AirportsCountryService;
import airportservice.ContinentsService;
import org.junit.After;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * The type Airport manager test.
 * @author Arvind
 */
public class AirportManagerTest {


    /**
     * The Airport manager service.
     */
    AirportManagerService airportManagerService ;
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
     * The Airport manager.
     */
    AirportManager airportManager;

    /**
     * The Lst airports.
     */
    List<String> lstAirports =new ArrayList<>();

    /**
     * The Lst countries.
     */
    List<String> lstCountries =new ArrayList<>();

    /**
     * The Lst all navaids.
     */
    List<String> lstAllNavaids =new ArrayList<>();

    /**
     * The Lst all regions.
     */
    List<String> lstAllRegions =new ArrayList<>();


    /**
     * Init.
     *
     * @throws IOException the io exception
     */
    @Before
    public void init() throws IOException {


        airportManagerService= Mockito.mock(AirportManagerService.class);
        airportsCountryService= Mockito.mock(AirportsCountryService.class);
        continentsService= Mockito.mock(ContinentsService.class);
        airportRunwayService= Mockito.mock(AirportRunwayService.class);
        lstAirports= Files.lines(Paths.get(TestPropertyLoader.getProperty("airport_csv"))).collect(Collectors.toList());
        lstCountries= Files.lines(Paths.get(TestPropertyLoader.getProperty("country_csv"))).collect(Collectors.toList());
        lstAllNavaids= Files.lines(Paths.get(TestPropertyLoader.getProperty("navaids_csv"))).collect(Collectors.toList());
        lstAllRegions= Files.lines(Paths.get(TestPropertyLoader.getProperty("regions_csv"))).collect(Collectors.toList());
        airportManager =new AirportManager(airportManagerService,airportsCountryService,continentsService,airportRunwayService);


    }


    /**
     * Destroy.
     */
    @After
    public void destroy(){

        System.out.println("End  the test");
    }


    /**
     * Test list airports.
     *
     * @throws IOException the io exception
     */
    @Test
    public void testListAirports() throws IOException {

        Mockito.when(airportManagerService.listAirports()).thenReturn(lstAirports);
        List<String> listAirports =airportManager.listAirports();
        assertNotEquals("Airports list can't be empty/null",0,listAirports.size());

    }


    /**
     * Test list airports by name.
     */
    @Test
    public void testListAirportsByName(){
        String airportName ="Mys Shmidta Airport";
        List<String> filteredList=lstAirports.stream().
                filter(airport->airport.contains(TestPropertyLoader.getProperty("airport_name"))).
                collect(Collectors.toList());
        Mockito.when(airportManagerService.listAirportsByName(TestPropertyLoader.getProperty("airport_name"))).thenReturn(filteredList);
        List<String> listAirports =airportManager.listAirportsByName(TestPropertyLoader.getProperty("airport_name"));
        assertNotEquals("Airport list by name can't be empty",0,listAirports.size());
    }


    /**
     * Test list airports by country.
     */
    @Test
    public void testListAirportsByCountry(){

        List<String> filteredAirportsList= lstAirports.stream().
                filter(airport->airport.contains(TestPropertyLoader.getProperty("country_code"))).
                collect(Collectors.toList());
        Mockito.when(airportsCountryService.getCountryDetailsByName(TestPropertyLoader.getProperty("country_name"))).thenReturn(TestPropertyLoader.getProperty("country_code"));
        Mockito.when(airportManagerService.listAirportsByCountry(TestPropertyLoader.getProperty("country_code"))).thenReturn(filteredAirportsList);
        List<String> listResult =airportManager.listAirportsByCountry(TestPropertyLoader.getProperty("country_name"));
        assertNotEquals("Airports by country can't be empty",0, listResult.size());
    }


    /**
     * Test list airports by runways.
     */
    @Test
    public void testListAirportsByRunways(){
    	Mockito.when(airportRunwayService.getRunwayCodeByName(TestPropertyLoader.getProperty("airport_runway")))
                .thenReturn(TestPropertyLoader.getProperty("runway_code"));
    	List<String> lstFilteredAirports =lstAirports.stream().
    			filter(airport->airport.contains(TestPropertyLoader.getProperty("runway_code"))).
    			collect(Collectors.toList());
    	Mockito.when(airportManagerService.listAirportsByRunways(TestPropertyLoader.getProperty("runway_code"))).thenReturn(lstFilteredAirports);
    	
        List<String> lstResults =airportManager.listAirportsByRunways(TestPropertyLoader.getProperty("airport_runway"));
        assertNotEquals("Airports by runway can't be empty", 0,lstResults.size());
    }


    /**
     * Test list airports by size.
     */
    @Test
    public void testListAirportsBySize(){

    	List<String> filteredList=lstAirports.stream().
                filter(airport->airport.contains(TestPropertyLoader.getProperty("airport_sizeinft"))).
                collect(Collectors.toList());
    	Mockito.when(airportManagerService.listAirportsBySize(TestPropertyLoader.getProperty("airport_sizeinft"))).thenReturn(filteredList);
    	List<String> lstResult =airportManager.listAirportsBySize(TestPropertyLoader.getProperty("airport_sizeinft"));
        assertNotEquals("Airports list can't be empty", 0,lstResult.size());
    }


    /**
     * Find list airports by continents.
     */
    @Test
    public void findListAirportsByContinents(){
        Mockito.when(continentsService.getContinentByName(TestPropertyLoader.getProperty("continent_name"))).thenReturn(TestPropertyLoader.getProperty("continent_code"));
        List<String> filteredAirportList=lstAirports.stream().filter(airport->airport.contains(TestPropertyLoader.getProperty("continent_code").toString())).collect(Collectors.toList());
        Mockito.when(airportManagerService.listAirportsByContinents(TestPropertyLoader.getProperty("continent_code"))).thenReturn(filteredAirportList);
        List<String> lstResults =airportManager.listAirportsByContinents(TestPropertyLoader.getProperty("continent_name"));
        assertNotEquals("Aiports by continent can't be empty",0,lstResults.size());
    }

    /**
     * Test list all regions.
     */
    @Test
    public void testListAllRegions() {

        Mockito.when(airportManagerService.listAllRegions()).thenReturn(lstAllRegions);
        List<String> listAllRegions =airportManager.listAllRegions();
        assertNotEquals("Regions list can't be empty/null",0,listAllRegions.size());
    }


    /**
     * Test list all navaids.
     */
    @Test
    public void testListAllNavaids() {

        Mockito.when(airportManagerService.listAllNavaids()).thenReturn(lstAllNavaids);
        List<String> listAllNavaids =airportManager.listAllNavaids();
        assertNotEquals("Navaids list can't be empty/null",0,listAllNavaids.size());
    }


    /**
     * Test get random airport.
     */
    @Test
    public void testGetRandomAirport() {
        Optional<String> airport=lstAirports.stream().skip((int) (lstAirports.size() * Math.random())).findAny();
        Mockito.when(airportManagerService.getRandomAirport()).thenReturn(airport.get());
        String result =airportManager.getRandomAirport();
        assertNotNull("Airport data can't be null",result);

    }


    /**
     * Test list countries.
     */
    @Test
    public void testListCountries() {
        Mockito.when(airportManagerService.listAllCountries()).thenReturn(lstCountries);
        List<String> listCountries =airportManager.listAllCountries();
        assertNotEquals("Countries list can't be empty/null",0,listCountries.size());

    }

}
