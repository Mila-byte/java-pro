import homework9.Client;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static Client client = new Client();
    private static int port = 8080;

    public static void main(String[] args) {
        try {
            client.startConnection("localhost", port);
            communication();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void communication() throws IOException {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");
        String message = scanner.next();
        while (!message.equalsIgnoreCase("exit")) {
            String resp = client.writeMessage(message);
            if (resp.equalsIgnoreCase("exit")) {
                client.stop();
                return;
            }
            System.out.println(resp);
            message = scanner.next();
        }
        client.writeMessage(message);
        client.stop();
    }
}