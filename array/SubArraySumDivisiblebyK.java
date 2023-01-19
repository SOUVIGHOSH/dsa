class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int[] prefix=new int[nums.length+1];
        int count=0;
        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=1;i<prefix.length;i++){
            // main trick is here
            // take modulo twice to avoid negative remainder
            prefix[i]=(prefix[i-1]+nums[i-1]%k+k)%k;
            count += map.getOrDefault(prefix[i],0);
            map.put(prefix[i],map.getOrDefault(prefix[i],0)+1);
        }
        
        return count;
    }
}
