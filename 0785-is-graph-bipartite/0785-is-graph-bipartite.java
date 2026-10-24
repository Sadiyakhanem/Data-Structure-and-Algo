class Solution {
    public boolean isBipartite(int[][] graph) {
        int n =graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        for(int i=0;i<n;i++)
        {
            if(colors[i]==-1)
            {
                if( !dfs(graph,i,colors,0))
                {
                    return false;
                }
            }
        }
        return true;


        
    }
    public boolean dfs(int[][] graph, int node, int[] colors,int currc)
    {
        colors[node]=currc;
        for(int i=0;i<graph[node].length;i++)
        {
            int neigh = graph[node][i];
            if(colors[neigh] ==-1)
            {
                if(! dfs(graph,neigh,colors,1-currc))
                {
                    return false;
                }
            }
            else if(colors[neigh]==colors[node])
            {
                return false;

            }

        }
        return true;


    }
}