package DP;
import java.util.*;
public class knapsack {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of weights: ");
        int n=sc.nextInt();
        System.out.println("Enter the target weight: ");
        int W=sc.nextInt();
        int[] wt=new int[n];
        int[] val= new int[n];

        System.out.println("Enter the weights: ");
        for(int i=0;i<n;i++)
        {
            wt[i]=sc.nextInt();
        }
        System.out.println("Enter the values: ");
        for(int i=0;i<n;i++)
        {
            val[i]=sc.nextInt();
        }
        System.out.println("The maximum profit is: "+ knap(wt,val,W,n));

    }

    private static int knap(int[] wt, int[] val, int w, int n)
    {
        int[][]dp=new int[n+1][w+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=w;j++)
            {
                if(i==0 || j==0)
                {
                    dp[i][j]=0;
                }
            }
        }

         for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=w;j++)
            {
                if(wt[i-1]<=j)
                {
                    dp[i][j]=Math.max(val[i-1]+dp[i-1][j-wt[i-1]], dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[n][w];
    }
}
