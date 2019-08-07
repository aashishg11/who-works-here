package com.aashishgodambe.whosworking.api;

import com.google.gson.JsonObject;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("sq-mobile-interview/employees.json")
    Observable<JsonObject> getEmployeeList();


}
