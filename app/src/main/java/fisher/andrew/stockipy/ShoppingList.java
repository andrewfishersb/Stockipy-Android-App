package fisher.andrew.stockipy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ShoppingList extends AppCompatActivity implements View.OnClickListener {
   @Bind(R.id.shoppingListView) ListView mShoppingListView;
   @Bind(R.id.goToAddItemListButton) Button goToAddItemListButton;
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
        Intent intent = getIntent();

        if(intent.getExtras()!=null){
            shoppingList = intent.getStringArrayListExtra("update-list");
        }

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, shoppingList);
        mShoppingListView.setAdapter(adapter);

     goToAddItemListButton.setOnClickListener(this);



    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent(ShoppingList.this,AddToShoppingList.class);
        intent.putExtra("list", shoppingList);
        startActivity(intent);
    }
}
