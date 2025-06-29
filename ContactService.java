package contact;

import java.util.HashMap;

public class ContactService {
    private HashMap<String, Contact> contactList = new HashMap<>();

    public void addContact(Contact contact) {
        if (contactList.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contactList.put(contact.getContactId(), contact);
    }

    public void deleteContact(String contactId) {
        if (!contactList.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact not found");
        }
        contactList.remove(contactId);
    }

    public void updateFirstName(String contactId, String firstName) {
        Contact c = contactList.get(contactId);
        if (c == null) throw new IllegalArgumentException("Contact not found");
        c.setFirstName(firstName);
    }

    public void updateLastName(String contactId, String lastName) {
        Contact c = contactList.get(contactId);
        if (c == null) throw new IllegalArgumentException("Contact not found");
        c.setLastName(lastName);
    }

    public void updatePhone(String contactId, String phone) {
        Contact c = contactList.get(contactId);
        if (c == null) throw new IllegalArgumentException("Contact not found");
        c.setPhone(phone);
    }

    public void updateAddress(String contactId, String address) {
        Contact c = contactList.get(contactId);
        if (c == null) throw new IllegalArgumentException("Contact not found");
        c.setAddress(address);
    }
}
