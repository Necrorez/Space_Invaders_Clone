package SpaceX05;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.Vector;


public class Client
{
    private static BufferedReader reader;
    private static PrintWriter writer;
    private static String username;
    private static Socket sock;
    public static void main(String[] args) throws Exception
    {
        networkSetup();
        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();
    }
    private static void networkSetup(){
        try {
            sock = new Socket("localhost", 4444);
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            var scanner = new Scanner(System.in);
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("Networking Established");
            while (scanner.hasNextLine()) {
                writer.println(scanner.nextLine());
            }

        } catch (IOException ex) {System.out.println("No network access");}
    }
    public static class IncomingReader implements Runnable {
        public void run() {
            try {
                while (reader.readLine() != null) {
                    System.out.println(reader.readLine());
                }
            } catch (Exception ex) {ex.printStackTrace();}
        }
    }

}