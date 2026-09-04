class Solution {
    vector<vector<int>> memo;
    vector<vector<int>> matr;
    int row;
    int col;
    int maxx = -1;
public:
    int longestIncreasingPath(vector<vector<int>>& matrix) {
        memo.assign(matrix.size(), vector<int>(matrix[0].size(), 0));
        row = matrix.size();
        col = matrix[0].size();
        matr = matrix;
        for(int i = 0; i<matrix.size(); i++)
        {
            for(int j = 0; j<matrix[0].size(); j++)
            {
                maxx = max(maxx, recurse(i, j, -1));
            }
        }
        return maxx;
    }

    int recurse(int r, int c, int preVal)
    {
        if(r<0 || r>=row || c<0 || c>=col || preVal>=matr[r][c])
        {
            return 0;
        }
        if(memo[r][c]>0)
        {
            return memo[r][c];
        }
        int ans1 = recurse(r+1, c, matr[r][c]);
         int ans2 = recurse(r-1, c, matr[r][c]);
          int ans3 = recurse(r, c+1, matr[r][c]);
           int ans4 = recurse(r, c-1, matr[r][c]);
        memo[r][c] = 1+max({ans1, ans2, ans3, ans4});
        return memo[r][c];
    }
};
