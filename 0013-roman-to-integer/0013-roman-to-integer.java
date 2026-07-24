class Solution {
    public int romanToInt(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int val = 0, i = s.length() - 1;
        int last = 0;
        while (i >= 0){
            int curr = map.get(s.charAt(i));
            if (curr < last){
                val -= curr;
            } else {
                val += curr;
            }
            i--;
            last = curr;
        }
        return val;
    }
}