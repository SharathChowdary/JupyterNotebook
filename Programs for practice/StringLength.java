import java.util.*;
public class StringLength{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter a sentence : ");
        String str=input.nextLine();
        int len=get_length(str);
        System.out.println(len);
    }
    static int get_length(String str){
        int i=0;
        try{
            while (true){
                str.charAt(i);
                i++;
            }
        }
        catch (Exception e){
        }
        return i;
    }
}