#include<bits/stdc++.h> 
using namespace std;

class Solution {
	void helper(int left, int right, vector<char> &v) {
		if(left > right) {
			return;
		}
		helper(left + 1, right - 1, v);
		std::swap(v[left], v[right]);
	}
public:
    void reverseString(vector<char>& s) {
    	helper(0, s.size() - 1, s);
    }
};

int main() {
	vector<char> v = {'l', 'o', 'x'}; 
 	Solution s;
 	s.reverseString(v);

 	for(size_t i = 0; i < v.size(); i++) {
 		cout << v[i];
 	}
}