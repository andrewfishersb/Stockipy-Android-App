package fisher.andrew.stockipy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ViewRecipeActivity extends AppCompatActivity {
    @Bind(R.id.addToFavoritesButton) Button mAddToFavoritesButton;
    @Bind(R.id.recipeNameTextView) TextView mRecipeNameTextView;
    @Bind(R.id.ingredientsView) TextView mIngredientsView;
    private ArrayList<String> favoriteRecipe = new ArrayList<String>();
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

    }
}
