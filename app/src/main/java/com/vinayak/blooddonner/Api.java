package com.vinayak.blooddonner;

import com.vinayak.blooddonner.Response.FetchDonner;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    String REGIURL = "https://anhedonic-comfort.000webhostapp.com/InternshipProjectBloodBank/";
    @FormUrlEncoded
    @POST("https://anhedonic-comfort.000webhostapp.com/InternshipProjectBloodBank/simpleregister.php")
    Call<String> getUserRegi(
            @Field("name") String name,
            @Field("email") String email,
            @Field("mobile") String mobile,
            @Field("address") String address,
            @Field("password") String password
    );

    String LOGINURL = "https://anhedonic-comfort.000webhostapp.com/InternshipProjectBloodBank/";
    @FormUrlEncoded
    @POST("https://anhedonic-comfort.000webhostapp.com/InternshipProjectBloodBank/simplelogin.php")
    Call<String> getUserLogin(
            @Field("email") String email,
            @Field("password") String password
    );

    String REQUEST = "https://anhedonic-comfort.000webhostapp.com/InternshipProjectBloodBank/";
    @FormUrlEncoded
    @POST("https://anhedonic-comfort.000webhostapp.com/InternshipProjectBloodBank/requestform.php")
    Call<String> requestForm(
            @Field("unit") String unit,
            @Field("grp") String group,
            @Field("contact") String contact,
            @Field("fname") String fname,
            @Field("lname") String lname,
            @Field("cond") String condition
    );

    @GET("https://anhedonic-comfort.000webhostapp.com/InternshipProjectBloodBank/display.php")
    Call<FetchDonner> fetchAllUsers();
}
