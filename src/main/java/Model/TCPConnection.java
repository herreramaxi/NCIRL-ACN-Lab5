/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maximiliano Herrera
 */
public class TCPConnection implements IConnection {

    private final String _hostName;
    private final int _port;

    public TCPConnection(String hostName, int port) {
        _hostName = hostName;
        _port = port;
    }

    @Override
    public ByteBuffer ReadMessage() {
        byte[] messageByte = new byte[8];

        try {
            try (Socket socket = new Socket(_hostName, _port)) {
                InputStream inputStream = socket.getInputStream();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                DataInputStream in = new DataInputStream(bufferedInputStream);

                in.read(messageByte, 4, 4);
            }
        } catch (IOException ex) {
            Logger.getLogger(TCPConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ByteBuffer.wrap(messageByte);
    }

    @Override
    public String getConnectionProtocol() {
        return "TCP";
    }
}
