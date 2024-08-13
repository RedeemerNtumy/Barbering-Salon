package org.barber;

import java.util.ArrayList;

public class ClientQueue {
    private ArrayList<Client> queue;

    public ClientQueue() {
        this.queue = new ArrayList<>();
    }

    public void enqueue(Client client) {
        queue.add(client);
    }

    public Client dequeue() {
        if (isEmpty()) {
            return null;
        }
        return queue.remove(0);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }

    public Client get(int index) {
        return queue.get(index);
    }

    public void remove(int index) {
        if (index >= 0 && index < queue.size()) {
            queue.remove(index);
        }
    }
}
