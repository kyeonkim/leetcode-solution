class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new LinkedList<Integer>();
        Stack<Integer> sandwichStack = new Stack<Integer>();

        for (int student : students) {
            studentQueue.offer(student);
        }
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            sandwichStack.push(sandwiches[i]);
        }
        int notServedCnt = 0;
        while (!studentQueue.isEmpty() && !sandwichStack.empty()) {
            if (studentQueue.peek().equals(sandwichStack.peek())) {
                studentQueue.poll();
                sandwichStack.pop();
                notServedCnt = 0;
            } else {
                studentQueue.offer(studentQueue.poll());
                notServedCnt++;
            }
            if (studentQueue.size() == notServedCnt)
                return notServedCnt;
        }
        return notServedCnt;
    }
}