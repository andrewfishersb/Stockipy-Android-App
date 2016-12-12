package fisher.andrew.stockipy.ui.shopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import fisher.andrew.stockipy.Constants;
import fisher.andrew.stockipy.R;
import fisher.andrew.stockipy.models.Food;


//add to shopping cart, might move to being a search widget
public class AddToShoppingListActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.addItemListButton) Button mAddItemListButton;
    @Bind(R.id.inputNewItem) EditText mInputNewItem;
    private  ArrayList<String> addToList;


    private Food mAddItemToShoppingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_shopping_list);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        addToList = intent.getStringArrayListExtra("list");
        mAddItemListButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==mAddItemListButton){
            String userInput = mInputNewItem.getText().toString();
            mInputNewItem.setText("");
            if(userInput.equals("")){
                Toast toast = Toast.makeText(AddToShoppingListActivity.this,"No Item Entered", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0,250);
                toast.show();
            }else{
                mAddItemToShoppingList = new Food(userInput);

                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String uId = user.getUid();

                DatabaseReference addToListRef = FirebaseDatabase.getInstance().
                        getReference(Constants.FIREBASE_CHILD_SHOPPING_CART).child(uId);

                DatabaseReference pushRef = addToListRef.push();
                String pushId = pushRef.getKey();
                mAddItemToShoppingList.setPushId(pushId);
                pushRef.setValue(mAddItemToShoppingList);

                Toast.makeText(AddToShoppingListActivity.this, "Saved to Shopping Cart", Toast.LENGTH_SHORT).show();

            }

        }

    }
}

