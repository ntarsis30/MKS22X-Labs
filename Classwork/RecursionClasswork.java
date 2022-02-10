public class RecursionClasswork{
    public static boolean groupSum(int start, int[] nums, int target) {
        if(target==0){
            return true;
        }
        if (target<0){
            return false;
        }
        if (start<nums.length){
            return groupSum(start+1, nums, target-nums[start])||groupSum(start+1, nums, target);
        }
        return false;
    }
    public static boolean splitArray(int[] nums) {
        int half_sum = 0;
        for (int i : nums){
            half_sum+=i;
        }
        if(half_sum%2==1){
            return false;
        }
        return groupSum(0,nums,half_sum/2);
    }

    public static void main(String[] args){
        int[] test = {8,4,2};
        int[] test1 = {2,2};
        int[] test2 = {2,3};        
        int[] test3 = {5,2,3};
        System.out.println(groupSum(0,test,10));
        System.out.println(groupSum(0,test,14));
        System.out.println(groupSum(0,test,9));
        System.out.println(splitArray(test1));
        System.out.println(splitArray(test2));
        System.out.println(splitArray(test3));
    }
}