package airportservice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The type User manager.
 * @author Arvind
 */
public class UserManager {
    private static final Logger logger = LogManager.getLogger(UserManager.class);

    /**
     * The User service.
     */
    UserService userService;

    /**
     * Instantiates a new User manager.
     *
     * @param userService the user service
     */
    public UserManager(UserService userService){
        this.userService=userService;
    }

    /**
     * Validate user login boolean.
     *
     * @param username the username
     * @param password the password
     * @return the boolean
     */
    public boolean validateUserLogin(String username,String password){
        logger.info("Enter inside validateUserLogin() method for user:{}",username);
        return this.userService.userLogin(username,password);
    }

}
