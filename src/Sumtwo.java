import java.util.HashMap;

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
public class Sumtwo {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        boolean finish = false;
        for(int i = 0; i < nums.length-1;i++){
            if(finish){
                break;
            }
            for (int j = i + 1;j<= nums.length-1;j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    finish = true;
                    break;
                }
            }
        }
        return result;
    }

    public int[] twoSumHash(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> hashMap = new HashMap();
        for(int i = 0; i < nums.length;i++){
            if(hashMap.containsKey(nums[i])){
                result[0] = i;
                result[1] = hashMap.get(nums[i]);
                break;
            }
            hashMap.put(target-nums[i],i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = new Sumtwo().twoSumHash(nums,target);
        System.out.println(result[0] + "--" +result[1]);
    }
}
