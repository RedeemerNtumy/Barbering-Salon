package org.barber;

import java.util.LinkedList;

class ClientQueue {
    private LinkedList<Client> queue = new LinkedList<>();

    public void enqueue(Client client) {
        if (client.isVIP() && !queue.isEmpty() && !queue.getFirst().isVIP()) {
            queue.addFirst(client); // VIPs jump to the front if the first in line is not a VIP
        } else {
            queue.add(client);
        }
    }

    public Client dequeue() {
        return queue.poll();
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
}
