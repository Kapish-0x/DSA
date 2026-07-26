class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    public void solve(int i, int t, int[] candidates, List<Integer> temp) { 
        if(i >= candidates.length || t < 0) {
            return;
        }
        if(t == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(candidates[i]);
        solve(i, t-candidates[i], candidates, temp);
        temp.remove(temp.size() - 1);
        solve(i+1, t, candidates, temp);
    } 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        solve(0,target,candidates, temp);
        return res;
    }
}