package pl.sda.external.client;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.time.LocalDate;

public class NbpApiClient {
    private final OkHttpClient okHttpClient;

    public NbpApiClient(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;
    }

    public NbpTable getTableAForDay(LocalDate date) {
        Request rq = new Request.Builder()
                .url("http://api.nbp.pl/api/exchangerates/tables/A/"
                        + date.toString() + "?format=json")
                .build();
        try {
            Response response = okHttpClient.newCall(rq).execute();
            if (response.isSuccessful()) {
                String json = response.body().string();
                return new Gson().fromJson(json, NbpTable.class);
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
