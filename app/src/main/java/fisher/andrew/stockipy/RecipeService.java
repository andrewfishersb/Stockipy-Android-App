package fisher.andrew.stockipy;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class RecipeService {

    public static void findRecipe(String query, Callback callback){
        OkHttpClient client = new OkHttpClient.Builder().build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.RECIPE_URL).newBuilder();
        urlBuilder.addQueryParameter("q",query);
        urlBuilder.addQueryParameter("app_id",Constants.RECIPE_API_ID);
        urlBuilder.addQueryParameter("app_key",Constants.RECIPE_API_KEY);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        call.enqueue(callback);


    }



}
