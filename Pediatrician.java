/**
 * 儿科医生子类（继承自HealthProfessional）
 */
/**
 * Pediatrician subclass (inherits from HealthProfessional)
 * Added unique attribute: specialized age range (different from general practitioners)
 */
public class Pediatrician extends HealthProfessional {
    // Unique instance variable: specialized age range (e.g. "0-12 years")
    private String specializedAgeRange;

    // 1. Default constructor
    public Pediatrician() {
        super(); // Call parent class default constructor
        this.specializedAgeRange = "Not set";
    }

    // 2. Full parameter constructor (including all parent class attributes)
    public Pediatrician(int id, String name, String field, String specializedAgeRange) {
        super(id, name, field); // Call parent class full parameter constructor
        this.specializedAgeRange = specializedAgeRange;
    }

    // Print complete information (including type identifier + parent class attributes)
    public void printPediatricianDetails() {
        System.out.println("=== Pediatrician Information ===");
        super.printDetails(); // Call parent class print method (ID, Name, Field)
        System.out.println("Specialized age range: " + specializedAgeRange);
        System.out.println(); // Empty line separator for readability
    }

    // Getter and Setter (encapsulate unique attributes)
    public String getSpecializedAgeRange() {
        return specializedAgeRange;
    }

    public void setSpecializedAgeRange(String specializedAgeRange) {
        this.specializedAgeRange = specializedAgeRange;
    }
}