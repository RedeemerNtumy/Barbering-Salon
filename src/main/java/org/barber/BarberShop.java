package org.barber;

class BarberShop {
    private Client mainChair;
    private ClientQueue waitingChairs;
    private int maxWaitingChairs;

    public BarberShop(int maxWaitingChairs) {
        this.mainChair = null;
        this.waitingChairs = new ClientQueue();
        this.maxWaitingChairs = maxWaitingChairs;
    }

    public boolean hasMainChairClient() {
        return mainChair != null;
    }

    public Client getClientInMainChair() {
        return mainChair;
    }

    public String shopState() {
        StringBuilder sb = new StringBuilder();
        sb.append(mainChair == null ? "----" : mainChair.getId());
        for (int i = 0; i < maxWaitingChairs; i++) {
            sb.append(" : ");
            if (i < waitingChairs.size()) {
                sb.append(waitingChairs.get(i).getId());
            } else {
                sb.append("----");
            }
        }
        return sb.toString();
    }

    public boolean clientArrives(Client client) {
        if (mainChair == null) {
            mainChair = client;
            return true;
        } else if (waitingChairs.size() < maxWaitingChairs) {
            waitingChairs.enqueue(client);
            return true;
        } else {
            return false; // Return false if client could not be seated
        }
    }

    public void clientLeavesMainChair() {
        mainChair = waitingChairs.dequeue();
    }
}