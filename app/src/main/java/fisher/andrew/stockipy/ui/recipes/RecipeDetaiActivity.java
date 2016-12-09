package fisher.andrew.stockipy.ui.recipes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import fisher.andrew.stockipy.Constants;
import fisher.andrew.stockipy.R;
import fisher.andrew.stockipy.ui.MainActivity;

//Shows a single recipe
public class RecipeDetaiActivity extends AppCompatActivity implements View.OnClickListener{

    @Bind(R.id.detailTitle) TextView mDetailTitle;
    @Bind(R.id.linkTextView) TextView mLinkTextView;
    @Bind(R.id.caloriesTextView) TextView mCaloriesTextView;
    @Bind(R.id.servingsTextView) TextView mServingsTextView;
    @Bind(R.id.ingredientListView) ListView mIngredientListView;
    @Bind(R.id.detailImage) ImageView mDetailImage;
    private String url;


//    private ArrayList<String> favoriteRecipe = new ArrayList<String>();
//    private ArrayList<String> favoriteRecipesIngredients = new ArrayList<String>();


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

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ingredients);
        mIngredientListView.setAdapter(adapter);

        Picasso.with(this).load(image).into(mDetailImage);

        mLinkTextView.setOnClickListener(this);
    }

    //create menu at top
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_favorite,menu);
//        ButterKnife.bind(this);
//        MenuItem menuItem = menu.findItem(R.id.action_favorite);
//        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem menuItem) {
//                Toast.makeText(RecipeDetaiActivity.this,"Liked",Toast.LENGTH_SHORT);
//                return true;
//            }
//        });
        return true;
    }

    //add actions that will happen in the bar (i.e. favorite and logout(which i will put in later);
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.action_favorite:
                //does get here

                saveToDatabase();


                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    @Override
    public void onClick(View v){

        if(v == mLinkTextView){
            Intent externalLink = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(externalLink);
        }


    }

    public void saveToDatabase(){
        DatabaseReference favoriteRef = FirebaseDatabase.getInstance().getReference(Constants.)
    }
}
