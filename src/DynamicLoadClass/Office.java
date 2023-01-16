package DynamicLoadClass;

public class Office {

    public static void main(String[] args) {
        // new 创建对象 是静态加载， 在编译时就需要加载所有可能使用到的类
        // 通过动态加载，可以解决这个问题
        if ("Word".equals(args[0])) {
            Word w = new Word();
            w.start();
        } else if ("Excel".equals(args[0])) {
            Excel e = new Excel();
            e.start();
        }
    }
}
