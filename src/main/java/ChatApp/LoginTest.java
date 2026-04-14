package ChatApp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    // =========================
    // assertEquals TESTS
    // =========================

    @Test
    public void testUsernameCorrectlyFormatted() {
        Login user = new Login("kyl_1", "Password1!", "+27838968976", "Kyle", "Smith");

        String expected = "Welcome Kyle Smith it is great to see you again.";
        assertEquals(expected, user.returnLoginStatus(true));
    }

    @Test
    public void testUsernameIncorrectlyFormatted() {
        Login user = new Login("kyle!!!!!!!", "Password1!", "+27838968976", "Kyle", "Smith");

        String expected = "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        assertEquals(expected, user.registerUser());
    }

    @Test
    public void testPasswordMeetsComplexity() {
        Login user = new Login("kyl_1", "Ch&&sec@ke99!", "+27838968976", "Kyle", "Smith");

        String expected = "Registration successful.";
        assertEquals(expected, user.registerUser());
    }

    @Test
    public void testPasswordDoesNotMeetComplexity() {
        Login user = new Login("kyl_1", "password", "+27838968976", "Kyle", "Smith");

        String expected = "Password must be 8+ characters with uppercase, number, and special character.";
        assertEquals(expected, user.registerUser());
    }

    @Test
    public void testCellPhoneCorrectFormat() {
        Login user = new Login("kyl_1", "Password1!", "+27838968976", "Kyle", "Smith");

        String expected = "Registration successful.";
        assertEquals(expected, user.registerUser());
    }

    @Test
    public void testCellPhoneIncorrectFormat() {
        Login user = new Login("kyl_1", "Password1!", "08966553", "Kyle", "Smith");

        String expected = "Cell number must follow format +27XXXXXXXXX.";
        assertEquals(expected, user.registerUser());
    }

    // =========================
    // assertTrue / assertFalse TESTS
    // =========================

    @Test
    public void testLoginSuccessful() {
        Login user = new Login("kyl_1", "Password1!", "+27838968976", "Kyle", "Smith");

        assertTrue(user.loginUser("kyl_1", "Password1!"));
    }

    @Test
    public void testLoginFailed() {
        Login user = new Login("kyl_1", "Password1!", "+27838968976", "Kyle", "Smith");

        assertFalse(user.loginUser("wrong", "wrong"));
    }

    @Test
    public void testUsernameValidTrue() {
        Login user = new Login("kyl_1", "Password1!", "+27838968976", "Kyle", "Smith");

        assertTrue(user.checkUserName());
    }

    @Test
    public void testUsernameInvalidFalse() {
        Login user = new Login("kyle!!!!!!!", "Password1!", "+27838968976", "Kyle", "Smith");

        assertFalse(user.checkUserName());
    }

    @Test
    public void testPasswordValidTrue() {
        Login user = new Login("kyl_1", "Password1!", "+27838968976", "Kyle", "Smith");

        assertTrue(user.checkPasswordComplexity());
    }

    @Test
    public void testPasswordInvalidFalse() {
        Login user = new Login("kyl_1", "password", "+27838968976", "Kyle", "Smith");

        assertFalse(user.checkPasswordComplexity());
    }

    @Test
    public void testCellPhoneValidTrue() {
        Login user = new Login("kyl_1", "Password1!", "+27838968976", "Kyle", "Smith");

        assertTrue(user.checkCellPhoneNumber());
    }

    @Test
    public void testCellPhoneInvalidFalse() {
        Login user = new Login("kyl_1", "Password1!", "08966553", "Kyle", "Smith");

        assertFalse(user.checkCellPhoneNumber());
    }
}