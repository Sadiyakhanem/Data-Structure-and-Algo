class Solution {
    class pair
    {
        int node;
        int distance;
        pair(int node,int distance)
        {
            this.node =node;
            this.distance =distance;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        int[] dist = new int[n];
        for(int i =0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++)
        {
            int src =times[i][0];
            int des =times[i][1];
            int wt = times[i][2];
         ArrayList<Integer> edge = new ArrayList<>();
         edge.add(des-1);
         edge.add(wt);
            adj.get(src-1).add(edge);
        }
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)-> a.distance - b.distance);

        dist[k-1]=0;
        pq.offer(new pair(k-1,0));
        while(!pq.isEmpty())
        {
            pair curr = pq.poll();
            int node =curr.node;
            int distance = curr.distance;
            if(distance>dist[node])
            {
                continue;
            }
            for(int i=0;i<adj.get(node).size();i++)
            {
                int neigh =adj.get(node).get(i).get(0);
                int weight = adj.get(node).get(i).get(1);
                int newdist = distance+weight;
                if(newdist<dist[neigh])
                {
                    dist[neigh]=newdist;
                    pq.offer(new pair(neigh,newdist));
                }

            }
        }
        int max =0;
        for(int i=0;i<dist.length;i++)
        {
            if (dist[i] == Integer.MAX_VALUE) {
    return -1;
}
            if(max<dist[i])
            {
                max=dist[i];
            }
            
        }
        return max;





        
    }
}