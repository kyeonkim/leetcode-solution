class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Map<Character, List<String>> dict = new HashMap<>();

        for (String word: dictionary) {
            char key = word.charAt(0);
            if (!dict.containsKey(key))
                dict.put(key, new ArrayList<>());
            dict.get(key).add(word);
        }
        for (char key: dict.keySet())
            Collections.sort(dict.get(key));

        String[] words = sentence.split(" ");
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char key = word.charAt(0);
            if (!dict.containsKey(key))
                answer.append(word);
            else
                answer.append(checkDict(dict, word, key));
            if (i < words.length - 1) {
                answer.append(" ");
            }
        }
        return answer.toString();
    }

    private String checkDict(Map<Character, List<String>> dict, String word, char key) {
        List<String> checkList = dict.get(key);
        String matchedWord = word;

        for (int i = 0; i < checkList.size(); i++) {
            String checkWord = checkList.get(i);
            if (word.length() >= checkWord.length()) {
                String subWord = word.substring(0, checkWord.length());
                if (subWord.equals(checkWord)) {
                    matchedWord = checkWord;
                    break;
                }
            }
        }
        return matchedWord;
    }
}