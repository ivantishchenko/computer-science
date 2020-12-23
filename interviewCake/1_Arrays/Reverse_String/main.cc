#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

void reverse(string& str) {
    if(str.empty()) {
        return;
    }
    for(size_t i = 0, j = str.size() - 1; i < j; i++, j--) {
        swap(str[i], str[j]);
    } 
}

int main() {
    string foobar = "foobar";
    cout << foobar << endl;
    reverse(foobar);
    cout << foobar;
    return 0;
}
