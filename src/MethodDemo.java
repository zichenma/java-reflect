import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //要获取print(int,int)方法 1.要获取一个方法就是获取类的信息，获取类的信息首先要获取类的类类型
        A a1 = new A();
        Class c = a1.getClass();
        /*
         * 2.获取方法 名称和参数列表来决定
         * getMethod获取的是public的方法
         * getDeclaredMethod自己声明的方法
         */
        Method m = c.getMethod("print", new Class[]{int.class,int.class});

        //方法的反射操作
        //a1.print(10,20);方法的反射操作是用m对象来进行方法调用和a1.print调用效果完全相同
        //方法如果没有返回值返回null，有返回值返回具体的返回值
        // Object o = m.invoke(a1, new Object[]{10,20});
        Object o = m.invoke(a1, 10,20);
        System.out.println("==================");
        // 获取print(String,String)方法
        Method m1 = c.getMethod("print", String.class, String.class);
        //用方法进行反射操作
        m1.invoke(a1, "hello", "world");
        // Method m2 = c.getMethod("print"), new Class[]{}); // 无参数
        // m2.invoke(a1）;// 无参数
        Method m2 = c.getMethod("print");
    }
}

class A {
    public void print() {
        System.out.println("helloworld");
    }
    public void print(int a, int b) {
        System.out.println(a + b);
    }
    public void print(String a, String b) {
        System.out.println(a.toUpperCase() + "," + b.toUpperCase());
    }
}
