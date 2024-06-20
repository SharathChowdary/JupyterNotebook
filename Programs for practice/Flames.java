import java.util.ArrayList;
import java.util.Scanner;
public class Flames{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        System.out.print("Enter boy name : ");
        String name1=input.nextLine();
        System.out.print("Enter girl name : ");
        String name2=input.nextLine();
        ArrayList<Character> flames=new ArrayList<>();
        flames.add('F');
        flames.add('L');
        flames.add('A');
        flames.add('M');
        flames.add('E');
        flames.add('S');
        ArrayList<Character> list1=new ArrayList<>();
        ArrayList<Character> list2=new ArrayList<>();
        list1=convertToList(name1,list1);
        list2=convertToList(name2,list2);
        if(list1.contains(' '))
            list1.remove(new Character(' '));
        if(list2.contains(' '))
            list2.remove(new Character(' '));
        ArrayList<Character> temp=new ArrayList<>();
        temp=(ArrayList)list1.clone();
        for(Character i : temp){
            if (list2.contains(i)){
                list1.remove(new Character(i));
                list2.remove(new Character(i));
            }
        }
        int length=list1.size()+list2.size();
        int flames_count=0,length_count=0;
        while (flames.size()>1){
            if(flames_count>flames.size()){
                flames_count=1;
            }
            if(length_count==length){
                flames.remove(flames_count-1);
                length_count=0;
                flames_count-=1;
            }
            flames_count+=1;
            length_count+=1;
        }
        switch (flames.get(0)){
            case 'F':System.out.print("You both are friends...");
                break;
            case 'L':System.out.print("You both are lovers...");
                break;
            case 'A':System.out.print("You both have attraction on each other...");
                break;
            case 'M':System.out.print("You will get married in future...");
                break;
            case 'E':System.out.print("You both are enemies...");
                break;
            default:System.out.print("You both are siblings...");
                break;
        }

    }
    public static ArrayList convertToList(String str,ArrayList<Character> lst){
        for(int i=0;i<str.length();i++){
            lst.add(str.charAt(i));
        }
        return lst;
    }
}