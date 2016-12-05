package fisher.andrew.stockipy.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import fisher.andrew.stockipy.R;

//Displays Recipes you have added to a personal list
public class YourRecipesActivity extends AppCompatActivity {
    @Bind(R.id.favoriteRecipesListView) ListView mFavoriteRecipesListView;
    private ArrayList<String> favoriteRecipes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_recipes);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        favoriteRecipes = intent.getStringArrayListExtra("favorites");
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,favoriteRecipes);
        mFavoriteRecipesListView.setAdapter(adapter);

    }
}
