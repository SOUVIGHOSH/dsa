// LC 2550  
class Solution {
    public int monkeyMove(int n) {
        //collision will not happen if all of them are in same either clockwise or anticlock
        // so toal number of ways 2^n -n is the answer
        // trick here is to handle modulo operation
        
        
        if(n==2) return 1;
        
        int result= (int)(helper(2,n,1)-2);
        //to avoid neg value we add the modulo and then do mod again
        result += 1000000007;
        result %= 1000000007;
        return result;
    }
    
    
    private long helper(int base,int exp,int res){
        long mod=1000000007;
        if(exp==1) return base;
        else if(exp%2==0) {
            long part =(helper(base,exp/2,res));
            //System.out.println(part);
            return ((part%mod) * (part%mod))%mod;
        }
        else{
            long part =helper(base,(exp-1)/2,res);
            //System.out.println(part);
            return (2*(part%mod)*(part%mod))%mod;
        }
    }
}
