#include <iostream>
#include <vector>

using namespace std;

bool isFirstComeFirstServed(const vector<int>& orders1, const vector<int>& orders2, const vector<int>& records) {
    size_t i = 0, j = 0;
    for(int r: records) {
        if(i < orders1.size() && r == orders1[i]) i++; 
        else if (j < orders2.size() && r == orders2[j]) j++;
        else return false;
    }
    if (i != orders1.size() || j != orders2.size()) return false;
    return true;
}

int main(int argc, char** argv) {
    vector<int> a = {17, 8, 24};
    vector<int> b = {12, 19, 2};
    vector<int> c = {17, 8, 12, 19, 24, 2};
    cout << isFirstComeFirstServed(a, b ,c);
    return 0;
}
