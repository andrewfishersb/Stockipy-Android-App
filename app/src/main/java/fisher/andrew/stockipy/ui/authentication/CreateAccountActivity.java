package fisher.andrew.stockipy.ui.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import fisher.andrew.stockipy.R;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.enterEmailEditText) EditText mEnterEmailEditText;
    @Bind(R.id.enterNameEditText) EditText mEnterNameEditText;
    @Bind(R.id.enterPasswordEditText) EditText mPasswordEditText;
    @Bind(R.id.confirmPasswordEditText) EditText mConfirmPasswordEditText;
    @Bind(R.id.createAccountButton) Button mCreateAccountButton;
    @Bind(R.id.loginTextView) EditText mLoginTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(View v){
        if(v==mLoginTextView){
            Intent intent = new Intent()
        }
    }
}
