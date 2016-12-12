package fisher.andrew.stockipy.ui.shopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;
import fisher.andrew.stockipy.Constants;
import fisher.andrew.stockipy.R;
import fisher.andrew.stockipy.adapters.FirebaseShoppingListViewHolder;
import fisher.andrew.stockipy.models.Food;


public class ShoppingListActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.listHeaderTextView) TextView mListHeaderTextView;
    @Bind(R.id.addFoodItemButton) Button mAddFoodItemButton;
    @Bind(R.id.foodItemRecyclerView) RecyclerView mRecyclerView;

    //database retrieval
    private DatabaseReference mShoppingListRef;
    private FirebaseRecyclerAdapter mFirebaseRecyclerAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_on_list);
        ButterKnife.bind(this);

        //getting current user
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        mShoppingListRef = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_SHOPPING_CART).child(uid);
        setUpFirebaseAdapter();

        //adds specific text to the shared layout
        mListHeaderTextView.setText("Shopping List");
        mAddFoodItemButton.setText("Add Items to List");

        mAddFoodItemButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent(ShoppingListActivity.this,AddToShoppingListActivity.class);
        startActivity(intent);
    }

    private void setUpFirebaseAdapter(){
        mFirebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Food, FirebaseShoppingListViewHolder>(Food.class, R.layout.food_list_item, FirebaseShoppingListViewHolder.class, mShoppingListRef){
            @Override
            public void populateViewHolder(FirebaseShoppingListViewHolder viewHolder, Food item, int position){
                viewHolder.bindShoppingList(item);
            }
        };

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseRecyclerAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseRecyclerAdapter.cleanup();
    }
}
