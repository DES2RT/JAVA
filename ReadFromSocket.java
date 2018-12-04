package prac;

import java.io.*;
import java.net.*;

public class ReadFromSocket {

  public static void main(String[] args) {
    try {
      Socket s = new Socket("localhost", 80);
      InputStream is = s.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      BufferedReader br = new BufferedReader(isr);
      String theTime = br.readLine();
      theTime = br.readLine();
      System.out.println(theTime);
    } catch (IOException e) {
      System.out.println("Exception : " + e);
    }
  }
}

