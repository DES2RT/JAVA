package prac;

import java.net.*;
import java.io.*;

public class ReadSites {
	public static void main(String[] args) {
		for (int i = 0; i < args.length; i++) {
			try {
				URL u = new URL(args[i]);
				InputStream is = u.openStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				String theLine;
				while ((theLine = br.readLine()) != null) {
					System.out.println(theLine);
				}
			} catch (MalformedURLException e) {
				System.err.println(e);
			} catch (IOException e) {
				System.err.println(e);
			}
		}
	}
}
