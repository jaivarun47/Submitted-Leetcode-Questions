class Solution {
    public int myAtoi(String s){
        boolean isNeg = false;
        long sum = 0;
        int i = 0;

        while (i < s.length() && s.charAt(i) == ' ') i++;

        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-') {
                isNeg = true;
            }
            i++;
        }
        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = s.charAt(i) - '0';

            if (sum > Integer.MAX_VALUE / 10 ||
                (sum == Integer.MAX_VALUE / 10 && digit > 7)) {
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            sum = sum * 10 + digit;
            i++;
        }

        if (isNeg) {
            sum = -sum;
        }

        if (sum < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if (sum > Integer.MAX_VALUE) return Integer.MAX_VALUE;

        return (int) sum;
    }   
}