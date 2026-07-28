class Solution {
    public String smallestPalindrome(String s) {
        int[] hash = new int[26];

        for (char c : s.toCharArray()) {
            hash[c - 'a']++;
        }

        int oddIdx = -1;

        for (int i = 0; i < 26; i++) {
            if (hash[i] % 2 != 0) {
                oddIdx = i;
                break;
            }
        }

        StringBuilder half = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            int count = hash[i] / 2;

            while (count-- > 0) {
                half.append((char)('a' + i));
            }
        }

        StringBuilder result = new StringBuilder(half);

        if (oddIdx != -1) {
            result.append((char)('a' + oddIdx));
        }

        result.append(half.reverse());

        return result.toString();
    }
}