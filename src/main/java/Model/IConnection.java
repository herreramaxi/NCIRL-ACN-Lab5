/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.nio.ByteBuffer;

/**
 *
 * @author Maximiliano Herrera
 */
public interface IConnection {

    public ByteBuffer ReadMessage();

    public String  getConnectionProtocol();
}
