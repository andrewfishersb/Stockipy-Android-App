package fisher.andrew.stockipy.ui.kitchen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import fisher.andrew.stockipy.R;


//need to refractor before this works
public class KitchenActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.addFoodItemButton) Button mStockKitchenButton;
//    @Bind(R.id.fridgeListView) ListView mFridgeListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //USE ONE LAYOUT AND DETERMINE THE TITLE BASED OFF OF THE ACTIVITY?
        setContentView(R.layout.activity_items_on_list);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        if(intent.getExtras()!=null){
//            itemsInFridge = intent.getStringArrayListExtra("fridge-update");

        }
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
}
