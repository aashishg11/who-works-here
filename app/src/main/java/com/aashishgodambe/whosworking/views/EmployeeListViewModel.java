package com.aashishgodambe.whosworking.views;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.MalformedJsonException;

import com.aashishgodambe.whosworking.model.ApiResponse;
import com.aashishgodambe.whosworking.model.Employee;
import com.aashishgodambe.whosworking.model.EmployeesResponse;
import com.aashishgodambe.whosworking.repositories.ApiRepository;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.util.ArrayList;
import java.util.Comparator;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;


public class EmployeeListViewModel extends ViewModel {

    private final CompositeDisposable disposables = new CompositeDisposable();
    private final MutableLiveData<ApiResponse> employeeListLiveData = new MutableLiveData<>();
    private ApiRepository repository;
    private final String TAG = getClass().getSimpleName();

    @Inject
    public EmployeeListViewModel(@NonNull ApiRepository repository) {
        this.repository = repository;
    }

    public void getEmployeeList(){
        disposables.add(repository.getEmployeeList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe((d) -> employeeListLiveData.setValue(ApiResponse.loading()))
                .doOnError((e) -> employeeListLiveData.setValue(ApiResponse.error(e.getMessage(),null)))
                .subscribe(
                        response ->{
                            EmployeesResponse employees = new EmployeesResponse();
                            try{
                                ArrayList employeeList = new ArrayList<Employee>();
                                JsonArray list = response.getAsJsonArray("employees");
                                for (int i = 0; i< list.size();i++){
                                    JsonObject employee = list.get(i).getAsJsonObject();
                                    Employee current = new Employee();
                                    current.setFullName(employee.get("full_name").getAsString());
                                    current.setUuid(employee.get("uuid").getAsString());
                                    current.setPhoneNumber(employee.get("phone_number").getAsString());
                                    current.setEmailAddress(employee.get("email_address").getAsString());
                                    current.setBiography(employee.get("biography").getAsString());
                                    current.setPhotoUrlLarge(employee.get("photo_url_large").getAsString());
                                    current.setPhotoUrlSmall(employee.get("photo_url_small").getAsString());
                                    current.setTeam(employee.get("team").getAsString());
                                    current.setEmployeeType(employee.get("employee_type").getAsString());
                                    employeeList.add(current);
                                }
                                employees.setEmployees(employeeList);

                            }catch (JsonParseException e){
                                Log.e(TAG, e.getMessage());
                            }
                            employees.getEmployees().sort(Comparator.comparing(Employee::getFullName));
                            employeeListLiveData.setValue(ApiResponse.success(employees));
                        },
                        error -> employeeListLiveData.setValue(ApiResponse.error(error.getMessage(),null)))
        );
    }

    public MutableLiveData<ApiResponse> getEmployeeListLiveData() {
        return employeeListLiveData;
    }

    @Override
    protected void onCleared() {
        disposables.clear();
    }
}
