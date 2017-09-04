package test.lasse.resttest.view.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import test.lasse.resttest.R;
import test.lasse.resttest.view.repoList.RepoListView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_USER = "test.lasse.resttest.view.main.USERNAME";
    public static final String EXTRA_PASS = "test.lasse.resttest.view.main.PASSWORD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button listener
        Button b = (Button) findViewById(R.id.main_btn_execute);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openList();
            }
        });

//        //Password done listener
//        EditText passInput = (EditText) findViewById(R.id.main_et_password);
//        passInput.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_DONE) {
//                    openList();
//                    return true;
//                }
//                return false;
//            }
//        });
    }

    /**
     * Opens list view
     */
    private void openList() {
        Intent intent = new Intent(MainActivity.this, RepoListView.class);
        EditText userET = (EditText) findViewById(R.id.main_et_username);
//        EditText passwordET = (EditText) findViewById(R.id.main_et_password);
        String user = userET.getText().toString();
        String password = "";
        intent.putExtra(EXTRA_USER, user);
        intent.putExtra(EXTRA_PASS, password);
        startActivity(intent);
    }
}
