class Solution {
    public int totalPaths(List<List<Integer>> triangle,List<List<Integer>> dp, int len, int idx){
        if (idx > triangle.get(len).size()) return 0;
        if (len == triangle.size() - 1) return triangle.get(len).get(idx);
        if (dp.get(len).get(idx) != Integer.MIN_VALUE) return dp.get(len).get(idx);
        int bottom = triangle.get(len).get(idx) + totalPaths(triangle, dp, len + 1, idx);
        int bottomRight = triangle.get(len).get(idx) + totalPaths(triangle, dp, len + 1, idx + 1);
        int ans = Math.min(bottom, bottomRight);
        dp.get(len).set(idx, ans);
        return ans;
    }
    public int minimumTotal(List<List<Integer>> triangle){
        List<List<Integer>> dp = new ArrayList<>();

        for (List<Integer> row : triangle) {
            List<Integer> dpRow = new ArrayList<>();
            for (int i = 0; i < row.size(); i++) {
                dpRow.add(Integer.MIN_VALUE);
            }
            dp.add(dpRow);
        }

        return totalPaths(triangle, dp, 0, 0);
    }
}