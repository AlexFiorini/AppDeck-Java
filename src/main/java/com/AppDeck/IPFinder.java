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
                        if (iface.getDisplayName().contains("wlan") || iface.getDisplayName().contains("eth")) {
                            if(!iface.getDisplayName().contains("virtual")) {
                                return addr.getHostAddress();
                            }
                        } else if(iface.getDisplayName().contains("Wireless")) {
                            if(!iface.getDisplayName().contains("virtual")) {
                                return addr.getHostAddress();
                            }
                        }
                    }
                }
            }
        }
        return "";
    }
}
