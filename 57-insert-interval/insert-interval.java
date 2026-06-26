class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        ArrayList<int[]> list = new ArrayList<int[]>();

        for(int[] interval : intervals) {
            if(newInterval == null || newInterval[0] > interval[1]) {
                list.add(interval);
            }
            else if( newInterval[1] < interval[0]) {
                list.add(newInterval);
                list.add(interval);
                newInterval = null;
            } 
            else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);      
                                // newInterval = null;

            }

        }
        if(newInterval != null) list.add(newInterval);
        return list.toArray(new int[list.size()][]);

    }
}