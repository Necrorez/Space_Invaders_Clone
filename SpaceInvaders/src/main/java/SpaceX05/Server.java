package SpaceX05;

import SpaceX05.Interpreter.AndExpression;
import SpaceX05.Interpreter.Expression;
import SpaceX05.Interpreter.OrExpression;
import SpaceX05.Interpreter.TerminalExpression;
import SpaceX05.Observer.ClientListener;
import SpaceX05.Observer.ServerCaster;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static SpaceX05.Server.Game.kickPlayer;

public class Server
{
    // TODO: add more stuff
    public class Game implements Runnable{
        Socket socket1;
        Socket socket2;
        private String command;
        public Game(Socket socket1,Socket socket2){
            this.socket1=socket1;
            this.socket2=socket2;
            command = "";
        }

        public static Expression kickPlayer(String playerID){
            Expression kick = new TerminalExpression("KICK");
            Expression player = new TerminalExpression(playerID);
            return new AndExpression(kick,player);
        }
        public static Expression pauseAll(){
            Expression kick = new TerminalExpression("PAUSE");
            Expression player = new TerminalExpression("STOP");
            return new OrExpression(kick,player);
        }
        public static Expression unpauseALL(){
            Expression kick = new TerminalExpression("RELEASE");
            Expression player = new TerminalExpression("UNDO");
            return new OrExpression(kick,player);
        }

        @Override
        public void run() {
            try {
                BufferedReader reader1 = new BufferedReader(new InputStreamReader(socket1.getInputStream())); //Set input Stream
                PrintWriter writer1 = new PrintWriter(socket1.getOutputStream());
                BufferedReader reader2 = new BufferedReader(new InputStreamReader(socket2.getInputStream()));
                PrintWriter writer2 = new PrintWriter(socket2.getOutputStream());
                System.out.println(socket1.getPort());
                System.out.println(socket2.getPort());
                //Interpreter Rules
                Expression kickPlayer1 = kickPlayer(Integer.toString(socket1.getPort()));
                Expression kickPlayer2 = kickPlayer(Integer.toString(socket2.getPort()));
                Expression pauseForAll = pauseAll();
                Expression unpauseForAll = unpauseALL();// Command reading logic goes here
                Thread inputThread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Scanner scan = new Scanner(System.in);
                        command = "";
                        while (true) {
                            command = scan.nextLine();
                        }
                    }
                });

                inputThread.start();

                var clientListener = new ServerCaster();
                clientListener.addObserver(new ClientListener(writer1));
                clientListener.addObserver(new ClientListener(writer2));
                Thread.sleep(1000);
                clientListener.notifyPlayers("START");
                boolean stop = false;
                while (!stop){

                    if(kickPlayer1.interpret(command)){
                        socket1.close();
                        clientListener.notifyPlayers("QUIT");
                    }
                    if(kickPlayer2.interpret(command)){
                        socket2.close();
                        clientListener.notifyPlayers("QUIT");
                    }
                    if (pauseForAll.interpret(command)){
                        clientListener.notifyPlayers("PAUSE");
                    }
                    if (unpauseForAll.interpret(command)){
                        clientListener.notifyPlayers("UNPAUSE");
                    }
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







