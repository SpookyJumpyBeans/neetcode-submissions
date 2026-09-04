class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        vector<int> temp;
        for(int i : asteroids)
        {
            if(temp.empty())
            {
                temp.push_back(i);
            }
            else if(temp.size()>0&& (temp.back()>0 && i<0))
            {
                bool flag = false;
                while(temp.size()>0&& (temp.back()>0 && i<0))
                {
                    int t = temp.back();
                    if(abs(t)>abs(i))               
                    {
                        flag = true;
                        break;
                    }
                    else if(abs(t)<abs(i))
                    {
                        temp.pop_back();
                    }
                    else if(abs(t)==abs(i))
                    {
                        flag = true;
                        temp.pop_back();
                        break;
                    }
                }
                if(!flag)
                {
                    temp.push_back(i);
                }
            }
            else
            {
                temp.push_back(i);
            }
        }
        return temp;
    }
};