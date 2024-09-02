package leetcode;

public class LC2678 {
    public static void main(String[] args) {
        System.out.println(countSeniors(new String[]{"5612624052M0130","5378802576M6424","5447619845F0171","2941701174O9078"}));
    }

    public static int countSeniors(String[] details) {

        int count = 0;
        for(String s: details){
            String[] sSplit = new String[2];
            int age = 0;
            if(s.contains("M"))
                sSplit = s.split("M");
            else if (s.contains("F"))
                sSplit = s.split("F");
            else
                sSplit = s.split("O");

            age = Integer.parseInt(sSplit[1].substring(0,2));
            if (age > 60)
                count++;
        }

        return count;

    }
}
