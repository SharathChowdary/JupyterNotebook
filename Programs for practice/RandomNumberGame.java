import java.util.Random;
import java.util.Scanner;

public class RandomNumberGame{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        Random random=new Random();
        int random_number=random.nextInt(100)+1;
        boolean won=false;
        int n,i;
        for (i=1;i<=5;i++){
            System.out.print("Enter a number : ");
            n=input.nextInt();
            if (n>random_number)
                System.out.println(n+" is high...");
            else if(n<random_number)
                System.out.println(n+" is low...");
            else{
                won=true;
                break;
            }

        }
        if(won)
            System.out.println("Congratulations...\nYou won the game in "+i+" attempts..");
        else
            System.out.println("Oops you lost the game... and the random number is "+random_number);
    }
}