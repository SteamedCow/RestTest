package test.lasse.resttest.service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import test.lasse.resttest.model.GitHubRepo;

/**
 * Created by Lasse on 06-Aug-17.
 */

public interface GitHubClient {
    @GET("/users/{user}/repos")
    Call<List<GitHubRepo>> reposForUser(@Path("user") String user);

    @GET("/user/repos")
    Call<List<GitHubRepo>> reposForAuthUser(@Header("Authorization") String credentials);
}
