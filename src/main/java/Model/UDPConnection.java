/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maximiliano Herrera
 */
public class UDPConnection implements IConnection {

    private final String _hostName;
    private final int _port;

    public UDPConnection(String hostName, int port) {
        _hostName = hostName;
        _port = port;
    }

    @Override
    public ByteBuffer ReadMessage() {
        byte[] messageByte = new byte[8];
        try {
            byte[] message = new byte[4];
            InetAddress host = InetAddress.getByName(_hostName);
            DatagramSocket dgramSocket = new DatagramSocket();
            DatagramPacket outPacket = new DatagramPacket(message, message.length, host, _port);

            //send empty datagram
            dgramSocket.send(outPacket);

            DatagramPacket inPacket = new DatagramPacket(message, message.length);

            //receive 32 bits datagram
            dgramSocket.receive(inPacket);
            message = inPacket.getData();

            System.arraycopy(message, 0, messageByte, 4, message.length);
        } catch (SocketException ex) {
            Logger.getLogger(UDPConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(UDPConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UDPConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ByteBuffer.wrap(messageByte);
    }

    @Override
    public String getConnectionProtocol() {
        return "UDP";
    }
}
