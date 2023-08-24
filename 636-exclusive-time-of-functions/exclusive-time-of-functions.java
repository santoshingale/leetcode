class Solution {
    class Tuple{
        int start;
        int id;
        int childThread;
        Tuple(int id, int start, int childThread){
            this.start = start;
            this.id = id;
            this.childThread = childThread;
        }
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Tuple> stack = new Stack();
        int[] time = new int[n];
        for(String log : logs){
            String[] sarr = log.split(":");
            if(sarr[1].equals("start")){
                stack.add(new Tuple(Integer.parseInt(sarr[0]), Integer.parseInt(sarr[2]), 0));
            }else{
                Tuple top = stack.pop();
                int interval = Integer.parseInt(sarr[2]) - top.start + 1;
                int curTime = interval - top.childThread;
                time[top.id] += curTime;
                if(stack.size() > 0)
                    stack.peek().childThread += interval;
            }
        }
        return time;
    }
}