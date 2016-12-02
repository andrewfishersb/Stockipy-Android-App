package fisher.andrew.stockipy.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import fisher.andrew.stockipy.R;
import fisher.andrew.stockipy.ui.fridge.FridgeActivity;
import fisher.andrew.stockipy.ui.recipes.SearchRecipeActivity;
import fisher.andrew.stockipy.ui.shopping.ShoppingListActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.fridgeButton) Button mFridgeButton;
    @Bind(R.id.recipeButton) Button mRecipeButton;
    @Bind(R.id.shoppingListButton) Button mShoppingListButton;
    @Bind(R.id.headerTextView) TextView mHeaderTextView; // Use to add a font later on

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mFridgeButton.setOnClickListener(this);
        mRecipeButton.setOnClickListener(this);
        mShoppingListButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        if(v==mFridgeButton){
            Intent intent = new Intent(MainActivity.this,FridgeActivity.class);
            startActivity(intent);
        }
        if(v==mRecipeButton){
            Intent intent = new Intent(MainActivity.this,SearchRecipeActivity.class);
            startActivity(intent);
        }
        if(v==mShoppingListButton){
            Intent intent = new Intent(MainActivity.this,ShoppingListActivity.class);
            startActivity(intent);
        }
    }
}