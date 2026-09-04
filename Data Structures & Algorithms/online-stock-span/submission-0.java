class StockSpanner {
    Stack<Integer> span = new Stack<>();
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        Stack<Integer> temp = new Stack<>();
        int count = 1;
        while(!span.isEmpty() && span.peek()<=price)
        {
            count++;
            temp.push(span.pop());
        }
        while(!temp.isEmpty())
        {
        span.push(temp.pop());
        }
        span.push(price);
        return count;       
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */