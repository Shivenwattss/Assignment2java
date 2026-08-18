package library.main;

import library.model.Book;
import library.model.DigitalResource;
import library.model.LibraryResource;
import library.service.LibraryService;
import library.util.InputValidator;

public class LibraryManagementSystem {

    public static void main(String[] args) {

        // Validate Resource IDs before creating resources
        int[] resourceIds = {101, 102, 103, 201, 202};

        for (int id : resourceIds) {
            InputValidator.validateResourceId(id);
        }

        // Create at least five objects
        LibraryResource[] resources = {
            new Book(101, "Clean Code", "Robert C. Martin", "Programming"),
            new Book(102, "Java: The Complete Reference", "Herbert Schildt", "Programming"),
            new Book(103, "The Alchemist", "Paulo Coelho", "Fiction"),
            new DigitalResource(201, "Artificial Intelligence Basics", "Stuart Russell", "E-Book"),
            new DigitalResource(202, "Database Management Systems", "Raghu Ramakrishnan", "PDF")
        };

        // Overdue days corresponding to each resource
        int[] overdueDays = {5, 0, 3, 2, 10};

        LibraryService service = new LibraryService();

        System.out.println("==============================================");
        System.out.println("   SMART LIBRARY RESOURCE MANAGEMENT SYSTEM");
        System.out.println("==============================================");

        // Display total resources created
        LibraryResource.displayTotalResources();

        // Display complete details
        service.displayAllResources(resources);

        // Display individual fines
        System.out.println("========== FINE DETAILS ==========");

        double totalFine = 0.0;

        for (int i = 0; i < resources.length; i++) {
            InputValidator.validateFineDays(overdueDays[i]);

            double fine = resources[i].calculateFine(overdueDays[i]);
            totalFine += fine;

            System.out.printf(
                "%s | Resource ID: %d | Overdue Days: %d | Fine: Rs. %.2f%n",
                resources[i].getTitle(),
                resources[i].getResourceId(),
                overdueDays[i],
                fine
            );
        }

        System.out.println("----------------------------------------------");
        System.out.printf("TOTAL FINE OF ALL RESOURCES: Rs. %.2f%n", totalFine);
        System.out.println("==============================================");
    }
}
