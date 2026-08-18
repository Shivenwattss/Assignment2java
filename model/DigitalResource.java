package library.model;

public class DigitalResource extends LibraryResource implements Printable {
    private String format;

    public DigitalResource(int resourceId, String title, String author, String format) {
        super(resourceId, title, author);
        this.format = format;
    }

    @Override
    public double calculateFine(int overdueDays) {
        return overdueDays * 2.0;
    }

    @Override
    public void printDetails() {
        System.out.println("----- Digital Resource Details -----");
        displayBasicDetails();
        System.out.println("Type        : Digital Resource");
        System.out.println("Format      : " + format);
    }
}
