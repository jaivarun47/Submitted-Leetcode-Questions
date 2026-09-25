class Solution {
    String s;
    int pos;

    public List<String> braceExpansionII(String expression) {
        s = expression;
        pos = 0;

        Set<String> ans = expression();

        List<String> res = new ArrayList<>(ans);
        Collections.sort(res);

        return res;
    }

    Set<String> expression() {
        Set<String> result = new HashSet<>();

        while (true) {
            Set<String> part = term();
            result.addAll(part);

            if (pos >= s.length() || s.charAt(pos) != ',')
                break;

            pos++;
        }

        return result;
    }

    Set<String> term() {
        Set<String> result = new HashSet<>();
        result.add("");

        while (pos < s.length() &&
               s.charAt(pos) != ',' &&
               s.charAt(pos) != '}') {

            Set<String> part;

            if (s.charAt(pos) == '{') {
                pos++;
                part = expression();
                pos++;
            } else {
                part = new HashSet<>();
                part.add(String.valueOf(s.charAt(pos)));
                pos++;
            }

            Set<String> next = new HashSet<>();

            for (String a : result) {
                for (String b : part) {
                    next.add(a + b);
                }
            }

            result = next;
        }

        return result;
    }
}