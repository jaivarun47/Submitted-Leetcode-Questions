class Solution {
    public String reverseWords(String s){
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        int i = s.length() - 1;
        StringBuilder temp = new StringBuilder();
        while (i >= 0){
            if (s.charAt(i) != ' '){
                temp.append(s.charAt(i));
            } else if (s.charAt(i) == ' ' && !temp.isEmpty()){
                sb.append(temp.reverse()).append(" ");
                temp = new StringBuilder();
            }
            i--;
        }
        sb.append(temp.reverse());
        return sb.toString();
    }
}