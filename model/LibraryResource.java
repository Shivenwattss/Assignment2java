package library.model;

public abstract class LibraryResource {
    private int resourceId;
    private String title;
    private String author;

    protected static String libraryName = "Smart University Library";
    private static int totalResources = 0;

    public LibraryResource(int resourceId, String title, String author) {
        this.resourceId = resourceId;
        this.title = title;
        this.author = author;
        totalResources++;
    }

    public int getResourceId() {
        return resourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    protected void displayBasicDetails() {
        System.out.println("Resource ID : " + resourceId);
        System.out.println("Title       : " + title);
        System.out.println("Author      : " + author);
        System.out.println("Library     : " + libraryName);
    }

    public static void displayTotalResources() {
        System.out.println("Total Resources Created: " + totalResources);
    }

    public abstract double calculateFine(int overdueDays);
}
