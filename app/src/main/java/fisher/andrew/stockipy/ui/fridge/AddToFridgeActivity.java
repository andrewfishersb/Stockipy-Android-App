package fisher.andrew.stockipy.ui.fridge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import fisher.andrew.stockipy.R;

public class AddToFridgeActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.addItemToFridgeButton) Button mAddItemToFridgeButton;
    @Bind(R.id.backToFridgeButton) Button mBackToFridgeButton;
    @Bind(R.id.fridgeInputEditText) EditText mFridgeInputEditText;
    private ArrayList<String> updateItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_fridge);
        ButterKnife.bind(this);
        mAddItemToFridgeButton.setOnClickListener(this);
        mBackToFridgeButton.setOnClickListener(this);
        Intent intent = getIntent();
        updateItems = intent.getStringArrayListExtra("fridge");
    }

    @Override
    public void onClick(View v){
        if(v==mBackToFridgeButton){
            Intent intent = new Intent(AddToFridgeActivity.this,FridgeActivity.class);
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
                updateItems.add(userInput);
                mFridgeInputEditText.setText("");
            }
        }
    }
}
