package org.barber;

public class Client {
    private String id;
    private boolean isVIP;

    public Client(String id, boolean isVIP) {
        this.id = id;
        this.isVIP = isVIP;
    }

    public String getId() {
        return id;
    }

    public boolean isVIP() {
        return isVIP;
    }

    @Override
    public String toString() {
        return id;
    }
}

