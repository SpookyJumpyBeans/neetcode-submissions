class Solution {
public:
    int openLock(vector<string>& deadends, string target) {
        queue<pair<string, int>> q;
        q.push({"0000", 0});
        unordered_set<string> visited;
        for(string m : deadends)
        {
            visited.insert(m);
        }
        if(visited.contains("0000"))
        {
            return -1;
        }
        while(!q.empty())
        {
            auto p = q.front();
            q.pop();
            int count = p.second + 1;
            vector<string> temp;
            for(int i = 0; i<4; i++)
            {
                string t = p.first;
                int b = t[i] - '0';
                if(b==0)
                {
                    b = 9;
                }
                else
                {
                    b--;
                }
                t[i] = b + '0';
                temp.push_back(t);
            }
             for(int i = 0; i<4; i++)
            {
                string t = p.first;
                int b = t[i] - '0';
                if(b==9)
                {
                    b = 0;
                }
                else
                {
                    b++;
                }
                t[i] = b + '0';
                temp.push_back(t);
            }
            for(string t : temp)
            {
                if(t==target)
                {
                    return count;
                }
                if(!visited.contains(t))
                {
                   visited.insert(t);
                   q.push({t, count});
                }
            }
        }
        return -1;
    }
};