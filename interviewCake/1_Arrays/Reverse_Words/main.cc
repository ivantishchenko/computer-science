#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

void reverseWords(string& msg) {
    reverse(msg.begin(), msg.end());
    int start = 0;
    for(size_t i = 0; i < msg.size(); i++) {
        if(msg[i] == ' ') {
            reverse(msg.begin() + start, msg.begin() + i);
            start = i + 1;
        }
    }
    reverse(msg.begin() + start, msg.end());
}

int main() {
   string msg = "cake pound steal";
   reverseWords(msg);
   cout << msg << endl;
}
