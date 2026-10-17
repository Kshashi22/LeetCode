class Solution {
    public int maximalSquare(char[][] matrix) {
        //initializing sentinal varibles
        int maxSqr=0 , rows=matrix.length , column=matrix[0].length;
        //base case
        if(rows==0) return 0;
        //dp matrix that we will be making
        int[][] dp=new int[rows+1][column+1];
		
        //Iterate over the matrix
        for(int i=1;i<=rows;i++)
            for(int j=1;j<=column;j++) {
                ///we found the 1 in our binary matrix 
                if(matrix[i-1][j-1]=='0') continue;
                dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i][j-1])) + 1;
                maxSqr=Math.max(maxSqr,dp[i][j]);
            }
        return maxSqr*maxSqr;
    }
}