package fisher.andrew.stockipy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Guest on 12/2/16.
 */
public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder{
    private ArrayList<Recipe> mRecipes = new ArrayList<>();
    private Context context;

    public RecipeListAdapter(ArrayList<Recipe> mRecipes, Context context) {
        this.mRecipes = mRecipes;
        this.context = context;
    }




}
