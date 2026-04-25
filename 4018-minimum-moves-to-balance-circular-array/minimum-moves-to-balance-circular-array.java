class Solution {
    public long minMoves(int[] balance) {
        int n = balance.length;
        long sum = 0;
        int idx = -1;
        long val = -1;
        long result = 0;

        for (int i = 0; i < n; i++) {
            sum += balance[i];

            if (balance[i] < 0) {
                idx = i;
                val = balance[i];
            }
        }

        if (sum < 0) return -1;
        if (idx == -1) return 0;

        int left = (idx - 1 + n) % n;
        int right = (idx + 1) % n;
        int dist = 1;

        while (val < 0) {
            if (balance[left] > 0) {
                long take = Math.min((long) balance[left], -val);
                val += take;
                result += take * dist;
            }

            if (val < 0 && balance[right] > 0) {
                long take1 = Math.min((long) balance[right], -val);
                val += take1;
                result += take1 * dist;
            }

            left = (left - 1 + n) % n;
            right = (right + 1) % n;
            dist++;
        }

        return result;
    }
}