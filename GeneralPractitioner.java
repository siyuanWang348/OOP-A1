/**
 * 全科医生子类（继承自HealthProfessional）
 * 新增独特属性：每日接诊上限（区别于其他医生类型）
 */
public class GeneralPractitioner extends HealthProfessional {
    // 独特实例变量：每日接诊上限（如20人/天）
    private int dailyMaxPatients;

    // 1. 默认构造方法
    public GeneralPractitioner() {
        super(); // 调用父类默认构造
        this.dailyMaxPatients = 0;
    }

    // 2. 全参构造方法（含父类所有属性）
    public GeneralPractitioner(int id, String name, String field, int dailyMaxPatients) {
        super(id, name, field); // 调用父类全参构造
        this.dailyMaxPatients = dailyMaxPatients;
    }

    // 打印完整信息（含类型标识 + 父类属性）
    public void printGPDetails() {
        System.out.println("=== 全科医生信息 ===");
        super.printDetails(); // 调用父类打印方法（ID、姓名、专业领域）
        System.out.println("每日接诊上限：" + dailyMaxPatients + "人");
        System.out.println(); // 空行分隔，提升可读性
    }

    // Getter和Setter（封装独特属性）
    public int getDailyMaxPatients() {
        return dailyMaxPatients;
    }

    public void setDailyMaxPatients(int dailyMaxPatients) {
        this.dailyMaxPatients = dailyMaxPatients;
    }
}