import java.util.Scanner;
public class Fibonacci{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter a number : ");
        int n=input.nextInt();
        int prev=1,temp=0,cur;
        System.out.print(temp+"\t"+prev+"\t");
        for (int i=2;i<=n;i++){
            cur=prev+temp;
            System.out.print(cur+"\t");
            temp=prev;
            prev=cur;
        }
    }
}