//brute
// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         int n = nums.length;
//         for(int i = 0; i < n; ++i) {
//             for(int j = i+1; j < n; ++j) {
//                 if(nums[i] == nums[j]) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }

//better
// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         Arrays.sort(nums);
//         for(int i = 1; i < nums.length; ++i) {
//             if(nums[i] == nums[i-1]) {
//                 return true;
//             }
//         }
//         return false;
//     }
// }

//best
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            if(set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }
}
