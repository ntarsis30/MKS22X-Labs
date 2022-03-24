import java.util.*;
public class Merge{
    public static void mergesort(int[] data){
        int[] temp = new int[data.length];
        mergesortH(data,temp,0,data.length-1);
    }
    public static void mergesortH(int[] data, int[] temp, int leftIndex, int rightIndex){
        if (rightIndex>leftIndex){
            int middleIndex = (rightIndex+leftIndex)/2;
            mergesortH(data,temp,leftIndex,middleIndex);
            mergesortH(data,temp,middleIndex+1,rightIndex);
            merge(data,temp,leftIndex,rightIndex);
        }
    }
    public static void merge(int[]destination, int[]temp, int leftIndex,int rightIndex){
        int old = leftIndex, curr = leftIndex;
        int currRight = (rightIndex+leftIndex)/2+1, leftBound = currRight;
        while (leftIndex < leftBound && currRight <= rightIndex){
            if (destination[leftIndex] <= destination[currRight]){
                temp[curr]=destination[leftIndex];
                leftIndex++;
            }
            else{
                temp[curr]=destination[currRight];
                currRight++;
            }
            curr++;
        }
        while(leftIndex < leftBound){
            temp[curr]=destination[leftIndex];
            curr++;
            leftIndex++;
        }
        while(currRight <= rightIndex){
            temp[curr]=destination[currRight];
            curr++;
            currRight++;
        }
        for (int i = old; i <= rightIndex; i++){
            destination[i]=temp[i];
        }
    }
    public static void main(String[] args){
        int[] test = {4,3,2,10,7,4,11,200,6,8,3,150,3,1,-1,0};
        mergesort(test);
        System.out.println(Arrays.toString(test));

        
    }
}