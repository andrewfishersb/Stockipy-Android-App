package fisher.andrew.stockipy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

//Shows a single recipe - fragment will be sent here
public class RecipeActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.addToFavoritesButton) Button mAddToFavoritesButton;
    @Bind(R.id.recipeNameTextView) TextView mRecipeNameTextView;
    @Bind(R.id.ingredientsView) TextView mIngredientsView;
    private ArrayList<String> favoriteRecipe = new ArrayList<String>();
    private ArrayList<String> favoriteRecipesIngredients = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String meal = intent.getStringExtra("recipe");
        String ingredients = intent.getStringExtra("ingredients");

        mRecipeNameTextView.setText(meal);
        mIngredientsView.setText(ingredients);
        mAddToFavoritesButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        Intent intent = getIntent();
        favoriteRecipe= intent.getStringArrayListExtra("favorites");
        favoriteRecipesIngredients= intent.getStringArrayListExtra("favorite-ingredients");
        favoriteRecipe.add(intent.getStringExtra("recipe"));
        favoriteRecipesIngredients.add(intent.getStringExtra("ingredients"));
        Intent favoriteIntent = new Intent(RecipeActivity.this,SearchRecipeActivity.class);
        favoriteIntent.putExtra("recipe-update",favoriteRecipe);
        favoriteIntent.putExtra("ingredients-update",favoriteRecipesIngredients);
        startActivity(favoriteIntent);

    }


}
