package fisher.andrew.stockipy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddToFridge extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.addItemToFridgeButton) Button mAddItemToFridgeButton;
    @Bind(R.id.backToFridgeButton) Button mBackToFridgeButton;
    @Bind(R.id.fridgeInputEditText) EditText mFridgeInputEditText;
//    private ArrayList<String> updateItems; <- array list of updated items
    private DatabaseReference mAddFridgeItemReference;
    private ValueEventListener mAddFridgeItemReferenceListener; //<- listener for reading list



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_fridge);
        ButterKnife.bind(this);
        mAddItemToFridgeButton.setOnClickListener(this);
        mBackToFridgeButton.setOnClickListener(this);
//        Intent intent = getIntent();
//        updateItems = intent.getStringArrayListExtra("fridge"); <-set equal to passed in array list
        mAddFridgeItemReference = FirebaseDatabase.getInstance().getReference().child(Constants.FIREBASE_CHILD_ADD_FRIDGE_ITEM);




        mAddFridgeItemReferenceListener = mAddFridgeItemReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot itemSnapshot : dataSnapshot.getChildren()){
                    String item = itemSnapshot.getValue().toString();
                    Log.d("Item updated","item: " +item);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        }); //<-used to read list



    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mAddFridgeItemReference.removeEventListener(mAddFridgeItemReferenceListener);
    }


    @Override
    public void onClick(View v){
        if(v==mBackToFridgeButton){
            Intent intent = new Intent(AddToFridge.this,FridgeStock.class);
//            intent.putExtra("fridge-update", updateItems); <- send the updated arraylist back
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

//                updateItems.add(userInput);<- adds new item to array
                mFridgeInputEditText.setText("");
            }
        }
    }

    public void saveItemToFridge(String item){
        mAddFridgeItemReference.push().setValue((item));
    }


}
