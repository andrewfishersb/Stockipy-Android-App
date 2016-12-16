package fisher.andrew.stockipy.ui.recipes;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import fisher.andrew.stockipy.Constants;
import fisher.andrew.stockipy.R;
import fisher.andrew.stockipy.adapters.RecipeListAdapter;
import fisher.andrew.stockipy.models.Recipe;
import fisher.andrew.stockipy.services.RecipeService;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


//Will display a recycler view of recipes received from the api
public class RecipeListActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
    }
}
