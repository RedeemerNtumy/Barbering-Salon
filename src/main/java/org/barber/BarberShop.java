package org.barber;

import java.util.ArrayList;

public class BarberShop {
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

    public void clientArrives(Client client) {
        if (mainChair == null) {
            mainChair = client;
        } else {
            if (waitingChairs.size() < maxWaitingChairs) {
                if (client.isVIP()) {
                    if (!waitingChairs.isEmpty() && waitingChairs.get(0).isVIP()) {
                        waitingChairs.enqueue(client);
                    } else {
                        waitingChairs.enqueue(client);
                    }
                } else {
                    waitingChairs.enqueue(client);
                }
            } else {

            }
        }
    }

    public void clientLeavesMainChair() {
        if (mainChair != null) {
            mainChair = waitingChairs.dequeue();
            if (mainChair != null) {
            }
        }

    }


}
