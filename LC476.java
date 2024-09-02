package leetcode;

public class LC476 {
    public static void main(String[] args) {
        System.out.println(findComplement(0));
    }
    public static int findComplement(int num) {
        int bitLen = 0;
        int tempNum = num;
        while (tempNum>0){
            bitLen++;
            tempNum /= 2;
        }

        int mask = (1 << bitLen) - 1;

        return num^mask;

    }
}
