package fisher.andrew.stockipy.ui;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.Bind;
import butterknife.ButterKnife;
import fisher.andrew.stockipy.R;

public class KitchenActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.stockFridgeButton) Button mStockFridgeButton;
    @Bind(R.id.fridgeListView) ListView mFridgeListView;
    private ArrayList<String> itemsInFridge = new ArrayList<String>(Arrays.asList(
            "Banana",
            "Potato",
            "Chicken",
            "Spaghetti",
            "Cereal",
            "Ketchup"
    ));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fridge_stock);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        if(intent.getExtras()!=null){
            itemsInFridge = intent.getStringArrayListExtra("fridge-update");

        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, itemsInFridge);
        mFridgeListView.setAdapter(adapter);
        mStockFridgeButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v){
        Intent intent = new Intent(KitchenActivity.this,AddToKitchenActivity.class);
        intent.putExtra("fridge",itemsInFridge);
        startActivity(intent);
    }
}
