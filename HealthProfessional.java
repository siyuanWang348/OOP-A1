/**
 * 健康专业人员基础类（父类）
 * 包含所有健康专业人员的通用属性和行为
 */
public class HealthProfessional {
    // 实例变量：ID（纯数字）、姓名、专业领域（通用属性）
    private int id; // 确保ID为纯数字（int类型天然满足）
    private String name;
    private String field; // 专业领域（如"内科"、"儿科"）

    // 1. 默认构造方法
    public HealthProfessional() {
        this.id = 0;
        this.name = "未设置";
        this.field = "未设置";
    }

    // 2. 全参构造方法
    public HealthProfessional(int id, String name, String field) {
        this.id = id;
        this.name = name;
        this.field = field;
    }

    // 打印所有实例变量的方法
    public void printDetails() {
        System.out.println("健康专业人员ID：" + id);
        System.out.println("姓名：" + name);
        System.out.println("专业领域：" + field);
    }

    // Getter和Setter（封装属性，支持子类访问和预约类使用）
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