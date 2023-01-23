import homework4.general_tasks.GeneralTasks;
import homework4.phonebook.Notation;
import homework4.phonebook.PhoneBook;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GeneralTasks generalTasks = new GeneralTasks();

        System.out.println("test phone book: ");
        testPhoneBook();
    }

    private static void testPhoneBook() {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("James", 36666636);
        phoneBook.add("James", 36666636);
        phoneBook.add("James", 36666636);
        phoneBook.add("James", 366636);
        phoneBook.add("James", 4444);
        phoneBook.add("ames", 555555);
        phoneBook.add("James", 36666636);
        phoneBook.add("James", 36666636);

        List<Notation> contactsAll = phoneBook.getNotations();

        System.out.println("general contacts:");
        contactsAll.forEach(contact -> {
            System.out.println(contact.getName() + ": " + contact.getPhone());
        });

        Notation contact = phoneBook.find("James");
        System.out.println("test find: " + (contact != null ? (contact.getName() + " " + contact.getPhone()) : "no found contact"));

        System.out.println("test find All: ");

        List<Notation> contacts = phoneBook.findAll("James");
        if (contacts != null) {
            System.out.println("contacts find: " + contacts.size());
            contacts.forEach(foundContact -> {
                System.out.println(foundContact.getName() + ": " + foundContact.getPhone());
            });
        } else {
            System.out.println("no found contacts");
        }
    }
}