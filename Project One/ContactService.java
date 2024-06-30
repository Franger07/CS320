package module6;

import java.util.List;
import java.util.ArrayList;
import module6.Contact;


public class ContactService {
    
    private int currentIDNum = 0; 
    private List<Contact> contactList = new ArrayList<>();

    
    public void addContact(String firstName, String lastName, String phoneNumber, String address) {
        String stringID = Integer.toString(currentIDNum);
        Contact newContact = new Contact(stringID, firstName, lastName, phoneNumber, address);
        contactList.add(newContact);
        currentIDNum++;
    }

    
    public void deleteContact(String ID) {
        contactList.removeIf(contact -> contact.getContactID().equals(ID));
    }

    
    public void editFirstName(String contactID, String firstName) {
        contactList.stream()
                   .filter(contact -> contact.getContactID().equals(contactID))
                   .findFirst()
                   .ifPresent(contact -> contact.setFirstName(firstName));
    }

   
    public void editLastName(String contactID, String lastName) {
        contactList.stream()
                   .filter(contact -> contact.getContactID().equals(contactID))
                   .findFirst()
                   .ifPresent(contact -> contact.setLastName(lastName));
    }

  
    public void editNumber(String contactID, String phoneNumber) {
        contactList.stream()
                   .filter(contact -> contact.getContactID().equals(contactID))
                   .findFirst()
                   .ifPresent(contact -> contact.setPhoneNumber(phoneNumber));
    }

    
    public void editAddress(String contactID, String address) {
        contactList.stream()
                   .filter(contact -> contact.getContactID().equals(contactID))
                   .findFirst()
                   .ifPresent(contact -> contact.setAddress(address));
    }
}
