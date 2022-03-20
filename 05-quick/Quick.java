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
            if (data[i] <= data[end]){
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
    public static int[] partitionDutch(int[] data,int lo, int hi){
        Random rand = new Random();
        int pivot = rand.nextInt(hi-lo+1) + lo;
        int val = data[pivot];
        int temp = data[hi];
        data[hi] = data[pivot];
        data[pivot] = temp;
        int new_pivot = lo;
        while (new_pivot <= hi){
            if (data[new_pivot] < val){
                int swap = data[lo];
                data[lo] = data[new_pivot];
                data[new_pivot] = swap;
                lo++;
                new_pivot++;
            }
            else if (data[new_pivot] > val){
                int swap = data[new_pivot];
                data[new_pivot] = data[hi];
                data[hi] = swap;
                hi--;
            }
            else{
                new_pivot++;
            }
        }
    int[] ans = new int[] {lo-1,new_pivot};
    return ans;
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
    public static void quicksort(int[] data){
        quicksort(data,0,data.length-1);
    }
    public static void quicksort(int[] data,int lo,int hi){
        //your code.
        if (lo < hi){
            int[] pivot = partitionDutch(data, lo, hi);
            quicksort(data, lo, pivot[0]);
            quicksort(data, pivot[1], hi);
        }
    }
    public static void main(String[] args){
        int [] data = new int[] {4,3,2,1,0};
        //int [] data = new int[] {4,3,2,1,0,997,998,999};
        //int [] data = new int[] {997,998,999,4,3,2,1,0};
        //int[] data = new int[] {1,1,1,1,1,1,1,1,1,1};
        System.out.println("Original: "+Arrays.toString(data));
        for (int i = 0; i < data.length; i++){
            //System.out.println(quickselect(data,i));
        }
        quicksort(data);

        int pivot[] = partitionDutch( data , 0, 4);
        //int pivot = partition( data , 3, 7);
        //System.out.println(pivot[0] + " " + pivot[1]  + " " + pivot[2]);
        System.out.println("Modified: "+Arrays.toString(data));

        System.out.println();
    }
}