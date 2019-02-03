package com.hackerrank2019.interviewkit;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        //ANALYSIS:
        //1. We have to identify how many times the single string will be repeated in n. There are 3 cases: s.length < n, s.length = n and s.length > n.
        //2. n < s.length -> Count the occurrences of the character up to n
        //3. s.length = n -> Count all the occurrences of the character (up to n works as well)
        //4.  n > s.length -> Divide length/n. Count all the occurrences of the character in s (step 2) and multiply by the result of the division. Then, calculate length mod n to get how many characters more should we consider. Apply step 1 using n= (length mod n).        
        if (n<s.length()){
            String substr = s.substring(0,(int) n);
            return substr.chars().filter(ch -> ch =='a').count();
        }else if (s.length()==n){
            return s.chars().filter(ch -> ch =='a').count();
        }else{
            long ocInStr = s.chars().filter(ch -> ch =='a').count();
            long StrTimes = n/s.length();
            long remChars = n % s.length();
            String substr = s.substring(0,(int)remChars);
            return substr.chars().filter(ch -> ch =='a').count() + (ocInStr*StrTimes);
        }
    }
    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
