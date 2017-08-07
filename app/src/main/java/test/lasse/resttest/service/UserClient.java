package test.lasse.resttest.service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import test.lasse.resttest.model.User;

/**
 * Created by Lasse on 07-Aug-17.
 */

public interface UserClient {
    @POST("user")
    Call<User> createAccount(@Body User user);
}
