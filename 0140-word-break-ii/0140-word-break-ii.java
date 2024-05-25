class Solution {
    List<String> outputs;
    int n;

    public List<String> wordBreak(String s, List<String> wordDict) {
        outputs = new ArrayList<>();
        n = s.length();
        Set<String> wordset = new HashSet<>();
        
        for (String str: wordDict)
            wordset.add(str);
        backtrack(0, s, wordset, new StringBuilder());
        return outputs;
    }

    private void backtrack(int start, String s, Set<String> wordset, StringBuilder subSentences) {
        if (start == n) {
            subSentences.deleteCharAt(subSentences.length() - 1);
            outputs.add(subSentences.toString());
            return;
        }
        for (int end = start + 1; end <= n; end++) {
            String subWord = s.substring(start, end);
            if (wordset.contains(subWord)) {
                int subSentencesLength = subSentences.length();
                subSentences.append(subWord);
                subSentences.append(' ');
                backtrack(end, s, wordset, subSentences);
                subSentences.setLength(subSentencesLength);
            }
        }
    }
}