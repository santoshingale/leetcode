class Solution {
    public int checkRecord(int n) {
        int mod = (int)1e9 + 7;
        int[][] prevDp = new int[2][3];
        prevDp[0][0] =1 ;
        prevDp[0][1] =1 ;
        prevDp[0][2] =1 ;
        prevDp[1][0] =1 ;
        prevDp[1][1] =1 ;
        prevDp[1][2] =1 ;

        for(int i = 1; i <= n; i++){
            int[][] newdp = new int[2][3];
            for(int a = 0; a < 2; a++){
                for(int l = 0; l < 3; l++){
                    newdp[a][l] = prevDp[a][2];
                    if(a > 0){
                        newdp[a][l] += prevDp[a - 1][2];
                        newdp[a][l] %= mod;
                    }
                    if(l > 0){
                        newdp[a][l] += prevDp[a][l - 1];
                        newdp[a][l] %= mod;
                    }
                }
            }
            prevDp = newdp;
        }
        return prevDp[1][2];
    }
}