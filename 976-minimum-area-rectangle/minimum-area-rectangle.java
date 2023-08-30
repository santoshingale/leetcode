class Solution {
    public int minAreaRect(int[][] points) {
        HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
        
        for(int p[]:points){
            if(!map.containsKey(p[0])){
                map.put(p[0],new HashSet<Integer>());
            }
            map.get(p[0]).add(p[1]);
        }
        
        int area=Integer.MAX_VALUE;
        
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int x1=points[i][0];
                int y1=points[i][1];
                int x2=points[j][0];
                int y2=points[j][1];
                
                if(x1!=x2 && y1!=y2){
                    if(map.get(x1).contains(y2) && map.get(x2).contains(y1)){
                        area=Math.min(area,Math.abs(x1-x2)*Math.abs(y1-y2));
                    }
                }
            }
        }
        return area==Integer.MAX_VALUE ? 0 : area;
    }
}