package com.aashishgodambe.whosworking;

import android.arch.core.executor.testing.InstantTaskExecutorRule;

import com.aashishgodambe.whosworking.model.Employee;
import com.aashishgodambe.whosworking.model.EmployeesResponse;
import com.aashishgodambe.whosworking.repositories.ApiRepository;
import com.aashishgodambe.whosworking.utils.Constants;
import com.aashishgodambe.whosworking.utils.RxSchedulersOverrideRule;
import com.aashishgodambe.whosworking.views.EmployeeListViewModel;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import io.reactivex.Observable;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(MockitoJUnitRunner.class)
public class EmployeeListViewmodelTest {

    private EmployeeListViewModel viewModel;
    private ApiRepository repository;

    @Rule
    public RxSchedulersOverrideRule rxSchedulersOverrideRule = new RxSchedulersOverrideRule();

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        repository = Mockito.mock(ApiRepository.class);
        viewModel = new EmployeeListViewModel(repository);
    }

    @Test
    public void set_employee_list_in_livedata_when_api_returns_list() {

        EmployeesResponse response = getEmployees();

        Mockito.when(repository.getEmployeeList())
                .thenReturn(Observable.just(getMockedEmployees()));

        viewModel.getEmployeeList();

        EmployeesResponse expected = (EmployeesResponse)viewModel.getEmployeeListLiveData().getValue().data;

        assertEquals(response.getEmployees().size(),expected.getEmployees().size());
    }

    @Test
    public void set_error_in_livedata_when_api_returns_error() {

        String error = "ERROR";
        Mockito.when(repository.getEmployeeList())
                .thenReturn(Observable.error(new Throwable(error)));

        viewModel.getEmployeeList();

        String actual = viewModel.getEmployeeListLiveData().getValue().error;

        assertEquals(error,actual);
    }

    @Test
    public void check_employee_list_is_sorted_alphabetically_by_name() {

        //EmployeesResponse response = getMockedEmployees();

        Mockito.when(repository.getEmployeeList())
                .thenReturn(Observable.just(getMockedEmployees()));

        viewModel.getEmployeeList();

        EmployeesResponse actual = (EmployeesResponse)viewModel.getEmployeeListLiveData().getValue().data;

        assertEquals("Camille Rogers",actual.getEmployees().get(0).getFullName());
        assertEquals("Justine Mason",actual.getEmployees().get(1).getFullName());
        assertEquals("Richard Stein",actual.getEmployees().get(2).getFullName());
    }

    private EmployeesResponse getEmployees(){
        List<Employee> list = new ArrayList<>();

        Employee employee1 = new Employee();
        employee1.setFullName("Camille Rogers");
        list.add(employee1);

        Employee employee2 = new Employee();
        employee2.setFullName("Justine Mason");
        list.add(employee2);

        Employee employee3 = new Employee();
        employee3.setFullName("Richard Stein");
        list.add(employee3);

        EmployeesResponse response = new EmployeesResponse();
        response.setEmployees(list);

        return response;
    }

    private JsonObject getMockedEmployees(){
        JsonObject jsonObject = new JsonParser().parse(Constants.SUCCESS_200_3_EMPLOYEES).getAsJsonObject();
        return jsonObject;
    }

}