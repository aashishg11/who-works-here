package com.aashishgodambe.whosworking.repositories;
import com.aashishgodambe.whosworking.api.ApiService;
import com.aashishgodambe.whosworking.model.EmployeesResponse;
import com.google.gson.JsonObject;

import java.util.Comparator;

import javax.inject.Inject;

import io.reactivex.Observable;

public class ApiRepository {

    private ApiService apiService;

    @Inject
    public ApiRepository(ApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<JsonObject> getEmployeeList(){
        return apiService.getEmployeeList();
    }

}
