package interfacetest;
/*
    【注意事项】不能通过接口实现类的对象来调用接口当中的静态方法
    【正确的用法】静态方法是最简单的方法，直接通过接口名称，直接调用其中的静态方法
    【格式】接口名称.静态方法名（参数）；
 */
public interface MyInterfaceStatic {

    public static void StaticMethod() {
        System.out.println("这是接口的静态方法！");
    }
}

class DemoInterface {

    public static void main(String[] args) {
        MyInterfaceStatic.StaticMethod();
    }
}