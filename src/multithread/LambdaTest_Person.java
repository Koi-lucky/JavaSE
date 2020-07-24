package multithread;

import java.util.Arrays;

/**
 * Lambda表达式——> 【有参有返回值】的练习
 *
 *      需求：
 *          1.使用数组存储多个Person对象
 *          2.对数组中的Person对象使用Arrays的sort方法 通过年龄进行升序排序
 */
public class LambdaTest_Person {

    public static void main(String[] args) {
        //使用数组存储多个Person对象
        Person[] arr = {
                new Person("柳岩", 23),
                new Person("杨幂", 19),
                new Person("范冰冰", 28)
        };

        //1.使用原方法进行排序
        /*Arrays.sort( arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();//o1-o2是升序
            }
        });*/

        //2.使用Lambda表达式的方法进行排序
        Arrays.sort( arr, (Person o1, Person o2) -> {
            return o1.getAge() - o2.getAge();//o1-o2是升序
        });

        //3.优化 Lambda表达式——> 省略版Lambda表达式
        Arrays.sort( arr, ( o1, o2) -> o1.getAge() - o2.getAge());

        //遍历输出一下
        for (Person val : arr) {
            System.out.println(val);
        }
    }
}

class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}