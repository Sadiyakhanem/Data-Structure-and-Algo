class Solution {
    public String reorganizeString(String s) {
        class pair
        {
            int first;
            char second;
            pair(int first,char second)
            {
               this.first=first;
               this.second=second;
            }
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i =0;i<s.length();i++)
        {
            char ch =s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);

        }
        PriorityQueue<pair> pq = new PriorityQueue<>(
            (a,b)->
            {
                if(a.first!=b.first)
                {
                    return b.first-a.first;
                }
                else
                {
                   return b.second-a.second;
                }
            }
        );
        for(Map.Entry<Character,Integer>entry:map.entrySet())
        {
            char ch = entry.getKey();
            int freq = entry.getValue();
            pq.offer(new pair(freq,ch));
        }
    StringBuilder res = new StringBuilder();
    int seat =0;
    while(!pq.isEmpty())
    {
       pair curr = pq.poll();
       int p1=curr.first;
       char p2 =curr.second;
        if(seat==0 || res.charAt(seat-1) != p2)
        {
            res.append(p2);
            seat++;
            p1--;
            if(p1>0)
            {
                pq.offer(new pair(p1,p2));
            }

        }
        else
        {
            if (pq.isEmpty()) {
             return "";
                   }

            pair current = pq.poll();
            int nextfreq =current.first;
            char nextch = current.second;
            res .append( nextch);
            seat++;
            nextfreq--;
            if(nextfreq>0)
            {
                pq.offer(new pair(nextfreq,nextch));
            }
            pq.offer(new pair(p1,p2));




        }



    }
    return res.toString();

        

    }
}