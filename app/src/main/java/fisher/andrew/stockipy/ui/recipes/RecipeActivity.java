package fisher.andrew.stockipy.ui.recipes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import fisher.andrew.stockipy.Constants;
import fisher.andrew.stockipy.R;
import fisher.andrew.stockipy.adapters.RecipeListAdapter;
import fisher.andrew.stockipy.models.Recipe;
import fisher.andrew.stockipy.services.RecipeService;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


//either a use the pervious search or have a page that when no API say something like search for recipes

//Will display a recycler view of recipes received from the api
public class RecipeActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.favoriteRecipesButton) Button mFavoriteRecipesButton;
    @Bind(R.id.recipesRecyclerView) RecyclerView mRecipesRecyclerView;
    private ArrayList<String> favoriteRecipes = new ArrayList<String>();
    private RecipeListAdapter mAdapter;
    private ArrayList<Recipe> mRecipes = new ArrayList<>();
    private ArrayList<String> favoriteRecipesIngredients = new ArrayList<String>();

    //variables for the sharedpreferance search widget
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;
    private String mRecentSearch;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        ButterKnife.bind(this);


        Intent intent = getIntent();

        //checks that the intent has materials
        if(intent.getExtras()!=null){
            favoriteRecipes = intent.getStringArrayListExtra("recipe-update");
            favoriteRecipesIngredients = intent.getStringArrayListExtra("ingredients-update");
        }

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mRecentSearch = mSharedPreferences.getString(Constants.PREFERENCES_SEARCH_FOOD,null);

        if(mRecentSearch !=null){
            getRecipes(mRecentSearch);
        }

        mFavoriteRecipesButton.setOnClickListener(this);

    }

    //search menu create
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        ButterKnife.bind(this);

        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mEditor = mSharedPreferences.edit();

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query){
                addToSharedPreferences(query);


                getRecipes(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return true;
    }

    //This ensures that all functionality from the parent class will still apply despite us manually overriding portions of the menu's functionality.
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v){
            Intent intent = new Intent(RecipeActivity.this,YourRecipesActivity.class);
            intent.putExtra("favorites",favoriteRecipes);
            intent.putExtra("favorites-ingredients",favoriteRecipesIngredients);
            startActivity(intent);
    }

    public void getRecipes(String query){
        final RecipeService recipeService = new RecipeService();

        //searches for a type of recipe based on a query
        recipeService.findRecipe(query, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //calls on the service to pull information from the JSON set to an arraylist of recipes
                mRecipes = recipeService.proccessResults(response);

                RecipeActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //injects the recipes into an adapter
                        mAdapter = new RecipeListAdapter(mRecipes, getApplicationContext());
                        mRecipesRecyclerView.setAdapter(mAdapter);

                        //determines layout being used
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecipeActivity.this);
                        mRecipesRecyclerView.setLayoutManager(layoutManager);
                        mRecipesRecyclerView.setHasFixedSize(true);
                    }
                });

            }
        });


    }

    //write to shared preferance
    private void addToSharedPreferences(String searchTerm){
        mEditor.putString(Constants.PREFERENCES_SEARCH_FOOD, searchTerm).apply();
    }

}
