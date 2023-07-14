package library.management.application;

public class Book {
    private String title;
    private Boolean isAvailable;

    public Book(String title){
        this.title = title;
        this.isAvailable = true;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }
}
