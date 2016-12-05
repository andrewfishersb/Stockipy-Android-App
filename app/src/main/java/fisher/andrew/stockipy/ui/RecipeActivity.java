package fisher.andrew.stockipy.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import fisher.andrew.stockipy.R;
import fisher.andrew.stockipy.services.RecipeService;
import fisher.andrew.stockipy.adapters.RecipeListAdapter;
import fisher.andrew.stockipy.models.Recipe;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


//Will display a recycler view of recipes received from the api
public class RecipeActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.favoriteRecipesButton) Button mFavoriteRecipesButton;
    @Bind(R.id.recipesRecyclerView) RecyclerView mRecipesRecyclerView;
    private ArrayList<String> favoriteRecipes = new ArrayList<String>();
    private RecipeListAdapter mAdapter;
    private ArrayList<Recipe> mRecipes = new ArrayList<>();

    private ArrayList<String> favoriteRecipesIngredients = new ArrayList<String>();

    @Override
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

        mFavoriteRecipesButton.setOnClickListener(this);
        getRecipes("Chicken");
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

}
