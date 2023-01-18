class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // maximum sum of the array
        int normal = kadaneMax(nums);
        int[] arr=new int[nums.length];
        //keeping first and last element 0 because we want to find min sum of middle range
        for(int i=1;i<nums.length-1;i++){
            arr[i]=-nums[i];
        }
        int min = -kadaneMax(arr);
        int sum= Arrays.stream(nums).sum();
        return Math.max(normal,sum-min);
    }
    
    private int kadaneMax(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int sum=0;
        for(int a:arr){
            if(sum+a < a) sum=a;
            else sum+=a;
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }
}
