package net_and_stream.stream;

//类的构造器（构造方法）引用
public class MethodRef_ConstructorRef {
    //定义一个方法，参数传递姓名和PersonBuilde接口
    public static void printName(String name, PersonBuilder pb) {
        Person p = pb.builderPerson(name);
        System.out.println(p.getName());
    }

    public static void main(String[] args) {
        //调用printName方法，方法的参数是一个函数式接口
        /*
        printName( "迪丽热巴", (String name) -> {
            return new Person(name);
        });
        */

        //优化—— 构造方法已知，创建对象已知
        printName("古力娜扎", Person::new);
    }
}
//定义一个函数式接口
@FunctionalInterface
interface PersonBuilder {
    //定义一个方法，根据传递的姓名，创建person对象返回
    Person builderPerson(String name);
}
// 定义一个类
class Person {
    String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}