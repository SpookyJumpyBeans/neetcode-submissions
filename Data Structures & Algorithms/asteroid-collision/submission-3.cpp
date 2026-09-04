class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        stack<int> temp;
        for(int i : asteroids)
        {
            if(temp.empty())
            {
                temp.push(i);
            }
            else if(temp.size()>0&& (temp.top()>0 && i<0))
            {
                bool flag = false;
                while(temp.size()>0&& (temp.top()>0 && i<0))
                {
                    int t = temp.top();
                    if(abs(t)>abs(i))               
                    {
                        flag = true;
                        break;
                    }
                    else if(abs(t)<abs(i))
                    {
                        temp.pop();
                    }
                    else if(abs(t)==abs(i))
                    {
                        flag = true;
                        temp.pop();
                        break;
                    }
                }
                if(!flag)
                {
                    temp.push(i);
                }
            }
            else
            {
                temp.push(i);
            }
        }
        vector<int> tempp;
        vector<int> ans;
        while(!temp.empty())
        {

            tempp.push_back(temp.top());
            temp.pop();
        }
        reverse(tempp.begin(), tempp.end());
        ans.insert(ans.end(), tempp.begin(), tempp.end());
        return ans;
    }
};