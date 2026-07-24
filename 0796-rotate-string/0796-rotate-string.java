class Solution {
    public boolean rotateString(String s, String t){
        char[] arrS = s.toCharArray();
        char[] arrT = t.toCharArray();
        int x = 0;
        char[] temp = new char[arrS.length];
        while (x < s.length()){
            for (int i = 0; i < s.length(); i++){
                    temp[(i+1)%arrS.length] = arrS[i];
            }
            arrS = temp;
            if (Arrays.equals(temp, arrT)) return true;
            temp = new char[arrS.length];
            x++;
        }
        return false;
    }
}