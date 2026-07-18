class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currTank = 0;
        int startStation = 0;
        
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalTank += diff;
            currTank += diff;
            
            if (currTank < 0) {
                // can't start from any station between startStation and i
                startStation = i + 1;
                currTank = 0;
            }
        }
        
        return totalTank < 0 ? -1 : startStation;
    }
}