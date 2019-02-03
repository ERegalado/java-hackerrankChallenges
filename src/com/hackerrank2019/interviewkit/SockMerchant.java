package com.hackerrank2019.interviewkit;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SockMerchant {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int i=0;
        int matchingSocks =0;
        Arrays.sort(ar);        
        while(i<n-1){
            //As our array is ordered, we need to compare pairs only
            if (ar[i]==ar[i+1]){
                //Socks are equal! Set them as a pair
                matchingSocks++;
                //We do not need to count i+1, so we skip it
                i+=2;
            }else{
                //Too bad. No matches. Let's move on to the next pair
                i++;
            }            
        }
        return matchingSocks;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
