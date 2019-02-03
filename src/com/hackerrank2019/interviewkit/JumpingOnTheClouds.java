package com.hackerrank2019.interviewkit;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class JumpingOnTheClouds {

    // Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
        //The trick here is to always test first for the furthest cloud: That's i+2.
        //If we can jump to i+2 we do, otherwise, we only jump once.
        int jumps =0;
        int i=0;
        while(i<c.length-1){
            //Assuming that we start in position 0, check if we can jump to i+2
            if ((i+2)<c.length){
                if (c[i+2]==0){
                    //JUMP!
                    i+=2;
                    jumps++;
                    continue;
                }
            }
            //Jump to the next cloud (only if it has a 0)
            if (c[i+1]==0){
                //JUMP!
                i++;
                jumps++;
                continue;
            }else{
                //OOOPS! End of the road!
                break;
            }
        }
        return jumps;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int result = jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
