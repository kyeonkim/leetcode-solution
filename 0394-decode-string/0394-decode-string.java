class Solution {
    private int i = 0;
    
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        while (i < s.length()) {
            char ch = s.charAt(i++);
            if (ch == '[') {
                String tempStr = decodeString(s);
                for (int j = 0; j < cnt; j++)
                    sb.append(tempStr);
                cnt = 0;
            }
            else if (ch == ']') 
                break;
            else if (Character.isAlphabetic(ch))
                sb.append(ch);
            else
                cnt = cnt * 10 + ch - '0';
        }
        return sb.toString();
    }
} 