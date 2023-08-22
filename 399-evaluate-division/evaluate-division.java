class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> graph = new HashMap();
        int i = 0;

        for(List<String> equation : equations){
            if(!graph.containsKey(equation.get(0))) graph.put(equation.get(0), new HashMap());
            graph.get(equation.get(0)).put(equation.get(1), values[i]);
            if(!graph.containsKey(equation.get(1))) graph.put(equation.get(1), new HashMap());
            graph.get(equation.get(1)).put(equation.get(0), (double)1 / values[i]);
            i++;
        }

        double[] output = new double[queries.size()];
        i = 0;
        for(List<String> query : queries){
            if(graph.containsKey(query.get(1)) && graph.containsKey(query.get(0))){
                Set<String> visited = new HashSet();
                output[i] = dfs(query.get(0), query.get(1), graph, 1, visited);
            }else{
                output[i] = -1.0;
            }
            i++;
        }
        return output;
     }

     private double dfs(String start, String end, HashMap<String, HashMap<String, Double>> graph, double cost, Set<String> visited){
         if(start.equals(end)) return cost;
         if(visited.contains(start)) return -1;
         visited.add(start);
         for(Map.Entry<String, Double> neigh : graph.get(start).entrySet()){
             double res = dfs(neigh.getKey(), end, graph, cost * neigh.getValue(), visited);
             if(res != -1) return res;
         }
         return -1;
     }
}