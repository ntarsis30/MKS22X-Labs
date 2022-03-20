import java.util.*;
public class Quick{
    public static int partition(int[] data, int start, int end){
        Random rand = new Random();
        int pivot = rand.nextInt(end-start+1) + start;
        int temp = data[end];
        data[end] = data[pivot];
        data[pivot] = temp;
        int new_pivot = start-1;
        boolean right = true;
        for (int i = start; i < end; i++){
            if(data[i] <= data[end]){
                if (data[i]==data[end] && right){
                    //already on the right of new_pivot, so no swap
                    right = false;
                }
                else{
                    new_pivot++;
                    int swap = data[new_pivot];
                    data[new_pivot] = data[i];
                    data[i]= swap;
                    right = true;
                }
            }
        }
        int fix = data[new_pivot+1];
        data[new_pivot+1] = data[end];
        data[end] = fix;
        return new_pivot+1;
    }
    public static int quickselect(int[] data, int k){
        int lo = 0;
        int hi = data.length-1;
        while (lo <= hi){
            int pivot = partition(data,lo,hi);
            if (pivot==k){
                return data[pivot];
            }
            else if (k < pivot){
                hi = pivot-1;
            }
            else{
                lo = pivot+1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        //int [] data = new int[] {4,3,2,1,0};
        //int [] data = new int[] {4,3,2,1,0,997,998,999};
        int [] data = new int[] {997,998,999,4,3,2,1,0};
        System.out.println("Original: "+Arrays.toString(data));
        //int pivot = partition( data , 0, 4);
        //int pivot = partition( data , 3, 7);
        //System.out.println("Pivot value: "+data[pivot]+ ", Pivot index: "+pivot);
        //System.out.println("Modified: "+Arrays.toString(data));
        
        System.out.println();
    }
}