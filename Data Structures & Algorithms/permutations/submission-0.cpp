class Solution {
public:
    vector<vector<int>> ans;
    vector<int> num;
    vector<bool> visited;
    vector<vector<int>> permute(vector<int>& nums) {
        num = nums;
        visited = vector<bool>(nums.size(), false);
        vector<int> temp;
        recurse(temp);
        return ans;
    }

    void recurse(vector<int> temp)
    {
        if(temp.size()==num.size())
        {
            ans.push_back(temp);
            return;
        }
        for(int i = 0; i<num.size(); i++)
        {  
            if(!visited[i])
            {
                visited[i] = true;
                temp.push_back(num[i]);
                recurse(temp);
                visited[i] = false;
                temp.pop_back();
            }
        }
    }
};