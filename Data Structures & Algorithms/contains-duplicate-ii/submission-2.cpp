class Solution {
public:
    bool containsNearbyDuplicate(vector<int>& nums, int k) {
        if(k==0)
        {
            return false;
        }
        for(int l = 1; l<=k; l++)
        {
        int i = 0;
        int j = l;
        while(j<nums.size())
        {
            if(nums[i]==nums[j])
            {
                return true;
            }
            i++;
            j++;
        }
        }
        return false;
    }
};