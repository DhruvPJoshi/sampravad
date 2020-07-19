package io.dhruvpjoshi.sampravad.client.echo;

import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EchoClient {
  public static void main(String[] ar) {
    if(ar.length != 2) {
      System.err.println("usage: java EchoClient <hostname> <port>");
      System.exit(1);
    }

    String hostname = ar[0];
    int port = Integer.parseInt(ar[1]);

    try(
      Socket client = new Socket(hostname, port);
      BufferedReader in = new BufferedReader(new InputStreamReader(
        client.getInputStream()));
      PrintWriter out = new PrintWriter(client.getOutputStream(), true);
      Scanner msgScan = new Scanner(System.in);
    ) {
      System.out.println("Client connected with " + hostname + " on "
        + port + " port");
      String message;
      while(true) {
        System.out.print("Message: ");
        message = msgScan.nextLine();
        if("quit".equalsIgnoreCase(message) || "q".equalsIgnoreCase(message)) {
          break;
        }
        out.println(message);
      }
    } catch(IOException ioe) {
      System.err.println("Err: Failed to establish connection to server - "
        + ioe.getMessage());
    }
  }
}
