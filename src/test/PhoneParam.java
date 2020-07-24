package text;



/**当使用对象类型作为方法的参数*/
public class PhoneParam {
    public static void main(String[] args) {
        Phone ph = new Phone();
        ph.brand = "华为";
        ph.color = "黑色";
        ph.price = 1580.0;

        method(ph);//传递进去的参数其实就是地址值
    }

    public static void method(Phone param) {
        System.out.println(param.brand);//华为
        System.out.println(param.price);//1580.0
        System.out.println(param.color);//黑色
        //当一个对象作为参数，传递到方法中时，实际上传递进去的是对象的地址值
    }
}



/**当使用对象类型作为方法的返回值*/
class GetPhone {
    public static void main(String[] args) {
        Phone two = getPhone();
        System.out.println(two.brand);//华为
        System.out.println(two.price);//1580.0
        System.out.println(two.color);//黑色
    }
    public static Phone getPhone() {
        Phone one = new Phone();
        one.brand = "华为";
        one.color = "黑色";
        one.price = 1580.0;
        return one;
    }
    //当使用一个对象类型作为方法的返回值时，返回值其实就是对象的地址值
}

