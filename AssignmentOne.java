import java.util.ArrayList;
import java.util.Iterator;

/**
 * Main class: Health service appointment system entry point
 * Contains main method, demonstrates all module functions
 */
public class AssignmentOne {
    // Static ArrayList: stores all appointments (globally accessible)
    private static ArrayList<Appointment> appointmentList = new ArrayList<>();

    public static void main(String[] args) {
        // ==================== Part 3 – Using classes and objects ====================
        System.out.println("=================== Part 3: Health Professional Instances ====================");
        // 1. Create 3 general practitioner instances
        GeneralPractitioner gp1 = new GeneralPractitioner(101, "Dr. Zhang", "General Practice", 25);
        GeneralPractitioner gp2 = new GeneralPractitioner(102, "Dr. Li", "General Practice", 20);
        GeneralPractitioner gp3 = new GeneralPractitioner(103, "Dr. Wang", "General Practice", 18);

        // 2. Create 2 pediatrician instances
        Pediatrician pedia1 = new Pediatrician(201, "Dr. Liu", "Pediatrics", "0-3 years");
        Pediatrician pedia2 = new Pediatrician(202, "Dr. Chen", "Pediatrics", "4-12 years");

        // 3. Print all instance information
        gp1.printGPDetails();
        gp2.printGPDetails();
        gp3.printGPDetails();
        pedia1.printPediatricianDetails();
        pedia2.printPediatricianDetails();

        // Separator line
        System.out.println("------------------------------");

        // ==================== Part 5 – Collection of appointments ====================
        System.out.println("=================== Part 5: Appointment Collection Management ====================");
        // 1. Create 4 appointments (2 general practice + 2 pediatrics)
        createAppointment("Xiao Ming", "13800138000", "09:00", gp1);
        createAppointment("Xiao Hong", "13900139000", "10:30", gp2);
        createAppointment("Xiao Gang", "13700137000", "14:00", pedia1);
        createAppointment("Xiao Li", "13600136000", "15:30", pedia2);

        // 2. Print initial appointment list
        System.out.println("[Step 1: Print all appointments]");
        printExistingAppointments();

        // 3. Cancel an appointment (example: phone number 13900139000)
        System.out.println("[Step 2: Cancel appointment with phone number 13900139000]");
        cancelBooking("13900139000");

        // 4. Print updated appointment list
        System.out.println("[Step 3: Print appointments after cancellation]");
        printExistingAppointments();

        // Separator line
        System.out.println("------------------------------");
    }

    /**
     * Create appointment and add to collection
     * Validation logic: patient name, phone number, time slot, and doctor cannot be empty
     * @param patientName Patient's name
     * @param patientPhone Patient's phone number
     * @param timeSlot Appointment time slot
     * @param doctor Treating doctor (supports general practice/pediatrics and other subclasses)
     */
    public static void createAppointment(String patientName, String patientPhone, String timeSlot, HealthProfessional doctor) {
        // Validate required information
        if (patientName == null || patientName.trim().isEmpty()) {
            System.out.println("Creation failed: Patient name cannot be empty!");
            return;
        }
        if (patientPhone == null || patientPhone.trim().isEmpty() || !patientPhone.matches("\\d{11}")) {
            System.out.println("Creation failed: Phone number must be 11 digits!");
            return;
        }
        if (timeSlot == null || timeSlot.trim().isEmpty() || !timeSlot.matches("\\d{2}:\\d{2}")) {
            System.out.println("Creation failed: Time slot format error (example: 08:00)!");
            return;
        }
        if (doctor == null) {
            System.out.println("Creation failed: No treating doctor selected!");
            return;
        }

        // Validation passed: create appointment and add to collection
        Appointment newAppt = new Appointment(patientName, patientPhone, timeSlot, doctor);
        appointmentList.add(newAppt);
        System.out.println("Appointment created successfully! Patient: " + patientName);
    }

    /**
     * Print all existing appointments
     * Prompt "No appointment records" when there are no appointments
     */
    public static void printExistingAppointments() {
        if (appointmentList.isEmpty()) {
            System.out.println("No appointment records!");
            return;
        }

        System.out.println("There are currently " + appointmentList.size() + " appointment records:");
        for (int i = 0; i < appointmentList.size(); i++) {
            System.out.println("[Appointment " + (i + 1) + "]");
            appointmentList.get(i).printAppointmentDetails();
        }
    }

    /**
     * Cancel appointment by phone number
     * @param phone Patient's phone number
     */
    public static void cancelBooking(String phone) {
        // Use iterator for traversal (supports safe deletion)
        Iterator<Appointment> iterator = appointmentList.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Appointment appt = iterator.next();
            if (appt.getPatientPhone().equals(phone)) {
                iterator.remove(); // Safely remove current element
                System.out.println("Cancellation successful! Appointment with phone number " + phone + " has been deleted");
                found = true;
                break; // Assume one phone number corresponds to one appointment, exit after finding
            }
        }

        if (!found) {
            System.out.println("Cancellation failed: No appointment found with phone number " + phone);
        }
    }
}