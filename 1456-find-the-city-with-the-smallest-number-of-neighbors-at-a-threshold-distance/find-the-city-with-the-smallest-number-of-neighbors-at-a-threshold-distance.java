class Solution {
    class Node{
        int value;
        int weight;
        Node(int value, int weight){
            this.value = value;
            this.weight = weight;
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Node>> adjList = new ArrayList();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList());
        }
        for(int[] edge : edges){
            adjList.get(edge[0]).add(new Node(edge[1], edge[2]));
            adjList.get(edge[1]).add(new Node(edge[0], edge[2]));
        }

        int[] visited = new int[n];
        int minNode = 0;
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int value = helper(i, adjList, n, distanceThreshold);
            System.out.println(value);
            if(value <= minValue ){
                minNode = i;
                minValue = value;
            }
        }
        return minNode;
    }

    private int helper(int i, List<List<Node>> adjList, int n, int distanceThreshold){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.weight - b.weight);
        pq.add(new Node(i, 0));
        Set<Integer> visited = new HashSet();
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(!visited.contains(cur.value)){
                visited.add(cur.value);
                for(Node adjNode : adjList.get(cur.value)){
                    if(cur.weight + adjNode.weight <= distanceThreshold){
                        pq.add(new Node(adjNode.value, cur.weight + adjNode.weight));
                    }
                }
            }
        }
        return visited.size() - 1;
    }
}