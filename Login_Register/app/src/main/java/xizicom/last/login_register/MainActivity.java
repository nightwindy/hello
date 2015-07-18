package xizicom.last.login_register;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    EditText etusername, etpassword;
    Button btnSignIn, btnRegister;
    UserLocalStore sUserLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnRegister.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
        sUserLocalStore = new UserLocalStore(this);
    }

    public void init() {
        etusername = (EditText) findViewById(R.id.etUsername);
        etpassword = (EditText) findViewById(R.id.etPassword);
        btnSignIn = (Button) findViewById(R.id.btnRegister);
        btnRegister = (Button) findViewById(R.id.btnSignIn);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignIn:
                User user = new User(null, null);
                sUserLocalStore.setUserLoggedIn(true);
                break;
            case R.id.btnRegister:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
