import checker.HttpStatusChecker;
import client.HttpImageStatusCli;

import java.io.IOException;

public class ServerClient {

    public static void main(String[] args) throws IOException {
        new HttpImageStatusCli().askStatus();
    }
}
