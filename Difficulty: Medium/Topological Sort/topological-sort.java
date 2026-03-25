class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
        }
        int[] ind = new int[V];
        for(int i=0; i<V; i++){
            for(int n : adj.get(i)){
                ind[n]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<V; i++){
            if(ind[i] ==0){
                q.add(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int vertex = q.poll();
            res.add(vertex);
         for(int nei : adj.get(vertex)){
                ind[nei]--;
                if(ind[nei] ==0){
                    q.add(nei);
                }
         }
        }
         return res;
    }
}