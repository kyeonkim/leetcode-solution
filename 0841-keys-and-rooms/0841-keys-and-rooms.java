class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] isUnlocks = new boolean[rooms.size()];

        unlockRoom(rooms, isUnlocks, 0);
        for (boolean isUnlock: isUnlocks) {
            if (isUnlock == false)
                return false;
        }
        return true;
    }

    private void unlockRoom(List<List<Integer>> rooms, boolean[] isUnlocks, int start) {
        if (isUnlocks[start] == true) return;
        isUnlocks[start] = true;
        List<Integer> room = rooms.get(start);
        for (int i = 0; i < room.size(); i++)
            unlockRoom(rooms, isUnlocks, room.get(i));
    }
}