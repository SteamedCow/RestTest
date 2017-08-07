package test.lasse.resttest.view.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import test.lasse.resttest.R;
import test.lasse.resttest.view.repoList.RepoListView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_USER = "test.lasse.resttest.view.main.REPO_NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = (Button) findViewById(R.id.main_btn_execute);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RepoListView.class);
                EditText editText = (EditText) findViewById(R.id.main_et_input);
                String user = editText.getText().toString();
                intent.putExtra(EXTRA_USER, user);
                startActivity(intent);
            }
        });
    }
}
