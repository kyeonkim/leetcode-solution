class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visitedCodes = new HashSet<String>(Arrays.asList(deadends));
        if (visitedCodes.contains("0000"))
            return -1;
        Map<Character, Character> nextSlot = Map.of(
            '0','1',
            '1','2',
            '2','3',
            '3','4',
            '4','5',
            '5','6',
            '6','7',
            '7','8',
            '8','9',
            '9','0');
        Map<Character, Character> prevSlot = Map.of(
            '0','9',
            '1','0',
            '2','1',
            '3','2',
            '4','3',
            '5','4',
            '6','5',
            '7','6',
            '8','7',
            '9','8');
        Queue<String> pendingCodes = new LinkedList<String>();
        int turn = 0;
        visitedCodes.add("0000");
        pendingCodes.add("0000");
        while(!pendingCodes.isEmpty()) {
            int curCodesSize = pendingCodes.size();
            for (int i = 0; i < curCodesSize; i++) {
                String curCode = pendingCodes.poll();
                if (curCode.equals(target))
                    return turn;
                for (int wheel = 0; wheel < 4; wheel++) {
                    StringBuilder newCode = new StringBuilder(curCode);
                    newCode.setCharAt(wheel, nextSlot.get(newCode.charAt(wheel)));
                    if (!visitedCodes.contains(newCode.toString())) {
                        visitedCodes.add(newCode.toString());
                        pendingCodes.add(newCode.toString());
                    }
                    newCode = new StringBuilder(curCode);
                    newCode.setCharAt(wheel, prevSlot.get(newCode.charAt(wheel)));
                    if (!visitedCodes.contains(newCode.toString())) {
                        visitedCodes.add(newCode.toString());
                        pendingCodes.add(newCode.toString());
                    }
                }
            }
            turn++;           
        }
        return -1;
    }
}