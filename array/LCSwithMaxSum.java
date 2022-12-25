// (m+n)logn time o(n) space
// https://leetcode.com/problems/longest-subsequence-with-limited-sum/solution/
class LCSwithMaxSum {
    public int[] answerQueries(int[] nums, int[] queries) {
        //sorting array so that we can take a sprted prefix sum
        Arrays.sort(nums);
        // preifx sum of sorted number
        int[] prefix=new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];
        }
        int[] ans=new int[queries.length];
        // binary search into sorted prefix sum
        for(int i=0;i<queries.length;i++){
            int index= Arrays.binarySearch(prefix,queries[i]);
            // if position found
            if(index>=0) ans[i]=index+1;
            // if not found index = -(insertion_point)-1
            // insertion point = -index-1;
            else ans[i]=-index-1;
        }
        return ans;
    }
}
