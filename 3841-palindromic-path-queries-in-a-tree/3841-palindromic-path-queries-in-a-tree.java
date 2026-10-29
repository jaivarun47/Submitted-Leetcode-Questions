class Solution {
    private int[][] up;
    private int[] depth, tin, tout, prefix, bit;
    private int n, LOG, timer;

    private void updateBIT(int i, int val) {
        while (i <= n) {
            bit[i] ^= val;
            i += i & -i;
        }
    }

    private int queryBIT(int i) {
        int result = 0;
        while (i > 0) {
            result ^= bit[i];
            i -= i & -i;
        }
        return result;
    }

    private int lca(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        int diff = depth[a] - depth[b];

        for (int i = 0; i < LOG; i++) {
            if ((diff & (1 << i)) != 0) {
                a = up[i][a];
            }
        }

        if (a == b) return a;

        for (int i = LOG - 1; i >= 0; i--) {
            if (up[i][a] != up[i][b]) {
                a = up[i][a];
                b = up[i][b];
            }
        }

        return up[0][a];
    }

    public List<Boolean> palindromePath(int n, int[][] edges,
                                        String s, String[] queries) {
        this.n = n;

        LOG = 1;
        while ((1L << LOG) <= n) LOG++;

        up = new int[LOG][n];
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];
        prefix = new int[n];
        bit = new int[n + 2];

        char[] chars = s.toCharArray();

        List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        int[] stack = new int[2 * n + 1];
        int top = 0;

        stack[top++] = 0;
        prefix[0] = 1 << (chars[0] - 'a');

        while (top > 0) {
            int u = stack[--top];

            if (u < 0) {
                u = ~u;
                tout[u] = timer;
                continue;
            }

            tin[u] = ++timer;
            stack[top++] = ~u;

            for (int v : adj[u]) {
                if (v == up[0][u] && u != 0) {
                    continue;
                }

                if (u == 0 && v == 0) continue;

                depth[v] = depth[u] + 1;
                up[0][v] = u;

                for (int j = 1; j < LOG; j++) {
                    up[j][v] = up[j - 1][up[j - 1][v]];
                }

                prefix[v] = prefix[u] ^ (1 << (chars[v] - 'a'));
                stack[top++] = v;
            }
        }

        List<Boolean> answer = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");

            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                int delta = (1 << (chars[u] - 'a'))
                          ^ (1 << (c - 'a'));

                if (delta != 0) {
                    updateBIT(tin[u], delta);
                    updateBIT(tout[u] + 1, delta);
                    chars[u] = c;
                }
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int w = lca(u, v);

                int mask = prefix[u] ^ prefix[v];
                mask ^= queryBIT(tin[u]);
                mask ^= queryBIT(tin[v]);
                mask ^= 1 << (chars[w] - 'a');

                answer.add(Integer.bitCount(mask) <= 1);
            }
        }

        return answer;
    }
}