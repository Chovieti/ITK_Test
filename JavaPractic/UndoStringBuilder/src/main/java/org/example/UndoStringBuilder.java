package org.example;

import java.util.Stack;

public class UndoStringBuilder {
    private StringBuilder builder;
    private Stack<Snapshot> snapshots;

    // Можно было бы реализовать с сохраненем не состояний, а операций или разницы, но это достаточно проблемно было бы
    // делать с методами меняющими строку посреди или в начале, а не при добавлении. Так что оставил такой вариант,
    // хоть он и не особо эффективен по памяти
    private record Snapshot(String state) {}

    public UndoStringBuilder() {
        this.builder = new StringBuilder();
        this.snapshots = new Stack<>();
    }

    public UndoStringBuilder(String str) {
        this.builder = new StringBuilder(str);
        this.snapshots = new Stack<>();
        saveSnapshot();
    }

    private void saveSnapshot() {
        snapshots.push(new Snapshot(builder.toString()));
    }

    public UndoStringBuilder undo() {
        if (!snapshots.isEmpty()) {
            builder = new StringBuilder(snapshots.pop().state);
        }
        return this;
    }

    public UndoStringBuilder append(String str) {
        saveSnapshot();
        builder.append(str);
        return this;
    }

    @Override
    public String toString() {
        return builder.toString();
    }
}
