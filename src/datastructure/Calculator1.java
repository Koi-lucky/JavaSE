package datastructure;

public class Calculator1 {

    public static void main(String[] args) {

        String expression = "7*26-15+13*2";
        //创建两个栈，一个符号栈，一个运算符栈
        ArrayStack1 numStack = new ArrayStack1(10);
        ArrayStack1 operStack = new ArrayStack1(10);
        //定义有关变量
        int index = 0;//用于扫描表达式的索引
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//用于存放每次扫描得到的字符串
        String keepNum = " ";//用于拼接多位数，比如110
        //开始扫描表达式
        while(true) {
            //判断得到表达式的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么，然后做相应的处理
            if(operStack.isOper(ch)) {//如果是运算符
                //判断当前的栈是否为空
                if(!operStack.isEmpty()) {
                    //如果符号栈中含有操作符，就进行比较，
                    //如果当前的操作符优先级小于或者等于栈中的操作符，就需要从栈中弹出两个数
                    //再从符号栈中弹出一个符号，进行运算，将得到结果，将结果入数栈，然后将当前的操作符入栈
                    if(operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //将运算的结果入栈
                        numStack.push(res);
                        //然后将当前的操作符入符号栈
                        operStack.push(ch);
                    } else {
                        //如果当前的操作符优先级大于栈中的操作符，就直接入栈
                        operStack.push(ch);
                    }
                } else {
                    //如果为空直接入符号栈
                    operStack.push(ch);
                }
            } else {
                //处理多位数的思路：
                //1.如果是数，则直接入数栈
                //2.当处理多位数的时候，不能发现一个数就直接入栈，因为他可能是多位数
                //3.在处理数的时候，需要向表达式的index后再看一位，如果是数就进行扫描，如果下一位是符号，才入栈
                //4.因此我们需要定义一个变量用于拼接字符串
                keepNum = keepNum + ch;
                //如果ch已经是表达式的最后一位，就直接入栈
                if(index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum.trim()));//转换成数字字符时，必须去掉字符串的空格，否则会抛出异常信息
                } else {
                    //判断下一位是不是数字，如果是数字就继续扫描，如果是运算符，就入栈
                    //注意看是不是最后一位，不是index++，只是看一眼下一位是什么，
                    if(operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果最后一位是运算符，则入栈keepNum=1或keepNum=123
                        numStack.push(Integer.parseInt(keepNum.trim()));
                        //将keepNum清零,便于下次拼接
                        keepNum = " ";
                    }
                }
            }
            //让index+1，并判断是否扫描到表达式最后
            index++;
            if(index >= expression.length()) {
                break;
            }
        }

        //当表达式扫描完毕，就顺序的从数栈和符号栈中弹出的相应的数和符号，并运行
        while(true) {
            //当符号栈为空，则计算到最后的结果，数栈中只有一个数字，这个数字就是结果
            if(operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            //将运算的结果入栈
            numStack.push(res);
        }
        //将数栈的最后数弹出，就表示的是结果
        System.out.printf("表达式%s = %d\n", expression, numStack.pop());
    }
}


//定义一个数组实现栈的类
class ArrayStack1 {
    private int maxSize;//定义栈的大小
    private int[] stack;
    private int top = -1;//定义一个栈顶指针

    public ArrayStack1(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //判满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //判空
    public boolean isEmpty() {
        return top == -1;
    }

    ///入栈
    public void push(int value) {
        //判满
        if(isFull()) {
            System.out.println("栈满，无法加入数据！！");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        //判空
        if(isEmpty()) {
            throw new RuntimeException("栈空，没有数据！！");//抛出异常之后就不用写return
        }
        int value = stack[top];
        top--;
        return value;
    }

    //遍历栈，也就是显示一下当前栈的情况
    public void list() {
        if(isEmpty()) {
            System.out.println("栈空，没有数据！！");
            return;
        }
        //从栈顶开始显示数据
        for (int i = top; i >=0 ; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }

    //显示当前栈顶元素的值，并不是让他出栈‘
    public int peek() {
        return stack[top];
    }

    //返回运算符的优先级，优先级是由程序员来确定的，使用数字来表示
    //数字越大，优先级越高
    public int priority(int oper) {
        if(oper == '*' || oper == '/') {
            return 1;
        } else if(oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;//假设目前表达式的运算符只有+，-，*，/
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '*' || val == '/' || val == '+' || val == '-' ;
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case'+':
                res = num1 + num2;
                break;
            case'-':
                res = num2 - num1;//第二个数减第一个数
                break;
            case'*':
                res = num1 * num2;
                break;
            case'/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}