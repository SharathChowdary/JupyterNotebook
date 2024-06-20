import java.util.*;
public class Splitting_a_string{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter a Sentance : ");
        String str=input.nextLine();
        System.out.print("Enter split char : ");
        char spl=input.next().charAt(0);
        ArrayList<String> temp=split(str,spl);
        System.out.println(temp);
    }
    static ArrayList<String> split(String sentance,char spl){
        int i=0;
        String str_temp="";
        ArrayList<String> temp=new ArrayList<>();
        while(i<sentance.length()){
            if(sentance.charAt(i)==spl){
                temp.add(str_temp);
                str_temp="";
            }
            else {
                str_temp+=sentance.charAt(i);
                if(i==sentance.length()-1)
                    temp.add(str_temp);
            }
            i+=1;
        }
        return temp;
    }
}