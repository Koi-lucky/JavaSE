package datastructure;

import java.util.Scanner;

public class HashTableTest {

    public static void main(String[] args) {

        //创建哈希表
        HashTable hashTable = new HashTable(7);
        //创建一个菜单
        String key = " ";
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("add:表示添加雇员");
            System.out.println("list:表示显示雇员信息");
            System.out.println("search:表示查找雇员");
            System.out.println("exit:表示退出程序");

            key = sc.next();
            switch (key) {
                case "add":
                    System.out.println("请输入雇员id");
                    int id = sc.nextInt();
                    System.out.println("请输入雇员姓名");
                    String name = sc.next();
                    //创建雇员
                    Emp emp = new Emp( id, name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "search":
                    System.out.println("请输入要查找的雇员的id");
                    id = sc.nextInt();
                    hashTable.search(id);
                    break;
                case "exit":
                    sc.close();
                    System.exit(0);
                default:
                        break;
            }
        }
    }
}



//创建哈希散列表，来管理多条链表,
class HashTable {
    private EmpLinkedList[] empLinkedLists;
    private int size;//表示哈希表有多少条链表

    //构造器

    public HashTable(int size) {
        this.size = size;
        //初始化empLinkedLists
        empLinkedLists = new EmpLinkedList[size];
        //初始化每一条链表
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp) {
        //根据雇员的id来决定将其添加到那一条链表中
        int empNo = hashFun(emp.id);
        //将emp添加到对应的链表中
        empLinkedLists[empNo].add(emp);
    }


    //遍历所有的链表，遍历哈希表
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }


    //根据输入的id查找雇员
    public void search(int id) {
        //使用哈希散列函数判断找那条链表
        int empNo = hashFun(id);
        Emp emp = empLinkedLists[empNo].search(id);
        if(emp != null) {
            //找到了
            System.out.printf("在第%d条链表中找到了雇员id = %d\t", empNo, id);
        } else {
            System.out.println("在哈希表中没有找到该雇员！");
        }
    }

    //构造哈希散列函数
    public int hashFun(int id) {
        return id % size;
    }
}




//创建雇员链表
class EmpLinkedList {
    //创建头指针，head直接指向第一个数据
    private Emp head;//默认为空

    //添加雇员到链表
    //假定添加雇员的时候id是自己增长的，即从小到大分配
    //直接将雇员添加到链表尾部
    public void add(Emp emp) {
        //如果添加的是第一个雇员
        if(head == null) {
            head = emp;
            return;
        }
        //如果不是第一个雇员，则使用一个指针帮助定位到该链表的最后
        Emp curEmp = head;
        while(true) {
            if(curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        //退出的时候，直接将数据加到链表最后
        curEmp.next = emp;
    }


    //遍历链表的信息
    public void list(int no) {
        if(head == null) {
            System.out.println("第" + no + "条链表为空");
            return;
        }
        System.out.print("第" + no + "条链表信息为：");
        Emp curEmp = head;
        while(true) {
            System.out.printf(" ==> id = %d , name = %s \t", curEmp.id, curEmp.name);
            if(curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }


    //根据id查找雇员
    //如果找到就返回，如果没找到就返回空值
    public Emp search(int id) {
        if(head == null) {
            System.out.println("链表为空！");
            return null;
        }
        Emp curEmp = head;
        while(true) {
            if(curEmp.id == id) {
                break;
            }
            if(curEmp.next == null) {
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }

}



//创建雇员节点
class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}