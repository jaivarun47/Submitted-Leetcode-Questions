class Solution {
    public int maxDepth(String s){
        int currentDepth = 0, maxDepth = 0;
        for (char c: s.toCharArray()){
            if (c == '('){
                currentDepth++;
            } else if (c == ')'){
                currentDepth--;
            }
            maxDepth = Math.max(currentDepth, maxDepth);
        }
        return maxDepth;
    } 
}