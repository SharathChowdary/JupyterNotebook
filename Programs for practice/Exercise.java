import java.awt.*;
import java.util.*;
public class Exercise{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter the length of an Array : ");
        int n=input.nextInt();
        Point[] p=new Point[n];
        for(int i=0;i<p.length;i++){
            System.out.print("Enter x and y for point "+(i+1)+" : ");
            Arrays.fill(p,i,i+1,new Point(input.nextInt(),input.nextInt()));
        }
        for(int i=0;i<p.length;i++){
            System.out.print(p[i]+" ");
        }
    }
}