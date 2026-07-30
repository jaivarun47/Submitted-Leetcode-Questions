class Solution {
    public int minimumPushes(String word){
        int[] freq = new int[26];
        for (char c: word.toCharArray()){
            freq[c - 'a']++;
        }
        Arrays.sort(freq);
        int rank = 0, count = 0;

        for (int i = 25; i >= 0 && freq[i] > 0; i--) {
            count += freq[i] * (rank / 8 + 1);
            rank++;
        }
        return count;
    }
}