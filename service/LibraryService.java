package library.service;

import library.model.LibraryResource;
import library.model.Printable;
import library.util.InputValidator;

public class LibraryService {

    public void displayAllResources(LibraryResource[] resources) {
        System.out.println("\n========== ALL LIBRARY RESOURCES ==========");

        for (LibraryResource resource : resources) {
            if (resource instanceof Printable) {
                ((Printable) resource).printDetails();
                System.out.println();
            }
        }
    }

    public double calculateTotalFine(LibraryResource[] resources, int[] overdueDays) {
        if (resources.length != overdueDays.length) {
            throw new IllegalArgumentException(
                "Resources and overdue days must have the same length."
            );
        }

        double totalFine = 0.0;

        for (int i = 0; i < resources.length; i++) {
            InputValidator.validateFineDays(overdueDays[i]);
            totalFine += resources[i].calculateFine(overdueDays[i]);
        }

        return totalFine;
    }
}
