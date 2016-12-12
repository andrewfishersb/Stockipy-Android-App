package fisher.andrew.stockipy.ui.kitchen;

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

import butterknife.Bind;
import butterknife.ButterKnife;
import fisher.andrew.stockipy.Constants;
import fisher.andrew.stockipy.R;
import fisher.andrew.stockipy.models.Food;

//takes the  user input and adds it to the firebase database element of fridge IF ADD A SEARCH WIDGET MIGHT NEED TO MOVE OVER CODE
public class AddToKitchenActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.addItemToKitchenButton) Button mAddItemToKitchenButton;
//    @Bind(R.id.backToFridgeButton) Button mBackToFridgeButton; ->use manifest
    @Bind(R.id.kitchenInputEditText) EditText mKitchenInputEditText;

    private Food mKitchenItem;

    //is this needed?
    private DatabaseReference mAddToKitchenReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //is this needed?
    mAddToKitchenReference = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_CHILD_KITCHEN);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_kitchen);
        ButterKnife.bind(this);
        mAddItemToKitchenButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v==mAddItemToKitchenButton){
            String userInput = mKitchenInputEditText.getText().toString();
            mKitchenInputEditText.setText("");
            if(userInput.equals("")){
                Toast toast = Toast.makeText(this, "No Item Added", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER_VERTICAL,0,250);
                toast.show();
            }else{
                mKitchenItem = new Food(userInput);


                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                String uid = user.getUid();
                DatabaseReference kitchenItemReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_KITCHEN).child(uid);

                DatabaseReference pushRef = kitchenItemReference.push();
                String pushId = pushRef.getKey();
                mKitchenItem.setPushId(pushId);
                pushRef.setValue(mKitchenItem);

                Toast.makeText(AddToKitchenActivity.this, "Saved to Kitchen", Toast.LENGTH_SHORT).show();

            }
        }
    }

}
