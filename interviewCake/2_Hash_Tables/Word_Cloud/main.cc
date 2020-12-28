#include <iostream>
#include <string>
#include <unordered_map>
#include <sstream>
#include <algorithm>

using namespace std;

class WordCloudData {
    unordered_map<string, size_t> wordsToCounts_;
    void populateWordsToCounts(const string& str);
public:
    WordCloudData (const string& inputString);
    const unordered_map<string, size_t> getWordsToCounts() const;
};

void WordCloudData::populateWordsToCounts(const string& original_str) {
    string str = original_str;
    for(size_t i = 0; i < str.size(); i++) {
        if(str[i] == '.') {
            str[i] = ' ';
        }
    }

    istringstream ss(str);
    string word;
    while(ss >> word) {
        if(word[0] == '-') continue;
        if(isupper(word[0])) word[0] = tolower(word[0]);
        if(ispunct(word[word.size() - 1])) word.erase(word.size() - 1); 
        if(wordsToCounts_.find(word) == wordsToCounts_.end()) {
            wordsToCounts_[word] = 1;
        } else {
            wordsToCounts_[word]++;
        }
    }
}

WordCloudData::WordCloudData(const string& inputString) {
    populateWordsToCounts(inputString);
}

const unordered_map<string, size_t> WordCloudData::getWordsToCounts() const {
    return wordsToCounts_;
}

int main() {
    const string text = "Mmm...mmm...decisions...decisions"; 
    WordCloudData data(text);
    for(auto& cloud: data.getWordsToCounts()) {
        cout << cloud.first << " " << cloud.second << endl;
    }
}
