class Solution {
    public int[] findBuildings(int[] heights) {
        int currMax = heights[heights.length-1];
        ArrayList<Integer> indices = new ArrayList<>();
        indices.add(heights.length-1);
        for(int i = heights.length-2; i>=0; i--)
        {
            if(heights[i]>currMax)
            {
                indices.add(0, i);
                currMax = heights[i];
            }
        }
        int[] ans = new int[indices.size()];
        for(int i = 0; i<indices.size(); i++)
        {
            ans[i] = indices.get(i);
        }
        return ans;
    }
}