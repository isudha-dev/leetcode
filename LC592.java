package leetcode;

import java.util.*;

public class LC592 {

    public static void main(String[] args) {
        System.out.println(fractionAddition2("-7/3"));


    }

    public static String fractionAddition2(String expression) {
        List<Integer> numerator = new ArrayList<>();
        List<Integer> denominator = new ArrayList<>();

        if(expression.charAt(0) != '-'){
            expression = "+"+expression;
        }
        char[] chArr = expression.toCharArray();

        int idx = 0;
        while (idx<chArr.length){
            if(chArr[idx] == '-' || chArr[idx] == '+'){
                boolean isNeg = chArr[idx] == '-';
                idx++;
                StringBuilder sb = new StringBuilder();
                while (idx < chArr.length &&  chArr[idx] != '/') {
                    sb.append(chArr[idx]);
                    idx++;
                }
                if(isNeg)
                    numerator.add(Integer.parseInt(sb.toString())*-1);
                else
                    numerator.add(Integer.parseInt(sb.toString()));

            } else if(chArr[idx] == '/') {
                idx++;
                StringBuilder sb = new StringBuilder();
                while (idx < chArr.length && chArr[idx] != '+' && chArr[idx] != '-') {
                    sb.append(chArr[idx]);
                    idx++;
                }
                denominator.add(Integer.parseInt(sb.toString()));
            }
        }

        if(numerator.size() == 1) {
            int gcd = findGcd(numerator.get(0), denominator.get(0));
            if(gcd < 0)
                gcd *= -1;
            int sum = numerator.get(0)/ gcd;
            int lcm = denominator.get(0)/ gcd;
            return sum+"/"+lcm;
        }
        int lcm = findLcm(denominator.get(0), denominator.get(1));
        for (int i = 2; i < denominator.size(); i++) {
            lcm = findLcm(lcm, denominator.get(i));
        }

        int sum = 0;
        if(lcm == 1) {
            for (int i : numerator) {
                sum += i;
            }
            return sum+"/1";
        }


        for (int i = 0; i < numerator.size(); i++) {
            int n = numerator.get(i);
            int d = denominator.get(i);
            int m = lcm/d;
            n *= m;
            sum += n;
        }

        if(sum == 0){
            return "0/1";
        }

        int gcd = findGcd(sum, lcm);
        if(gcd < 0)
            gcd *= -1;
        sum /= gcd;
        lcm /= gcd;


        return sum+"/"+lcm;
    }

    public static int findLcm (int n, int m){
        return n*m / findGcd(n, m);
    }

    public static int findGcd(int n, int m) {
        if(m != 0){
            return findGcd(m, n%m);
        } else {
            return n;
        }
    }


    public static String fractionAddition(String expression) {
        // this is stupid solution
        List<Integer> numerator = new ArrayList<>();
        List<Integer> denominator = new ArrayList<>();

        char[] chArr = expression.toCharArray();
        int idx = 0;
        while (idx<chArr.length){
            if(chArr[idx] == '-'){
                idx++;
                numerator.add(Character.getNumericValue(chArr[idx])*-1);
                idx++;
            } else if(chArr[idx] == '+') {
                idx++;
                numerator.add(Character.getNumericValue(chArr[idx]));
                idx++;
            } else if(chArr[idx] == '/') {
                idx++;
                denominator.add(Character.getNumericValue(chArr[idx]));
                idx++;
            }
        }

        // find lcf for all the denominator

        HashMap<Integer, Integer> denoPrimeMap = new HashMap<>();
        for(int d: denominator){
            List<Integer> primeFactors = findPrimeFactor(d);
            int[] list = new int[4];
            for (int k: primeFactors) {
                if(k == 2)
                    list[0]++;
                else if (k == 3)
                    list[1]++;
                else if (k == 5)
                    list[2]++;
                else if (k == 7)
                    list[3]++;
            }

            if(denoPrimeMap.containsKey(2)){
                if(denoPrimeMap.get(2) < list[0]){
                    denoPrimeMap.put(2, list[0]);
                }
            } else {
                denoPrimeMap.put(2, list[0]);
            }

            if(denoPrimeMap.containsKey(3)){
                if(denoPrimeMap.get(3) < list[1]){
                    denoPrimeMap.put(3, list[1]);
                }
            } else {
                denoPrimeMap.put(3, list[1]);
            }

            if(denoPrimeMap.containsKey(5)){
                if(denoPrimeMap.get(5) < list[2]){
                    denoPrimeMap.put(5, list[2]);
                }
            } else {
                denoPrimeMap.put(5, list[2]);
            }

            if(denoPrimeMap.containsKey(7)){
                if(denoPrimeMap.get(7) < list[3]){
                    denoPrimeMap.put(7, list[3]);
                }
            } else {
                denoPrimeMap.put(7, list[3]);
            }
        }

        int commonDivisor = 1;
        for(Map.Entry<Integer, Integer> entry: denoPrimeMap.entrySet()){
            commonDivisor *= Math.pow(entry.getKey(), entry.getValue());
        }

        int sum = 0;
        if(commonDivisor == 1) {
            for (int i : numerator) {
                sum += i;
            }

            return sum+"/1";
        }


        for (int i = 0; i < numerator.size(); i++) {
            int n = numerator.get(i);
            int d = denominator.get(i);
            int m = commonDivisor/d;
            n *= m;
            sum += n;
        }

        if(sum == 0){
            return "0/1";
        }

        return "";
    }

    public static List<Integer> findPrimeFactor(int n){
        List<Integer> primeFactors = new ArrayList<>();

        while (n%2 == 0){
            primeFactors.add(2);
            n /= 2;
        }

        for (int i = 3; i <= n; i += 2) {
            while (n%i == 0){
                primeFactors.add(i);
                n /= i;
            }
        }

        if(n > 1){
            primeFactors.add(n);
        }
        return primeFactors;
    }
}
