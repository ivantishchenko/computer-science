#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

void dfs(vector<vector<int>> &adj, int node, int &visit_count, vector<int> &enter, vector<int> &leave) {
    if (enter[node] == -1) {
        enter[node] = visit_count++;
        sort(adj[node].begin(), adj[node].end());
        for(int next_node: adj[node]) {
            dfs(adj, next_node, visit_count, enter, leave);
        }
        leave[node] = visit_count++;
    }
}

void testcase() {
    int n, m, v; 
    cin >> n >> m >> v;
    vector<vector<int>> adj(n);
    for(int i = 0; i < m; ++i) {
        int a, b;
        cin >> a >> b;
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    // do dfs
    vector<int> enter(n, -1);
    vector<int> leave(n, -1);
    int visit_count = 0;
    dfs(adj, v, visit_count, enter, leave);
    for(int num: enter) cout << num << " ";
    cout << endl;
    for(int num: leave) cout << num << " ";
    cout << endl;
}

int main() {
    int t; 
    cin >> t;
    for(int i = 0; i < t; ++i) {
        testcase();
    }
}
