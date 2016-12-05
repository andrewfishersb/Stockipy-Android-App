package fisher.andrew.stockipy.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import fisher.andrew.stockipy.R;

public class AddToShoppingListActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.addItemListButton) Button mAddItemListButton;
    @Bind(R.id.backToListButton) Button mBackToListButton;;
    @Bind(R.id.inputNewItem) EditText mInputNewItem;
    private  ArrayList<String> addToList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_shopping_list);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        addToList = intent.getStringArrayListExtra("list");
        mAddItemListButton.setOnClickListener(this);
        mBackToListButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        if(v==mBackToListButton){
            Intent addedItemIntent = new Intent(AddToShoppingListActivity.this,ShoppingListActivity.class);
            addedItemIntent.putExtra("update-list", addToList);
            startActivity(addedItemIntent);
        }

        if(v==mAddItemListButton){
            String userInput = mInputNewItem.getText().toString();
            if(userInput.equals("")){
                Toast toast = Toast.makeText(AddToShoppingListActivity.this,"No Item Entered", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0,250);
                toast.show();
            }else{
                addToList.add(userInput);
                mInputNewItem.setText("");
            }

        }

    }
}

