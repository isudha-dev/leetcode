package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class LC264 {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber3(1252));
    }


    public static int nthUglyNumber3(int n) {
        TreeSet<Long> uglyNumbersSet = new TreeSet<>(); // TreeSet to store potential ugly numbers
        uglyNumbersSet.add(1L); // Start with 1, the first ugly number
        // TreeSet automatically sorts elements in ascending order and does not
        // allow duplicate entries, just like a HashSet in python

        Long currentUgly = 1L;
        for (int i = 0; i < n; i++) {
            currentUgly = uglyNumbersSet.pollFirst(); // Get the smallest number from the set and remove it

            // Insert the next potential ugly numbers into the set
            uglyNumbersSet.add(currentUgly * 2);
            uglyNumbersSet.add(currentUgly * 3);
            uglyNumbersSet.add(currentUgly * 5);
        }

        return currentUgly.intValue(); // Return the nth ugly number
    }

    public static int nthUglyNumber2(int n) {
        HashSet<Integer> set = new HashSet<>(new ArrayList<>(List.of(1,2,3,4,5)));
        List<Integer> uglyList = new ArrayList<>(List.of(1,2,3,4,5));
        if(n <= 5){
            return uglyList.get(n-1);
        }
        int num = 6;
        while (uglyList.size() != n){
            int tempNum = num;
            int[] div = {2,3,5};
            for (int k : div){
                if(tempNum%k == 0){
                    tempNum = tempNum/k;
                    if(set.contains(tempNum)){
                        set.add(num);
                        uglyList.add(num);
                    }
                    break;
                }
            }
            num++;
        }


        return uglyList.get(n-1);
    }

    public static int nthUglyNumber(int n) {
        List<Integer> uglyList = new ArrayList<>();
        uglyList.addAll(List.of(1,2,3,4,5));
        if(n < 6){
            return uglyList.get(n-1);
        }
        int num = 6;
        while (uglyList.size() != n){
            if(!isPrime(num)){
                int tempNum = num;
                while (tempNum > 0){
                    if(isPrime(tempNum)){
                        if(tempNum>5)
                            break;
                        else{
                            uglyList.add(num);
                            break;
                        }
                    }
                    for (int k = 2; k*k <= tempNum; k++){
                        if(isPrime(k) && tempNum%k == 0){
                            tempNum = tempNum/k;
                            break;
                        }
                    }
                }
            }
            num++;
        }

        return uglyList.get(n-1);
    }

    public static boolean isPrime(int n) {
        // Handle edge cases
        if (n <= 1) return false;  // 0 and 1 are not prime
        if (n <= 3) return true;   // 2 and 3 are prime

        // Eliminate even numbers and numbers divisible by 3
        if (n % 2 == 0 || n % 3 == 0) return false;

        // Check for divisibility using 6k ± 1 rule
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return false;
        }

        return true;
    }

}
