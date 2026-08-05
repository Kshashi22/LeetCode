class RecentCounter {

    List<Integer> calls;

    public RecentCounter() {
        calls = new ArrayList<>();
    }

    public int ping(int t) {

        calls.add(t);

        int count = 0;

        for (int time : calls) {
            if (time >= t - 3000 && time <= t) {
                count++;
            }
        }

        return count;
    }
}