package com.ejparz.golf;

import android.content.Context;
import android.util.Log;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketFactory;

import org.junit.Test;
import org.junit.runner.RunWith;

import javax.net.ssl.SSLContext;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Test
    public void testWebsocket() throws Exception {
        long startTime = System.nanoTime();
        connectIpLocal();

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;  //divide by 1000000 to get milliseconds.

        Log.i("Test", "Connect took " + duration + "ms");
    }

    //Connect took 277 ms
    public void connect() throws Exception{
        SSLContext context = NaiveSSLContext.getInstance("TLS");

        WebSocketFactory factory = new WebSocketFactory();
        factory.setSSLContext(context);
        factory.setVerifyHostname(false);

        WebSocket ws = factory.createSocket("wss://echo.websocket.org");

        ws.connect();
    }

    //Attempt to connect to echo ip
    public void connectIp() throws Exception{
        SSLContext context = NaiveSSLContext.getInstance("TLS");

        WebSocketFactory factory = new WebSocketFactory();
        factory.setSSLContext(context);
        factory.setVerifyHostname(false);

        WebSocket ws = factory.createSocket("wss://174.129.224.73:443/");

        ws.connect();
    }

    public void connectIpLocal() throws Exception{
        SSLContext context = NaiveSSLContext.getInstance("TLS");

        WebSocketFactory factory = new WebSocketFactory();
        factory.setSSLContext(context);
        factory.setVerifyHostname(false);

       //WebSocket ws = factory.createSocket("wss://192.168.0.15:63850");

        WebSocket ws = factory.createSocket("wss://localhost:64860");

        ws.connect();
    }
}

