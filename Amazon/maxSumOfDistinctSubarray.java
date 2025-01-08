package Amazon;
import java.util.Set;
import java.util.HashSet;
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n=nums.length;
        Set<Integer> elements=new HashSet<>();
        long currSum=0;
        long maxSum=0;
        int begin=0;

        for(int end=0;end<n;end++){
            if(!elements.contains(nums[end])){
                currSum+=nums[end];
                elements.add(nums[end]);

                if(end-begin+1==k){
                    maxSum=Math.max(maxSum, currSum);
                    currSum-=nums[begin];
                    elements.remove(nums[begin]);
                    begin++;
                }
            }
            else{
                while(nums[begin]!=nums[end]){
                    currSum-=nums[begin];
                    elements.remove(nums[begin]);
                    begin++;
                }
                begin++;
            }
        }
        return maxSum;
    }
}
