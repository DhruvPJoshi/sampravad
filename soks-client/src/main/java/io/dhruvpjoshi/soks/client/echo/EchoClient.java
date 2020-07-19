package io.dhruvpjoshi.soks.client.echo;

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
      String serverMessage, clientMessage;

      System.out.print("Message: ");
      clientMessage = msgScan.nextLine();
      out.println(clientMessage);

      while((serverMessage = in.readLine()) != null) {
        System.out.println("Echo - " + serverMessage);
        System.out.print("Message: ");
        clientMessage = msgScan.nextLine();
        if("quit".equalsIgnoreCase(clientMessage)
          || "q".equalsIgnoreCase(clientMessage)) {
          break;
        }
        out.println(clientMessage);
      }
    } catch(IOException ioe) {
      System.err.println("Err: Failed to establish connection to server - "
        + ioe.getMessage());
    }
  }
}
