
package module6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import module6.ContactService;

class ContactServiceTest {

    @AfterEach
    void tearDown() {
        ContactService.contactList.clear();
    }

    @DisplayName("Test addContact")
    @Test
    void testAddContact() {
        String firstName = "franger";
        String lastName = "brito";
        String phoneNumber = "1234567891";
        String address = "123 jonh Street";

        ContactService test = new ContactService();

        assertTrue(ContactService.contactList.isEmpty());

        test.addContact(firstName, lastName, phoneNumber, address);

        assertFalse(ContactService.contactList.isEmpty());
        assertEquals("0", ContactService.contactList.get(0).getContactID());
        assertEquals(firstName, ContactService.contactList.get(0).getFirstName());
        assertEquals(lastName, ContactService.contactList.get(0).getLastName());
        assertEquals(phoneNumber, ContactService.contactList.get(0).getPhoneNumber());
        assertEquals(address, ContactService.contactList.get(0).getAddress());
    }

    @DisplayName("Test deleteContact")
    @Test
    void testDeleteContact() {
        String firstName = "franger";
        String lastName = "brito";
        String phoneNumber = "1234567891";
        String address = "123 jonh Street";

        ContactService test = new ContactService();

        test.addContact(firstName, lastName, phoneNumber, address); 
        test.addContact(firstName, lastName, phoneNumber, address); 
        test.addContact(firstName, lastName, phoneNumber, address); 

        assertEquals(3, ContactService.contactList.size());

        test.deleteContact("1");

        assertEquals(2, ContactService.contactList.size());
        assertFalse(ContactService.contactList.stream().anyMatch(c -> c.getContactID().equals("1")));
    }

    @DisplayName("Test editing a phone number")
    @Test
    void testEditPhone() {
        String firstName = "franger";
        String lastName = "brito";
        String phoneNumber = "1234567891";
        String address = "123 jonh Street";

        ContactService test = new ContactService();
        test.addContact(firstName, lastName, phoneNumber, address);

        assertEquals(phoneNumber, ContactService.contactList.get(0).getPhoneNumber());

        test.editNumber("0", "1987654321");
        assertEquals("1987654321", ContactService.contactList.get(0).getPhoneNumber());
    }

    @DisplayName("Test editing a last name")
    @Test
    void testEditLast() {
        String firstName = "franger";
        String lastName = "brito";
        String phoneNumber = "1234567891";
        String address = "123 jonh Street";

        ContactService test = new ContactService();
        test.addContact(firstName, lastName, phoneNumber, address);

        assertEquals(lastName, ContactService.contactList.get(0).getLastName());

        test.editLastName("0", "Test_Last");
        assertEquals("Test_Last", ContactService.contactList.get(0).getLastName());
    }

    @DisplayName("Test editing a first name")
    @Test
    void testEditFirst() {
        String firstName = "franger";
        String lastName = "brito";
        String phoneNumber = "1234567891";
        String address = "123 jonh Street";

        ContactService test = new ContactService();
        test.addContact(firstName, lastName, phoneNumber, address);

        assertEquals(firstName, ContactService.contactList.get(0).getFirstName());

        test.editFirstName("0", "Test_First");
        assertEquals("Test_First", ContactService.contactList.get(0).getFirstName());
    }

    @DisplayName("Test editing an address")
    @Test
    void testEditAddress() {
        String firstName = "franger";
        String lastName = "brito";
        String phoneNumber = "1234567891";
        String address = "123 jonh Street";

        ContactService test = new ContactService();
        test.addContact(firstName, lastName, phoneNumber, address);

        assertEquals(address, ContactService.contactList.get(0).getAddress());

        test.editAddress("0", "Test_Address");
        assertEquals("Test_Address", ContactService.contactList.get(0).getAddress());
    }

    @DisplayName("Test editing a non-existent contact ID for address")
    @Test
    void testEditBadAddress() {
        String firstName = "franger";
        String lastName = "brito";
        String phoneNumber = "1234567891";
        String address = "123 jonh Street";

        ContactService test = new ContactService();
        test.addContact(firstName, lastName, phoneNumber, address);

        test.editAddress("3", "Test_Address");

        
        assertTrue(ContactService.contactList.stream()
                .noneMatch(c -> c.getAddress().equals("Test_Address")));
    }

    @DisplayName("Test editing a non-existent contact ID for first name")
    @Test
    void testEditBadFirstName() {
        String firstName = "franger";
        String lastName = "brito";
        String phoneNumber = "1234567891";
        String address = "123 jonh Street";

        ContactService test = new ContactService();
        test.addContact(firstName, lastName, phoneNumber, address);

        test.editFirstName("3", "Test_First");

        
        assertTrue(ContactService.contactList.stream()
                .noneMatch(c -> c.getFirstName().equals("Test_First")));
    }

    @DisplayName("Test editing a non-existent contact ID for last name")
    @Test
    void testEditBadLastName() {
        String firstName = "franger";
        String lastName = "brito";
        String phoneNumber = "1234567891";
        String address = "123 jonh Street";

        ContactService test = new ContactService();
        test.addContact(firstName, lastName, phoneNumber, address);

        test.editLastName("3", "Test_Last");

        
        assertTrue(ContactService.contactList.stream()
                .noneMatch(c -> c.getLastName().equals("Test_Last")));
    }

    @DisplayName("Test editing a non-existent contact ID for phone number")
    @Test
    void testEditBadNumber() {
        String firstName = "franger";
        String lastName = "brito";
        String phoneNumber = "1234567891";
        String address = "123 jonh Street";

        ContactService test = new ContactService();
        test.addContact(firstName, lastName, phoneNumber, address);

        test.editNumber("3", "9876543210");

        
        assertTrue(ContactService.contactList.stream()
                .noneMatch(c -> c.getPhoneNumber().equals("9876543210")));
    }
}
