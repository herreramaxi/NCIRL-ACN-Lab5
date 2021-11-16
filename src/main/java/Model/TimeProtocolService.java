/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 *
 * @author Maximiliano Herrera
 */
public class TimeProtocolService {

    private final IConnection _connection;
    private final long SECONDS_1970 = 2208988800l;

    public TimeProtocolService(IConnection connection) {
        _connection = connection;
    }

    public TimeServiceResult GetDateTime() {
        try {
            ByteBuffer byteBuffer = _connection.ReadMessage();

            long secondsSince1900 = byteBuffer.getLong();
            String hexa = getHexaFromBytes(byteBuffer.array(), 4);
            Instant instant = getInstantTimeLine(secondsSince1900);
            String output = getFormatedDateTime(instant);

            return new TimeServiceResult(instant, output, secondsSince1900, byteBuffer.array(), hexa);
        } catch (Exception e) {
            System.out.println(e);
            return new TimeServiceResult(e.getMessage());
        }
    }

    public String getServiceProtocol() {
        return _connection.getConnectionProtocol();
    }

    private Instant getInstantTimeLine(long secondsSince1900) {
        long epoch = secondsSince1900 - SECONDS_1970;

        Instant instant = Instant.ofEpochSecond(epoch);
        ZonedDateTime.ofInstant(instant, ZoneOffset.UTC);

        return instant;
    }

    private String getFormatedDateTime(Instant instant) {
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)
                .withLocale(Locale.UK)
                .withZone(ZoneId.systemDefault());
        String output = formatter.format(instant);

        return output;
    }

    private String getHexaFromBytes(byte[] bytes, int offset) {
        StringBuilder sb = new StringBuilder();

        for (int i = offset; i < bytes.length; i++) {
            sb.append(String.format("%02X ", bytes[i]));
        }

        return sb.toString();
    }
}
