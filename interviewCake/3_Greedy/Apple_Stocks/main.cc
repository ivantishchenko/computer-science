#include <iostream>
#include <vector>
#include <climits>

using namespace std;

int getMaxProfit(const vector<int>& prices) {
    if(prices.empty()) throw "Empty list";
    if(prices.size() == 1) throw "One element";
    int min_price = prices[0];
    int max_profit = INT_MIN;
    for(size_t i = 1; i < prices.size(); i++) {
        max_profit = max(prices[i] - min_price, max_profit);
        min_price = min(prices[i], min_price);
    }
    return max_profit;
}

int main() {
    const int actual = getMaxProfit({9, 7, 4, 1});
    cout << actual << endl;
    return 0;
}
