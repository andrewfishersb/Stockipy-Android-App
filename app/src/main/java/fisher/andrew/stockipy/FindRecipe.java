package fisher.andrew.stockipy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    @Bind(R.id.favoriteRecipesButton) Button mFavoriteRecipesButton;
    @Bind(R.id.recipeListView) ListView mRecipeListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_recipe);
        ButterKnife.bind(this);

        mRecipeListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>adapterView, View v, int position, long l){
                Intent intent = new Intent(FindRecipe.this,ViewRecipeActivity.class);
                intent.putExtra("recipe",recipes.get(position));
                intent.putExtra("index",position);
                startActivity(intent);
            }
        });

    }


}
