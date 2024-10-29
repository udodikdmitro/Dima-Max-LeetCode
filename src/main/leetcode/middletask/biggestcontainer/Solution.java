package main.leetcode.middletask.biggestcontainer;

public class Solution {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int[] width = new int[height.length]; //width[i] is the greatest possible width where one of the sides is height[i]
        for (int i = 0; i < height.length; i++) {
            width[i] = findGreatestWidth(height, i);
        }

        for (int i = 0; i < width.length; i++) {
            int area = width[i] * height[i];
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }

    /*
    Looks for the highest width of the container, the height being height[i]
     */
    private int findGreatestWidth(int[] height, int i) {
        int maxDistance = 0;
        for (int j = 0; j < i; j++) {
            if (height[j] >= height[i]) {
                maxDistance = i - j;
                break;  //no interest in continuing the loop because the nearer to the beginning/end of the array other side is, the greater the width
            }
        }
        for (int j = height.length - 1; j > i; j--) {
            if (height[j] >= height[i]) {
                maxDistance = j - i;
                break;
            }
        }
        return maxDistance;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(new int[]{6, 3, 4, 5, 6, 2, 4, 7, 5, 1}));
         }
}
