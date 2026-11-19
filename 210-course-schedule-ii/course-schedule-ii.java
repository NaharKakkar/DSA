class Solution {
    public void adjList(Map<Integer,List<Integer>> adj,int[][] arr){
        for(int i=0;i<arr.length;i++){
            int u=arr[i][0];
            int v=arr[i][1];
            adj.get(v).add(u);
        }
    }
    public int[] findOrder(int n, int[][] arr) {
        Map<Integer,List<Integer>> adj=new HashMap<>();
        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }
        adjList(adj,arr);
        int[] indegree=new int[n];
        for(int i=0;i<n;i++){
            for(int neighbor:adj.getOrDefault(i,new ArrayList<>())){
                indegree[neighbor]++;
            }
        }
        Queue<Integer> q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> list=new ArrayList<>();
        while(!q.isEmpty()){
            int front=q.poll();
            list.add(front);
            for(int neighbor:adj.getOrDefault(front,new ArrayList<>())){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    q.add(neighbor);
                }
            }
        }
        if(list.size()!=n){
            return new int[]{};
        }
        int[] nums=new int[n];
        for(int i=0;i<list.size();i++){
            nums[i]=list.get(i);
        }
        return nums;
    }
}