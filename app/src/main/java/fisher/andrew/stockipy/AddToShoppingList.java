package fisher.andrew.stockipy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddToShoppingList extends AppCompatActivity implements View.OnClickListener{
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
        String userInput = mInputNewItem.getText().toString();

        if(v==mBackToListButton){
            Intent addedItemIntent = new Intent(AddToShoppingList.this,ShoppingList.class);
            addedItemIntent.putExtra("update-list", addToList);
            startActivity(addedItemIntent);
        }

        if(v==mAddItemListButton){
            if(userInput.equals("")){
                Toast toast = Toast.makeText(AddToShoppingList.this,"No Item Entered", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0,250);
                toast.show();
            }else{
                addToList.add(userInput);
                mInputNewItem.setText("");
            }

        }

    }
}

