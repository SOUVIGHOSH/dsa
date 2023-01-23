package com.dsa.dsa.rangequery;

public class SegmentTree {

    int[] input, sTree;

    
    public SegmentTree(int[] arr){
        this.input=arr;
        int height = (int)Math.ceil(Math.log(arr.length)/Math.log(2));
        sTree = new int[(int)Math.pow(2,height+1)-1];
        constructTree(0,arr.length-1,0);
    }
    //O(n) to construct O(n) space to construct
    private void constructTree(int low, int high, int pos) {
        if(low==high) {sTree[pos]=input[low];return;}
        int mid=(low+high)/2;
        constructTree(low, mid, pos*2+1);
        constructTree(mid+1, high, pos*2+2);
        sTree[pos]=sTree[pos*2+1]+sTree[pos*2+2];
    }
    // O(logn) for each query
    public int rangeSum(int qlow,int qhigh){
        return rangeSumQuery(0,input.length-1,qlow,qhigh,0);
    }

    private int rangeSumQuery(int low, int high, int qlow, int qhigh, int pos) {
        //total overlap
        if(qlow <= low && qhigh >= high) return sTree[pos];
        //no overlap
        if(qlow > high  || qhigh < low) return 0;
        //partial overlap
        int mid=(low+high)/2;
        return rangeSumQuery(low, mid, qlow, qhigh, pos*2+1) + rangeSumQuery(mid+1, high, qlow, qhigh, pos*2+2);
    }

    public void updateVal(int index,int val){
        int diff = val -input[index];
        input[index]=val;
        updateSegmentTree(0,input.length-1,index,diff,0);
    }

    private void updateSegmentTree(int low, int high, int index, int diff,int pos) {
        if(index < low || index > high) return;
        sTree[pos] += diff;
        if(low>=high) return;
        int mid=(low+high)/2;
        updateSegmentTree(low, mid, index, diff, pos*2+1);
        updateSegmentTree(mid+1, high, index, diff, pos*2+2);
    }
    
}
