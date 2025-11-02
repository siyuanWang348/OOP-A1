/**
 * 预约类：存储患者预约信息及关联的医生
 */
public class Appointment {
    // 实例变量：患者姓名、患者手机号、预约时间段、选中的医生（支持所有子类类型）
    private String patientName;
    private String patientPhone;
    private String timeSlot;
    private HealthProfessional selectedDoctor; // 多态：父类引用指向子类对象

    // 1. 默认构造方法
    public Appointment() {
        this.patientName = "未设置";
        this.patientPhone = "未设置";
        this.timeSlot = "未设置";
        this.selectedDoctor = new HealthProfessional();
    }

    // 2. 全参构造方法
    public Appointment(String patientName, String patientPhone, String timeSlot, HealthProfessional selectedDoctor) {
        this.patientName = patientName;
        this.patientPhone = patientPhone;
        this.timeSlot = timeSlot;
        this.selectedDoctor = selectedDoctor;
    }

    // 打印所有实例变量的方法（含医生详细信息）
    public void printAppointmentDetails() {
        System.out.println("=== 预约信息 ===");
        System.out.println("患者姓名：" + patientName);
        System.out.println("患者手机号：" + patientPhone);
        System.out.println("预约时间段：" + timeSlot);
        System.out.println("接诊医生信息：");
        // 多态：根据医生实际类型调用对应打印方法
        if (selectedDoctor instanceof GeneralPractitioner) {
            ((GeneralPractitioner) selectedDoctor).printGPDetails();
        } else if (selectedDoctor instanceof Pediatrician) {
            ((Pediatrician) selectedDoctor).printPediatricianDetails();
        } else {
            selectedDoctor.printDetails();
        }
    }

    // Getter和Setter（封装属性，支持集合操作）
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