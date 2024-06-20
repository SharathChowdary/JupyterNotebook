import java.util.Scanner;
public class ComparingTwoStrings{
    public static void main(String[] args){
        String names[]={"James","Binny","Tim","Alex","Kevin"};
        int id[]={101,105,106,112,115};
        for(String name:names)
            System.out.print(name+"   ");
        System.out.print("\nEnter a name : ");
        Scanner input=new Scanner(System.in);
        String name=input.next();
        for (int i=0;i<names.length;i++){
            if(name.equals(names[i])){
                System.out.println("ID of "+name+" is "+id[i]);
            }
        }
    }
}