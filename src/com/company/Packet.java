package com.company;

public class Packet {
    private String date;
    private String protocol;
    private String connection;
    private int bytes;

    public Packet(String date, String protocol, String connection, int bytes) {
        this.date = date;
        this.protocol = protocol;
        this.connection = connection;
        this.bytes = bytes;
    }

    @Override
    public String toString() {
        return "Packet{" +
                "date='" + date + '\'' +
                ", protocol='" + protocol + '\'' +
                ", connection='" + connection + '\'' +
                ", bytes=" + bytes +
                '}' + '\r' + '\n';
    }

    public String getType() {
        return protocol;
    }

    public int getBytes() {
        return bytes;
    }
}
