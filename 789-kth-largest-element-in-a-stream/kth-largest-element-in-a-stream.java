class KthLargest {
    int k = 0;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        List<Integer> list = new ArrayList();
        for(int i = 0; i < Math.min(k, nums.length); i++){
            list.add(nums[i]);
        }
        this.k = k;
        pq = new PriorityQueue(); 
        pq.addAll(list);
        for(int i = k; i < nums.length; i++){
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > k) pq.poll();
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */