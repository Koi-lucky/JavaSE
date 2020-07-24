package text;

public class PrimeNumberMethod {

     public static void main(String[] args) {

         //调用primeNumbers函数求素数个数
         primeNumbers(10000);
     }


      public static void primeNumbers(long numberOfPrimes) {

          int count = 0; // 统计素数的个数
          int number = 2; // 从最小的素数2开始判断，直至到达numberOfPrimes为止

          // 利用while循环寻找numberOfPrimes以内的素数
          while (number < numberOfPrimes) {
              // 调用isPrimes函数判断是不是素数
              if (isPrime(number)) {
                  count++; // 如果是的话，计数器count自增1
              }
              // 如果这个数不是素数，该数自增1，接着判断下一个数是不是素数
              number++;
          }
              // 输出count的值
              System.out.println("10000以内的素数的个数为:" + count);
      }

        // 判断一个数是不是素数
       public static boolean isPrime(int digit) {

         for (int divisor = 2; divisor <= digit / 2; divisor++) {
             if (digit % divisor == 0) {
                 // 如果求余运算为true，则该数不是素数
                 return false;
              }
          }
        return true; // for循环不通过，则该数是素数
       }
}
