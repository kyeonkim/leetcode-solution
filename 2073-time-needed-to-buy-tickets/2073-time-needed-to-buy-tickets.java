class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        Queue<Integer> buyTicketNum = new ArrayDeque<Integer>();
        int remainingTickets = tickets[k];
        for (int i = 0; i < tickets.length; i++)
            buyTicketNum.offer(i);
        while (remainingTickets != 0) {
            if (tickets[buyTicketNum.peek()] == 0)
                buyTicketNum.poll();
            else {
                if (buyTicketNum.peek() == k)
                    remainingTickets--;
                tickets[buyTicketNum.peek()]--;
                time++;
                buyTicketNum.offer(buyTicketNum.poll());
            }
        }
        return time;
    }
}