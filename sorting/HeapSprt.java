package com.dsa.dsa.sort;

import java.util.Arrays;

//nlogn not stable
public class HeapSort {
    
    public void sort(int[] arr){
        Heap heap=new Heap(arr.length);
        heap.initialize(arr);
        for(int i=0;i<arr.length;i++) {
            heap.poll();
            System.out.println((heap));
        }
        System.out.println(heap);
    }

    class Heap{
        int[] arr;
        int N=0;
        Heap(int size){
            arr=new int[size+1];
        }
        public void initialize(int[] num){
            for(int i=0;i<num.length;i++) offer(num[i]);
            System.out.println(Arrays.toString(arr));
        }
        public void offer(int a){
            N++;
            arr[N]=a;
            swim(N);
        }
        public void swim(int a){
            while(a>1 && arr[a]>arr[a/2]){
                swap(a,a/2);
                a=a/2;
            }
        }
        public void swap(int a,int b){
            int temp=arr[a];
            arr[a]=arr[b];
            arr[b]=temp;
        }

        public void sink(int a){
            int j=2*a;
            while(2*a<=N){
                if(j+1 <=N && arr[j]<arr[j+1]) j++;
                if(arr[a] > arr[j]) break;
                swap(a,j);
                a=j;
            }
        }

        public void poll(){
            swap(1,N--);
            sink(1);
        }

        @Override
        public String toString(){
            int[] result= new int[arr.length-1];
            for(int i=1;i<arr.length;i++) result[i-1]=arr[i];
            return Arrays.toString(result);
        }

    }
}
