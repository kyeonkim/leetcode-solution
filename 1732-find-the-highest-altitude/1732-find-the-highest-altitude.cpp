class Solution {
public:
    int largestAltitude(vector<int>& gain) {
        int highAltSum = 0, curAltSum = 0;
        for (int i = 0; i < gain.size(); i++) {
            curAltSum += gain[i];
            highAltSum = max(curAltSum, highAltSum);
        }
        return highAltSum;
    }
};