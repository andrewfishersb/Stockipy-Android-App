package fisher.andrew.stockipy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


//Will display a recycler view of recipes received from the api -> maybe send the information from here to a new activity
public class RecipeActivity extends AppCompatActivity implements View.OnClickListener{
    //definitely keep
    @Bind(R.id.favoriteRecipesButton) Button mFavoriteRecipesButton;
    @Bind(R.id.recipesRecyclerView) RecyclerView mRecipesRecyclerView;
    private ArrayList<String> favoriteRecipes = new ArrayList<String>();
    private RecipeListAdapter mAdapter;


//    private ArrayList<String> recipes = new ArrayList<String>(Arrays.asList(
//            "Chili",
//            "Mashed Potatoes",
//            "Marinated Flank Steak",
//            "Asparagus pasta"
//    ));
private ArrayList<Recipe> mRecipes = new ArrayList<>();
    private ArrayList<String> ingredients = new ArrayList<String>(Arrays.asList(
            "Red kidney beans\n\ntomatoes\n\nonion\n\nchili powder\n\ncorn\n\nrice",
            "Potatoes\n\ncream cheese\n\negg\n\nonion\n\nsalt",
            "flank Steak\n\nbalsamic vinegar\n\ngarlic clove\n\nTBS Worcestershire Sauce",
            "asparagus\n\nheavy whipping cream\n\ntuna\n\nspaghetti"
    ));

    private ArrayList<String> favoriteRecipesIngredients = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        //check that the intent has materials
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

        recipeService.findRecipe(query, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mRecipes = recipeService.proccessResults(response);

                RecipeActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter = new RecipeListAdapter(mRecipes, getApplicationContext());
                        mRecipesRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecipeActivity.this);
                        mRecipesRecyclerView.setLayoutManager(layoutManager);
                        mRecipesRecyclerView.setHasFixedSize(true);
                    }
                });

            }
        });


    }

}
