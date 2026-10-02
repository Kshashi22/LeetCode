class SmallestInfiniteSet {
    Set<Integer> set;
    PriorityQueue<Integer> pq;
    int next =1;
    public SmallestInfiniteSet() {
        set = new HashSet<>();
        pq = new PriorityQueue<>();
    }
    
    public int popSmallest() {
        if(!pq.isEmpty()){
            int num = pq.poll();
            set.remove(num);
            return num;
        }
        return next++;
    }
    
    public void addBack(int num) {
        if(num<next && !set.contains(num)){
            pq.add(num);
            set.add(num);
        }
    }
}

