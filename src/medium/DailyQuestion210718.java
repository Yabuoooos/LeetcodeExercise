package medium;
/*
    编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 */

import org.junit.Test;

import java.util.*;

public class DailyQuestion210718 {
    @Test
    public void test() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }



    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character, Integer>, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            HashMap<Character, Integer> tempMap = new HashMap<>();
            for (Character c : strs[i].toCharArray()) {
                tempMap.put(c, tempMap.getOrDefault(c, 0) + 1);
            }
            if (map.size() == 0) {
                List<String> tempList = new ArrayList<>();
                tempList.add(strs[i]);
                map.put(tempMap, tempList);
            } else {
                if (map.containsKey(tempMap)) {
                    map.get(tempMap).add(strs[i]);
                } else {
                    List<String> tempList = new ArrayList<>();
                    tempList.add(strs[i]);
                    map.put(tempMap, tempList);
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (List list : map.values()) {
            res.add(list);
        }
        return res;
    }
}
