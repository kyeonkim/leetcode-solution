class Solution {
    public int trap(int[] height) {
        int total = 0;
        int left = 0, right = height.length - 1;
        int leftMax = height[left], rightMax = height[right];
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                if (leftMax < height[left])
                    leftMax = height[left];
                else
                    total += leftMax - height[left];
            } else {
                right--;
                if (rightMax < height[right])
                    rightMax = height[right];
                else
                    total += rightMax - height[right];
            }
        }
        return total;
    }
}