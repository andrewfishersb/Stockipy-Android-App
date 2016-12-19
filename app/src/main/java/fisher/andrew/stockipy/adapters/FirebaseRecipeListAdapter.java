package fisher.andrew.stockipy.adapters;


import android.content.Context;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;

import fisher.andrew.stockipy.models.Recipe;
import fisher.andrew.stockipy.util.ItemTouchHelperAdapter;
import fisher.andrew.stockipy.util.OnStartDragListener;



//IS THIS EVEN NEEDED???
public class FirebaseRecipeListAdapter extends FirebaseRecyclerAdapter<Recipe, FirebaseRecipeViewHolder> implements ItemTouchHelperAdapter {
    private DatabaseReference mRef;
    private Context mContext;
    private OnStartDragListener mOnStartDragListener;




    public FirebaseRecipeListAdapter(Class<Recipe> modelClass , int modelLayout, Class<FirebaseRecipeViewHolder> viewHolderClass, Query ref, OnStartDragListener onStartDragListener, Context context){
        super(modelClass, modelLayout, viewHolderClass, ref);

        mRef = ref.getRef();
        mOnStartDragListener = onStartDragListener;
        mContext = context;











    }

    @Override
    protected void populateViewHolder(FirebaseRecipeViewHolder viewHolder, Recipe model, int position) {
        viewHolder.bindRecipe(model);
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        return false;
    }

    @Override
    public void onItemDismiss(int position) {

    }

}
