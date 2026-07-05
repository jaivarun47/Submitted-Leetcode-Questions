class Solution {
    public int majorityElement(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int majority = -1;
        int maxFreq = 0;

        for (Integer key : map.keySet()) {
            if (map.get(key) > maxFreq) {
                maxFreq = map.get(key);
                majority = key;
            }
        }

        return majority;
    }
}