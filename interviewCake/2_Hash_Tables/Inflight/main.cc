#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

bool canTwoMoviesFillFlight(const vector<int>& movieLengths, int target) {
    unordered_set<int> nums;
    for(int num: movieLengths) {
        auto iter = nums.find(target - num);
        if(iter != nums.end()) return true;
        nums.insert(num);
    }
    return false;
}

int main() {
    const vector<int> nums = {1, 2, 3, 4, 5, 6};
    int target = 7;
    cout << canTwoMoviesFillFlight(nums, target);
    return 0;
}

