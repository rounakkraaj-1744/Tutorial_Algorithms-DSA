//Rabin Karp String Pattern Matching Algorithm
import java.util.Scanner;
public class RabinKarp {
    static final int VAL = 131;//to generate a unique hash
    public static long generateHash(String str) {
        long hash = 0;
        for(int i=0; i < str.length(); i++)
            hash = hash + str.charAt(i)*(long)Math.pow(VAL, i);
        return hash;
    }
    public static long updateHash(long prevHash, char prevChar, char newChar, int len) {
        long newHash = (prevHash-prevChar)/VAL;
        newHash = newHash+newChar*(long)Math.pow(VAL, len-1);
        return newHash;
    }
    public static void matchPattern(String str, String pattern) {
        long patternHash = generateHash(pattern), strHash = generateHash(str.substring(0, pattern.length()));
        for(int i=0; i<= str.length() - pattern.length(); i++) {
            if(strHash == patternHash)
                if(str.startsWith(pattern, i)) {
                    System.out.println("Pattern found at index " + i);
                    break;
                }
            if (i < str.length()-pattern.length())
                strHash = updateHash(strHash, str.charAt(i), str.charAt(i+pattern.length()), pattern.length());
        }
    }
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string : ");
        String str = sc.next ();
        System.out.print("Enter a pattern : ");
        String pattern = sc.next ();
        matchPattern(str.toLowerCase(), pattern.toLowerCase());
        sc.close ();
    }
}