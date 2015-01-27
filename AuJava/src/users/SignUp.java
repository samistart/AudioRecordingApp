package users;
/**
 * part of login/sign up library from  <a href="http://www.zentut.com/java-swing/simple-login-dialog/">zentut.com</a> 
 * not implemented due to refactoring.
 * 
 * @author Pietro Passarelli 
 *
 */
public class SignUp {
	public static boolean authenticate(String username, String password) {
        // hardcoded username and password
		if (username.equals("bob") && password.equals("secret")) {
            return true;
       }
        return true;
    }

}
