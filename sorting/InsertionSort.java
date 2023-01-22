public class InsertionSort {

    
    public static void main(String[] args) {
        int[] arr= {5,4,3,2,1};
        new InsertionSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    // time complexity O(n2) Space complexity O(1)
    // Insertion sort is a stable sort. During the selection sort process,
    // we will only swap the ordering of any two items if the item on the right is less than the item to its left.
    // Therefore, the ordering of two equivalent items will always be preserved in insertion sort.
    public void sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int j=i;
            while(j>0 && arr[j-1]>arr[j]){
                int temp=arr[j];
                arr[j]=arr[j-1];
                arr[j-1]=temp;
                j--;
            }
        }
    }
    
}
