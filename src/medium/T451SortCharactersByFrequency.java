package medium;

import java.util.*;

public class T451SortCharactersByFrequency {
    public static void main(String[] args) {
        System.out.println(frequencySort("tree"));
    }


    public static String frequencySort(String s) {
        int len = s.length();
        //统计每个字符出现的数量
        HashMap<Character, Integer> hMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int freq = hMap.getOrDefault(s.charAt(i), 0)+1;
            hMap.put(s.charAt(i),freq);
        }
        //得到所有字符的列表并排序
        ArrayList<Character> list = new ArrayList<>(hMap.keySet());
        Collections.sort(list, (o1, o2) -> hMap.get(o2) - hMap.get(o1));
        StringBuffer sb = new StringBuffer();
        for (Character ch : list){
            for (int i = 0; i < hMap.get(ch); i++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

}
