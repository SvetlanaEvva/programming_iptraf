package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static java.lang.Integer.parseInt;

/**
 *
 * @author http://habrahabr.ru/users/nucleotide/
 */
public class Main {
    static BufferedReader reader;
    public static void main(String[] args) throws IOException {
        List<Packet> packetList = new ArrayList<Packet>();
        try {
            reader = new BufferedReader(new FileReader("src/iptraf.log"));
        } catch (FileNotFoundException ex) { }

        String line;
//        int TCPCount = 0;
        int TCPbytes = 0;
//        int UDPCount = 0;
        int UDPbytes = 0;
//        int ICMPCount = 0;
        int ICMPbytes = 0;

        try {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                String str[] = line.split("; ");
                if (str.length > 2) {
                    Packet currentPacket = new Packet(
                            str[0], str[1], str[2], Integer.parseInt(str[3].replaceAll("[^0-9]", ""))
                    );
                    packetList.add(currentPacket);
                }
//                if (str.length > 3) {
//                    String strbytes = str[3].replaceAll("[^0-9]", "");
//                    if (str[1].contains("TCP")) {
//                        TCPCount++;
//                        TCPbytes += parseInt(strbytes);
//                    } else if (str[1].contains("UDP")) {
//                        UDPCount++;
//                        UDPbytes += parseInt(strbytes);
//                    } else if (str[1].contains("ICMP")) {
//                        ICMPCount++;
//                        ICMPbytes += parseInt(strbytes);
//                    }
//                }
            }

            for (Packet aPacket : packetList) {
                switch (aPacket.getType()) {
                    case "UDP":
                        UDPbytes += aPacket.getBytes();
                    case "TCP":
                        TCPbytes += aPacket.getBytes();
                    case "ICMP":
                        ICMPbytes += aPacket.getBytes();
                }
            }

        } catch (IOException ex) { }

        System.out.println(packetList);
        System.out.println(UDPbytes);
        System.out.println(TCPbytes);
        System.out.println(ICMPbytes);
//        System.out.println("\r\n" +"Всего TCP пакетов: " + TCPCount);
//        System.out.println("TCP байт: " + TCPbytes + "\r\n");
//        System.out.println("Всего UDP пакетов: " + UDPCount);
//        System.out.println("UDP байт: " + UDPbytes + "\r\n");
//        System.out.println(MessageFormat.format("{0} ICMP пакетов", ICMPCount));
//        System.out.println(MessageFormat.format("{0} ICMP байт", ICMPbytes));
    }
}