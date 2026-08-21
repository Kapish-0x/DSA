//Brute Force
// class Solution {
//     public int lastStoneWeight(int[] stones) {
//         int n = stones.length;
//         for(int i = 0; i < n - 1; ++i) {
//             Arrays.sort(stones);
//             stones[n-1] = stones[n-1] - stones[n-2];
//             stones[n-2] = 0;
//         }
//         Arrays.sort(stones);
//         return stones[n-1];
//     }
// }

//Priority Queue (MAX HEAP)
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); //reverse because in java pq is default a min heap and here we need max heap
        for(int i : stones) {
            pq.add(i);
        }
        while(pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            if(first != second) {
                pq.add(first - second);
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}

