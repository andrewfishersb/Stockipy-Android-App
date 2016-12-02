package fisher.andrew.stockipy;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>{
    private ArrayList<Recipe> mRecipes = new ArrayList<>();
    private Context context;

    public RecipeListAdapter(ArrayList<Recipe> mRecipes, Context context) {
        this.mRecipes = mRecipes;
        this.context = context;
    }

    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_item, parent, false);
        RecipeViewHolder recipeViewHolder = new RecipeViewHolder(view);
        return recipeViewHolder;
    }

    @Override
    public void onBindViewHolder(RecipeListAdapter.RecipeViewHolder holder, int position){
        holder.bindRecipes(mRecipes.get(position));
    }

    @Override
    public int getItemCount(){
        return mRecipes.size();
    }

    public class RecipeViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.foodImageView) ImageView  mFoodImage;
        @Bind(R.id.foodTitle) TextView mFoodTitle;
        private Context mContext;

        public RecipeViewHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }
        public void bindRecipes(Recipe recipe){
            Picasso.with(mContext).load(recipe.getImage()).into(mFoodImage);
            mFoodTitle.setText(recipe.getLabel());
        }
    }


}
