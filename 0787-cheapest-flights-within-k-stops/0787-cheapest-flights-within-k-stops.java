class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
       
        for(int i=0;i<k+1;i++)
        {
            int[] temp = dist.clone();

            for(int j=0;j<flights.length;j++)
            {
                int sr =flights[j][0];
                int ds =flights[j][1];
                int wt =flights[j][2];
                if(dist[sr]!=Integer.MAX_VALUE)
                {
                     temp[ds] = Math.min(temp[ds], dist[sr] + wt);
                   
                }


            }
         dist=temp;

        }
           return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }
}