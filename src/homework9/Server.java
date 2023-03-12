package homework9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
    private ServerSocket serverSocket;
    private Socket accept;
    private PrintWriter writer;
    private BufferedReader reader;

    private static int port = 8080;

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.start(port);
            server.checkClientText();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        accept = serverSocket.accept();
        writer = new PrintWriter(accept.getOutputStream(), true);
        reader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
    }

    private void stop() throws IOException {
        reader.close();
        writer.close();
        accept.close();
        serverSocket.close();
    }

    private void checkClientText() throws IOException {
        String clientText = reader.readLine();
        while (!clientText.equalsIgnoreCase("exit")) {
            if (isInvalid(clientText)) {
                writer.println("що таке паляниця?");
                boolean isRight = checkAnswer();
                if (isRight) {
                    Date date = new Date();
                    writer.println(date + " bye");
                } else {
                    disconnectClient();
                    break;
                }
            } else {
                writer.println("hello :)");
            }
            clientText = reader.readLine();
        }
        stop();
    }

    private boolean checkAnswer() throws IOException {
        String answer = reader.readLine();
        return answer.equalsIgnoreCase("хліб");
    }

    private void disconnectClient() throws IOException {
        writer.println("exit");
        stop();
    }

    private static boolean isInvalid(String str) {
        String invalidLetters = "ёъыэ";
        return invalidLetters.chars().anyMatch(c -> str.toLowerCase().indexOf(c) != -1);
    }
}