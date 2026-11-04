class Solution {
    static class Fenwick {
        int n;
        int[] count;
        long[] sum;

        Fenwick(int n) {
            this.n = n;
            count = new int[n + 1];
            sum = new long[n + 1];
        }

        void add(int i, int value, int delta) {
            for (; i <= n; i += i & -i) {
                count[i] += delta;
                sum[i] += (long) value * delta;
            }
        }

        int queryCount(int i) {
            int res = 0;
            for (; i > 0; i -= i & -i) {
                res += count[i];
            }
            return res;
        }

        long querySum(int i) {
            long res = 0;
            for (; i > 0; i -= i & -i) {
                res += sum[i];
            }
            return res;
        }

        int kth(int k) {
            int pos = 0;

            for (int step = Integer.highestOneBit(n);
                 step > 0; step >>= 1) {

                int next = pos + step;

                if (next <= n && count[next] < k) {
                    pos = next;
                    k -= count[next];
                }
            }

            return pos + 1;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int size = 0;
        for (int num : sorted) {
            if (size == 0 || sorted[size - 1] != num) {
                sorted[size++] = num;
            }
        }

        Fenwick bit = new Fenwick(size);
        long[] cost = new long[n - x + 1];

        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            int index = Arrays.binarySearch(
                sorted, 0, size, nums[i]
            ) + 1;

            bit.add(index, nums[i], 1);
            totalSum += nums[i];

            if (i >= x) {
                int oldIndex = Arrays.binarySearch(
                    sorted, 0, size, nums[i - x]
                ) + 1;

                bit.add(oldIndex, nums[i - x], -1);
                totalSum -= nums[i - x];
            }

            if (i >= x - 1) {
                int midIndex = bit.kth((x + 1) / 2);
                long median = sorted[midIndex - 1];

                int leftCount = bit.queryCount(midIndex);
                long leftSum = bit.querySum(midIndex);

                cost[i - x + 1] =
                    median * leftCount - leftSum
                    + (totalSum - leftSum)
                    - median * (x - leftCount);
            }
        }

        long INF = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];

        for (int j = 1; j <= k; j++) {
            long[] curr = new long[n + 1];
            Arrays.fill(curr, INF);

            for (int i = 1; i <= n; i++) {
                curr[i] = curr[i - 1];

                if (i >= x && prev[i - x] != INF) {
                    curr[i] = Math.min(
                        curr[i],
                        prev[i - x] + cost[i - x]
                    );
                }
            }

            prev = curr;
        }

        return prev[n];
    }
}