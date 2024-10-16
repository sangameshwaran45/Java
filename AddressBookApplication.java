import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber + ", Email Address: " + emailAddress;
    }
}

class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public void viewAllContacts() {
        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        }
    }

    public void searchContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println(contact.toString());
                return;
            }
        }
        System.out.println("Contact not found.");
    }
}

public class AddressBookApplication {
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Address Book Menu:");
            System.out.println("1. Add a new contact");
            System.out.println("2. View all contacts");
            System.out.println("3. Search for a contact by name");
            System.out.println("4. Exit the program");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.next();
                    System.out.print("Enter email address: ");
                    String emailAddress = scanner.next();
                    Contact contact = new Contact(name, phoneNumber, emailAddress);
                    addressBook.addContact(contact);
                    break;
                case 2:
                    addressBook.viewAllContacts();
                    break;
                case 3:
                    System.out.print("Enter name to search: ");
                    String searchName = scanner.next();
                    addressBook.searchContactByName(searchName);
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}