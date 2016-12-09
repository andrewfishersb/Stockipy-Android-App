package fisher.andrew.stockipy.ui.recipes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import fisher.andrew.stockipy.Constants;
import fisher.andrew.stockipy.R;
import fisher.andrew.stockipy.adapters.FirebaseRecipeViewHolder;
import fisher.andrew.stockipy.models.Recipe;

//Displays Recipes you have added to a personal list
public class SavedRecipesActivity extends AppCompatActivity {
    private ArrayList<String> favoriteRecipes;//needed?

    @Bind(R.id.favoriteRecipesRecyclerView) RecyclerView mFavoriteRecipesRecyclerView;
    private DatabaseReference mFavoriteRecipesReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_recipes);
        ButterKnife.bind(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        mFavoriteRecipesReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_RECIPES).child(uid);
        setUpFirebaseAdapter();



//old code dont know if needed
//        Intent intent = getIntent();
//        favoriteRecipes = intent.getStringArrayListExtra("favorites");
//        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,favoriteRecipes);
//        mFavoriteRecipesRecyclerView.setAdapter(adapter);

    }

    private void setUpFirebaseAdapter(){
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Recipe, FirebaseRecipeViewHolder>(Recipe.class, R.layout.recipe_list_item, FirebaseRecipeViewHolder.class,mFavoriteRecipesReference){
            @Override
            protected void populateViewHolder(FirebaseRecipeViewHolder viewHolder,Recipe model, int position){
                viewHolder.bindRecipe(model);
            }
        };
        mFavoriteRecipesRecyclerView.setHasFixedSize(true);
        mFavoriteRecipesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFavoriteRecipesRecyclerView.setAdapter(mFirebaseAdapter);

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }

}
