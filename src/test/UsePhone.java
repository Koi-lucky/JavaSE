package text;

public class UsePhone {
    public static void main(String[] args) {
        //根据Phone类，创建一个名为ph的对象
        //格式：类名称 对象名 = new 类名称（）；
        Phone ph = new Phone();
        System.out.println(ph.brand);
        System.out.println(ph.price);
        System.out.println(ph.color);
        System.out.println("==============");


        ph.brand = "华为";
        ph.color = "黑色";
        ph.price = 1580.0;
        System.out.println(ph.brand);
        System.out.println(ph.price);
        System.out.println(ph.color);
        System.out.println("==============");

        ph.call("李新凯");
        ph.sendMessage();

    }
}
