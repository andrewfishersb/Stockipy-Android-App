package fisher.andrew.stockipy;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class RecipeDetailFragment extends Fragment {
    @Bind(R.id.fragmentTitle) TextView mFragmentTitle;
    @Bind(R.id.fragmentImage) ImageView mFragmentImage;
    @Bind(R.id.caloriesTextView) TextView mCaloriesTextView;
    @Bind(R.id.servingsTextView) TextView mServingTextView;
    @Bind(R.id.ingredientListView) ListView mIngredientListView;

    private ArrayList<String> ingredientList;
    private Recipe mRecipe;

    public static RecipeDetailFragment newInstance(Recipe recipe){
        RecipeDetailFragment recipeDetailFragment = new RecipeDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("recipe", Parcels.wrap(recipe));
        recipeDetailFragment.setArguments(args);
        return recipeDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        mRecipe = Parcels.unwrap(getArguments().getParcelable("recipe"));
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_recipe_detail, container, false);
        ButterKnife.bind(this, view);


        Picasso.with(view.getContext()).load(mRecipe.getImage()).into(mFragmentImage);
        mFragmentTitle.setText(mRecipe.getLabel());
        mCaloriesTextView.setText(mRecipe.getCalories() +" calories per person");
        mServingTextView.setText(mRecipe.getYield() +" servings");


        return view;
    }

}
