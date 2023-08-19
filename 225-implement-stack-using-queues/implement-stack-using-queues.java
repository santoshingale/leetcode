class MyStack {
    Queue<Integer> q1;
    int top = 0;
    public MyStack() {
        q1 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.offer(x);
        top = x;
    }
    
    public int pop() {
        int size = q1.size();
        while(size-- > 2)
            q1.offer(q1.poll());
        
        top = q1.peek();
        q1.offer(q1.poll());
        return q1.poll();
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */