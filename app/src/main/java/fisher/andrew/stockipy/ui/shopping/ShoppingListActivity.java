package fisher.andrew.stockipy.ui.shopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import fisher.andrew.stockipy.R;


public class ShoppingListActivity extends AppCompatActivity implements View.OnClickListener {
//   @Bind(R.id.shoppingListView) ListView mShoppingListView;
//   @Bind(R.id.goToAddItemListButton) Button goToAddItemListButton;

    @Bind(R.id.listHeaderTextView) TextView mListHeaderTextView;
    @Bind(R.id.addFoodItemButton) Button mAddFoodItemButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_items_on_list);
        ButterKnife.bind(this);
        mListHeaderTextView.setText("Shopping List");
        mAddFoodItemButton.setText("Add Items to List");


//        mShoppingListView.setAdapter(adapter);

//     goToAddItemListButton.setOnClickListener(this);

        mAddFoodItemButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent(ShoppingListActivity.this,AddToShoppingListActivity.class);
//        intent.putExtra("list", shoppingList);
        startActivity(intent);
    }
}
