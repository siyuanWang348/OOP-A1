/**
 * 全科医生子类（继承自HealthProfessional）
 */
/**
 * General Practitioner subclass (inherits from HealthProfessional)
 * Added unique attribute: daily maximum number of patients (different from other doctor types)
 */
public class GeneralPractitioner extends HealthProfessional {
    // Unique instance variable: daily maximum number of patients (e.g. 20 people/day)
    private int dailyMaxPatients;

    // 1. Default constructor
    public GeneralPractitioner() {
        super(); // Call parent class default constructor
        this.dailyMaxPatients = 0;
    }

    // 2. Full parameter constructor (including all parent class attributes)
    public GeneralPractitioner(int id, String name, String field, int dailyMaxPatients) {
        super(id, name, field); // Call parent class full parameter constructor
        this.dailyMaxPatients = dailyMaxPatients;
    }

    // Print complete information (including type identifier + parent class attributes)
    public void printGPDetails() {
        System.out.println("=== General Practitioner Information ===");
        super.printDetails(); // Call parent class print method (ID, Name, Field)
        System.out.println("Daily maximum patients: " + dailyMaxPatients + " people");
        System.out.println(); // Empty line separator for readability
    }

    // Getter and Setter (encapsulate unique attributes)
    public int getDailyMaxPatients() {
        return dailyMaxPatients;
    }

    public void setDailyMaxPatients(int dailyMaxPatients) {
        this.dailyMaxPatients = dailyMaxPatients;
    }
}