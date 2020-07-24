package extendstest;

public class UseStudent01 {
    public static void main(String[] args) {
        Student01 stu1 = new Student01();//无参构造
        System.out.println("=================");

        Student01 stu2 = new Student01("赵丽颖",20);//全参构造
        System.out.println("姓名："+stu2.getName()+"   年龄："+stu2.getAge());

        //如果想改变成员对象当中的成员变量数据内容，仍然还需要使用setXxx方法
        stu2.setAge(29);//改变年龄
        System.out.println("姓名："+stu2.getName()+"   年龄："+stu2.getAge());

    }

}



class Studengt02 {
    public static void main(String[] args) {
        Student02 stu1 = new Student02();
        stu1.setName("赵丽颖");
        stu1.setAge(20);
        System.out.println("姓名："+ stu1.getName() +"，年龄："+ stu1.getAge());
        System.out.println("=======================");

        Student02 stu2 = new Student02("李元芳",20);
        System.out.println("姓名："+ stu2.getName() +"，年龄："+ stu2.getAge());
        stu2.setAge(25);
        System.out.println("姓名："+ stu2.getName() +"，年龄："+ stu2.getAge());

    }
}