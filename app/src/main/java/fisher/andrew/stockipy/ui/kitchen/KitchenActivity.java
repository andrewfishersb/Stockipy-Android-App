package fisher.andrew.stockipy.ui.kitchen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;
import fisher.andrew.stockipy.Constants;
import fisher.andrew.stockipy.R;
import fisher.andrew.stockipy.adapters.FirebaseKitchenViewHolder;
import fisher.andrew.stockipy.models.Food;


//need to refractor before this works
public class KitchenActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.addFoodItemButton) Button mStockKitchenButton;
    @Bind(R.id.foodItemRecyclerView) RecyclerView  mFoodItemRecyclerView;



//    @Bind(R.id.fridgeListView) ListView mFridgeListView;

    private DatabaseReference mKitchenReference;
    private FirebaseRecyclerAdapter mFirebaseRecyclerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //USE ONE LAYOUT AND DETERMINE THE TITLE BASED OFF OF THE ACTIVITY?
        setContentView(R.layout.activity_items_on_list);
        ButterKnife.bind(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        mKitchenReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_KITCHEN).child(uid);
        setUpFirebaseAdapter();


        //WAS PREVIOUS CODE
//        Intent intent = getIntent();
//        if(intent.getExtras()!=null){
//            itemsInFridge = intent.getStringArrayListExtra("fridge-update");

//        }
//        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, itemsInFridge);
//        mFridgeListView.setAdapter(adapter);
        mStockKitchenButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent(KitchenActivity.this,AddToKitchenActivity.class);
//        intent.putExtra("fridge",itemsInFridge);
        startActivity(intent);
    }



    private void setUpFirebaseAdapter(){
        mFirebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Food, FirebaseKitchenViewHolder>(Food.class, R.layout.food_list_item, FirebaseKitchenViewHolder.class,mKitchenReference) {
            @Override
            protected void populateViewHolder(FirebaseKitchenViewHolder viewHolder, Food model, int position) {
                viewHolder.bindKitchen(model);
            }
        };

        mFoodItemRecyclerView.setHasFixedSize(true);
        mFoodItemRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFoodItemRecyclerView.setAdapter(mFirebaseRecyclerAdapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseRecyclerAdapter.cleanup();
    }



}


// there search widget is added to page may need onDataChange to check for changes