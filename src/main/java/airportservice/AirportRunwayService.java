package airportservice;

/**
 * The interface Airport runway service.
 * @author Arvind
 */
public interface AirportRunwayService {

	/**
	 * Gets runway code by name.
	 *
	 * @param runway the runway
	 * @return the runway code by name
	 */
	String getRunwayCodeByName(String runway);
}
