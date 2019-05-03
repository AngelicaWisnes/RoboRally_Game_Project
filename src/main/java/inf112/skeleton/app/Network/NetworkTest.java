/*
package inf112.skeleton.app.Network;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net.Protocol;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.net.ServerSocket;
import com.badlogic.gdx.net.ServerSocketHints;
import com.badlogic.gdx.net.Socket;
import com.badlogic.gdx.net.SocketHints;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import inf112.skeleton.app.Card.AbstractCard;
import inf112.skeleton.app.Card.RotationCard;
import inf112.skeleton.app.Enums.Rotation;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class NetworkTest implements ApplicationListener {
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Skin skin;
    private Stage stage;
    private Label labelDetails;
    private Label labelMessage;
    private TextButton button;
    private TextArea textIPAddress;
    private TextArea textMessage;

    private final int port = 9029;

    // Pick a resolution that is 16:9 but not unreadibly small
    public final static float VIRTUAL_SCREEN_HEIGHT = 960;
    public final static float VIRTUAL_SCREEN_WIDTH = 540;


    @Override
    public void create() {
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch = new SpriteBatch();

        // Load our UI skin from file.  Once again, I used the files included in the tests.
        // Make sure default.fnt, default.png, uiskin.[atlas/json/png] are all added to your assets
        skin = new Skin(Gdx.files.internal("data/uiskin.json"));
        stage = new Stage();
        // Wire the stage to receive input, as we are using Scene2d in this example
        Gdx.input.setInputProcessor(stage);


        // The following code loops through the available network interfaces
        // Keep in mind, there can be multiple interfaces per device, for example
        // one per NIC, one per active wireless and the loopback
        // In this case we only care about IPv4 address ( x.x.x.x format )
        List<String> addresses = new ArrayList<String>();
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface ni : Collections.list(interfaces)) {
                for (InetAddress address : Collections.list(ni.getInetAddresses())) {
                    if (address instanceof Inet4Address) {
                        addresses.add(address.getHostAddress());
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

        // Print the contents of our array to a string.  Yeah, should have used StringBuilder
        String ipAddress = new String("");
        for (String str : addresses) {
            ipAddress = ipAddress + str + "\n";
        }

        // Now setupt our scene UI

        // Vertical group groups contents vertically.  I suppose that was probably pretty obvious
        VerticalGroup vg = new VerticalGroup().space(3).pad(5).fill();//.space(2).pad(5).fill();//.space(3).reverse().fill();
        // Set the bounds of the group to the entire virtual display
        vg.setBounds(0, 0, VIRTUAL_SCREEN_WIDTH, VIRTUAL_SCREEN_HEIGHT);

        // Create our controls
        labelDetails = new Label(ipAddress, skin);
        labelMessage = new Label("Hello world", skin);
        button = new TextButton("Send message", skin);
        textIPAddress = new TextArea("127.0.0.1", skin);
        textMessage = new TextArea("", skin);

        // Add them to scene
        vg.addActor(labelDetails);
        vg.addActor(labelMessage);
        vg.addActor(textIPAddress);
        vg.addActor(textMessage);
        vg.addActor(button);

        // Add scene to stage
        stage.addActor(vg);

        // Setup a viewport to map screen to a 480x640 virtual resolution
        // As otherwise this is way too tiny on my 1080p android phone.
        stage.getCamera().position.set(VIRTUAL_SCREEN_WIDTH / 2, VIRTUAL_SCREEN_HEIGHT / 2, 0);

        // Now we create a thread that will listen for incoming socket connections
        new Thread(new Runnable() {

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
                        AbstractPacket packet = (AbstractPacket) in.readObject();
                        //AbstractCard c = (AbstractCard) in.readObject();
                        labelMessage.setText(packet.getCardsToClient().get(0).getDescription());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start(); // And, start the thread running

        // Wire up a click listener to our button
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
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        stage.draw();
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}
*/
