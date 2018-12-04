  import java.awt.Desktop;
  import java.io.IOException;
  import java.net.URI;
  import java.net.URISyntaxException;

  public class TestCheckedExceptions {
	  
      public static void test1(String myURL) {
    	 
    	  try {
    		  URI uri = new URI(myURL);
        	  if (Desktop.isDesktopSupported()) {
        		  try {
        			  Desktop.getDesktop().browse(uri);
        		  } catch(IOException ioe) {
        			  System.out.println(ioe);
        		  }
        	  }
    	  } catch(URISyntaxException e) {
    		  System.out.print("Invalid URI entry");
    	  }
    	  

     
     }
      
      public static void test2(String myURL) throws IOException, URISyntaxException {
            URI uri = new URI(myURL);
            if (Desktop.isDesktopSupported()) {
                  Desktop.getDesktop().browse(uri);
            }
      }
      
      public static void main(String[] args) {
            System.out.println("Please enter an URL (e.g. https://ict.senecacollege.ca/): ");
            java.util.Scanner sc = new java.util.Scanner(System.in);
            String url = sc.nextLine();
            try {
            	test1(url);
            	test2(url);
            } catch (IOException | URISyntaxException e) { System.out.println(e); }
      }
}
