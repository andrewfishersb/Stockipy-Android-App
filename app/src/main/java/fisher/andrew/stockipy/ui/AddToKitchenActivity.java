package fisher.andrew.stockipy.ui;

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

import butterknife.Bind;
import butterknife.ButterKnife;
import fisher.andrew.stockipy.Constants;
import fisher.andrew.stockipy.R;

//takes the  user input and adds it to the firebase database element of fridge
public class AddToKitchenActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.addItemToKitchenButton) Button mAddItemToKitchenButton;
//    @Bind(R.id.backToFridgeButton) Button mBackToFridgeButton; ->use manifest
    @Bind(R.id.kitchenInputEditText) EditText mKitchenInputEditText;

    private DatabaseReference mAddToKitchenReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

    mAddToKitchenReference = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_CHILD_KITCHEN);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_kitchen);
        ButterKnife.bind(this);
        mAddItemToKitchenButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
//        if(v==mBackToFridgeButton){ //this is usless right??? just use a manifest
//            Intent intent = new Intent(AddToKitchenActivity.this,KitchenActivity.class);
//            intent.putExtra("fridge-update", updateItems);
//            startActivity(intent);
//        }
        if(v==mAddItemToKitchenButton){
            String userInput = mKitchenInputEditText.getText().toString();
            mKitchenInputEditText.setText("");
            if(userInput.equals("")){
                Toast toast = Toast.makeText(this, "No Item Added", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL,0,250);
                toast.show();
            }else{
                saveItemToKitchenFirebase(userInput);
                Intent intent = new Intent(AddToKitchenActivity.this,KitchenActivity.class);
                intent.putExtra("item",userInput); // remove if no need for object passing
                startActivity(intent);
            }
        }
    }

    public void saveItemToKitchenFirebase(String item){
        mAddToKitchenReference.setValue(item);
    }
}
