package text;


public class Method {
    public static void main(String[] args) {
        print();
    }
    public static void print() {
        for(int i=0;i<5;i++) {
            for(int j=0;j<8;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}


class MethodSum {
    public static void main(String[] args) {
        int sum=getSum(5,6);
        System.out.println(sum);
    }
    public static int getSum(int a,int b) {
        return a+b;
    }
}


class MethodSum01 {
    public static void main(String[] args) {
        int sum=getSum();
        System.out.println(sum);
    }
    public static int getSum() {
        int sum=0;
        for(int i=1;i<=100;i++) {
            sum=sum+i;
        }
        return sum;
    }
}




class MethodCompare {
    public static void main(String[] args) {
        boolean bool=compare(3,8);
        System.out.println(bool);
    }
    public static boolean compare(int a,int b) {
        if(a==b) {
            return true;
        } else {
            return false;
        }
    }
}





class MethodPow {
    public static void main(String[] args) {
        int a = 2;
        double b = 3.5;
        System.out.println(Math.pow( a , b ));
    }
}