import java.util.*;
public class Quick{
    public static int partition( int [] data, int start, int end){
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
}