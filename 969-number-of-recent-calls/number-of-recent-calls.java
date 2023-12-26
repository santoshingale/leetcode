class RecentCounter {
    private LinkedList<Integer> pingList;

    public RecentCounter() {
        this.pingList = new LinkedList<Integer>();
    }
    
    public int ping(int t) {
        pingList.addLast(t);
        while (t - 3000 > pingList.getFirst()) {
            pingList.removeFirst();
        }
        return pingList.size();
    }
}