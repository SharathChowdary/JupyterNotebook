import java.util.*;
public class Arr_odd_even{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int[] nums={45,12,36,11,45,88,97,16,17};
        int start=0,end=nums.length-1,temp;
        while(start<end){
            while(start< nums.length && nums[start]%2==1)
                start+=1;
            while(end>=0 && nums[end]%2==0)
                end-=1;
            temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            System.out.println(Arrays.toString(nums));
        }
    }
}