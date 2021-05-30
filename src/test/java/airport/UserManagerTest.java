package airport;

import airportservice.UserManager;
import airportservice.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;

/**
 * The type User manager test.
 * @author Arvind
 */
public class UserManagerTest {
    private static final Logger logger = LogManager.getLogger(UserManagerTest.class);
    /**
     * The User service.
     */
    UserService userService;
    /**
     * The User manager.
     */
    UserManager userManager;

    /**
     * Init.
     */
    @Before
    public void init(){
    logger.info("Init method called for usermanager test");
    userService = Mockito.mock(UserService.class);
    userManager =new UserManager(userService);

    }

    /**
     * Destroy.
     */
    @After
    public void destroy(){
        logger.info("Destroy method called.");
    }

    /**
     * Test validate user login.
     */
    @Test
    public void testValidateUserLogin(){
        String userName="test";
        String pwd ="password";
        Mockito.when(userService.userLogin(userName,pwd)).thenReturn(true);
        boolean actual =userManager.validateUserLogin(userName,pwd);
        assertTrue(actual);
    }
}
