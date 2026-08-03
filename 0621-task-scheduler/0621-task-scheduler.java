class Solution {
    public int leastInterval(char[] tasks, int n) {

        class Pair {
            int freq;
            char ch;

            Pair(int freq, char ch) {
                this.freq = freq;
                this.ch = ch;
            }
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);

        HashMap<Character, Integer> reserved = new HashMap<>();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new Pair(entry.getValue(), entry.getKey()));
            reserved.put(entry.getKey(), 0);      // initially available
        }

        int seat = 0;

        while (!pq.isEmpty()) {

            ArrayList<Pair> temp = new ArrayList<>();
            Pair chosen = null;

            // Find the first executable task
            while (!pq.isEmpty()) {

                Pair curr = pq.poll();

                if (reserved.get(curr.ch) <= seat) {
                    chosen = curr;
                    break;
                }

                temp.add(curr);
            }

            // Put skipped tasks back
            for (Pair p : temp) {
                pq.offer(p);
            }

            if (chosen == null) {
                // CPU is idle
                seat++;
                continue;
            }

            // Execute chosen task
            chosen.freq--;

            reserved.put(chosen.ch, seat + n + 1);

            if (chosen.freq > 0) {
                pq.offer(chosen);
            }

            seat++;
        }

        return seat;
    }
}