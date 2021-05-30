package airportservice;

/**
 * The interface User service.
 * @author Arvind
 */
public interface UserService {
    /**
     * User login boolean.
     *
     * @param userName the user name
     * @param password the password
     * @return the boolean
     */
    boolean userLogin(String userName,String password);
}

