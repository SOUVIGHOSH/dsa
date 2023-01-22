class MergeSort {
    //O(nlogn) & On space & stable
  // only insertion and selection sort is inplace, so ergesort is not inplace.
    public int[] sort(int[] arr){
        int start=0,end=arr.length;
        if(arr.length <=1) return arr;
        int mid=start+(end-start)/2;
        int[] low = sort(Arrays.copyOfRange(arr,0,mid));
        int[] high=sort(Arrays.copyOfRange(arr,mid,end));
        return merge(low,high);
    }
    public int[] merge(int[] a,int[] b){
        int p1=0,p2=0,k=0;
        int[] nums = new int[a.length+b.length];
        while(p1<a.length && p2<b.length){
            if(a[p1]<b[p2]) nums[k++]=a[p1++];
            else nums[k++]=b[p2++];
        }
        while(p1<a.length){
            nums[k++]=a[p1++];
        }
        while(p2<b.length){
            nums[k++]=b[p2++];
        }
        return nums;
    }
}
