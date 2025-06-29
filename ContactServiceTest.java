package contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

    private ContactService service;
    private Contact c;

    @BeforeEach
    public void setup() {
        service = new ContactService();
        c = new Contact("abc123", "Tom", "Hanks", "5556667777", "Hllywood Blvd");
        service.addContact(c);
    }

    @Test
    public void testAddContact() {
        Contact newContact = new Contact("xyz789", "Ella", "Fitz", "9998887777", "Jazz St");
        service.addContact(newContact);
        assertEquals("Ella", newContact.getFirstName());
    }

    @Test
    public void testAddDuplicateContact() {
        assertThrows(IllegalArgumentException.class, () -> service.addContact(c));
    }

    @Test
    public void testDeleteContact() {
        service.deleteContact("abc123");
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("abc123"));
    }

    @Test
    public void testUpdateFirstName() {
        service.updateFirstName("abc123", "Tim");
        assertEquals("Tim", c.getFirstName());
    }

    @Test
    public void testUpdateLastName() {
        service.updateLastName("abc123", "Cruise");
        assertEquals("Cruise", c.getLastName());
    }

    @Test
    public void testUpdatePhone() {
        service.updatePhone("abc123", "1112223333");
        assertEquals("1112223333", c.getPhone());
    }

    @Test
    public void testUpdateAddress() {
        service.updateAddress("abc123", "Mission Impossible HQ");
        assertEquals("Mission Impossible HQ", c.getAddress());
    }
}
