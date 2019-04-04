package ru.eltex.shoppingcustomer;

import java.io.Serializable;
import java.util.Scanner;
import java.util.UUID;

public class Credentials implements Serializable {
    private UUID id;
    private String firstname;
    private String lastname;
    private String patronymic;
    private String eMail;

    public Credentials(String firstname, String lastname, String patronymic, String eMail) {
        id = UUID.randomUUID();
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.eMail = eMail;
    }

    public Credentials()
    {
        id = UUID.randomUUID();
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public void setPatronymic(String patronymic)
    {
        this.patronymic = patronymic;
    }

    public void setMail(String eMail)
    {
        this.eMail = eMail;
    }

    public void showData() {
        System.out.println("\nUser:");
        System.out.println("ID: " + id);
        System.out.println("Firstname: " + firstname);
        System.out.println("Lastname: " + lastname);
        System.out.println("Patronymic: " + patronymic);
        System.out.println("EMail: " + eMail);
    }

    public void updateData() {
        Scanner in = new Scanner(System.in);
        System.out.println("\nFirstname: ");
        firstname = in.next();
        System.out.println("Lastname: ");
        lastname = in.next();
        System.out.println("Patronymic: ");
        patronymic = in.next();
        System.out.println("EMail: ");
        eMail = in.next();
    }
}
