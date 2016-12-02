package fisher.andrew.stockipy;

import android.util.Log;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class RecipeService {

    public static void findRecipe(String query, Callback callback){

        OkHttpClient client = new OkHttpClient.Builder().build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.RECIPE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.SEARCHED_TERM,query);
        urlBuilder.addQueryParameter("app_id","7a2d769f");
        urlBuilder.addQueryParameter("app_key","07772915f9b7d9f972db135f45bacb44");
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        call.enqueue(callback);


    }



}
