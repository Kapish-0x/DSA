class Solution:
    def countSubarrays(self, nums: List[int], k: int) -> int:
        max_ele = max(nums)
        n = len(nums)

        i = 0
        found = 0
        res = 0

        for j in range(n):
            if nums[j] == max_ele:
                found += 1

            while found >= k:
                res += n - j
                if nums[i] == max_ele:
                    found -= 1
                i += 1

        return res