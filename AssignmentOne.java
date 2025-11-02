import java.util.ArrayList;
import java.util.Iterator;

/**
 * 主类：健康服务预约系统入口
 * 包含main方法，实现所有模块功能演示
 */
public class AssignmentOne {
    // 静态ArrayList：存储所有预约（全局可访问）
    private static ArrayList<Appointment> appointmentList = new ArrayList<>();

    public static void main(String[] args) {
        // ==================== Part 3 – Using classes and objects ====================
        System.out.println("=================== Part 3：健康专业人员实例 ====================");
        // 1. 创建3个全科医生实例
        GeneralPractitioner gp1 = new GeneralPractitioner(101, "张医生", "全科", 25);
        GeneralPractitioner gp2 = new GeneralPractitioner(102, "李医生", "全科", 20);
        GeneralPractitioner gp3 = new GeneralPractitioner(103, "王医生", "全科", 18);

        // 2. 创建2个儿科医生实例
        Pediatrician pedia1 = new Pediatrician(201, "刘医生", "儿科", "0-3岁");
        Pediatrician pedia2 = new Pediatrician(202, "陈医生", "儿科", "4-12岁");

        // 3. 打印所有实例信息
        gp1.printGPDetails();
        gp2.printGPDetails();
        gp3.printGPDetails();
        pedia1.printPediatricianDetails();
        pedia2.printPediatricianDetails();

        // 分隔线
        System.out.println("------------------------------");

        // ==================== Part 5 – Collection of appointments ====================
        System.out.println("=================== Part 5：预约集合管理 ====================");
        // 1. 创建4个预约（2个全科 + 2个儿科）
        createAppointment("小明", "13800138000", "09:00", gp1);
        createAppointment("小红", "13900139000", "10:30", gp2);
        createAppointment("小刚", "13700137000", "14:00", pedia1);
        createAppointment("小丽", "13600136000", "15:30", pedia2);

        // 2. 打印初始预约列表
        System.out.println("【第一步：打印所有预约】");
        printExistingAppointments();

        // 3. 取消一个预约（示例：手机号13900139000）
        System.out.println("【第二步：取消手机号为13900139000的预约】");
        cancelBooking("13900139000");

        // 4. 打印更新后的预约列表
        System.out.println("【第三步：打印取消后的预约】");
        printExistingAppointments();

        // 分隔线
        System.out.println("------------------------------");
    }

    /**
     * 创建预约并添加到集合
     * 校验逻辑：患者姓名、手机号、时间段、医生均不可为空
     * @param patientName 患者姓名
     * @param patientPhone 患者手机号
     * @param timeSlot 预约时间段
     * @param doctor 接诊医生（支持全科/儿科等子类）
     */
    public static void createAppointment(String patientName, String patientPhone, String timeSlot, HealthProfessional doctor) {
        // 校验必填信息
        if (patientName == null || patientName.trim().isEmpty()) {
            System.out.println("创建失败：患者姓名不可为空！");
            return;
        }
        if (patientPhone == null || patientPhone.trim().isEmpty() || !patientPhone.matches("\\d{11}")) {
            System.out.println("创建失败：手机号必须为11位数字！");
            return;
        }
        if (timeSlot == null || timeSlot.trim().isEmpty() || !timeSlot.matches("\\d{2}:\\d{2}")) {
            System.out.println("创建失败：时间段格式错误（示例：08:00）！");
            return;
        }
        if (doctor == null) {
            System.out.println("创建失败：未选择接诊医生！");
            return;
        }

        // 校验通过：创建预约并添加到集合
        Appointment newAppt = new Appointment(patientName, patientPhone, timeSlot, doctor);
        appointmentList.add(newAppt);
        System.out.println("预约创建成功！患者：" + patientName);
    }

    /**
     * 打印所有现有预约
     * 无预约时提示"暂无预约记录"
     */
    public static void printExistingAppointments() {
        if (appointmentList.isEmpty()) {
            System.out.println("暂无预约记录！");
            return;
        }

        System.out.println("当前共有 " + appointmentList.size() + " 条预约记录：");
        for (int i = 0; i < appointmentList.size(); i++) {
            System.out.println("【预约" + (i + 1) + "】");
            appointmentList.get(i).printAppointmentDetails();
        }
    }

    /**
     * 通过手机号取消预约
     * @param phone 患者手机号
     */
    public static void cancelBooking(String phone) {
        // 使用迭代器遍历（支持安全删除）
        Iterator<Appointment> iterator = appointmentList.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Appointment appt = iterator.next();
            if (appt.getPatientPhone().equals(phone)) {
                iterator.remove(); // 安全删除当前元素
                System.out.println("取消成功！已删除手机号为" + phone + "的预约");
                found = true;
                break; // 假设一个手机号对应一个预约，找到后直接退出
            }
        }

        if (!found) {
            System.out.println("取消失败：未找到手机号为" + phone + "的预约");
        }
    }
}