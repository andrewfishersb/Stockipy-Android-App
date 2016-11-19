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

public class FindRecipe extends AppCompatActivity {
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
    @Bind(R.id.favoriteRecipesButton) Button mFavoriteRecipesButton;
    @Bind(R.id.recipeListView) ListView mRecipeListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_recipe);
        ButterKnife.bind(this);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,recipes);
        mRecipeListView.setAdapter(adapter);

        mRecipeListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>adapterView, View v, int position, long l){
                Intent intent = new Intent(FindRecipe.this,ViewRecipeActivity.class);
                intent.putExtra("recipe",recipes.get(position));
                intent.putExtra("ingredients",ingredients.get(position));
                startActivity(intent);
            }
        });

    }


}
