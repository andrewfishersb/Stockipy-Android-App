package fisher.andrew.stockipy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddToShoppingList extends AppCompatActivity {
    @Bind(R.id.goToAddItemListButton)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_shopping_list);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        ArrayList<String> addToList = intent.getStringArrayListExtra("list");

    }
}
