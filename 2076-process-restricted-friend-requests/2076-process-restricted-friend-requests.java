class Solution {
    int[] parent;

    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        boolean[] result = new boolean[requests.length];

        for (int i = 0; i < requests.length; i++) {
            int u = requests[i][0];
            int v = requests[i][1];

            int pu = find(u);
            int pv = find(v);

            boolean possible = true;

            for (int[] restriction : restrictions) {
                int x = find(restriction[0]);
                int y = find(restriction[1]);

                if ((pu == x && pv == y) || (pu == y && pv == x)) {
                    possible = false;
                    break;
                }
            }

            result[i] = possible;

            if (possible) {
                parent[pu] = pv;
            }
        }

        return result;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }
}