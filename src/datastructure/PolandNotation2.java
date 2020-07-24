package datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation2 {

    public static void main(String[] args) {

        //先给定中缀达式
        //为了方便，将中缀表达式的数字和符号用空格隔开
        String expression = "1+((2+3)*4)-5";
        //先将表达式放入栈中去
        //将ArrayList传递给一个方法，遍历ArrayList配合栈完成计算
        List<String> infixExpressionList = toInFixExpressionList(expression);
        System.out.println("中缀表达式对应的List为：" + infixExpressionList);

        List<String> suffixExpressionList = parseSuffixExpressionList(infixExpressionList);
        System.out.println("后缀表达式对应的List为：" + suffixExpressionList);

        //转换完之后用逆波兰计算器计算
        System.out.printf("expression = % d", calculate(suffixExpressionList));
    }


    //将现有的中缀表达式转换为对应的后缀表达式
    public static List<String> parseSuffixExpressionList(List<String> ls) {
        //定义一个栈，一个列表（将原本的第二个栈转为列表，便于以后的操作）
        Stack<String> s1 = new Stack<>();//符号栈
        List<String> s2 = new ArrayList<>();//存储中间结果的list2

        //遍历ls
        for(String item : ls) {
            //如果是一个数，就加入到s2
            if(item.matches("\\d+")) {
                s2.add(item);
            } else if("(".equals(item)) {
                s1.push(item);
            } else if(")".equals(item)) {
                //如果是右括号，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                while(!"(".equals(s1.peek())) {
                    s2.add(s1.pop());
                }
                s1.pop();//将（弹出s1栈，消除小括号
            } else if(s1.empty()) {
                s1.push(item);
            } else if(Operation.getValue(s1.peek()) < Operation.getValue(item)) {
                s1.push(item);
            } else {
                    //当item的优先级小于等于s1栈顶运算符，将s1栈顶的运算符弹出并加入到s2中，再次转到4.1步骤进行与s1中的新的栈顶运算符相比较
                    while(true) {
                        if(s1.isEmpty() || Operation.getValue(s1.peek()) < Operation.getValue(item)) {
                            s1.push(item);
                            break;
                        }
                        s2.add(s1.pop());
                    }
                }
            }
        //将s1中剩余的运算符依次弹出并加入s2
        while(!s1.isEmpty()) {
            s2.add(s1.pop());
        }
        return s2;//注意因为是存放到List，因此按顺序输出就是对应的后缀表达式对应的list
    }


    //将中缀表达式转换成相应地list
    public static List<String> toInFixExpressionList(String s) {
        //定义一个list，存放中缀表达式的对应内容
        List<String> ls = new ArrayList<>();
        int i = 0;//定义一个指针用于遍历中缀表达式字符串
        String str;//对多位数的拼接
        char c;//每遍历一个字符就放入到c
        do {
            //如果c是一个非数字，就需要加入到ls
            if((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add(" " + c);
                i++;//指针后移
            } else {
                //如果是一个数，需要考虑多位数
                str = " ";//先将str置成"" '0'[48]~'9'[57]
                while(i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str = str + c;//拼接
                    i++;
                }
                ls.add(str);
            }
        } while(i < s.length());
        return ls;
    }


    //完成对逆波兰表达式的运算
    public static int calculate(List<String> ls) {
        //创建一个栈，就一个
        Stack<String> stack = new Stack<>();
        //遍历ls
        for (String item : ls) {
            //这里使用正则表达式来取出数
            if (item.matches("\\d+")) {//+表示匹配多位数
                //入栈
                stack.push(item);
            } else {
                //弹出两个数，并进行运算，最后再将其入栈
                while (!stack.empty()) {
                    int num2;
                    num2 = Integer.parseInt(stack.pop().trim());
                    int num1;
                    num1 = Integer.parseInt(stack.pop().trim());
                    int res = 0;
                    if (item.equals("+")) {
                        res = num1 + num2;
                    } else if (item.equals("-")) {
                        res = num1 - num2;
                    } else if (item.equals("*")) {
                        res = num1 * num2;
                    } else if (item.equals("/")) {
                        res = num1 / num2;
                    } else {
                        throw new RuntimeException("运算符有误！！");
                    }
                    //将结果入栈
                    stack.push(" " + res);//结果是数字，要将其转换为字符串才能进行入栈，直接给数拼接一个空字符串
                }
            }
        }
        //最后留在栈中的数据即为结果
        return (!stack.empty()) ? Integer.parseInt(stack.pop().trim()) : 0;
    }
}


//写一个类，可以返回一个运算符的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case"+":
                result = ADD;
                break;
            case"-":
                result = SUB;
                break;
            case"*":
                result = MUL;
                break;
            case"/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符！");
                break;
        }
        return result;
    }
}