package library.management.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Client {
    private String name;
    private List<Book> borrowedBooks;

    public Client(String name) {
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void addToBorrowedList(Book book) {
        this.borrowedBooks.add(book);
    }

    public int getNumberOfBorrowedBooks() {
        return this.borrowedBooks.size();
    }

    public void removeFromBorrowedList(Book book) {
        this.borrowedBooks.remove(book);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Client client = (Client) obj;

        return Objects.equals(name, client.getName());
    }

    @Override
    public int hashCode(){
        return Objects.hash(name);
    }
}
