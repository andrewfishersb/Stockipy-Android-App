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
//    private ArrayList<String> ingredients = new ArrayList<String>(Arrays.asList(
//            "Red kidney beans\n\ntomatoes\n\nonion\n\nchili powder\n\ncorn\n\nrice",
//            "Potatoes\n\ncream cheese\n\negg\n\nonion\n\nsalt",
//            "flank Steak\n\nbalsamic vinegar\n\ngarlic clove\n\nTBS Worcestershire Sauce",
//            "asparagus\n\nheavy whipping cream\n\ntuna\n\nspaghetti"
//    ));

    private ArrayList<String> favoriteRecipesIngredients = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        ButterKnife.bind(this);
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,mRecipes);

        Intent intent = getIntent();
        //check that the intent has materials
        if(intent.getExtras()!=null){
            favoriteRecipes = intent.getStringArrayListExtra("recipe-update");
            favoriteRecipesIngredients = intent.getStringArrayListExtra("ingredients-update");
        }





//        mRecipeListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//            @Override
//            public void onItemClick(AdapterView<?>adapterView, View v, int position, long l){
//                Intent intent = new Intent(RecipeActivity.this,RecipeDetaiActivity.class);
//               // intent.putExtra("recipe",mRecipes.get(position)); <-this would send recipe array over but of strings
//                intent.putExtra("ingredients",ingredients.get(position));
//                intent.putExtra("favorites",favoriteRecipes);
//                intent.putExtra("favorite-ingredients",favoriteRecipesIngredients);
//                startActivity(intent);
//            }
//        });
        mFavoriteRecipesButton.setOnClickListener(this);
        getRecipes("Chicken");
        mRecipesRecyclerView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v == mFavoriteRecipesButton){
            Intent intent = new Intent(RecipeActivity.this,YourRecipesActivity.class);
            intent.putExtra("favorites",favoriteRecipes);
            intent.putExtra("favorites-ingredients",favoriteRecipesIngredients);
            startActivity(intent);
        }else if(v == mRecipesRecyclerView){
            //make parcelable later
            Intent intent = new Intent(RecipeActivity.this, RecipeDetaiActivity.class);
            int position = mAdapter.getPosition();
//            Recipe sendRecipe = mRecipes.get(position);
//            intent.putExtra("title",sendRecipe.getLabel());
//            intent.putExtra("image", sendRecipe.getImage());
//            intent.putExtra("ingredients",sendRecipe.getIngredientLines());
//            intent.putExtra("url", sendRecipe.getUrl());
//            intent.putExtra("yield", sendRecipe.getYield());
            startActivity(intent);
        }

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
