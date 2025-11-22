class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for(int candy : candies){
            if(candy > max){
                max = candy;
            }
        }
        List<Boolean> result = new ArrayList();
        Boolean curResult = false;
        for(int candy : candies){
            curResult = false;
            if(candy + extraCandies >= max){
                curResult = true;
            }
            result.add(curResult);
        }
        return result;
    }
}