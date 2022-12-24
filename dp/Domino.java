/*
 reference: https://leetcode.com/problems/domino-and-tromino-tiling
 the main difficult thing of this problem is to reduce it to two mathematical equation
 F(k)=F(k-1)+F(K-2)+2*P(K-1)
 P(K)=P(K-1)+F(K-2)
 O(N) TC & SC
*/
class Domino {
    public int numTilings(int n) {
        int mod=(int)(1e9)+7;
        if(n<=2) return n;
        long[] full = new long[n+1];
        long[] partial = new long[n+1];
        full[1]=1;
        full[2]=2;
        partial[1]=0;
        partial[2]=1;
        for(int i=3;i<=n;i++){
            full[i]=(full[i-2]+full[i-1]+partial[i-1]*2)%mod;
            partial[i]=(partial[i-1]+full[i-2])%mod;
        }
        return (int)full[n];
    }
}
