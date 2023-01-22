class QuickSort {
  //nlogn time and logn space complexity not stable
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }
    
    public void quickSort(int[] arr,int low,int high){
        if(low >= high) return;
        int mid=(low+high)/2;
        int pivot = partition(arr,low,high,mid);
        quickSort(arr,low,pivot-1);
        quickSort(arr,pivot+1,high);
    }
    public int partition(int[] arr,int low,int high,int pivot_index){
        int p=arr[pivot_index];
        swap(arr,high,pivot_index);
        int index=low;
        for(int i=low;i<high;i++){
            if(arr[i]<p) swap(arr,index++,i);
        }
        swap(arr,index,high);
        return index;
    }
    public void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
