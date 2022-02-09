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
  public static void main(String[] args){
    int[] test = {2,4,8};
    System.out.println(groupSum(0, test, 10));
    System.out.println(groupSum(0,test, 14));
    System.out.println(groupSum(0,test, 9));
  }

}
