package org.example;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Long> {
    private int from, to;
    public FactorialTask(int n) {
        this.to = n;
        this.from = n > 0 ? 1 : 0;
    }

    private FactorialTask(int from, int to) {
        this.to = to;
        this.from = from;
    }
    @Override
    protected Long compute() {
        int range = to - from;
        if (range == 0) {
            return (long) from;
        } else if (range == 1) {
            return ((long) from * to);
        } else {
            int mid = from + range / 2;
            FactorialTask leftTask = new FactorialTask(from, mid);
            leftTask.fork();
            return new FactorialTask(mid + 1, to).compute() * leftTask.join();
        }
    }
}
