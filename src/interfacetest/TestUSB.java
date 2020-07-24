package interfacetest;

public class TestUSB {

    public static void main(String[] args) {
        //首先创建一个笔记本电脑
        Computer computer = new Computer();
        computer.powerOn();//笔记本电脑开机
        //使用鼠标
        //首先进行了向上转型
        USB usb = new Mouse();//多态写法
        //参数为USB类型
        computer.useDevice(usb);//打开相关的USB设备
        // 使用键盘
        Keyboard keyboard = new Keyboard();//没有使用多态写法
        computer.useDevice(keyboard);//在这里发生了向上转型
        computer.powerOff();//笔记本电脑关机
    }
}


interface USB {
    public void open();//打开设备
    public void close();//关闭设备
}

class Computer {
    public void powerOn() {
        System.out.println("笔记本电脑开机");
    }
    public void powerOff() {
        System.out.println("笔记本电脑关机");
    }
    //使用USB设备的方法，使用接口作为方法的参数
    public void useDevice(USB usb) {
        usb.open();//打开设备
        if(usb instanceof Mouse) {//一定要先判断是什么
            Mouse mouse = new Mouse();//再向下转型
            mouse.click();
        } else if(usb instanceof Keyboard) {//一定要先判断是什么
            Keyboard keyboard = new Keyboard();//再向下转型
            keyboard.type();
        }
        usb.close();//关闭设备
    }

}

class Mouse implements USB{

    @Override
    public void open() {
        System.out.println("打开鼠标");
    }

    @Override
    public void close() {
        System.out.println("关闭鼠标");
    }

    public void click() {
        System.out.println("点击鼠标");
    }
}

class Keyboard implements USB{

    @Override
    public void open() {
        System.out.println("打开键盘");
    }

    @Override
    public void close() {
        System.out.println("关闭键盘");
    }
    public void type() {
        System.out.println("键盘输入");
    }
}