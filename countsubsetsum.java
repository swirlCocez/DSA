package DP;
import java.util.*;
public class countsubsetsum {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of numbers: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the target sum: ");
        int sum=sc.nextInt();
        System.out.println("Enter the numbers: ");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println("The number of times the sum of "+ sum+" is repeated in the given array is "+countsub(arr,sum));
    }

    static int countsub(int[] arr, int sum)
    {
        int n=arr.length;
        int[][] dp= new int[n+1][sum+1];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=sum;j++)
            {
                if(i==0)
                {
                    dp[i][j]=0;
                }
                if(j==0)
                {
                    dp[i][j]=1;
                }
            }
        }

        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(arr[i-1]<=j)
                {
                dp[i][j]= dp[i-1][j-arr[i-1]]+ dp[i-1][j];
                }
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
            
        }
        return dp[n][sum];

    }
}