package fisher.andrew.stockipy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SearchRecipeActivity extends AppCompatActivity implements View.OnClickListener{
    private ArrayList<String> recipes = new ArrayList<String>(Arrays.asList(
            "Chili",
            "Mashed Potatoes",
            "Marinated Flank Steak",
            "Asparagus pasta"
    ));
    private ArrayList<String> ingredients = new ArrayList<String>(Arrays.asList(
            "Red kidney beans\n\ntomatoes\n\nonion\n\nchili powder\n\ncorn\n\nrice",
            "Potatoes\n\ncream cheese\n\negg\n\nonion\n\nsalt",
            "flank Steak\n\nbalsamic vinegar\n\ngarlic clove\n\nTBS Worcestershire Sauce",
            "asparagus\n\nheavy whipping cream\n\ntuna\n\nspaghetti"
    ));
    private ArrayList<String> favoriteRecipes = new ArrayList<String>();
    private ArrayList<String> favoriteRecipesIngredients = new ArrayList<String>();
    @Bind(R.id.favoriteRecipesButton) Button mFavoriteRecipesButton;
    @Bind(R.id.recipeListView) ListView mRecipeListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_recipe);
        ButterKnife.bind(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,recipes);
        mRecipeListView.setAdapter(adapter);

        Intent intent = getIntent();
        //check that the intent has materials
        if(intent.getExtras()!=null){
            favoriteRecipes = intent.getStringArrayListExtra("recipe-update");
            favoriteRecipesIngredients = intent.getStringArrayListExtra("ingredients-update");
        }

        mRecipeListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>adapterView, View v, int position, long l){
                Intent intent = new Intent(SearchRecipeActivity.this,ViewRecipeActivity.class);
                intent.putExtra("recipe",recipes.get(position));
                intent.putExtra("ingredients",ingredients.get(position));
                intent.putExtra("favorites",favoriteRecipes);
                intent.putExtra("favorite-ingredients",favoriteRecipesIngredients);
                startActivity(intent);
            }
        });
        mFavoriteRecipesButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent(SearchRecipeActivity.this,YourRecipes.class);
        intent.putExtra("favorites",favoriteRecipes);
        intent.putExtra("favorites-ingredients",favoriteRecipesIngredients);
        startActivity(intent);
    }


}
