package fisher.andrew.stockipy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ShoppingList extends AppCompatActivity {
    @Bind(R.id.shoppingListView) ListView mShoppingListView;
    private ArrayList<String> shoppingList = new ArrayList<String>(Arrays.asList(
            "Bell Peppers",
            "Pork",
            "Bread Crumbs",
            "Onion",
            "Sour Cream",
            "Potatoes"
    ));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, shoppingList);
        mShoppingListView.setAdapter(adapter);


    }
}
