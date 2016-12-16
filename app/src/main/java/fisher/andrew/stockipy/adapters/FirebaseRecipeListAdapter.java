package fisher.andrew.stockipy.adapters;


import android.content.Context;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import fisher.andrew.stockipy.models.Recipe;

public class FirebaseRecipeListAdapter extends FirebaseRecyclerAdapter<Recipe, FirebaseRecipeViewHolder> implements ItemTouchHelperAdapter{
    private DatabaseReference mRef;
    private Context mContext;



    public FirebaseRecipeListAdapter(Class<Recipe> modelClass , int modelLayout, Class<FirebaseRecipeViewHolder> viewHolderClass, Query ref, OnStartDragListener onStartDragListener, Context context);
    
    @Override
    protected void populateViewHolder(FirebaseRecipeViewHolder viewHolder, Recipe model, int position) {
        
    }
}
