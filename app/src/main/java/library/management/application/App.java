package library.management.application;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Library library = new Library();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("welcome to the Library");
            System.out.println("Press 1 to add a Book");
            System.out.println("Press 2 to add a Client");
            System.out.println("Press 3 to borrow a Book");
            System.out.println("Press 4 to return a Book");
            System.out.println("Press 5 to quit");

            int selectedNumber = scanner.nextInt();
            scanner.nextLine();
            if (selectedNumber == 5) {
                break;
            }

            actions(library, scanner, selectedNumber);
        }

        scanner.close();
    }

    private static void actions(Library library, Scanner scanner, int selectedNumber) {
        switch (selectedNumber) {
            case 1:
                System.out.println("Enter the Title of the Book");
                Book book = new Book(scanner.nextLine());
                library.addBook(book);
                System.out.println(book.getTitle() + " added to the Library");
                break;

            case 2:
                System.out.println("Enter the Client's name");
                String clientName = scanner.nextLine();
                library.addClient(clientName);
                break;

            case 3:
                System.out.println("Enter the name of the Book");
                String name = scanner.nextLine();
                System.out.println("Enter Client's name");
                String client1 = scanner.nextLine();
                library.borrowBook(name, client1);
                break;

            case 4:
                System.out.println("Enter the name of the Book");
                String bookName = scanner.nextLine();
                System.out.println("Enter the Client's name");
                String clientName1 = scanner.nextLine();
                library.returnBook(bookName, clientName1);
                break;

            default:
                System.out.println("Invalid Choose");
                break;
        }
    }
}
