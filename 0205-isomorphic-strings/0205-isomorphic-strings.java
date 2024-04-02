class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        char[] Sarr = s.toCharArray();
        char[] Tarr = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (sMap.containsKey(Sarr[i])) {
                if(sMap.get(Sarr[i]) != Tarr[i])
                    return false;
            }
            else {
                if(tMap.containsKey(Tarr[i]))
                    return false;
                sMap.put(Sarr[i], Tarr[i]);
                tMap.put(Tarr[i], Sarr[i]);
            }
        }
        return true;
    }
}