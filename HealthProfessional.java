/**
 * 健康专业人员基础类（父类）
 */
/**
 * Health professional base class (parent class)
 * Contains common attributes and behaviors of all health professionals
 */
public class HealthProfessional {
    // Instance variables: ID (numeric only), name, field of expertise (common attributes)
    private int id; // Ensure ID is numeric (int type naturally satisfies this)
    private String name;
    private String field; // Field of expertise (e.g. "Internal Medicine", "Pediatrics")

    // 1. Default constructor
    public HealthProfessional() {
        this.id = 0;
        this.name = "Not set";
        this.field = "Not set";
    }

    // 2. Full parameter constructor
    public HealthProfessional(int id, String name, String field) {
        this.id = id;
        this.name = name;
        this.field = field;
    }

    // Method to print all instance variables
    public void printDetails() {
        System.out.println("Health Professional ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Field of expertise: " + field);
    }

    // Getter and Setter (encapsulate attributes, support subclass access and appointment class usage)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}