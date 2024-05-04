class Solution {
    public boolean isSubsequence(String s, String t) {
        // 가장 쉬운 건 이중 루프문
        // 다만, 이중 루프로 풀었을 때
        // s의 길이가 10^9 이라면 시간 초과가 날 것이다.
        // 정렬 되어 있지 않으니 이진탐색은 X
        // s 는 idx 로 증가, t 는 루프
        // idx 가 s.length() 와 같다면 트루, 아니면 폴스
        int sizeS = s.length(), sizeT = t.length();
        if (sizeS == 0)
            return true;
        for (int i = 0, j = 0; i < sizeT; i++) {
            if (s.charAt(j) == t.charAt(i))
                j++;
            if (j == sizeS)
                return true;
        }
        return false;
    }
}