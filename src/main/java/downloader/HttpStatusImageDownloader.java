package downloader;
import checker.HttpStatusChecker;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

public class HttpStatusImageDownloader {

    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient();
    private static final Request.Builder REQUEST_BUILDER = new Request.Builder();

    public void downloadStatusImage(int code) throws IOException {
        HttpStatusChecker httpStatusChecker = new HttpStatusChecker();
        String url = httpStatusChecker.getStatusImage(code);
        Request request = REQUEST_BUILDER.get()
                .url(url)
                .build();

        Call call = HTTP_CLIENT.newCall(request);
        try (Response response = call.execute()) {

            if (response.code() != 404) {
                String fileName = code + ".jpg";
                InputStream inputStream = response.body().byteStream();

                File file = new File(fileName);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(inputStream.readAllBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
            }
        }
    }

//    public static void main(String[] args) throws IOException {
//        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
//
//        downloader.downloadStatusImage(200);
//    }
}
