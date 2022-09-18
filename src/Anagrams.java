import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/* Question 1
Given two strings s1 and s2, check if they're anagrams.
Two strings are anagrams if they're made of the same characters
with the same frequencies.
*/
public class Anagrams {
    public static Boolean isAnagram(String s1, String s2) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            if (map1.containsKey(ch)) {
                map1.compute(ch, (key, value) -> value + 1);
            }
            else {
                map1.put(ch, 1);
            }
            ch = s2.charAt(i);
            if (map2.containsKey(ch)) {
                map2.compute(ch, (key, value) -> value + 1);
            }
            else {
                map2.put(ch, 1);
            }
        }
        return map1.equals(map2);

    }

    public static Boolean isAnagram2(String s1, String s2) {
        // O(nlog n)
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] temp1 = s1.toCharArray();//O(n)
        char[] temp2 = s2.toCharArray();//O(n)
        Arrays.sort(temp1);// O(nlogn)
        Arrays.sort(temp2);// O(nlogn)
        return new String(temp1).equals(new String(temp2));
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(isAnagram2(s1, s2));

    }
}
