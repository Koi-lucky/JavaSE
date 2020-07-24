package datastructure;

public class SingleLinkedListStackText {

    public static void main(String[] args) {
        Stack1<Integer> integerStack = new Stack1<>();
        integerStack.initStack();
        integerStack.pushStack(1);
        integerStack.printStack();
        integerStack.pushStack(2);
        integerStack.printStack();
        integerStack.pushStack(3);
        integerStack.printStack();
        integerStack.pushStack(4);
        integerStack.printStack();

        integerStack.popStack();
        integerStack.printStack();
        integerStack.pushStack(4);
        integerStack.printStack();
        integerStack.popStack();
        integerStack.printStack();

        System.out.println("大小：" + integerStack.sizeStack());

        integerStack.getTop();
    }
}


class Node<T> {
        public T data;
        public Node next;
    private int value;
}

class Stack1<T> {
    private Node bottom; //栈底指针
    private Node top; //栈顶指针
    private Integer size; //栈当前大小


    public void initStack() {
        bottom = top = new Node();
        top.next = bottom;
        size = 0;
    }


    public boolean isEmpty() {
        if (top.next == bottom) {
            return true;
        }
        return false;
    }


    public void pushStack(T element) {
        Node temp = new Node();
        temp.data = element;
        if (top.next == bottom)//第一次入栈操作
        {
            temp.next = bottom;
            top.next = temp;
        } else {
            temp.next = top.next;
            top.next = temp;
        }
        size++;
    }


    public void popStack() {
        if (isEmpty()) {
            System.out.println("栈中没有元素！");
        } else {
            System.out.println("出栈操作：" + top.next.data + " ");
            top.next = top.next.next;
        }
        size--;
    }


    public int sizeStack() {
        return size;
    }


    public void getTop() {
        System.out.println("顶部值：" + top.next.data);
    }


    public void printStack() {
        Node temp = top;
        if (isEmpty()) {
            System.out.println("栈中没有元素！");
        } else {
            for (int i = 0; i < size; i++) {
                System.out.print(temp.next.data + " ");
                temp = temp.next;
            }
        }
        System.out.println();

    }
}