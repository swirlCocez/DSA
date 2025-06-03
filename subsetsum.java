package DP;
import java.util.*;
public class subsetsum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of integers: ");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the target sum: ");
        int sum=sc.nextInt();
        System.out.println("Enter the numbers: ");
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        if(subset(arr,sum))
        {
            System.out.println(" Yes, a subset do exists that results in "+ sum);
        }
        else{
            System.out.println("No a subset doesn't exist that results in "+ sum);
        }
        
    }

    static boolean subset(int[] arr, int sum)
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
