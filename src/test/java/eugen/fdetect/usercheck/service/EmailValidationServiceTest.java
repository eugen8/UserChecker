package eugen.fdetect.usercheck.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class EmailValidationServiceTest {

    private final EmailValidationService emailValidationService = new EmailValidationService();

    @ParameterizedTest
    @CsvSource({
            "test@example.com,example.com",
            "eugen@gmail.com,gmail.com",
            "john@somesite.co.za,somesite.co.za",
            "star@domain.net,domain.net",
            "star+anotheruser@domain.net,domain.net"
    })
    void testValidEmailAddresses(String anEmail, String aDomain) {
        String domain = emailValidationService.validateEmail(anEmail);
        assertEquals(domain, aDomain);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "invalidemail.com",
            "user@invalidemail",
            "@missingusername.com",
            "user@invalid..com",
            "user@invalid.."
    })
    void testInvalidEmailAddresses(String email) {
        String domain = emailValidationService.validateEmail(email);
        assertNull(domain);
    }
}