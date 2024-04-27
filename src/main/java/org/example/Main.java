package org.example;

import org.example.client.Client;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    //виден только ПАССВОРД
    public static final String PASSWORD = "default";
    static final Scanner SCANNER = new Scanner(System.in);
    static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    static final String NAME_PATTERN = "[A-Za-z]{3,}"; // Minimum 3 letters

    public static void main(String[] args) {
        run();
    }

    static void run() {
        if (auth()) {
            registerNewClient();
        }
    }

    static boolean auth() {

        boolean accepted = false;

        for (int i = 0; i < 3; i++) {
            System.out.print("Password: ");
            String input = SCANNER.nextLine();

            if (PASSWORD.equals(input)) {
                accepted = true;
                break;
            } else {
                System.out.println("Access denied. Please check your password.");
            }
        }

        System.out.println(accepted ? "Welcome to the Magic Vet!" : "Application has been blocked.");

        return accepted;
    }

    static void registerNewClient() {

        System.out.println("Please provide client details.");

        String email;
        do {
            System.out.print("Email: ");
            email = SCANNER.nextLine();
            if (!isEmailValid(email)) {
                System.out.println("Invalid email format. Please enter a valid email address.");
            }
        } while (!isEmailValid(email));

        String firstName;
        do {
            System.out.print("First name: ");
            firstName = SCANNER.nextLine();
            if (!isValidName(firstName)) {
                System.out.println("Invalid name. Your name must contain only letters and be at least 3 characters long.");
            }
        } while (!isValidName(firstName));

        String lastName;
        do {
            System.out.print("Last name: ");
            lastName = SCANNER.nextLine();
            if (!isValidName(lastName)) {
                System.out.println("Invalid name. Your name must contain only letters and be at least 3 characters long.");
            }
        } while (!isValidName(lastName));

        //тут в клиенте дожен быть конструктор
        Client client = buildClient(email, firstName, lastName);
        System.out.println("New client: " + client.firstName + " " + client.lastName + " (" + client.email + ")");
    }

    static Client buildClient(String email, String firstName, String lastName) {
        //тут клиенту помогут сеттеры
        Client client = new Client();

        //client.setFirstName("Kva");

        client.email = email;
        client.firstName = firstName;
        client.lastName = lastName;
        return client;
    }

    static boolean isEmailValid(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    static boolean isValidName(String name) {
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }


}


