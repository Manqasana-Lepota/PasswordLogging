import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordCheckerTwo {

    private static final String PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})";

    private final static Logger log = LogManager.getLogger(PasswordCheckerTwo.class.getName());

    public static void main(String[] args) throws Exception {

        String userPassword = "";

        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Please enter your password:");
            userPassword = sc.nextLine();

            System.out.println("Password : " + userPassword);
            passwordIsOK(userPassword);

        }
        catch (PasswordException ex) {
            log.error(ex.getMessage());
        }
    }

    public static boolean passwordIsValid(String password) throws PasswordException {

        if(password.isEmpty() || password.length() < 8) {
            throw new PasswordException("Oops! your password is too short , " + "" +
                    "password should be longer than 8 characters.");
        }

        Pattern pattern = Pattern.compile(PATTERN);
        Matcher match = pattern.matcher(password);

        if (match.matches()) {
            return match.matches();
        }
        if (!password.matches(".*\\d.*")) {
            throw new PasswordException("Password should have at least one digit.");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new PasswordException("Password should have at least one uppercase.");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new PasswordException("Password should have at least one lowercase.");
        }
        if (!password.matches(".*[!@#$%^&*+=?-].*")) {
            throw new PasswordException("Password should have at least one special character.");
        }
        return false;
    }

    public static boolean passwordIsOK(String password) throws PasswordException {
        if(passwordIsValid(password)) {
            log.debug("User password is OK");
            return true;

        }
        else {
            log.debug("User password is not OK");
            return false;
        }
    }

    public static class PasswordException extends Exception {
        public PasswordException(String message){
            super("Invalid Password : " + message);
        }
    }
}


