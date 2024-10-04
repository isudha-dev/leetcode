package leetcode;

public class LC2491 {

    public static void main(String[] args) {
        dividePlayers(new int[] {3,2,5,1,3,4});
    }
    public static long dividePlayers(int[] skill) {
        // 1 2 3 3 4 5
        // 1 3 4 5 6 8
        int n = skill.length;
        int totalSkill = 0;
        int[] skillFrequency = new int[1001];

        for(int s: skill) {
            totalSkill += s;
            skillFrequency[s]++;
        }

        if(totalSkill % (n/2) != 0)
            return -1;

        int targetTeamSkill = totalSkill / (n/2);
        long chemistry = 0l;

        for(int s: skill) {
            int partnerSkill = targetTeamSkill - s;

            if(skillFrequency[partnerSkill] == 0)
                return -1;

            chemistry += (long) s * (long) partnerSkill;
            skillFrequency[partnerSkill]--;
        }

        return chemistry/2;


    }
}
