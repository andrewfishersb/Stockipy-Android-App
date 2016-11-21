package fisher.andrew.stockipy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddToFridge extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.addItemToFridgeButton) Button mAddItemToFridgeButton;
    @Bind(R.id.backToFridgeButton) Button mBackToFridgeButton;
    @Bind(R.id.fridgeInputEditText) EditText mFridgeInputEditText;
    private ArrayList<String> updateItems;
    private DatabaseReference mAddFridgeItem;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_fridge);
        ButterKnife.bind(this);
        mAddItemToFridgeButton.setOnClickListener(this);
        mBackToFridgeButton.setOnClickListener(this);
        Intent intent = getIntent();
        updateItems = intent.getStringArrayListExtra("fridge");
        mAddFridgeItem = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_CHILD_ADD_FRIDGE_ITEM);

    }

    @Override
    public void onClick(View v){
        if(v==mBackToFridgeButton){
            Intent intent = new Intent(AddToFridge.this,FridgeStock.class);
            intent.putExtra("fridge-update", updateItems);
            startActivity(intent);
        }
        if(v==mAddItemToFridgeButton){
            String userInput = mFridgeInputEditText.getText().toString();
            if(userInput.equals("")){
                Toast toast = Toast.makeText(this, "No Item Added", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL,0,250);
                toast.show();
            }else{
                saveItemToFridge(userInput);

                updateItems.add(userInput);
                mFridgeInputEditText.setText("");
            }
        }
    }

    public void saveItemToFridge(String item){
        mAddFridgeItem.push().setValue((item));
    }


}
