import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
 
    public static void main(String[] args) {
//        if (args.length < 2) return;
//        if (args.length < 1) return;
    	
    	String hostname = "2601:58b:8304:3970:f1b0:109d:9f65:da7c"; // hardcoded host
    	
//        int port = Integer.parseInt(args[1]);
        int port = 6789;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Press Enter or Type Host: ");
        
        String str = scan.nextLine();
        
        if(str.length() > 6) {
        	hostname = str;
        }
        
        System.out.println();
        
        try (Socket socket = new Socket(hostname, port)) {
 
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
 
            String cardz = reader.readLine();
 
            String[] cards = cardz.split(", ");
            
            for(int i=0; i<cards.length; i++) {
            	System.out.println(cards[i]);
            	scan.nextLine();
            }
 
 
        } catch (UnknownHostException ex) {
 
        	System.out.println("\nThere is no game going on! [Server not found: " + ex.getMessage() + "]");
 
        } catch (IOException ex) {
 
            System.out.println("\nThere is no game going on! [I/O error: " + ex.getMessage() + "]");
        }
        
        scan.close();
        
    }
}