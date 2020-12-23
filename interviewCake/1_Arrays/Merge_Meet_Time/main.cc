#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class Meeting {
    // number of 30 min blocks past 9:00 am
    unsigned int startTime_;
    unsigned int endTime_;
public:
    Meeting(): startTime_(0), endTime_(0) {}

    Meeting(unsigned int startTime, unsigned int endTime): startTime_(startTime), endTime_(endTime) {}

    unsigned int getStartTime() const {
        return startTime_;
    }

    void setStartTime(unsigned int startTime) {
        startTime_ = startTime;
    }

    unsigned int getEndTime() const {
        return endTime_;
    }

    void setEndTime(unsigned int endTime) {
        endTime_ = endTime;
    }

    bool operator==(const Meeting& other) const {
        return startTime_ == other.startTime_ && endTime_ == other.endTime_;
    }
};

bool compareMeeting(const Meeting& m1, const Meeting& m2) {
    return m1.getStartTime() < m2.getStartTime();
}

vector<Meeting> mergeRanges(const vector<Meeting>& meetings) {
    vector<Meeting> sorted_meetings = meetings; 
        
    sort(sorted_meetings.begin(), sorted_meetings.end(), compareMeeting);
    vector<Meeting> res;

    unsigned int start = sorted_meetings[0].getStartTime();
    unsigned int end = sorted_meetings[0].getEndTime();

    for(size_t i = 0; i < sorted_meetings.size(); i++) {
        if(sorted_meetings[i].getStartTime() <= end) {
            end = max(sorted_meetings[i].getEndTime(), end);
        } else {
            res.push_back(Meeting(start, end));
            start = sorted_meetings[i].getStartTime();
            end = sorted_meetings[i].getEndTime();
        }
    }
    res.push_back(Meeting(start, end));
    return res;
}

void printMeetings(const vector<Meeting>& meetings) {
    for(auto& m: meetings) {
        cout << m.getStartTime() << " " << m.getEndTime() << endl; 
    }
}

int main() {
    vector<Meeting> meetings= {Meeting(1, 10), Meeting(2, 6), Meeting(3, 5), Meeting(7, 9)};
    printMeetings(meetings);
    cout << endl;
    vector<Meeting> res = mergeRanges(meetings);
    printMeetings(res);
    return 0;
}
