package DP;
import java.util.*;
public class equalpartition {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of numbers: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the numbers: ");
        int sum=0;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }
        if(sum%2!=0)
        {
            System.out.println("There can't be equal sum partition in the subset");
        }
        else{
            if(checksubsetsum(arr,sum/2))
            {
                System.out.println("The equal partion is possible.");
            }
            else{
                System.out.println("The equal partition isn't possible");
            }
        }
    }

    static boolean checksubsetsum(int[] arr, int sum)
    {
        int n=arr.length;
        boolean[][] dp=new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=sum;j++)
            {
                if(i==0)
                {
                    dp[i][j]=false;
                }
                if(j==0)
                {
                    dp[i][j]=true;
                }
            }
        }

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(arr[i-1]<=j)
                {
                    dp[i][j]=(dp[i-1][j-arr[i-1]])||(dp[i-1][j]);
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
    
}
