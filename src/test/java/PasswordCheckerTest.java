import org.junit.Assert;
import org.junit.Test;

public class PasswordCheckerTest {
    PasswordCheckerTwo pc = new PasswordCheckerTwo();


    @Test
    public void passwordIsValid() throws PasswordCheckerTwo.PasswordException {
        Assert.assertTrue(pc.passwordIsValid("Manqasana@3"));

    }

    @Test
   public void passwordOK() throws PasswordCheckerTwo.PasswordException {
        boolean expected = true;
        Assert.assertEquals(expected,pc.passwordIsOK("Manqasana@3"));
    }

}