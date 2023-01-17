import java.lang.reflect.Method;

public class ClassUtil {
    /**
     * 打印类的信息， 包括类的成员函数，成员变量
     * @param obj 该对象所属类的信息
     */
    public static void  printClassMessage(Object obj){
        // 要获取类的信息，首先要获取类的类类型
        Class c = obj.getClass(); // 传递的是哪个子类的对象，c就是该子类的类类型 c就是该子类的类类型
        // 获取类的名称
        System.out.println("类的名称是：" + c.getName());
        /**
         * Method类，方法对象
         *
         * getMethods()方法获取的是所有的public的函数，包括父类继承而来的
         */
        Method[] ms = c.getMethods(); // 获取所有的方法
        /**
         * getDeclaredMethods()获取的是所有该类自己声明的方法，不问访问权限
         */
        c.getDeclaredMethods(); // 获取自己声明的方法
        for(int i = 0; i < ms.length; i++){
            // 得到方法的返回值类型的类类型
            Class returnType = ms[i].getReturnType();
            System.out.print(returnType.getName() + " ");
            // 得到方法的名称
            System.out.print(ms[i].getName() + "(");
            // 获取参数类型 --> 得到的是参数列表的类型的类类型
            Class[] paramTypes = ms[i].getParameterTypes();
            for(Class class1 : paramTypes){
                System.out.print(class1.getName() + ",");
            }
            System.out.println(")");
        }
    }
}
