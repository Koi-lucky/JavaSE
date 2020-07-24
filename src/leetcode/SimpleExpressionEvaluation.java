package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SimpleExpressionEvaluation {

    private static Stack<Integer> resStack = new Stack<>();
    private static Stack<Character> opStack = new Stack<>();

    public static void main(String[] args) throws IOException {
        //读入一个数
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        //输入多组数据进行验证
        while(!(str = br.readLine()).equals("END")) {
            //将输入的字符串转换成字符数组来处理
            char[] ch = str.toCharArray();
            int i = 0;//表达式的索引
            while(i < ch.length) {
                //如果是加号或减号(同一级运算符)
                if(ch[i] == '+' || ch[i] == '-') {
                    while(!opStack.isEmpty()) {
                        calculate();
                    }
                    opStack.push(ch[i]);
                    i ++;
                } else if(ch[i] == '*') {//如果是乘号
                    //栈不空，并且栈顶的操作符与乘号同级，才可以进行运算
                    while(!opStack.isEmpty() && opStack.peek() == '*') {
                        calculate();
                    }
                    opStack.push(ch[i]);
                    i ++;
                } else {
                    //如果是数字
                    //这里还要考虑多位数的情况
                    int num = ch[i] - '0';
                    int j = i + 1;
                    //要保证在表达式的长度范围之内
                    //该数字必须是0~9的数
                    while(j < ch.length && ch[j] >= '0' && ch[j] <= '9') {
                        //相当于完成多位数的拼接工作
                        num = num * 10;
                        num = num + ch[j] - '0';
                        j ++;
                    }
                    i = j;
                    resStack.push(num);//将计算后的结果入栈
                }
            }
            while(!opStack.isEmpty()) {
                calculate();
            }
            //栈中的最后一个元素即为最终的结果
            System.out.println(resStack.pop());
        }
        br.close();
    }

    public static void calculate() {
        int num1 = resStack.pop();
        int num2 = resStack.pop();
        char oper = opStack.pop();
        int res = 0;//存放当前的计算结果
        switch (oper) {//根据操作符来进行运算
            case'+':
                res = num1 + num2;
                break;
            case'-':
                res = num2 - num1;
                break;
            case'*':
                res = num1 * num2;
                break;
        }
        resStack.push(res);//将计算后的结果入栈
    }
}
