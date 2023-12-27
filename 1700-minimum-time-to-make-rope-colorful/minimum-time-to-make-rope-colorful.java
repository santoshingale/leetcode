class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int sum = 0;
        int i = 0;
        int j = 0;
        while(i < colors.length() && j < neededTime.length){
            int curTime = 0;
            int maxTime = 0;
            while(j < neededTime.length && colors.charAt(i) == colors.charAt(j)){
                curTime += neededTime[j];
                maxTime = Math.max(maxTime, neededTime[j]);
                j++;
            }
            sum += curTime - maxTime;
            i = j;
        }
        return sum;
    }
}