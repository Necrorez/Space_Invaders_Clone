package SpaceX05;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.Executors;

public class Server
{
    ArrayList<PrintWriter> clientOutStream;

    public class Game implements Runnable{
        BufferedReader reader;
        Socket socket;
        public Game(Socket clientSocket){
            try{
                socket = clientSocket;
                InputStreamReader isReader = new InputStreamReader(socket.getInputStream());
                reader = new BufferedReader(isReader);
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String data;
            try {
                clientOutStream.forEach(client-> System.out.println(client));
                while ((data = reader.readLine()) != null) {
                    sendData(data);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws Exception
    {
        new Server().start();
    }

    public void start(){
        clientOutStream = new ArrayList<PrintWriter>();
        try {
            ServerSocket serverSocket = new ServerSocket(4444);
            while (true){
                Socket clientSocket = serverSocket.accept();
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                clientOutStream.add(writer);
                Thread t = new Thread(new Game(clientSocket));
                t.start();
                System.out.println("Player Connected");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void sendData(String data){
        Iterator<PrintWriter> writerIterator = clientOutStream.iterator();
        while (writerIterator.hasNext()){
            try {
                System.out.println("sending");
                PrintWriter writer = writerIterator.next();
                writer.println(data);
                writer.flush();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}






