/**
 * 儿科医生子类（继承自HealthProfessional）
 * 新增独特属性：擅长年龄段（区别于全科医生）
 */
public class Pediatrician extends HealthProfessional {
    // 独特实例变量：擅长年龄段（如"0-12岁"）
    private String specializedAgeRange;

    // 1. 默认构造方法
    public Pediatrician() {
        super(); // 调用父类默认构造
        this.specializedAgeRange = "未设置";
    }

    // 2. 全参构造方法（含父类所有属性）
    public Pediatrician(int id, String name, String field, String specializedAgeRange) {
        super(id, name, field); // 调用父类全参构造
        this.specializedAgeRange = specializedAgeRange;
    }

    // 打印完整信息（含类型标识 + 父类属性）
    public void printPediatricianDetails() {
        System.out.println("=== 儿科医生信息 ===");
        super.printDetails(); // 调用父类打印方法（ID、姓名、专业领域）
        System.out.println("擅长年龄段：" + specializedAgeRange);
        System.out.println(); // 空行分隔，提升可读性
    }

    // Getter和Setter（封装独特属性）
    public String getSpecializedAgeRange() {
        return specializedAgeRange;
    }

    public void setSpecializedAgeRange(String specializedAgeRange) {
        this.specializedAgeRange = specializedAgeRange;
    }
}