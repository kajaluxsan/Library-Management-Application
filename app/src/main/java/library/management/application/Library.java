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

    public void borrowBook(String bookTitle, String clientName) {
        Book book = books.stream()
                .filter(b -> b.getTitle().equals(bookTitle)).findFirst().orElse(null);

        Client client = clients.stream()
                .filter(c -> c.getName().equals(clientName)).findFirst().orElse(null);

        if(book == null){
            System.out.println("book not found");
        } else if (client == null) {
            System.out.println("client not found");
        } else if (!book.getIsAvailable()){
            System.out.println("book not available");
        } else {
            borrowedBooks.put(book,client);
            client.addToBorrowedList(book);
            book.setIsAvailable(false);
            System.out.println(bookTitle + " borrowed by " + clientName);
        }
    }

    public void returnBook(Book book, Client client) {
        if (this.borrowedBooks.containsKey(book) && Boolean.TRUE.equals(!book.getIsAvailable())) {
            if (clients.contains(client) && borrowedBooks.get(book) == client) {
                book.setIsAvailable(true);
                borrowedBooks.remove(book);
                client.removeFromBorrowedList(book);
            }
        } else {
            System.out.println("unexpected Book-Title");
        }
    }

    public void addClient(String clientName) {
        boolean isNameUnique = clients.stream()
                .noneMatch(c -> c.getName().equals(clientName));

        if(isNameUnique){
            this.clients.add(new Client(clientName));
            System.out.println(clientName + " is added as a member of the Library");
        } else {
            System.out.println("A client with this name already exists. please use a unique name.");
        }
    }

    public void removeClient(Client client) {
        this.clients.remove(client);
    }
}
