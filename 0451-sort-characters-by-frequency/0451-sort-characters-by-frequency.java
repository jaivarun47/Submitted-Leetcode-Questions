class Solution {
    public String frequencySort(String s){
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a,b) -> b.getValue() - a.getValue());

        StringBuilder sb = new StringBuilder();
        int n = list.size(), i = 0;
        while (i < n){
            int freq = list.get(i).getValue();
            while (freq > 0){
                sb.append(list.get(i).getKey());
                freq--;
            }
            i++;
        }
        return sb.toString();
    }
}