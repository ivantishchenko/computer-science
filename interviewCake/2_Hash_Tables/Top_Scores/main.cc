#include <iostream>
#include <vector>

using namespace std;

vector<int> sortScores(const vector<int>& unorderedScores, int highestPossibleScore) {
    vector<int> counts(highestPossibleScore + 1);
    vector<int> res(unorderedScores.size());
    for(size_t i = 0; i < unorderedScores.size(); i++) {
        counts[unorderedScores[i]]++;
    }
    for(size_t i = 1; i < counts.size(); i++) {
        counts[i] += counts[i - 1]; 
    }
    for(size_t i = 0; i < unorderedScores.size(); i++) {
        res[unorderedScores.size() - counts[unorderedScores[i]]] = unorderedScores[i];
        counts[unorderedScores[i]]--;
    }
    return res;
}

int main() {
    const vector<int> unsortedScores {20, 10, 30, 30, 10, 20};
    const int HIGHEST_POSSIBLE_SCORE = 100;
    vector<int> sortedScores = sortScores(unsortedScores, HIGHEST_POSSIBLE_SCORE);
    for(size_t i = 0; i < sortedScores.size(); i++) {
        cout << sortedScores[i] << " ";
    } 
}
