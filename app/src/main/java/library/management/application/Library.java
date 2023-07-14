package library.management.application;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Client> clients;
    private HashMap<Book, Client> borrowedBooks;

    public Library(){
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

    public int getNumberOfClients(){
        return clients.size();
    }

    public HashMap<Book, Client> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addBook(String title){
        this.books.add(new Book(title));
    }

    public void removeBook(String title){
        Book book = new Book(title);
        if(books.contains(book)){
            books.remove(book);
        }else {
            System.out.println(title + "Book not found");
        }
    }

    public void borrowBook(String title, String clientName){
        Book book = new Book(title);
        Client client = new Client(clientName);
        if(this.books.contains(book) && book.getIsAvailable()){
            if(this.clients.contains(client)){
                book.setIsAvailable(false);
                this.borrowedBooks.put(book, client);
            }
        } else {
            System.out.println(title + "Book not available");
        }
    }

    public void returnBook(String title) {
        Book book = new Book(title);
        if(this.books.contains(book) && !book.getIsAvailable()){
            book.setIsAvailable(true);
        }else {
            System.out.println(title + "unexpected title" );
        }
    }


}
