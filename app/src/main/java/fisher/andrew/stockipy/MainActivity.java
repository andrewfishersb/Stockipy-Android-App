package fisher.andrew.stockipy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.fridgeButton) Button mFridgeButton;
    @Bind(R.id.recipeButton) Button mRecipeButton;
    @Bind(R.id.shoppingListButton) Button mShoppingListButton;
    @Bind(R.id.yourRecipeButton) Button mYourRecipeButton;
    @Bind(R.id.headerTextView) TextView mHeaderTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mFridgeButton.setOnClickListener(View);
        mRecipeButton.setOnClickListener();
        mShoppingListButton.setOnClickListener();
        mYourRecipeButton.setOnClickListener();
    }


}
