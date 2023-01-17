import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class GenericTypeDemo {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("hello");
        Class c1 = list.getClass();
        Class c2 = list1.getClass();
        System.out.println(c1 == c2); // true
        // 反射的操作都是编译之后的操作

        /*
           c1 == c2 结果返回true说明编译之后集合的泛型是去泛型化的
           Java中集合的泛型，是防止错误输入的，只在编译阶段有效，
           绕过编译就无效了
           验证：我们可以通过方法的反射来绕过编译
         */
        try {
            Method m = c1.getDeclaredMethod("add", Object.class);
            m.invoke(list1, 20); // 绕过编译操作就绕过了泛型
            System.out.println(list1.size()); // 2
//            for (String string: list1) {
//                System.out.println(string   );
//            } // 现在不能使用foreach循环，因为list1中有Integer类型的元素
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
