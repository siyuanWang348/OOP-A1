/**
 * 预约类：存储患者预约信息及关联的医生
 */
/**
 * Appointment class: stores patient appointment information and associated doctor
 */
public class Appointment {
    // Instance variables: patient name, patient phone number, appointment time slot, selected doctor (supports all subclass types)
    private String patientName;
    private String patientPhone;
    private String timeSlot;
    private HealthProfessional selectedDoctor; // Polymorphism: parent class reference points to subclass object

    // 1. Default constructor
    public Appointment() {
        this.patientName = "Not set";
        this.patientPhone = "Not set";
        this.timeSlot = "Not set";
        this.selectedDoctor = new HealthProfessional();
    }

    // 2. Full parameter constructor
    public Appointment(String patientName, String patientPhone, String timeSlot, HealthProfessional selectedDoctor) {
        this.patientName = patientName;
        this.patientPhone = patientPhone;
        this.timeSlot = timeSlot;
        this.selectedDoctor = selectedDoctor;
    }

    // Method to print all instance variables (including doctor details)
    public void printAppointmentDetails() {
        System.out.println("=== Appointment Information ===");
        System.out.println("Patient name: " + patientName);
        System.out.println("Patient phone: " + patientPhone);
        System.out.println("Appointment time slot: " + timeSlot);
        System.out.println("Treating doctor information:");
        // Polymorphism: call corresponding print method based on actual doctor type
        if (selectedDoctor instanceof GeneralPractitioner) {
            ((GeneralPractitioner) selectedDoctor).printGPDetails();
        } else if (selectedDoctor instanceof Pediatrician) {
            ((Pediatrician) selectedDoctor).printPediatricianDetails();
        } else {
            selectedDoctor.printDetails();
        }
    }

    // Getter and Setter (encapsulate attributes, support collection operations)
    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public HealthProfessional getSelectedDoctor() {
        return selectedDoctor;
    }

    public void setSelectedDoctor(HealthProfessional selectedDoctor) {
        this.selectedDoctor = selectedDoctor;
    }
}