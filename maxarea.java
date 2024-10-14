import java.util.Scanner;

public class MaxArea {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int area = h * w;
            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaxArea solution = new MaxArea();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the height array (space-separated values): ");
        String[] input = scanner.nextLine().split(" ");
        int[] height = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            height[i] = Integer.parseInt(input[i]);
        }
        int maxArea = solution.maxArea(height);
        System.out.println("Maximum area: " + maxArea);
    }
}