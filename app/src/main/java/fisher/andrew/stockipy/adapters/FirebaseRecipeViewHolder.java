package fisher.andrew.stockipy.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import fisher.andrew.stockipy.Constants;
import fisher.andrew.stockipy.R;
import fisher.andrew.stockipy.models.Recipe;
import fisher.andrew.stockipy.ui.recipes.RecipeDetailActivity;

/**
 * Created by andrewfisher on 12/6/16.
 */

public class FirebaseRecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    View mView;
    Context mContext;

    public FirebaseRecipeViewHolder(View itemView){
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
    }

    public void bindRecipe(Recipe recipe){
        ImageView recipeImage = (ImageView) mView.findViewById(R.id.foodImageView);
        TextView recipeTitle = (TextView) mView.findViewById(R.id.foodTitle);

        Picasso.with(mContext).load(recipe.getImage()).into(recipeImage);
        recipeTitle.setText(recipe.getLabel());
    }


    @Override
    public void onClick(View v){
        final ArrayList<Recipe> recipes = new ArrayList<Recipe>();
        DatabaseReference recipeRef = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_RECIPES);
        recipeRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    recipes.add(snapshot.getValue(Recipe.class));
                }

                int itemPosition = getLayoutPosition();

                //where should this be sent
                Intent intent = new Intent(mContext, RecipeDetailActivity.class);
                intent.putExtra("position",itemPosition); //is this needed?
                intent.putExtra("recipes", Parcels.wrap(recipes));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
