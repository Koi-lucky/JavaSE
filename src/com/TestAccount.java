package com;

import java.util.Date;

public class TestAccount {

    public static void main(String[] args) {


        Account account = new Account();
        account.setId(1122);//账户ID为1122
        account.setBalance(20000);//账户余额为20000美元
        account.setAnnuallnterestRate(4.5);//当前利率
        account.withDraw(2500);//取款金额
        account.deposit(3000);//存款金额
        System.out.println(account.toString());


        CheckingAccount checkingAccount = new CheckingAccount(2000);
        System.out.println(checkingAccount.toString());


        SavingAccount savingAccount = new SavingAccount(1000);
        System.out.println(savingAccount.toString());
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

    //toString方法描述

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", annuallnterestRate=" + annuallnterestRate +
                ", dateCreated=" + dateCreated +
                '}';
    }
}



class CheckingAccount extends Account {
    private double overdraw;//透支金额

    public CheckingAccount(double overdraw) {
        this.overdraw = overdraw;
    }

    public void test(){
        if(super.getBalance() < 0 - overdraw) {
            System.out.println("以超出了用户支票账户的最低透支金额！！");
        }
    }

    @Override
    public String toString() {
        return "overdraw = " + overdraw ;
    }
}

class SavingAccount extends Account{
    private double money ;

    public SavingAccount(double money) {
        this.money = money;
    }

    public void test(){
        if(money > super.getBalance()) {
            System.out.println("用户储蓄账户余额不足，并且无法透支！！");
        }
    }

    @Override
    public String toString() {
        return "SavingAccount :" + money ;
    }
}