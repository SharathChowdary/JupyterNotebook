import java.util.*;
public class RectangleClassExample{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        Rectangle[] rectangles=new Rectangle[3];
        for(int i=0;i<rectangles.length;i++){
            System.out.print("Do you want to enter the values (y/n) : ");
            char choice=input.next().charAt(0);
            if (choice=='y'){
                System.out.print("Enter length and breadth for Rectangle "+(i+1)+" : ");
                rectangles[i]=new Rectangle(input.nextInt(),input.nextInt());
            }
            else{
                System.out.println("Default values are length : 1 and breadth : 1");
                rectangles[i]=new Rectangle();
            }
        }
        for(int i=0;i<rectangles.length;i++){
            System.out.println(rectangles[i].getValues());
        }
    }
}
class Rectangle{
    private double width,length;
    Rectangle(){
        this(1.0,1.0);
    }
    Rectangle(double width,double length){
        this.width=width;
        this.length=length;
    }
    void setValues(double length,double width){
        this.length=length;
        this.width=width;
    }
    String getValues(){
        return this.length+" "+this.width;
    }
    double getArea(){
        return this.length*this.width;
    }
    double getPerimeter(){
        return 2*(this.length+this.width);
    }
}