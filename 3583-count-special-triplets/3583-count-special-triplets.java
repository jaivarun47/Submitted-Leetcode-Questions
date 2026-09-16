class Solution {
    public int specialTriplets(int[] nums) {
        final long MOD = 1_000_000_007L;

        HashMap<Integer, Long> left = new HashMap<>();
        HashMap<Integer, Long> right = new HashMap<>();

        for (int num : nums) {
            right.put(num, right.getOrDefault(num, 0L) + 1);
        }

        long ans = 0;

        for (int num : nums) {
            right.put(num, right.get(num) - 1);

            int target = num * 2;

            long l = left.getOrDefault(target, 0L);
            long r = right.getOrDefault(target, 0L);

            ans = (ans + l * r) % MOD;

            left.put(num, left.getOrDefault(num, 0L) + 1);
        }

        return (int) ans;
    }
}