import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
 

public class DeckServer {
 
	// TODO note to self: only works with Ethernet Adapter 3
	
    public static void main(String[] args) {
        int port = 6789;
        
        String[] arr = {"Inmate", "Inmate", "Inmate", "Inmate", "Inmate", 
        		"Warden", "Warden", "Warden", "Warden", "Warden", 
        		"Con Man", "Con Man", "Con Man", "Con Man", "Con Man", 
        		"Gambler", "Gambler", "Gambler", "Gambler", "Gambler", 
        		"Vigilante", "Vigilante", "Vigilante", "Vigilante", "Vigilante"};
        
        ArrayList<String> deck = new ArrayList<String>(Arrays.asList(arr));
        
        Collections.shuffle(deck);
        
        Scanner scan = new Scanner(System.in);
        
        int players = 3;
        
        if(args.length > 0) {
        	players = Integer.parseInt(args[0]);
        }
        
        else {
        	
        }
        System.out.print("Players: ");
        
        String str = scan.nextLine();
        
        if(str.trim().length() > 0) {
        	players = Integer.parseInt(str);
        }
        
        System.out.println();
        
        ArrayList<ArrayList<String>> draw = new ArrayList<ArrayList<String>>(players);
        
        for(int i=0; i<players; i++) {
        	draw.add(new ArrayList<String>());
        }
        
        int i=0;
        while(!deck.isEmpty()) {
        	draw.get(i).add(deck.remove(0));
        	i++;
        	i%=players;
        }
        
        /*for(int j=0; j<players; j++) {
        	System.out.println(draw.get(j));
        }*/
        
        try (ServerSocket serverSocket = new ServerSocket(port)) {
 
            System.out.println("Server is listening on port " + port);
            
            int player = 0;
            
            while (player < players) {
                Socket socket = serverSocket.accept();
 
                System.out.println("New client connected");
 
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
 
                writer.println(draw.get(player).toString().substring(1, draw.get(player).toString().length()-1));
                player++;
            }
            
            System.out.println("\nCards dealt successfully");
 
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
            ex.printStackTrace();
            
        }
        
        scan.nextLine();
        scan.close();
        
    }
}