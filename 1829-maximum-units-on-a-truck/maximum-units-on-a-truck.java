class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        int ans = 0;
        int index = 0;
        while(truckSize != 0 && index < boxTypes.length){
            if(boxTypes[index][0] <= truckSize){
                ans += boxTypes[index][0] * boxTypes[index][1];
                truckSize -= boxTypes[index][0];
            }else{
                ans += truckSize * boxTypes[index][1];
                truckSize = 0;
            }
            index++;
        }
        return ans;
    }
}