package searchcode;

public class Main6 {
    public static void main(String[] args) {
        String example1 = "pcmzbzpcmzb";
        String example2 = "mppzmbbzpcmbpmczcz";
        String example3 = "pcmbz";
        String example4 = "pcmpp";
        System.out.println(perfectTeam(example1)); // Output for example 1
        System.out.println(perfectTeam(example2));
        System.out.println(perfectTeam(example3));
        System.out.println(perfectTeam(example4));

    }
    public static int perfectTeam(String skills) {
        int[] skillCounts = new int[5];

        for (int i = 0; i < skills.length(); i++) {
            char skill = skills.charAt(i);
            switch (skill) {
                case 'p':
                    skillCounts[0]++;
                    break;
                case 'c':
                    skillCounts[1]++;
                    break;
                case 'm':
                    skillCounts[2]++;
                    break;
                case 'b':
                    skillCounts[3]++;
                    break;
                case 'z':
                    skillCounts[4]++;
                    break;
                default:
                    // If there's a character that doesn't represent a skill, you can handle it as needed
                    break;
            }
        }

        int minCount = Integer.MAX_VALUE;
        for (int count : skillCounts) {
            minCount = Math.min(minCount, count);
        }

        return minCount;
    }

}
