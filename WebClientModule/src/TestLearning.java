/**
 * @Author 黄昌焕
 * @Date 2018-01-26  15:28
 */
public class TestLearning {
    public static void main(String[] args) {
        try {
            int a[] = new int[2];
            System.out.println("Access element three :" + a[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception thrown  :" + e);
            System.out.println(e.getMessage());
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            for (StackTraceElement stackTraceElement : stackTraceElements) {
                System.out.println(stackTraceElement);
            }
        } finally {

        }
    }
}
