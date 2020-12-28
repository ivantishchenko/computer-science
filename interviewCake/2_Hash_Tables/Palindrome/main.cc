#include <iostream>
#include <string>
#include <unordered_map>

using namespace std;

bool hasPalindromePermutation(const string& str) {
    unordered_map<char, int> count_map;
    for(const char& c: str) {
        if(count_map.find(c) == count_map.end()) {
            count_map[c] = 1;
        }
        else {
            count_map[c]++;
        }
    }
    for(auto iter = count_map.begin(); iter != count_map.end();) {
        if(iter->second % 2 == 0) iter = count_map.erase(iter);
        else iter++;
    }
    return count_map.size() <= 1;    
}

int main() {
    string str = "civic";
    cout << hasPalindromePermutation(str) << endl;
    return 0;
}
