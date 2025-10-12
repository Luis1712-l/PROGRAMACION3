public class PanSimilar{
    public static boolean SandwichesSimilares(String[] s1, String[] s2) {
        if (s1.length < 3 || s2.length < 3) return false;
        
        return s1[0].equals(s2[0]) && s1[s1.length - 1].equals(s2[s2.length - 1]);
    }
}