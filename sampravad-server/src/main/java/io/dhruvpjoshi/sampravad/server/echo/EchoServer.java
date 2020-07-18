package io.dhruvpjoshi.sampravad.server.echo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
  public static void main(String[] ar) {
    if(ar.length != 1) {
      System.err.println("usage: java EchoServer <port>");
      System.exit(1);
    }

    int port = Integer.parseInt(ar[0]);

    try(
      ServerSocket server = new ServerSocket(port);
    ) {
      System.out.println("Server listening on port: " + port);
      acceptClientConnection(server);
    } catch(IOException ioe) {
      System.err.println("Err: Failed to start server on " + port + " port - "
        + ioe.getMessage());
    }
  }

  private static void acceptClientConnection(ServerSocket server) {
    try(
      Socket client = server.accept();
      BufferedReader in = new BufferedReader(
        new InputStreamReader(client.getInputStream()));
      PrintWriter out = new PrintWriter(client.getOutputStream(), true);
    ) {
      String clientMessage;
      while((clientMessage = in.readLine()) != null) {
        System.out.println("Echo - " + clientMessage);
      }
    } catch(IOException ioe) {
      System.err.println("Err: An internal server error has occured - "
        + ioe.getMessage());
    }
  }
}
