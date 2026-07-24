class Solution {
    public int maxDepth(String s){
        int balance = 0, x = 0, maxDepth = 0;
        while (x < s.length()){
            if (s.charAt(x) == '(') balance++;
            if (s.charAt(x) == ')') balance--;
            maxDepth = Math.max(balance, maxDepth);
            x++;
        }
        return maxDepth;
    }
}