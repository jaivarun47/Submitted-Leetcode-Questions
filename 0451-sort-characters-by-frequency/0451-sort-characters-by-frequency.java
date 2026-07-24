class Solution {
    public String frequencySort(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a,b) -> b.getValue() - a.getValue());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry: list){
            char c = entry.getKey();
            int freq = entry.getValue();

            while (freq-- > 0){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}