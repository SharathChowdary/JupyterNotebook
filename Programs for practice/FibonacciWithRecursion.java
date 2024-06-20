import java.util.Scanner;
public class FibonacciWithRecursion{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n=input.nextInt();
        System.out.print("0\t1\t");
        Fibo(0,1,n);
    }
    static void Fibo(int a,int b,int n){
        if(n-2<0){
            return;
        }
        else{
            System.out.print(a+b+"\t");
            Fibo(b,a+b,n-1);
        }
    }
}