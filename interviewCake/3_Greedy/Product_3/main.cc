#include <iostream>
#include <vector>
#include <algorithm>
#include <exception>
#include <climits>

using namespace std;

int highestProductOf3(const vector<int>& vec) {
    if(vec.size() <= 2) {
        throw runtime_error("Invalid vector");
    }
    int low = min(vec[0], vec[1]);
    int high = max(vec[0], vec[1]);
    
    int low_prod2 = vec[0] * vec[1];
    int high_prod2 = vec[0] * vec[1];

    int res = INT_MIN;

    for(size_t i = 2; i < vec.size(); ++i) {
        res = max(max(low_prod2 * vec[i], high_prod2 * vec[i]), res);

        low_prod2 = min(min(low * vec[i], high * vec[i]), low_prod2);
        high_prod2 = max(max(high * vec[i], low * vec[i]), high_prod2);

        low = min(vec[i], low);
        high = max(vec[i], high);
    }
    return res; 
}

int main() {
    cout << highestProductOf3({1, 2, 3, 4}) << endl;
    return 0;
}
