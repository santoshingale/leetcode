class Solution {
    class Pair{
        int node;
        int weight;
        Pair(int node, int weight){
            this.weight = weight;
            this.node = node;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adjList = new ArrayList();
        for(int i = 0; i <= n; i++){
            adjList.add(new ArrayList());
        }
        for(int[] adj : times){
            adjList.get(adj[0]).add(new Pair(adj[1], adj[2]));
        }
        PriorityQueue<Pair> q = new PriorityQueue<Pair>((a, b) -> a.weight - b.weight);
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        q.add(new Pair(k, 0));
        distance[k] = 0;
        while(!q.isEmpty()){
            Pair cur = q.poll();
            for(Pair neigh : adjList.get(cur.node)){
                int nWeight = neigh.weight;
                int nNode = neigh.node;
                if(nWeight + cur.weight < distance[nNode]){
                    distance[nNode] = nWeight + cur.weight;
                    q.add(new Pair(nNode, distance[nNode]));
                }
            }
        }
        int max = 0;
        for(int i = 1; i <= n; i++){
            if(distance[i] == Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(max, distance[i]);
        }
        return max;
    }
}