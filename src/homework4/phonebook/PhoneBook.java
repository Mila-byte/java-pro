package homework4.phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private List<Notation> notations = new ArrayList<>();

    public List<Notation> getNotations() {
        return notations;
    }

    public void add(String name, int phone) {
        Notation notation = new Notation(name, phone);
        if (!notations.contains(notation)) {
            notations.add(notation);
        }
    }

    public Notation find(String name) {
        for (Notation notation : notations) {
            if (notation.getName().equals(name)) {
                return notation;
            }
        }
        return null;
    }

    public List<Notation> findAll(String name) {
        List<Notation> foundContacts = new ArrayList<>();
        for (Notation notation : notations) {
            if (notation.getName().equals(name)) {
                foundContacts.add(notation);
            }
        }
        if (foundContacts.size() != 0) {
            return foundContacts;
        } else {
            return null;
        }
    }
}
