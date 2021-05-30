package airport;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import airport.helpers.PropertyHelper;


/**
 * The type Property helper test.
 */
public class PropertyHelperTest {

	/**
	 * The Property helper.
	 */
	PropertyHelper propertyHelper;

	/**
	 * Init.
	 *
	 *
	 */
	@Before
    public void init() {


      propertyHelper =Mockito.mock(PropertyHelper.class);

    }

	/**
	 * Test get property.
	 */
	@Test
	public void testGetProperty() {
		String result=PropertyHelper.getProperty("airport");
		assertNotNull(result);
	}
}
