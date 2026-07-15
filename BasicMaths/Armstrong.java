package BasicMaths;

public class Armstrong {
     public static boolean isArmstrong(int n) {
      int original=n;
      int digits=0;
      int temp=n;

      while(temp!=0) {
        digits++;
        temp/=10;
      }

      int sum=0;
      temp=n;

      while(temp!=0) {
        int d=temp%10;
        sum+=Math.pow(d,digits);
        temp/=10;
      }

      return sum==original;
     }
     
     public static void main(String[] args) {
        System.out.println(isArmstrong(153));
     }
}
