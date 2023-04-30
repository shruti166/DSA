//Given a 0-indexed integer array nums of length n and an integer k, return the number of pairs (i, j) such that:
// 0 <= i < j <= n - 1 and nums[i] +  nums[j] is divisible by k.
import java.util.*;
public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr [] = new int[n];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

       System.out.println(countKdivPairs(n, arr, k));

    }
    public static int countKdivPairs(int n, int A[], int K)
    {
        // Create a frequency array to count
        // occurrences of all remainders when
        // divided by K
        int freq[] = new int[K];

        // Count occurrences of all remainders
        for (int i = 0; i < n; i++)
            freq[A[i] % K]++;

        // If both pairs are divisible by 'K'
        int sum = freq[0] * (freq[0] - 1) / 2;

        // count for all i and (k-i)
        // freq pairs
        for (int i = 1; i <= K / 2; i++)
            sum += freq[i] * freq[K - i];
        // If K is even
        if (K % 2 == 0)
            sum += (freq[K / 2] * (freq[K / 2] - 1) / 2);
        return sum;
    }
}