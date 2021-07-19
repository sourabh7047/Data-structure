#include <bits/stdc++.h>
using namespace std;
#define int long long int 
int32_t main()
{
    
    ios_base::sync_with_stdio(false);
    int t;
    cin >> t;
    while (t--)
    {
        int n;
        cin >> n;
        vector<pair<int, int>> x;
        vector<pair<int, int>> y;
        multiset<int> X;
        multiset<int> Y;
        for (int a = 0; a < n; ++a)
        {
            int p, q;
            cin >> p >> q;
            x.push_back({p, q});
            y.push_back({q, p});
            X.insert(p);
            Y.insert(q);
        }
        sort(x.begin(), x.end());
        sort(y.begin(), y.end());
        int up1 = 0;
        int up2 = 0;
        int height1maximum = 0;
        int height1minimum = LONG_MAX;
        int area = LONG_MAX;
        for (int a = 0; a < n - 1; ++a)
        {
            height1maximum = max(height1maximum, x[a].second);
            height1minimum = min(height1minimum, x[a].second);
            up1 = height1maximum - height1minimum;
            auto it = Y.find(x[a].second);
            Y.erase(it);
            up2 = *Y.rbegin() - *Y.begin();
            int newArea = (x[a].first - x[0].first) * up1 + (x[n - 1].first - x[a + 1].first) * up2;
            area = min(area, newArea);
        }
        int wd1 = 0;
        int wd2 = 0;
        int width1maximum = 0;
        int width1minimum = LONG_MAX;
        for (int a = 0; a < n - 1; ++a)
        {
            width1maximum = max(width1maximum, y[a].second);
            width1minimum = min(width1minimum, y[a].second);
            wd1 = width1maximum - width1minimum;
            auto it = X.find(y[a].second);
            X.erase(it);
            wd2 = *X.rbegin() - *X.begin();
            int newArea = (y[a].first - y[0].first) * wd1 + (y[n - 1].first - y[a + 1].first) * wd2;
            area = min(area, newArea);
        }
        if (area == LONG_MAX)
            area = 0;
        cout << area << endl;
    }
    return 0;
}