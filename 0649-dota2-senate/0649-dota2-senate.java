class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Character> senators = new LinkedList<>();
        for (char ch : senate.toCharArray())
            senators.offer(ch);
        int flag = 0;
        while (senators.size() > 1 && Math.abs(flag) < senators.size()) {
            char senator = senators.poll();
            if (senator == 'R') {
                flag++;
                if (flag > 0) senators.offer(senator);
            }
            else {
                flag--;
                if (flag < 0) senators.offer(senator);
            }
        }
        if (senators.peek() == 'R')
            return "Radiant";
        return "Dire";
    }
}