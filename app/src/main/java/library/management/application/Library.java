package library.management.application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Client> clients;
    private HashMap<Book, Client> borrowedBooks;

    public Library() {
        this.books = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.borrowedBooks = new HashMap<>();
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Client> getClients() {
        return clients;
    }

    public int getNumberOfClients() {
        return clients.size();
    }

    public HashMap<Book, Client> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        if (books.contains(book)) {
            books.remove(book);
        } else {
            System.out.println("Book not found");
        }
    }

    public void borrowBook(Book book, Client client) {
        if (this.books.contains(book) && book.getIsAvailable()) {
            if (this.clients.contains(client)) {
                book.setIsAvailable(false);
                this.borrowedBooks.put(book, client);
                client.addToBorrowedList(book);
            }
        } else {
            System.out.println("Book not available");
        }
    }

    public void returnBook(Book book, Client client) {
        if (this.borrowedBooks.containsKey(book) && !book.getIsAvailable()) {
            if (clients.contains(client) && borrowedBooks.get(book) == client) {
                book.setIsAvailable(true);
                borrowedBooks.remove(book);
                client.removeFromBorrowedList(book);
            }
        } else {
            System.out.println("unexpected Book-Title");
        }
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public void removeClient(Client client) {
        this.clients.remove(client);
    }
}
