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
        lstAirports= Files.lines(Paths.get("C:\\Users\\arv\\Downloads\\airports.csv")).collect(Collectors.toList());
        lstCountries= Files.lines(Paths.get("C:\\Users\\arv\\Downloads\\countries.csv")).collect(Collectors.toList());
        lstAllNavaids= Files.lines(Paths.get("C:\\Users\\arv\\Downloads\\navaids.csv")).collect(Collectors.toList());
        lstAllRegions= Files.lines(Paths.get("C:\\Users\\arv\\Downloads\\regions.csv")).collect(Collectors.toList());
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

        lstAirports= Files.lines(Paths.get("C:\\Users\\arv\\Downloads\\airports.csv")).collect(Collectors.toList());
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
        List<String> filteredList=lstAirports.stream().filter(airport->airport.contains(airportName)).
                collect(Collectors.toList());
        Mockito.when(airportManagerService.listAirportsByName(airportName)).thenReturn(filteredList);
        List<String> listAirports =airportManager.listAirportsByName(airportName);
        assertNotEquals("Airport list by name can't be empty",0,listAirports.size());
    }


    /**
     * Test list airports by country.
     */
    @Test
    public void testListAirportsByCountry(){
        String countryName ="Maldives";
        String countryCode ="MV";
        List<String> filteredAirportsList= lstAirports.stream().filter(airport->airport.contains(countryCode)).collect(Collectors.toList());
        Mockito.when(airportsCountryService.getCountryDetailsByName(countryName)).thenReturn(countryCode);
        Mockito.when(airportManagerService.listAirportsByCountry(countryCode)).thenReturn(filteredAirportsList);
        List<String> listResult =airportManager.listAirportsByCountry(countryName);
        assertNotEquals("Airports by country can't be empty",0, listResult.size());
    }


    /**
     * Test list airports by runways.
     */
    @Test
    public void testListAirportsByRunways(){
    	String runway ="GRAVEL";
    	String runwayCode ="ZNC";
    	Mockito.when(airportRunwayService.getRunwayCodeByName(runway)).thenReturn(runwayCode);
    	List<String> lstFilteredAirports =lstAirports.stream().
    			filter(airport->airport.contains(runwayCode)).
    			collect(Collectors.toList());
    	Mockito.when(airportManagerService.listAirportsByRunways(runwayCode)).thenReturn(lstFilteredAirports);
    	
        List<String> lstResults =airportManager.listAirportsByRunways(runway);
        assertNotEquals("Airports by runway can't be empty", 0,lstResults.size());
    }


    /**
     * Test list airports by size.
     */
    @Test
    public void testListAirportsBySize(){
    	String sizeinft ="5068";
    	List<String> filteredList=lstAirports.stream().filter(airport->airport.contains(sizeinft)).collect(Collectors.toList());
    	Mockito.when(airportManagerService.listAirportsBySize(sizeinft)).thenReturn(filteredList);
    	List<String> lstResult =airportManager.listAirportsBySize(sizeinft);
        assertNotEquals("Airports list can't be empty", 0,lstResult.size());
    }


    /**
     * Find list airports by continents.
     */
    @Test
    public void findListAirportsByContinents(){
        String continentCode="AS";
        String continentName="Asia";
        Mockito.when(continentsService.getContinentByName(continentName)).thenReturn(continentCode);
        List<String> filteredAirportList=lstAirports.stream().filter(airport->airport.contains(continentCode)).collect(Collectors.toList());
        Mockito.when(airportManagerService.listAirportsByContinents(continentCode)).thenReturn(filteredAirportList);
        List<String> lstResults =airportManager.listAirportsByContinents(continentName);
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
