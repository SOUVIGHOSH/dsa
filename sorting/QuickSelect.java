class QuickSelect {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,0,nums.length-1,nums.length-k);
    }
    public int quickSelect(int[] nums,int start,int end,int target){
        int mid=(start+end)/2;
        int pivot= partition(nums,start,end,mid);
        if(pivot==target) return nums[target];
        // as we do not need to run quickselect to both part of pivot the time complexity is O(n) in average & On2 in worst, O1 space
        else if(pivot > target) return quickSelect(nums,start,pivot-1,target);
        else return quickSelect(nums,pivot+1,end,target);
    }
    public int partition(int[] nums,int low,int high,int pivot_index){
        int pivot=nums[pivot_index];
        swap(nums,pivot_index,high);
        int index=low;
        for(int i=low;i<high;i++){
            if(nums[i] < pivot) swap(nums,index++,i);
        }
        swap(nums,index,high);
        return index;
    }
    public void swap(int[] arr, int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
