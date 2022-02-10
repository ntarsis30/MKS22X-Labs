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
    public static boolean groupSum6(int start, int[] nums, int target) {
        if(start==nums.length){
            return target == 0;
        }
        if (nums[start]==6){
            return groupSum6(start+1, nums, target-nums[start]);
        }
        return groupSum6(start+1, nums, target-nums[start])||groupSum6(start+1, nums, target);
    }
    public static boolean groupNoAdj(int start, int[] nums, int target) {
        if(start>=nums.length){
            return target == 0;
        }
        return groupNoAdj(start+1, nums, target)||groupNoAdj(start+2, nums, target-nums[start]);
    }
    public static boolean splitOdd10(int[] nums) {
        int sum = 0;
        for (int i : nums){
            sum+=i;
        }
        return helpSplit10(0,nums,0,sum);
    }
    public static boolean helpSplit10(int start, int[] nums, int sum1, int sum2){
        if (sum1%10==0 && sum2%2==1){
            return true;
        }
        if (start<nums.length){
            return helpSplit10(start+1, nums, sum1+nums[start],sum2-nums[start])||helpSplit10(start+1, nums, sum1, sum2);
        }
        return false;
    }
    public static boolean split53(int[] nums) {
        int sum = 0;
        for (int i : nums){
            sum+=i;
        }
        return helpSplit53(0,nums,0,sum);
    }
    public static boolean helpSplit53(int start, int[] nums, int sum1, int sum2){
        if (sum1==sum2){
            return true;
        }
        if (start<nums.length){
            if (nums[start]%5==0){
                return helpSplit53(start+1, nums, sum1+nums[start],sum2-nums[start]);
            }
            else if (nums[start]%3==0){
                return helpSplit53(start+1,nums,sum1,sum2);
            }
            return helpSplit53(start+1, nums, sum1+nums[start],sum2-nums[start])||helpSplit53(start+1,nums,sum1,sum2);
        }
        return false;
    }
    public static boolean groupSum5(int start, int[] nums, int target) {
        if(start>=nums.length){
            return target == 0;
        }
        if (nums[start]%5==0){
            if (start<nums.length-1 && nums[start+1]%5==1){
                return groupSum5(start+2, nums, target-nums[start]);
            }
            return groupSum5(start+1, nums, target-nums[start]);
        }
        return groupSum5(start+1, nums, target-nums[start])||groupSum5(start+1, nums, target);
  
    }




    public static void main(String[] args){
        int[] test = {8,4,2};
        int[] test1 = {2,2};
        int[] test2 = {2,3};        
        int[] test3 = {5,2,3};
        int[] test4 = {5,6,2};
        int[] test5 = {2,5,10,4};
        int[] test6 = {5,5,5};
        int[] test7 = {5,5,6};
        int[] test8 = {5,5,6,1};
        int[] test9 = {1,1};
        int[] test10 = {1,1,1};
        int[] test11 = {2,4,2};

        System.out.println(groupSum(0,test,10));
        System.out.println(groupSum(0,test,14));
        System.out.println(groupSum(0,test,9));

        System.out.println(splitArray(test1));
        System.out.println(splitArray(test2));
        System.out.println(splitArray(test3));

        System.out.println(groupSum6(0,test4,8));
        System.out.println(groupSum6(0,test4,9));
        System.out.println(groupSum6(0,test4,7));

        System.out.println(groupNoAdj(0,test5,12));
        System.out.println(groupNoAdj(0,test5,14));
        System.out.println(groupNoAdj(0,test5,7));

        System.out.println(splitOdd10(test6));
        System.out.println(splitOdd10(test7));
        System.out.println(splitOdd10(test8));

        System.out.println(split53(test9));
        System.out.println(split53(test10));
        System.out.println(split53(test11));

        System.out.println(groupSum5(0,test5,19));
        System.out.println(groupSum5(0,test5,17));
        System.out.println(groupSum5(0,test5,12));
    }
}