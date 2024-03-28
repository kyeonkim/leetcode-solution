class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        frequency = {}
        size = len(nums)
        left = 0
        right = 0
        answer = 0
        while right < size:
            if not nums[right] in frequency:
                frequency[nums[right]] = 1
            else:
                frequency[nums[right]] += 1
            while frequency[nums[right]] > k:
                frequency[nums[left]] -= 1
                left += 1
            answer = max(answer, right - left + 1)
            right += 1
        return answer