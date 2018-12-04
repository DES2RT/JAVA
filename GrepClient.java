
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.util.Vector;
import java.io.*;

public class GrepClient {

  public static void main(String[] args) {
    if (args.length == 0)
      System.exit(1);

    try {
      Grep g = (Grep)
        Naming.lookup("Wonderful");

     Vector v = g.find(args[0], args[1]);
     for (int i = 0; i < v.size(); i++)
        System.out.println("line: " + i + ": " + (String)v.get(i));

    } catch (MalformedURLException murle) {
      System.out.println("MalformedURLException");
      System.out.println(murle);
    } catch (RemoteException re) {
      System.out.println("RemoteException");
      System.out.println(re);
    } catch (NotBoundException nbe) {
      System.out.println("NotBoundException");
      System.out.println(nbe);
    } catch (FileNotFoundException ae) {
      System.out.println("java.io.FileNotFoundException");
      System.out.println("File Not Found " + args[0]);
    }
  }
}
