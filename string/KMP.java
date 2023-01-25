package com.dsa.dsa.string;

import java.util.Arrays;

// We get find subtring using two point in O(m*n) time
// KMP solves this problem in O(m+n) time


public class KMP {

    //o(m)
    public int[] buildLSP(String pattern){
        int[] lsp = new int[pattern.length()];
        int j=0;
        for(int i=1;i<pattern.length();){
            if(pattern.charAt(i)==pattern.charAt(j)){
                lsp[i]=j+1;
                i++;j++;
            }
            else{
                if(j!=0){
                    j=lsp[j-1];
                }
                else{
                    lsp[i]=0;
                    i++;
                }
            }
        }
        return lsp;
    }
  ` 
    public int indexOf(String str,String pattern){
        int[] lsp= buildLSP(pattern);
        int i=0,j=0;
        while(i<str.length() && j<pattern.length()){
            System.out.println(i+" "+j);
            if(str.charAt(i)==pattern.charAt(j)){
                i++;
                j++;
                if(j==pattern.length()) return i-pattern.length();
            }
            else if(j!=0){
                j=lsp[j-1];
            }
            else{
                i++;
            }
        }
        return -1;
    }
    
}
