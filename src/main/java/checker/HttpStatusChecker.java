package checker;

import okhttp3.*;

import java.io.IOException;

public class HttpStatusChecker {

    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient();
    private static final Request.Builder REQUEST_BUILDER = new Request.Builder();
    private static final String LINK = "https://http.cat/";

    public String getStatusImage(int code) throws IOException {

        Request request = REQUEST_BUILDER.get()
                .url(LINK + code)
                .build();

        Call call = HTTP_CLIENT.newCall(request);
        try (Response response = call.execute()) {
            System.out.println(response.code());

            if (response.code() != 404) {
                HttpUrl url = response.request().url();
                String result = url + ".jpg";
                System.out.println(result);
                return result;
            }
            throw new RuntimeException("There is not image for HTTP status " + code);
        }
    }
}
