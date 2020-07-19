package io.dhruvpjoshi.sampravad.server.echo.thread;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

public class EchoServerThread extends Thread {
  private Socket client;

  public EchoServerThread(Socket client) {
    super("SampravadEchoServerThread");
    this.client = client;
  }

  public void run() {
    try(
      BufferedReader in = new BufferedReader(new InputStreamReader(
        client.getInputStream()));
      PrintWriter out = new PrintWriter(client.getOutputStream(), true);
    ) {
      String clientMessage;
      while((clientMessage = in.readLine()) != null) {
        if("quit".equalsIgnoreCase(clientMessage)
          || "q".equalsIgnoreCase(clientMessage)) {
            break;
        }
        System.out.println("Received - " + clientMessage);
        out.println(clientMessage);
      }
      client.close();
    } catch(IOException ioe) {
      System.err.println("Err: An internal server error has occured - "
        + ioe.getMessage());
    }
  }
}
