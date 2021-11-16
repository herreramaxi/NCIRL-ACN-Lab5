/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.Instant;

/**
 *
 * @author Maximiliano Herrera
 */
public class TimeServiceResult {

    private boolean _successful;
    private String _errorMessage;
    private String _hexa;

    public boolean isSuccessful() {
        return _successful;
    }
    private Instant _instance;

    public TimeServiceResult(String errorMessage) {
        _errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return _errorMessage;
    }

    public TimeServiceResult(Instant instance, String formatedDateTime, long seconds, byte[] data, String hexa) {
        _instance = instance;
        _formatedDateTime = formatedDateTime;
        _seconds = seconds;
        _data = data;
        _successful = true;
        _hexa = hexa;
    }

    public String getHexa() {
        return _hexa;
    }

    public Instant getInstance() {
        return _instance;
    }

    public String getFormatedDateTime() {
        return _formatedDateTime;
    }

    public long getSeconds() {
        return _seconds;
    }

    public byte[] getData() {
        return _data;
    }
    private String _formatedDateTime;
    private long _seconds;
    private byte[] _data;
}
