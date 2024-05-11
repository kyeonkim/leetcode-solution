class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<Pair<Double, Integer>> wageQualityRatio = new ArrayList<>();

        for (int i = 0; i < wage.length; i++) {
            wageQualityRatio.add(new Pair<>((double)wage[i] / quality[i], quality[i]));
        }
        Collections.sort(wageQualityRatio, Comparator.comparingDouble(Pair::getKey));
        PriorityQueue<Integer> highQualityWorker = new PriorityQueue<>(Collections.reverseOrder());
        double total = Double.MAX_VALUE;
        for (int i = 0, curQualityWage = 0; i < wage.length; i++) {
            highQualityWorker.offer(wageQualityRatio.get(i).getValue());
            curQualityWage += wageQualityRatio.get(i).getValue();
            if (highQualityWorker.size() > k)
                curQualityWage -= highQualityWorker.poll();
            if (highQualityWorker.size() == k)
                total = Math.min(total, curQualityWage * wageQualityRatio.get(i).getKey());
        }
        return total;
    }
}