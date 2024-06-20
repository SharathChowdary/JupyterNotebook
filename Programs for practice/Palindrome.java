import java.util.Scanner;
public class Palindrome{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter a String : ");
        String str=input.next();
        int length=str.length();
        boolean isPalindrome=true;
        for(int i=0;i<length;i++){
            if(str.charAt(i)!=str.charAt(length-i-1)){
                isPalindrome=false;
                break;
            }
        }
        if(isPalindrome)
            System.out.print("It is a paindrome");
        else
            System.out.print("It is not a palindrome");
    }

}