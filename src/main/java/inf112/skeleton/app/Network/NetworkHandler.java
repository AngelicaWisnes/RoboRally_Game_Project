package inf112.skeleton.app.Network;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.net.ServerSocket;
import com.badlogic.gdx.net.ServerSocketHints;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Card.RotationCard;
import inf112.skeleton.app.Enums.Rotation;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NetworkHandler {

    private Queue<Packet> queue = new ArrayDeque<>();
    private int port = 9029;
    private String IPAddress = "192.168.43.88";

    public NetworkHandler() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                ServerSocketHints serverSocketHint = new ServerSocketHints();
                serverSocketHint.reuseAddress = true;
                serverSocketHint.acceptTimeout = 0;
                ServerSocket serverSocket = Gdx.net.newServerSocket(Net.Protocol.TCP, port, serverSocketHint);

                while (true) {
                    // Create a socket
                    Socket socket = serverSocket.accept(null);

                    try {
                        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                        Packet packet = (Packet) in.readObject();
                        queue.add(packet);

                        System.out.println(packet.getCardsToClient().size());
                        for (int i = 0; i < packet.getCardsToClient().size(); i++) {
                            System.out.println(packet.getCardsToClient().get(i).getDescription());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


    }

    public void sendToClient(List<AbstractCard> cardsOnHand){
        Packet packet = new Packet(true, cardsOnHand, null);
        SocketHints socketHints = new SocketHints();
        socketHints.connectTimeout = 4000;
        Socket socket = Gdx.net.newClientSocket(Net.Protocol.TCP, IPAddress, port, socketHints);
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(packet);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Packet getNextPacket() {
        return queue.poll();
    }
}




/*        new Thread(new Runnable() {

            @Override
            public void run() {
                ServerSocketHints serverSocketHint = new ServerSocketHints();
                serverSocketHint.reuseAddress = true;
                // 0 means no timeout.  Probably not the greatest idea in production!
                serverSocketHint.acceptTimeout = 0;

                // Create the socket server using TCP protocol and listening on port
                // Only one app can listen to a port at a time, keep in mind many ports are reserved
                // especially in the lower numbers ( like 21, 80, etc )
                ServerSocket serverSocket = Gdx.net.newServerSocket(Protocol.TCP, port, serverSocketHint);

                // Loop forever
                while (true) {
                    // Create a socket
                    Socket socket = serverSocket.accept(null);

                    // Read data from the socket into a BufferedReader
                    BufferedReader buffer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    try {
                        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                        ArrayList<AbstractCard> cards = (ArrayList<AbstractCard>) in.readObject();
                        //AbstractCard c = (AbstractCard) in.readObject();
                        labelMessage.setText(cards.get(0).getClass().getName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start(); // And, start the thread running
*/

/*
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {

                // When the button is clicked, get the message text or create a default string value

                //l.add(new MoveForward(450, 1));
                SocketHints socketHints = new SocketHints();
                // Socket will time our in 4 seconds
                socketHints.connectTimeout = 4000;
                //create the socket and connect to the server entered in the text box ( x.x.x.x format ) on port 9021
                Socket socket = Gdx.net.newClientSocket(Protocol.TCP, textIPAddress.getText(), port, socketHints);
                try {
                    // write our entered message to the
                    RotationCard c = new RotationCard(110, Rotation.TURN_CLOCKWISE);
                    ArrayList<AbstractCard> cards = new ArrayList<>();
                    cards.add(c);
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    out.writeObject(cards);
                    out.flush();
                    //socket.getOutputStream().write(textToSend.getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
 */