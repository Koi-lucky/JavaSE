package text;

import java.util.Date;

public class AccountText {

    public static void main(String[] args) {

        //创建一个用户
        Account account = new Account();
        account.setId(1122);//账户ID为1122
        account.setBalance(20000);//账户余额为20000美元
        account.setAnnuallnterestRate(4.5);//当前利率
        account.withDraw(2500);//取款金额
        account.deposit(3000);//存款金额
        //显示用户当前的账户信息
        System.out.println("该账户余额为：" + account.getBalance() +
                " ，月利息为：" + account.getMonthlyInterestRate() * account.getBalance() +
                " ，开户日期为：" + account.getDateCreated().toString());
    }
}


class Account {

    //定义私有数据域
    private int id = 0;//账户ID，初始值为0
    private double balance = 0;//账户余额，初始值为0
    private double annuallnterestRate = 0;//当前利率，初始值为0
    private Date dateCreated = new Date();//开户日期

    //无参构造方法

    public Account() {
    }

    //带特定 id 和初始余额的账户的构造方法

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    //id的访问器和修改器

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // balance的访问器和修改器

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //annuallnterstRate的访问器和修改器

    public double getAnnuallnterestRate() {
        return annuallnterestRate;
    }

    public void setAnnuallnterestRate(double annuallnterestRate) {
        this.annuallnterestRate = annuallnterestRate;
    }

    //dateCreated 的访问器

    public Date getDateCreated() {
        return dateCreated;
    }

    //一个名为getMonthlyInterestRate的方法，返回月利率

    public double getMonthlyInterestRate() {
        return annuallnterestRate / 100 / 12;
    }

    //—个名为 withDraw 的方法， 从账户提取特定数额
    public void withDraw(double money) {
        if(money > this.balance) {
            System.out.println("您的账户余额不足！");
        } else {
            this.balance = this.balance - money;
        }
    }

    //—个名为 deposit 的方法向账户存储特定数额。
    public double deposit(double money) {
        return this.balance = this.balance + money;
    }
}