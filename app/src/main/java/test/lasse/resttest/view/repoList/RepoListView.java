package test.lasse.resttest.view.repoList;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import test.lasse.resttest.BuildConfig;
import test.lasse.resttest.R;
import test.lasse.resttest.model.GitHubRepo;
import test.lasse.resttest.service.GitHubClient;
import test.lasse.resttest.view.main.MainActivity;

public class RepoListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_list_view);

        //Get username from intent
        Intent intent = getIntent();
        String user = intent.getStringExtra(MainActivity.EXTRA_USER);

        final ListView repoListV = (ListView) findViewById(R.id.rlv_lv_Repos);

        //Build okHttp client w/ logging interceptor
        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        if(BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();

            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClientBuilder.addInterceptor(loggingInterceptor);
        }

        //Build retrofit
        Retrofit.Builder rfBuilder = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClientBuilder.build());

        Retrofit rf = rfBuilder.build();

        //Create client & call object
        GitHubClient ghClient = rf.create(GitHubClient.class);

//        Call<List<GitHubRepo>> call = ghClient.reposForAuthUser(Credentials.basic("SteamedCow", "****"));
        Call<List<GitHubRepo>> call = ghClient.reposForUser(user);

        //Send call async
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                if(response.code() == 200) {
                    List<GitHubRepo> repos = response.body();

                    if(repos != null)
                        Log.d("RETROFIT", repos.toString());

                    repoListV.setAdapter(new GitHubRepoAdapter(RepoListView.this, repos));
                }
                else
                    Toast.makeText(RepoListView.this, "Server error: " + response.code() + " " + response.message(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                Toast.makeText(RepoListView.this, "Something went wrong: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
