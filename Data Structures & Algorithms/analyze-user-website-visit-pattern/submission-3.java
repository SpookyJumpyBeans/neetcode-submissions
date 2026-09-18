class Solution {
    public record tuple(int time, String user, String web) {}
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        PriorityQueue<tuple> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.time(), b.time()));
        for(int i = 0; i<username.length; i++)
        {
            pq.add(new tuple(timestamp[i], username[i], website[i]));
        }
        Map<String, List<String>> userVisit = new HashMap<>();
        while(!pq.isEmpty())
        {
            tuple temp = pq.poll();
            userVisit.computeIfAbsent(temp.user(), k -> new ArrayList<>()).add(temp.web());
        }
        TreeMap<String, Set<String>> counts = new TreeMap<>();
        for(String user : userVisit.keySet())
        {
            List<String> temp = userVisit.get(user);
            for(int i = 0; i<temp.size()-2; i++)
            {
                for(int j = i+1; j<temp.size()-1; j++)
                {
                    for(int k = j+1; k<temp.size(); k++)
                    {
                        StringBuilder ss = new StringBuilder(temp.get(i));
                        ss.append(" ");
                        ss.append(temp.get(j));
                        ss.append(" ");
                        ss.append(temp.get(k));
                        if(!counts.containsKey(ss.toString()))
                        {
                            counts.put(ss.toString(), new HashSet<>());
                        }
                        counts.get(ss.toString()).add(user);
                    }
                }
            }
        }            
        int max = 0;
        String maxx = "";
        for(String temp : counts.keySet())
        {
            if(counts.get(temp).size()>max)
            {
                max = counts.get(temp).size();
                maxx = temp;
            }
        }
        String[] tempp = maxx.split(" ");
        List<String> ans = new ArrayList<>();
        for(String t : tempp)
        {
            ans.add(t);
        }
        return ans;
    }
}