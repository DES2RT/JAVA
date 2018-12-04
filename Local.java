package prac;

import java.net.*;

public class Local {

  public static void main(String[] args) {

    try {
      InetAddress me = InetAddress.getLocalHost();
      System.out.println("My name is " + me.getHostName());
      System.out.println("My host address is " + me.getHostAddress());
      System.out.println("My address is " + me.getAddress());
      System.out.println(me.isMulticastAddress());
    } catch (UnknownHostException e) {
      System.err.println("Could not determine local address.");
    }
  }

}

