class Solution {
    public String longestCommonPrefix(String[] strs){
        int min = strs[0].length();
        for (String s: strs){
            if (s.length() < min) min = s.length();
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < min){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++){
                if (strs[j].charAt(i) != c){
                    return sb.toString();
                }
            }
            sb.append(c);
            i++;
        }
        return sb.toString();
    }
}