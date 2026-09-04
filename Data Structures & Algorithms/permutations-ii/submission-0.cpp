class Solution {
public:
    vector<vector<int>> ans;
    vector<int> num;
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        num = nums;
        recurse(0);
        return ans;
    }

    void recurse(int ind)
    {
        if(ind==num.size())
        {
            auto it = find(ans.begin(), ans.end(), num);
            if(it==ans.end())
            {
                ans.push_back(num);
            }
            return;
        }
        for(int i = ind; i<num.size(); i++)
        {  
            swap(num[ind], num[i]);   //1   // 1 1  // 1 
            recurse(ind+1);   
            swap(num[ind], num[i]);  // ind: 1  ind: 2 
        }
    }
};