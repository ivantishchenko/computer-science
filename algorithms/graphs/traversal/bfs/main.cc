#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

vector<int> bfs(vector<vector<int>> adj, int start_node) {
    queue<int> q;
    q.push(start_node);
    vector<int> distances(adj.size(), -1);
    distances[start_node] = 0;
    while(!q.empty()) {
        int curr_node = q.front(); q.pop();
        for(int next_node: adj[curr_node]) {
            if(distances[next_node] == -1) {
                distances[next_node] = distances[curr_node] + 1;
                q.push(next_node);
            }
        }
    }
    return distances;
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
    vector<int> distances = bfs(adj, v);
    for(int num: distances) cout << num << " ";
    cout << endl;
}

int main() {
    int t;
    cin >> t;
    for(int i = 0; i < t; ++i) {
        testcase();
    }
}
