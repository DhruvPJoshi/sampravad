package io.dhruvpjoshi.soks.server.echo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import io.dhruvpjoshi.soks.server.echo.thread.EchoServerThread;

public class EchoServer {
  public static void main(String[] ar) {
    if(ar.length != 1) {
      System.err.println("usage: java EchoServer <port>");
      System.exit(1);
    }

    int port = Integer.parseInt(ar[0]);
    boolean echoing = true;

    try(
      ServerSocket server = new ServerSocket(port);
    ) {
      System.out.println("Server listening on port: " + port);
      while(echoing) {
        new EchoServerThread(server.accept()).start();
      }
    } catch(IOException ioe) {
      System.err.println("Err: Failed to start server on " + port + " port - "
        + ioe.getMessage());
    }
  }
}
