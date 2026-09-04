class Solution {
public:
    void sortColors(vector<int>& nums) {
        vector<int> temp(3);
        for(int i : nums)
        {
            temp[i]++;
        }
        int tt = 0;
        for(int j = 0; j<3; j++)
        {
           int w = temp[j];
           while(w-->0)
           {
            nums[tt] = j;
            tt++;
           }
        }
    }
};