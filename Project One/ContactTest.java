
package module6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactTest{

    
    @DisplayName("Test a valid Constructor")
    @Test
    public void testGoodConstructor() {
        String contactId = "1";
        String firstName = "brito";
        String lastName = "franger";
        String phoneNumber = "1234567891";
        String address = "123 jonh Street";
        
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);
        
        assertEquals(contactId, testContact.getContactID());
        assertEquals(firstName, testContact.getFirstName());
        assertEquals(lastName, testContact.getLastName());
        assertEquals(phoneNumber, testContact.getPhoneNumber());
        assertEquals(address, testContact.getAddress());
    }
    
    
    @DisplayName("Test an invalid Constructor")
    @Test
    public void testBadConstructor() {
        String badID = null;
        
        String firstName = "brito";
        String lastName = "franger";
        String address = "123 jonh Street";       
        
        
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(badID, firstName, lastName, "1234567890", address);
        });
        
        assertEquals("Invalid contact ID", exception.getMessage());
        
        
        exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("0", firstName, lastName, "1", address);
        });
        
        assertEquals("Invalid phone number", exception.getMessage());
    }
    
    
    @DisplayName("Test a valid setFirstName")
    @Test
    public void testGoodSetFirstName() {
        String contactId = "3";
        String firstName = "brito";
        String lastName = "franger";
        String phoneNumber = "1234567891";
        String address = "123 jonh Street";
        
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        testContact.setFirstName("Test");        
        assertEquals("Test", testContact.getFirstName());
    }
    
    
    @DisplayName("Test an invalid null setFirstName")
    @Test
    public void testBadSetFirstName() {
        String contactId = "3";
        String firstName = "brito";
        String lastName = "franger";
        String phoneNumber = "1234567891";
        String address = "123 jonh Street";
        
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testContact.setFirstName(null);
        });
    }
    
    
    @DisplayName("Test an invalid length setFirstName")
    @Test
    public void testLongSetFirstName() {
        String contactId = "3";
        String firstName = "brito";
        String lastName = "franger";
        String phoneNumber = "1234567891";
        String address = "123 jonh Street";
        
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testContact.setFirstName("IamWayTooLongOfAFirstName");
        });
    }

   
    @DisplayName("Test getID")
    @Test
    public void testGetID() {
        String contactId = "3";
        String firstName = "brito";
        String lastName = "franger";
        String phoneNumber = "1234567891";
        String address = "123 jonh Street";
        
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        assertEquals("3", testContact.getContactID());  // Corrected to return String
    }

    
    @DisplayName("Test an invalid null setLastName")
    @Test
    public void testBadSetLastName() {
        String contactId = "3";
        String firstName = "brito";
        String lastName = "franger";
        String phoneNumber = "1234567891";
        String address = "123 jonh Street";
        
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testContact.setLastName(null);
        });
    }

    
    @DisplayName("Test an invalid length setLastName")
    @Test
    public void testLongSetLastName() {
        String contactId = "3";
        String firstName = "brito";
        String lastName = "franger";
        String phoneNumber = "1234567891";
        String address = "123 jonh Street";
        
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testContact.setLastName("IamWayTooLongOfALastName");
        });
    }

   
    @DisplayName("Test a valid setLastName")
    @Test
    public void testGoodSetLastName() {
        String contactId = "3";
        String firstName = "brito";
        String lastName = "franger";
        String phoneNumber = "1234567891";
        String address = "123 jonh Street";
        
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        testContact.setLastName("Test");        
        assertEquals("Test", testContact.getLastName());
    }

    
    @DisplayName("Test an invalid null setPhoneNumber")
    @Test
    public void testBadSetPhoneNumber() {
        String contactId = "3";
        String firstName = "brito";
        String lastName = "franger";
        String phoneNumber = "1234567891";
        String address = "123 jonh Street";
        
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testContact.setPhoneNumber(null);
        });
    }

   
    @DisplayName("Test an invalid length setPhoneNumber")
    @Test
    public void testWrongLengthPhoneNumber() {
        String contactId = "3";
        String firstName = "brito";
        String lastName = "franger";
        String phoneNumber = "1234567891";
        String address = "123 jonh Street";
        
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testContact.setPhoneNumber("1");
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testContact.setPhoneNumber("123456789101112131415");
        });
    }

    
    @DisplayName("Test a valid length setPhoneNumber")
    @Test
    public void testGoodPhoneNumber() {
        String contactId = "3";
        String firstName = "brito";
        String lastName = "franger";
        String phoneNumber = "1234567891";
        String address = "123 jonh Street";
        
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   

        testContact.setPhoneNumber("1987654321");        
        assertEquals("1987654321", testContact.getPhoneNumber());
    }

    
    @DisplayName("Test an invalid null setAddress")
    @Test
    public void testNullSetAddress() {
        String contactId = "3";
        String firstName = "brito";
        String lastName = "franger";
        String phoneNumber = "1234567891";
        String address = "123 jonh Street";
        
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testContact.setAddress(null);
        });
    }

    
    @DisplayName("Test an invalid length setAddress")
    @Test
    public void testWrongLengthAddress() {
        String contactId = "3";
        String firstName = "brito";
        String lastName = "franger";
        String phoneNumber = "1234567891";
        String address = "123 jonh Street";
        
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testContact.setAddress("123456789 Address Too Long Street");
        });
    }

    
    @DisplayName("Test a valid length setAddress")
    @Test
    public void testGoodAddress() {
        String contactId = "3";
        String firstName = "brito";
        String lastName = "franger";
        String phoneNumber = "1234567891";
        String address = "123 jonh Street";
        
        Contact testContact = new Contact(contactId, firstName, lastName, phoneNumber, address);   

        testContact.setAddress("987 Good Address");        
        assertEquals("987 Good Address", testContact.getAddress());
    }
}
