package fisher.andrew.stockipy.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import butterknife.Bind;
import butterknife.ButterKnife;
import fisher.andrew.stockipy.R;
import fisher.andrew.stockipy.ui.authentication.LoginActivity;
import fisher.andrew.stockipy.ui.kitchen.KitchenActivity;
import fisher.andrew.stockipy.ui.recipes.RecipeActivity;
import fisher.andrew.stockipy.ui.shopping.ShoppingListActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.fridgeButton) Button mFridgeButton;
    @Bind(R.id.recipeButton) Button mRecipeButton;
    @Bind(R.id.shoppingListButton) Button mShoppingListButton;
    @Bind(R.id.headerTextView) TextView mHeaderTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mFridgeButton.setOnClickListener(this);
        mRecipeButton.setOnClickListener(this);
        mShoppingListButton.setOnClickListener(this);

    }

    //inflates the main menu bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }


    //checks for selected item from the menu (i.e. logout)
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.action_logout){
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v){
        if(v==mFridgeButton){
            Intent intent = new Intent(MainActivity.this,KitchenActivity.class);
            startActivity(intent);
        }
        if(v==mRecipeButton){
            Intent intent = new Intent(MainActivity.this,RecipeActivity.class);
            startActivity(intent);
        }
        if(v==mShoppingListButton){
            Intent intent = new Intent(MainActivity.this,ShoppingListActivity.class);
            startActivity(intent);
        }
    }

    //should this be public to use on other pages???? i should try before submission
    private void logout(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        //new task resets the stack, clear will prevent from accessing this activity
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }


}
