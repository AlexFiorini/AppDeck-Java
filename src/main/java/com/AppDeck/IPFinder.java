package com.AppDeck;

import java.net.*;
import java.util.Enumeration;

public class IPFinder {
    public static String FindIP() throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface iface = interfaces.nextElement();
            if (iface.isUp() && !iface.isLoopback()) {
                Enumeration<InetAddress> addresses = iface.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    InetAddress addr = addresses.nextElement();
                    if (addr instanceof Inet4Address) {
                        if(!iface.getDisplayName().contains("virtual")) {
                            return addr.getHostAddress();
                            //Allow wlan, eth, Wireless
                        }
                    }
                }
            }
        }
        return "";
    }
}
