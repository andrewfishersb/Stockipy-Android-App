package fisher.andrew.stockipy.ui.kitchen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import butterknife.Bind;
import butterknife.ButterKnife;
import fisher.andrew.stockipy.Constants;
import fisher.andrew.stockipy.R;
import fisher.andrew.stockipy.adapters.FirebaseKitchenAdapter;
import fisher.andrew.stockipy.adapters.FirebaseKitchenViewHolder;
import fisher.andrew.stockipy.models.Food;
import fisher.andrew.stockipy.util.OnStartDragListener;
import fisher.andrew.stockipy.util.SimpleItemTouchHelperCallback;


public class KitchenActivity extends AppCompatActivity implements View.OnClickListener, OnStartDragListener {
    @Bind(R.id.addFoodItemButton) Button mStockKitchenButton;
    @Bind(R.id.foodItemRecyclerView) RecyclerView  mFoodItemRecyclerView;

    private DatabaseReference mKitchenReference;
    private FirebaseKitchenAdapter mFirebaseAdapter;
    private ItemTouchHelper mItemTouchHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_on_list);
        ButterKnife.bind(this);

        setUpFirebaseAdapter();

        mStockKitchenButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent(KitchenActivity.this,AddToKitchenActivity.class);
        startActivity(intent);
    }



    private void setUpFirebaseAdapter(){

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();

        Query query = FirebaseDatabase.getInstance()
                .getReference(Constants.FIREBASE_CHILD_KITCHEN)
                .child(uid)
                .orderByChild(Constants.FIREBASE_QUERY_INDEX);

        mFirebaseAdapter = new FirebaseKitchenAdapter(Food.class, R.layout.food_list_item, FirebaseKitchenViewHolder.class,query,this,this);

        mFoodItemRecyclerView.setHasFixedSize(true);
        mFoodItemRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mFoodItemRecyclerView.setAdapter(mFirebaseAdapter);

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mFirebaseAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(mFoodItemRecyclerView);
    }


    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        mItemTouchHelper.startDrag(viewHolder);
    }
}


