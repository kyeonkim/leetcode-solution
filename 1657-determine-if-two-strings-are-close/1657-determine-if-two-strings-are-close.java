class Solution {
    public boolean closeStrings(String word1, String word2) {
        Set<Character> setWord1 = wordToCharSet(word1);
        Set<Character> setWord2 = wordToCharSet(word2);
        if (setWord1.size() != setWord2.size())
            return false;
        for (char ch : setWord2) {
            if (!setWord1.contains(ch))
                return false;
        }
        List<Integer> word1Fre = sortedWordFre(word1);
        List<Integer> word2Fre = sortedWordFre(word2);
        for (int i = 0; i < word1Fre.size(); i++) {
            if (!word1Fre.get(i).equals(word2Fre.get(i)))
                return false;
        }
        return true;
    }

    private Set<Character> wordToCharSet(String word) {
        char[] charArray = word.toCharArray();
        Set<Character> charSet = new HashSet<>();
        for (char c : charArray) charSet.add(c);
        return charSet;
    }

    private List<Integer> sortedWordFre(String word) {
        Map<Character, Integer> wordFre = new HashMap<>();
        for (int i = 0; i < word.length(); i++)
            wordFre.put(word.charAt(i), wordFre.getOrDefault(word.charAt(i), 0) + 1);
        List<Integer> sortWordFre = new ArrayList<>(wordFre.values());
        Collections.sort(sortWordFre);
        return sortWordFre;
    }
}