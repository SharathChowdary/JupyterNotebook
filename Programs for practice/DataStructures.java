public class DataStructures {
    public static void main(String[] args) {
        int[] arr = {4, 56, 2, 45, 80, 87, 53, 74, 24, 35, 75};
        int target = 74;
        MergeSort.sort(arr);
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
        int res = RecBinarySearch.search(0,arr.length-1,arr,target);
        if (res == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index " + res);

    }
}
class LinearSearch{
    public static int search(int[] arr,int target){
        for(int i=0;i<arr.length;i++){
            if (arr[i]==target)
                return i;
        }
        return -1;
    }
}
class BinarySearch{
    public static int search(int[] arr,int target){
        int start=0,end=arr.length-1,mid;
        while(start<=end){
            mid=(start+end)/2;
            if(arr[mid]==target)
                return mid;
            else if(arr[mid]>target)
                end=mid-1;
            else
                start=mid+1;
        }
        return -1;
    }
}
class RecBinarySearch{
    public static int search(int start,int end,int[] arr,int target){
        int mid=(start+end)/2;
        if(start<=end){
            if(arr[mid]==target)
                return mid;
            else if(arr[mid]>target)
                return search(start,mid-1,arr,target);
            else
                return search(mid+1,end,arr,target);
        }
        return -1;
    }
}
class BubbleSort{
    public static void sort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}
class SelectionSort{
    public static void sort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int mini=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[mini]>arr[j]){
                    int temp=mini;
                    mini=j;
                    j=temp;
                }
            }
            int temp=arr[i];
            arr[i]=arr[mini];
            arr[mini]=temp;
        }
    }
}
class QuickSort{
    public static void sort(int start,int end,int[] arr){
        if (start<end){
            int pi=quicksort_partition(start,end,arr);
            sort(start,pi-1,arr);
            sort(pi+1,end,arr);
        }
    }
    public static int quicksort_partition(int start,int end,int[] arr){
        int pivot_index=start;
        int pivot=arr[pivot_index];
        while(start<end){
            while(start<arr.length && arr[start]<=pivot)
                start+=1;
            while(end>=0 && arr[end]>pivot)
                end-=1;
            if(start<end){
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
            }
        }
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
        return end;
    }
}
class MergeSort{
    public static void sort(int[] arr){
        if (arr.length<=1)
            return;
        int mid=(arr.length)/2;
        int[] left=new int[arr.length%2==0?mid:mid+1];
        int[] right=new int[mid];
        int i=0;
        while(i<left.length){
            left[i]=arr[i];
            i++;
        }
        int j=0;
        while(j<right.length){
            right[j]=arr[i];
            j++;
            i++;
        }
        sort(left);
        sort(right);
        merge_two_arrays(left,right,arr);

    }
    public static void merge_two_arrays(int[] a,int[] b,int[] arr){
        int i=0,j=0,k=0;
        while(i<a.length && j<b.length){
            if(a[i]<b[j]){
                arr[k]=a[i];
                i++;
            }
            else{
                arr[k]=b[j];
                j++;
            }
            k++;
        }
        while (i<a.length){
            arr[k]=a[i];
            i++;
            k++;
        }
        while(j<b.length){
            arr[k]=b[j];
            j++;
            k++;
        }
    }
}

