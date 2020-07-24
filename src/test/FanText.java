package text;

public class FanText {

    public static void main(String[] args) {

        Fan fan1 = new Fan();
        fan1.setOn(true);
        fan1.setSpeed(3);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        System.out.println(fan1);

        Fan fan2 = new Fan();
        fan2.setSpeed(2);
        System.out.println(fan2);

    }
}



class Fan {
    //定义三个静态变量，分别赋值
    final static int SLOW = 1;
    final static int MEDIUM = 2;
    final static int FAST = 3;
    //定义三个私有数据域+一个非私有数据域
    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    String color = "blue";


   //无参构造方法
    public Fan() {
    }

    //toString方法

    @Override
    public String toString() {
        if(on == true) {
            return "Fan {" +
                    "speed=" + speed +
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        } else {
            return "Fan is off ! " +
                    " radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        }
    }

    //speed的访问器和修改器
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    //on的访问器和修改器
    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    //radius的访问器和修改器
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    //color的访问器和修改器
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}