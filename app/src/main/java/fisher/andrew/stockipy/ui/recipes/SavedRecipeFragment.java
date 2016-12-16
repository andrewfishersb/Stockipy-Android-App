package fisher.andrew.stockipy.ui.recipes;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import butterknife.Bind;
import butterknife.ButterKnife;
import fisher.andrew.stockipy.Constants;
import fisher.andrew.stockipy.R;
import fisher.andrew.stockipy.adapters.FirebaseRecipeViewHolder;
import fisher.andrew.stockipy.models.Recipe;


public class SavedRecipeFragment extends Fragment {
    @Bind(R.id.favoriteRecipesRecyclerView)
    RecyclerView mFavoriteRecipesRecyclerView;
    private DatabaseReference mFavoriteRecipesReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    public SavedRecipeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_saved_recipe, container, false);
        ButterKnife.bind(this,view);



        mFavoriteRecipesReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_RECIPES).child(uid);
        setUpFirebaseAdapter();
        return view;
    }

    private void setUpFirebaseAdapter(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        Query query = FirebaseDatabase.getInstance()
                .getReference(Constants.FIREBASE_CHILD_RECIPES)
                .child(uid)
                .orderByChild(Constants.FIREBASE_QUERY_INDEX);



        mFirebaseAdapter = new FirebaseRecyclerAdapter<Recipe, FirebaseRecipeViewHolder>(Recipe.class, R.layout.recipe_list_item, FirebaseRecipeViewHolder.class,mFavoriteRecipesReference, query, this,getActivity()){
            @Override
            protected void populateViewHolder(FirebaseRecipeViewHolder viewHolder,Recipe model, int position){
                viewHolder.bindRecipe(model);
            }
        };

        mFavoriteRecipesRecyclerView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        mFavoriteRecipesRecyclerView.setLayoutManager(gridLayoutManager);
        mFavoriteRecipesRecyclerView.setAdapter(mFirebaseAdapter);

    }

}
