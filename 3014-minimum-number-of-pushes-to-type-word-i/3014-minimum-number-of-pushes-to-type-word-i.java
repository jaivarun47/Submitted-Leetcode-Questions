class Solution {
    public int minimumPushes(String word){
        int[] freq = new int[26];
        for (char c: word.toCharArray()){
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int i = 25, count = 0;
        while (i >= 0){
            if (freq[i] == 0) break;
            if (i > 17){
                count += freq[i];
            } else if (i > 9){
                count += 2*freq[i];
            } else if (i > 1){
                count += 3*freq[i];
            } else {
                count += 4*freq[i];
            }
            i--;
        }
        return count;
    }
}