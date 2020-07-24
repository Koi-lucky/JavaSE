package text;

import java.util.Arrays;

public class Arr01 {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        arr[0]=6;
        int i=arr[0];
        System.out.println(i);
        System.out.println(arr[0]);
    }
}
class Arr002 {
    public static void main(String[] args) {
        int[] arr={5,15,2000,10000,100,4000};
        int max=arr[0];
        for(int i=0;i<arr.length;i++) {
            if(arr[i]>max) {
                max=arr[i];
            }
        }
        System.out.println("数组的最大值是："+max);
    }
}
class Arr003 {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6};
        for(int min=0,max=arr.length-1;min<=max;min++,max--) {
            int temp=arr[min];
            arr[min]=arr[max];
            arr[max]=temp;
        }
        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}
class Arr004 {
    public static void main(String[] args) {
        int arr[]={1,3,5};
        System.out.println(arr[0]);
        change(arr);
        System.out.println(arr[0]);
    }

    public static void change(int[] arr) {
        arr[0]=200;
    }
}
class Arr005{
    public static void main(String[] args) {
        int[] arr={10,20,30,40,50,60};
        //要求打印的格式为：[10, 20, 30, 40, 50, 60]
        //使用面向过程，每一个步骤细节都要亲力亲为
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {//如果是最后一个元素
                System.out.println(arr[i] + "]");
        } else {//如果不是最后一个元素
                System.out.print(arr[i]+", ");//对应的数+逗号+空格
            }
        }
        System.out.println("====================");
        //使用面向对象
        //就是找一个jdk给我们提供好的Arrays类
        //其中有一个toString方法，直接就能把数组变成想要的格式的字符串
        System.out.println(Arrays.toString(arr));
    }
}