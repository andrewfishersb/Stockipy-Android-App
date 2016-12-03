package fisher.andrew.stockipy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

//Shows a single recipe - fragment will be sent here
public class RecipeDetaiActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.addToFavoritesButton) Button mAddToFavoritesButton;
//    @Bind(R.id.recipeNameTextView) TextView mRecipeNameTextView;
//    @Bind(R.id.ingredientsView) TextView mIngredientsView;
    private ArrayList<String> mRecipes = new ArrayList<String>();
    private ArrayList<String> favoriteRecipesIngredients = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String meal = intent.getStringExtra("recipe");
        String ingredients = intent.getStringExtra("ingredients");

//        mRecipeNameTextView.setText(meal);
//        mIngredientsView.setText(ingredients);
        mAddToFavoritesButton.setOnClickListener(this);

        mRecipes = Parcels.unwrap(getIntent().getParcelableExtra("recipes"));
        int position = getIntent().getIntExtra("position",0);

    }

    @Override
    public void onClick(View v){
        Intent intent = getIntent();
        mRecipes= intent.getStringArrayListExtra("favorites");
        favoriteRecipesIngredients= intent.getStringArrayListExtra("favorite-ingredients");
        mRecipes.add(intent.getStringExtra("recipe"));
        favoriteRecipesIngredients.add(intent.getStringExtra("ingredients"));
        Intent favoriteIntent = new Intent(RecipeDetaiActivity.this,RecipeActivity.class);
        favoriteIntent.putExtra("recipe-update",mRecipes);
        favoriteIntent.putExtra("ingredients-update",favoriteRecipesIngredients);
        startActivity(favoriteIntent);

    }


}
