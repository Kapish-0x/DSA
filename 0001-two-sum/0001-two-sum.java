class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hs =new HashMap<>();
        for(int i = 0; i < nums.length; ++i) {
            int curr = nums[i];
            int rem = target - curr;
            if(hs.containsKey(rem)) {
                return new int[] {hs.get(rem), i};
            }
            hs.put(curr, i);
        }
        return new int[] {};  //empty array
    }
}