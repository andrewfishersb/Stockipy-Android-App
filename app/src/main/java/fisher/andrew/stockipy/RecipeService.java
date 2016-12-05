package fisher.andrew.stockipy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RecipeService {

    public static void findRecipe(String query, Callback callback){

        OkHttpClient client = new OkHttpClient.Builder().build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.RECIPE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.SEARCHED_TERM,query);

        //add in other wah to do api calls
        urlBuilder.addQueryParameter("app_id","7a2d769f");
        urlBuilder.addQueryParameter("app_key","07772915f9b7d9f972db135f45bacb44");
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder().url(url).build();

        Call call = client.newCall(request);
        call.enqueue(callback);


    }

    public ArrayList<Recipe> proccessResults(Response response){
        ArrayList<Recipe> allRecipes = new ArrayList<>();
        try{
            String jsonData = response.body().string();
            if(response.isSuccessful()){
                JSONObject recipeCatalogJSON = new JSONObject(jsonData);
                JSONArray recipesJSON = recipeCatalogJSON.getJSONArray("hits");
                for (int i = 0; i<recipesJSON.length();i++){
                    //gets specific hit
                    JSONObject recipeJSON = recipesJSON.getJSONObject(i);
                    //goes into the recipe portion of hit
                    JSONObject currentRecipe = recipeJSON.getJSONObject("recipe");
                    String title = currentRecipe.getString("label");
                    String image = currentRecipe.getString("image");
                    String url = currentRecipe.getString("url");
                    int calories = currentRecipe.getInt("calories");
                    int servings = currentRecipe.getInt("yield");

                    //array of ingredients may use in a recycler view or dialog box later
                    ArrayList<String> ingredients = new ArrayList<>();
                    JSONArray ingredientList = currentRecipe.getJSONArray("ingredientLines");
                    for(int j = 0; j< ingredientList.length(); j++){
                        ingredients.add(ingredientList.get(j).toString());
                    }

                    Recipe recipe = new Recipe(title,image,url,ingredients,calories,servings);
                    allRecipes.add(recipe);
                }

            }

        }catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
       return allRecipes;
    }



}
