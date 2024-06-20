import java.util.*;
public class Prime {
    public static void main(String[] args){
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the value of n:");
        n=sc.nextInt();
        for(int i=1;i<=n;i++){
            is_prime(i);
        }
    }
    public static void is_prime(int n){
        int count=0;
        for(int i=2;i<=n/2;i++){
            if(n%i==0){
                count+=1;
            }
        }
        if(count==0){
            System.out.println(n+" is Prime number");
        }
        else{
            System.out.println(n+" is Not a prime number");
        }
    }
}
