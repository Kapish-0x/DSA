class Solution {
    public int minimumCardPickup(int[] cards) {
        int left = 0;
        int min = Integer.MAX_VALUE;

        int maxValue = 0;

        for(int i = 0; i < cards.length; i++) {
            maxValue = Math.max(maxValue, cards[i]);
        }

        int[] freq = new int[maxValue + 1];

        for(int i = 0; i < cards.length; i++) {

            freq[cards[i]]++;

            while(freq[cards[i]] == 2) {

                min = Math.min(min, i - left + 1);

                freq[cards[left]]--;
                left++;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}