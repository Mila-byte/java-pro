package homework9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    private Socket socket;
    private PrintWriter writer;
    public BufferedReader reader;

    public void startConnection(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
        writer = new PrintWriter(socket.getOutputStream(), true);
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public String writeMessage(String msg) throws IOException {
        writer.println(msg);
        String resp = reader.readLine();
        return resp;
    }

    public void stop() throws IOException {
        reader.close();
        writer.close();
        socket.close();
    }
}