import java.util.*;
public class QuadraticEquation{
    public static void main(String[] args){
        int a,b,c,d;
        double r1,r2;
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the values of a,b and c : ");
        a=input.nextInt();
        b=input.nextInt();
        c=input.nextInt();
        d=(b*b)-4*a*c;
        System.out.println("Discriminant : "+d);
        if(d>0){
            System.out.println("Roots are real and distinct");
            r1= (-b+Math.sqrt(d))/(2*a);
            r2= (-b-Math.sqrt(d))/(2*a);
            System.out.println("Root 1 : "+r1+"\nRoot 2 : "+r2);
        }
        else if(d==0){
            System.out.println("The roots are real and same");
            r1=-b/2*a;
            r2=r1;
            System.out.println("Root 1 : "+r1+"\nRoot 2 : "+r2);
        }
        else {
            System.out.println("Roots are imaginary and distinct");
            System.out.println("Root 1 : "+(-b/2*a)+" + i "+d);
            System.out.println("Root 2 : "+(-b/2*a)+" - i "+d);
        }
    }
}