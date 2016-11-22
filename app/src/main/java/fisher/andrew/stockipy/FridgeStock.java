package fisher.andrew.stockipy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FridgeStock extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.stockFridgeButton) Button mStockFridgeButton;

    @Bind(R.id.fridgeListView) ListView mFridgeListView;
//    private ArrayList<String> itemsInFridge = new ArrayList<String>(Arrays.asList(
//            "Banana",
//            "Potato",
//            "Chicken",
//            "Spaghetti",
//            "Cereal",
//            "Ketchup"
//    )); <-the array of items
    private ArrayList<String> itemsInFridge = new ArrayList<>();
    private ValueEventListener mFridgeStockReferenceListener;
    private DatabaseReference mFridgeItemReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridge_stock);
        ButterKnife.bind(this);

        mFridgeItemReference = FirebaseDatabase.getInstance().getReference().child((Constants.FIREBASE_CHILD_ADD_FRIDGE_ITEM));

        ArrayAdapter adapter = new ArrayAdapter(FridgeStock.this, android.R.layout.simple_list_item_1, itemsInFridge);
        mFridgeListView.setAdapter(adapter);

        mFridgeStockReferenceListener = mFridgeItemReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot itemSnapshot : dataSnapshot.getChildren()){
                    String item = itemSnapshot.getValue().toString();
                    itemsInFridge.add(item);

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

//        Intent intent = getIntent(); //retriev an intent
//        if(intent.getExtras()!=null){ //if the intent is from the add page fall into this if statement
//            itemsInFridge = intent.getStringArrayListExtra("fridge-update"); <-set arraylist equal to updated arraylist
//
//        }

        mStockFridgeButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
//          pre database code
        Intent intent = new Intent(FridgeStock.this,AddToFridge.class);
//        intent.putExtra("fridge",itemsInFridge); <-this would send the array list to the next page
       startActivity(intent);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        mFridgeItemReference.removeEventListener(mFridgeStockReferenceListener);
    }

}


