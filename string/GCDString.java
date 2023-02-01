//https://leetcode.com/problems/greatest-common-divisor-of-strings
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        StringBuilder sb1 = new StringBuilder();
        sb1.append(str1);
        sb1.append(str2);
        
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(str1);
        
        if(!sb1.toString().equals(sb2.toString())) return "";
        int n=gcd(str1.length(),str2.length());
        return str1.substring(0,n);
    }
    
    private int gcd(int a,int b){
        if(b>a) return gcd(b,a);
        if(a%b==0) return b;
        return gcd(a-b,b);
    }
}
