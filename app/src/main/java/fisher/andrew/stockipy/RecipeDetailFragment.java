package fisher.andrew.stockipy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import butterknife.Bind;


public class RecipeDetailFragment extends Fragment {
    @Bind(R.id.fragmentTitle) TextView mFragmentTitle;
    @Bind(R.id.fragmentImage) ImageView mFragmentImage;
    @Bind(R.id.caloriesTextView) TextView mCaloriesTextView;
    @Bind(R.id.servingsTextView) TextView mServingTextView;
    @Bind(R.id.ingredientListView) ListView mIngredientListView;

    private Recipe mRecipe;

//    public static RecipeDetailFragment newInstance(Recipe recipe){
//        RecipeDetailFragment recipeDetailFragment = new RecipeDetailFragment();
//
//    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe_detail, container, false);
    }

}
