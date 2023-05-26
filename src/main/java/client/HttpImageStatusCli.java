package client;

import downloader.HttpStatusImageDownloader;

import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code");
        Integer code = null;
        try {
            code = scanner.nextInt();
        } catch (Exception e) {
            System.err.println("Please enter valid number");
        }

        try {
            if (code != null) {
                new HttpStatusImageDownloader().downloadStatusImage(code);
            }
        } catch (Exception e) {
            System.err.println("There is not image for HTTP status " + code);
        }
    }

//    public static void main(String[] args){
//        new HttpImageStatusCli().askStatus();
//    }
}
