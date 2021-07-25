package medium;

import java.util.*;

public class T38Permutation {
    public static void main(String[] args) {
        String s = "abdd";
        System.out.println(Arrays.toString(permutation(s)));
    }

    static List<String> res = new LinkedList<>();
    static char[] c;

    private static String[] permutation(String s) {
        c = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    static void dfs(int x){
        if (x == c.length - 1){
            res.add(String.valueOf(c));
            return;
        }

        HashSet<Character> charSet = new HashSet<>();
        for (int i = x; i < c.length; i++){
            if (charSet.contains(c[i])) continue;
            charSet.add(c[i]);
            swap(i,x);
            dfs(x+1);
            swap(i,x);
        }
    }

    static void swap(int a, int b){
        char temp = c[a];
        c[a] = c[b];
        c[b] = temp;
    }
}
