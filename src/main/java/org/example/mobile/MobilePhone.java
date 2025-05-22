package org.example.mobile;

import java.util.*;

public class MobilePhone {
    private String myNumber;
    private ArrayList<Contact> myContacts = new ArrayList<>();

    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<>(myContacts);
    }

    public String getMyNumber() {
        return myNumber;
    }

    public ArrayList<Contact> getMyContacts() {
        return myContacts;
    }

    public boolean addNewContact(Contact yeni) {
        if(!myContacts.contains(yeni)) {
            myContacts.add(yeni);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateContact(Contact eski, Contact yeni) {
        if (myContacts.contains(eski)) {
            myContacts.set(myContacts.indexOf(eski), yeni);
            return true;
        } else {
            return false;
        }
    }

    public boolean removeContact(Contact contact) {
        if (myContacts.contains(contact)) {
            myContacts.remove(contact);
            return true;
        } else {
            return false;
        }
    }
    public int findContact(Contact aranan) {
        if (myContacts.contains(aranan)) {
            return myContacts.indexOf(aranan);
        } else {
            return -1;
        }
    }
    public int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            if (myContacts.get(i).getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public Contact queryContact(String name) {
        for (Contact contact : myContacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public void printContact() {
        for (Contact contact : myContacts) {
            System.out.println(contact.getName() + " -> " + contact.getPhoneNumber());
        }
    }


}
