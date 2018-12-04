
import java.util.Vector;
import java.io.*;

public class GrepImpl
             extends java.rmi.server.UnicastRemoteObject
             implements Grep {

  public GrepImpl()
         throws java.rmi.RemoteException {
    super();
  }

  public Vector find(String file, String found)
              throws java.rmi.RemoteException, FileNotFoundException {

     Vector<String> v = new Vector<String>();
     String line = null;
     try {
       BufferedReader in
          = new BufferedReader(new FileReader(file));
       
       while ((line = in.readLine()) != null){
         if (line.indexOf(found) != -1)
           v.add(line);
       }
     } catch (IOException e) { 
        System.out.println("IO Exception file:" + file);
        return null;
     }
     return v;
  }
 
}
