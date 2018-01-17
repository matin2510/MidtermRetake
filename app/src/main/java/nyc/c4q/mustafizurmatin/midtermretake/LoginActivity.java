package nyc.c4q.mustafizurmatin.midtermretake;

import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private CheckBox checkBox;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username_edittext);
        password = (EditText) findViewById(R.id.password_edittext);
        checkBox = (CheckBox) findViewById(R.id.checkbox);
        Button button = (Button) findViewById(R.id.submit_button);

        sharedPreferences = getApplicationContext().getSharedPreferences("mySharedPrefs", MODE_PRIVATE);

        if (sharedPreferences.getBoolean("isChecked", false)) {
            username.setText(sharedPreferences.getString("user", null));
            password.setText(sharedPreferences.getString("password", null));
            checkBox.setChecked(true);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox.isChecked()) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isChecked", checkBox.isChecked());
                    editor.putString("username", username.getText().toString());
                    editor.putString("password", password.getText().toString());
                    editor.commit();
                }
                if (username.getText().toString().equalsIgnoreCase("user@aol.com") && password.getText().toString().equals("password1234")) {
                    Intent intent = new Intent(LoginActivity.this, ListActivity.class);
                    intent.putExtra("username", username.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}
