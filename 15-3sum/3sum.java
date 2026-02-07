class Solution {
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList();
        int sum = 0;
        int left = 0;
        int right = 0;
        for(int i = 0; i< num.length; i++){
            sum = -num[i];
            left = i + 1;
            right = num.length - 1;
            if(i == 0 || i > 0 && num[i] != num[i - 1]){
                while(left < right){
                    if(num[left] + num[right] == sum){
                        result.add(Arrays.asList(num[i], num[left], num[right]));
                        while(left < right && num[left] == num[left + 1]) left++;
                        while(right > left && num[right] == num[right - 1]) right--;
                        left++;
                        right--;
                    }else if(num[left] + num[right] < sum){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return result;
    }
}