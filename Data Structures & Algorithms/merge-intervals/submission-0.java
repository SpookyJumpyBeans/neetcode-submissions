class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[0]-b[0]);
        for(int i = 0; i<intervals.length; i++)
        {
            q.add(intervals[i]);
        }
        ArrayList<int[]> ans = new ArrayList<>();
        while(!q.isEmpty())
        {
            int[] temp = q.poll();
            int start = temp[0];
            int end = temp[1];
            while(!q.isEmpty()&& end>=q.peek()[0])
            {
                end = Math.max(end, q.poll()[1]);
            }
            ans.add(new int[]{start, end});
        }
        int[][] array2D = ans.stream().toArray(int[][]::new);
        return array2D;
    }
}
