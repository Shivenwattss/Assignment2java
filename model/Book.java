package library.model;

public class Book extends LibraryResource implements Printable {
    private String genre;

    public Book(int resourceId, String title, String author, String genre) {
        super(resourceId, title, author);
        this.genre = genre;
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 5.0;
    }

    @Override
    public void printDetails() {
        System.out.println("----- Book Details -----");
        displayBasicDetails();
        System.out.println("Type        : Book");
        System.out.println("Genre       : " + genre);
    }
}
