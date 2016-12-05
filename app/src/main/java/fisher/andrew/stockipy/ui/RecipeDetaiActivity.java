package fisher.andrew.stockipy.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import fisher.andrew.stockipy.R;

//Shows a single recipe
public class RecipeDetaiActivity extends AppCompatActivity implements View.OnClickListener{

    @Bind(R.id.detailTitle) TextView mDetailTitle;
    @Bind(R.id.linkTextView) TextView mLinkTextView;
    @Bind(R.id.caloriesTextView) TextView mCaloriesTextView;
    @Bind(R.id.servingsTextView) TextView mServingsTextView;
    @Bind(R.id.ingredientListView) ListView mIngredientListView;
    @Bind(R.id.detailImage) ImageView mDetailImage;
    private String url; //get rid of when made parcelable since will just need the object up here and can access all else lower.


    private ArrayList<String> favoriteRecipe = new ArrayList<String>();
    private ArrayList<String> favoriteRecipesIngredients = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipe_details);
        ButterKnife.bind(this);
        Intent intent = getIntent();

        String title = intent.getStringExtra("title");
        String image = intent.getStringExtra("image");
        url = intent.getStringExtra("url");
        String yield = intent.getStringExtra("yield");
        String calories = intent.getStringExtra("calories");
        ArrayList<String> ingredients = intent.getStringArrayListExtra("ingredients");

        mDetailTitle.setText(title);
        mCaloriesTextView.setText(calories + " calories per person");
        mServingsTextView.setText("Serves " + yield);

        //list view, eventually a recycler view
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ingredients);
        mIngredientListView.setAdapter(adapter);

        //image
        Picasso.with(this).load(image).into(mDetailImage);

        mLinkTextView.setOnClickListener(this);
    }


    //when there is an associated button this will either add to favs or shopping + favs
    @Override
    public void onClick(View v){

        if(v == mLinkTextView){
            //implicit intent
            Intent externalLink = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(externalLink);

        }

        // WAS HERE WHEN THERE WAS A BUTTON
//        Intent intent = getIntent();
//        favoriteRecipe= intent.getStringArrayListExtra("favorites");
//        favoriteRecipesIngredients= intent.getStringArrayListExtra("favorite-ingredients");
//        favoriteRecipe.add(intent.getStringExtra("recipe"));
//        favoriteRecipesIngredients.add(intent.getStringExtra("ingredients"));
//        Intent favoriteIntent = new Intent(RecipeDetaiActivity.this,RecipeActivity.class);
//        favoriteIntent.putExtra("recipe-update",favoriteRecipe);
//        favoriteIntent.putExtra("ingredients-update",favoriteRecipesIngredients);
//        startActivity(favoriteIntent);

    }


}
