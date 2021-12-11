package SpaceX05;

import SpaceX05.Observer.ClientListener;
import SpaceX05.Observer.ServerCaster;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    // TODO: add more stuff
    public class Game implements Runnable{
        Socket socket1;
        Socket socket2;
        public Game(Socket socket1,Socket socket2){
            this.socket1=socket1;
            this.socket2=socket2;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader1 = new BufferedReader(new InputStreamReader(socket1.getInputStream())); //Set input Stream
                PrintWriter writer1 = new PrintWriter(socket1.getOutputStream());
                BufferedReader reader2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
                PrintWriter writer2 = new PrintWriter(socket2.getOutputStream());
                var clientListener = new ServerCaster();
                clientListener.addObserver(new ClientListener(writer1));
                clientListener.addObserver(new ClientListener(writer2));
                clientListener.notifyPlayers("START");
                boolean stop = false;
                while (!stop){
                    String player1 = reader1.readLine();
                    String player2 = reader2.readLine();
                    String[] p1 = player1.split(" ");
                    String[] p2 = player2.split(" ");
                    if (p1[0].equals("QUIT") || p2[0].equals("QUIT")){  //Check if player exited
                        clientListener.notifyPlayers("QUIT");
                        stop = true;
                        continue;
                    }
                    else if (p1[0].equals("BEGIN")){ //Check if both player are connected
                        clientListener.notifyPlayers("BEGIN");
                        continue;
                    }
                    else if (p1[0].equals("MOVE")){ //check if player wants to move
                        String temp = player1;
                        player1 = player2;
                        player2 = temp;

                    }
                    writer1.println(player1);//Send data to player 1
                    writer2.println(player2);
                    writer1.flush();
                    writer2.flush();
                }

/// update player stuff


            } catch (Exception ex) {
                System.out.println("player did something");
            }
        }
    }
    public static void main(String[] args) throws Exception
    {
        new Server().start();
    }

    public void start(){
        try {
            ServerSocket serverSocket = new ServerSocket(4000);
            while (true){
                Game game = new Game(serverSocket.accept(),serverSocket.accept());
                Thread t = new Thread(game);
                t.start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}






