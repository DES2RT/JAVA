package prac;


import java.net.*;
import java.io.*;

public class URLReader {
  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      System.out.println("usage: java URLReader urlstring");
      return;
    }

    URL url = new URL(args[0]);
    BufferedReader in = new BufferedReader(new InputStreamReader(
        url.openStream()));

    String inputLine;
    while ((inputLine = in.readLine()) != null)
      System.out.println(inputLine);

    in.close();
  }
}

