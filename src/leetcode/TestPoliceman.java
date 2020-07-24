package leetcode;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestPoliceman {

    public static void main(String[] args) throws ParseException {
        //写一个测试方法
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
        String str = "2004年04月01日";
        Date date = df.parse(str);//日期格式转换：将其转为Date类型
        ArmedPolice ap = new ArmedPolice( 10034, "Jackie chan ", 3000, date, " the 7th Brigade of the Armed Police ", "the third Police supervisor");
        //修改前的警员信息
        System.out.println("修改前的警员信息：");
        System.out.println(ap.toString());
        //修改后的警员信息
        System.out.println("修改后的警员信息：");
        ap.Raise(ap.getServiceYears());
        System.out.println(ap.toString());
    }
}


class Policeman {
    //定义四个私有属性
    private int number;
    private String name;
    private double salary;
    private Date workTime;

    //无参构造
    public Policeman() {
    }

    //带参构造
    public Policeman(int number, String name, double salary, Date workTime) {
        this.number = number;
        this.name = name;
        this.salary = salary;
        this.workTime = workTime;
    }

    // 所有的访问器
    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getWorkTime() {
        return workTime;
    }

    // 薪资和工作日期的修改器
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setWorkTime(Date workTime) {
        this.workTime = workTime;
    }

    //写一个方法，得到警员的从警年限
    public int getServiceYears(){
        Calendar c = new GregorianCalendar();
        c.getTime();
        return (int)((c.getTime().getTime() - workTime.getTime()) / (24 * 60 * 60 * 1000) / 365);
    }

    //重写toString方法
    @Override
    public String toString() {
            return "Policeman { " +
                    "number =" + number +
                    ", name ='" + name +
                    ", years of service =" + getServiceYears() +
                    ", salary =" + salary ;
    }
}

interface Employee {
    public abstract void Raise(int n);
}

class ArmedPolice extends Policeman implements Employee {

    //定义两个数据域
    String army;
    String rank;

    //无参构造
    public ArmedPolice() {
    }

    //带参构造
    public ArmedPolice(int number, String name, double salary, Date workTime, String army, String rank) {
        super( number, name, salary, workTime);
        this.army = army;
        this.rank = rank;
    }

    //重写抽象方法
    @Override
    public void Raise(int n) {
        double EndSalary = super.getSalary();
        for (int i = 0; i < n / 2; i++) {
            EndSalary *= 1.3;
        }
        setSalary(EndSalary);
    }

    //重写toString方法
    @Override
    public String toString() {
        return super.toString() +
                ", army = " + army +
                ", rank = " + rank +
                '}';
    }
}