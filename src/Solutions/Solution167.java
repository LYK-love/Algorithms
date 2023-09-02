package Solutions;

public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;

        while(left<right)
        {
            int sum = numbers[left] + numbers[right];
            if(sum == target)
            {
                return new int[]{left + 1,right + 1};//The array index is 0-indexed, but the answer required is 1-indexed, so plus one.
            } else if (sum > target) {
                right--;
            }
            else {
                left++;
            }
        }
        return null;
    }
}
