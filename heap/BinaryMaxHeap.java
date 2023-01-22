package com.dsa.dsa.heap;

import java.util.ArrayList;
import java.util.List;

public class BinaryMaxHeap {
    List<Integer> list;
    public BinaryMaxHeap(){
        list = new ArrayList<>();
        list.add(-1);
    }
    // logn time complexity
    public void offer(int a){
        list.add(a);
        swim(list.size()-1);
    }

    public void swim(int n){
        while(n>1 && list.get(n) > list.get(n/2)){
            swap(n,n/2);
            n=n/2;
        }
    }

    public void swap(int a,int b){
        int temp=list.get(a);
        list.set(a,list.get(b));
        list.set(b,temp);
    }

    public void sink(int n){
        while(2*n < list.size()){
            int j=2*n;
            if(j+1 <list.size() && list.get(j)<list.get(j+1)) j++;
            if(list.get(j) < list.get(n)) break;
            swap(j,n);
            n=j;
        }
    }
    //O(logn)
    public int poll(){
        if(size()==0) throw new UnsupportedOperationException();
        int max=list.get(1);
        swap(1,list.size()-1);
        list.remove(list.size()-1);
        sink(1);
        return max;
    }

    public boolean isEmpty(){
        return list.size()==1;
    }

    public int size(){
        return list.size()-1;
    }

    @Override
    public String toString(){
        List<Integer> l=new ArrayList<>();
        for(int i=1;i<list.size();i++) l.add(list.get(i));
        return l.toString();
    }
}
