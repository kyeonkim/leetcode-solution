import java.util.StringTokenizer;

class Solution {
    public String reverseWords(String s) {
        StringBuilder reverse = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(s, " ");
        List<String> words = new ArrayList<>();
        while (tokenizer.hasMoreTokens())
            words.add(tokenizer.nextToken());
        Collections.reverse(words);
        return String.join(" ", words);
    }
}