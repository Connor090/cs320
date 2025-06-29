package contact;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {

    @Test
    public void testContactCreationValid() {
        Contact c = new Contact("123", "Paul", "Rogers", "1234567890", "Fake Street");
        assertEquals("123", c.getContactId());
        assertEquals("John", c.getFirstName());
    }

    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "A", "B", "1234567890", "Test");
        });
    }

    @Test
    public void testTooLongFirstName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "LENGTHISTOOLONG", "Fail", "1234567890", "Street");
        });
    }

    @Test
    public void testInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("123", "Paul", "Rogers", "12345", "Street");
        });
    }

    @Test
    public void testSetters() {
        Contact c = new Contact("321", "Jane", "Smith", "0987654321", "56 Boom Ave");
        c.setFirstName("Janey");
        c.setLastName("S");
        c.setPhone("1112223333");
        c.setAddress("New Address");
        assertEquals("Janey", c.getFirstName());
    }
}
