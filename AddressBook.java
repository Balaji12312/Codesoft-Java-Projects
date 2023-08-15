import java.io.*;
import java.util.*;

class Contact implements Serializable {
    private String Name;
    private String ContactNumber;
    private String Email;

    public Contact(String Name, String ContactNumber, String Email) {
        this.Name = Name;
        this.ContactNumber = ContactNumber;
        this.Email = Email;
    }

    public String getName() {
        return Name;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public String getEmail() {
        return Email;
    }

    
    public String toString() {
        return "Name: " + Name + ", Contact: " + ContactNumber + ", Email: " + Email;
    }
}

class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public List<Contact> searchContacts(String searchTerm) {
        List<Contact> searchResults = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().contains(searchTerm) ||
                contact.getContactNumber().contains(searchTerm) ||
                contact.getEmail().contains(searchTerm)) {
                searchResults.add(contact);
            }
        }
        return searchResults;
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }
}

class AddressBookApp {
    private static AddressBook addressBook = new AddressBook();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Anna Address Book System");
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contact");
            System.out.println("3. Search Contacts");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addContact();
                    break;
                case 2:
                    removeContact();
                    break;
                case 3:
                    searchContacts();
                    break;
                case 4:
                    displayAllContacts();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String Name = scanner.nextLine();

        System.out.print("Enter Contact number: ");
        String ContactNumber = scanner.nextLine();

        System.out.print("Enter email : ");
        String Email = scanner.nextLine();

        if (!Name.isEmpty() && !ContactNumber.isEmpty() && !Email.isEmpty()) {
            Contact contact = new Contact(Name, ContactNumber, Email);
            addressBook.addContact(contact);
            System.out.println("New Contact is added.");
        } else {
            System.out.println("Please Try Again.");
        }
    }

    private static void removeContact() {
        System.out.print("Enter name to remove: ");
        String nameToRemove = scanner.nextLine();
        List<Contact> searchResults = addressBook.searchContacts(nameToRemove);

        if (!searchResults.isEmpty()) {
            System.out.println("Matching contacts:");
            for (Contact contact : searchResults) {
                System.out.println(contact);
            }

            System.out.print("Enter the number of the contact to remove: ");
            int contactIndex = scanner.nextInt();
            scanner.nextLine();

            if (contactIndex >= 1 && contactIndex <= searchResults.size()) {
                Contact contactToRemove = searchResults.get(contactIndex - 1);
                addressBook.removeContact(contactToRemove);
                System.out.println("Contact removed successfully.");
            } else {
                System.out.println("Invalid contact number.");
            }
        } else {
            System.out.println("No matching contacts found.");
        }
    }

    private static void searchContacts() {
        System.out.print("Enter search term: ");
        String searchTerm = scanner.nextLine();
        List<Contact> searchResults = addressBook.searchContacts(searchTerm);

        if (!searchResults.isEmpty()) {
            System.out.println("Matching contacts:");
            for (Contact contact : searchResults) {
                System.out.println(contact);
            }
        } else {
            System.out.println("No matching contacts found.");
        }
    }

    private static void displayAllContacts() {
        List<Contact> contacts = addressBook.getAllContacts();
        if (!contacts.isEmpty()) {
            System.out.println("All contacts:");
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println((i + 1) + ". " + contacts.get(i));
            }
        } else {
            System.out.println("No contacts available.");
        }
    }
}