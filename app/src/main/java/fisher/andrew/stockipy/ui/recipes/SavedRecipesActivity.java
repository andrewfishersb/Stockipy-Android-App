package fisher.andrew.stockipy.ui.recipes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;
import fisher.andrew.stockipy.Constants;
import fisher.andrew.stockipy.R;
import fisher.andrew.stockipy.adapters.FirebaseRecipeViewHolder;
import fisher.andrew.stockipy.models.Recipe;

//Displays Recipes you have added to a personal list
public class SavedRecipesActivity extends AppCompatActivity {
//    @Bind(R.id.favoriteRecipesRecyclerView) RecyclerView mFavoriteRecipesRecyclerView;
//    private DatabaseReference mFavoriteRecipesReference;
//    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_recipes);


//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
//        String uid = user.getUid();
//
//        mFavoriteRecipesReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_RECIPES).child(uid);
//        setUpFirebaseAdapter();


    }

//    private void setUpFirebaseAdapter(){
//        mFirebaseAdapter = new FirebaseRecyclerAdapter<Recipe, FirebaseRecipeViewHolder>(Recipe.class, R.layout.recipe_list_item, FirebaseRecipeViewHolder.class,mFavoriteRecipesReference){
//            @Override
//            protected void populateViewHolder(FirebaseRecipeViewHolder viewHolder,Recipe model, int position){
//                viewHolder.bindRecipe(model);
//            }
//        };
//
//
//
//
//        mFavoriteRecipesRecyclerView.setHasFixedSize(true);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
//        mFavoriteRecipesRecyclerView.setLayoutManager(gridLayoutManager);
//        mFavoriteRecipesRecyclerView.setAdapter(mFirebaseAdapter);
//
//    }

//    @Override
//    protected void onDestroy(){
//        super.onDestroy();
//        mFirebaseAdapter.cleanup();
//    }

}
