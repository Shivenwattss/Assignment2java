package library.util;

public final class InputValidator {

    private InputValidator() {
        // Prevent object creation
    }

    public static boolean isValidResourceId(int resourceId) {
        return resourceId > 0;
    }

    public static boolean isValidFineDays(int overdueDays) {
        return overdueDays >= 0;
    }

    public static void validateResourceId(int resourceId) {
        if (!isValidResourceId(resourceId)) {
            throw new IllegalArgumentException("Resource ID must be greater than 0.");
        }
    }

    public static void validateFineDays(int overdueDays) {
        if (!isValidFineDays(overdueDays)) {
            throw new IllegalArgumentException("Fine days must be greater than or equal to 0.");
        }
    }
}
