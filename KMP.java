public class KMP {
    public static int[] indexArray(String pattern) {
        int ar []= new int[pattern.length()];
        int c = 0, i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(c))
                ar[i++] = ++c;
            else {
                if (c != 0)
                    c = ar[c - 1];
                else
                    ar[i++] = 0;
            }
        }
        return ar;
    }
    public static int searchPattern(String str, String pattern, int[] lps) {
        int i = 0,j = 0;
        while (i < str.length()) {
            if (pattern.charAt(j) == str.charAt(i)) {
                i++;
                j++;
            }
            if (j == pattern.length())
                return i - j;
            if(i < str.length() && pattern.charAt(j) != str.charAt(i)) {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }
        }
        return -999;
    }
    public static void main(String[] args) {
        String str = "ababdabaabababc", pattern = "ababc";
        int ar[] = indexArray(pattern);
        if (searchPattern(str, pattern, ar) != -999)
            System.out.println("Pattern found at : " + searchPattern(str, pattern, ar));
        else
            System.out.println("Pattern not found");
    }
}