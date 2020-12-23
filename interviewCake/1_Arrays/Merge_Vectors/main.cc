#include <iostream>
#include <vector>

using namespace std;

vector<int> mergeVectors(const vector<int>& a, const vector<int>& b) {
    vector<int> res;
    size_t i = 0;
    size_t j = 0;
    while(i < a.size() && j < b.size()) {
        if(a[i] <= b[j]) {
            res.push_back(a[i]);
            i++;
        }
        else {
            res.push_back(b[j]);
            j++;
        }
    }
    while(i < a.size()) {
        res.push_back(a[i]);
        i++;
    }
    while(j < b.size()) {
        res.push_back(b[j]);
        j++;
    }
    return res;
}

int main() {
    const vector<int> myVector = {3, 4, 6, 10, 11, 15};
    const vector<int> alicesVector = {1, 5, 8, 12, 14, 19};
    
    vector<int> mergedVector = mergeVectors(myVector, alicesVector);
    cout << "[";
    for (size_t i = 0; i < mergedVector.size(); ++i) {
        if (i > 0) cout << ", ";     
        cout << mergedVector[i];      
    }
    cout << "]" << endl;
    return 0;
}
