package com.aashishgodambe.whosworking;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.aashishgodambe.whosworking.test.MockServerDispatcher;
import com.aashishgodambe.whosworking.utils.Constants;
import com.aashishgodambe.whosworking.utils.Helper;
import com.aashishgodambe.whosworking.views.EmployeeListActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class EmployeeListActivityTest {

    private EmployeeListActivity activity = null;
    private MockWebServer server;
    private final String TAG = getClass().getSimpleName();

    @Rule
    public ActivityTestRule<EmployeeListActivity> rule = new ActivityTestRule<>(EmployeeListActivity.class
            ,false,false);

    @Before
    public void setUp() throws Exception {
        activity = rule.getActivity();
        startServer("/");

    }

    private void startServer(String path) throws IOException {
        server = new MockWebServer();
        server.start(8080);
        Constants.BASE_URL = server.url(path).toString();
        Log.d(TAG,"Server url : "+ Constants.BASE_URL);
    }

    @Test
    public void display_list_if_api_returns_valid_list() throws InterruptedException{
        server.setDispatcher(new MockServerDispatcher().new RequestDispatcher());
        rule.launchActivity(new Intent());
        Thread.sleep(500);
        RecyclerView recyclerView = rule.getActivity().findViewById(R.id.employee_recycler_view);
        int items = recyclerView.getAdapter().getItemCount();
        assertEquals(3,items);
    }

    @Test
    public void display_place_holder_if_api_returns_valid_list_but_no_small_image() throws InterruptedException{
        Helper.deleteCache(InstrumentationRegistry.getTargetContext());
        server.setDispatcher(new MockServerDispatcher().new SuccessWithEmptyImage());
        rule.launchActivity(new Intent());
        Thread.sleep(500);
        RecyclerView recyclerView = rule.getActivity().findViewById(R.id.employee_recycler_view);
        int items = recyclerView.getAdapter().getItemCount();
        assertEquals(2,items);
    }

    @Test
    public void display_error_if_api_returns_empty_list() throws InterruptedException{
        server.setDispatcher(new MockServerDispatcher().new SuccessWithEmployeesEmpty());
        rule.launchActivity(new Intent());
        Thread.sleep(500);
        onView(withId(R.id.tv_error)).check(matches(withText("No employees available")));
    }

    @Test
    public void display_error_if_api_returns_error() throws InterruptedException{
        server.setDispatcher(new MockServerDispatcher().new ErrorDispatcher());
        rule.launchActivity(new Intent());
        Thread.sleep(500);
        onView(withId(R.id.tv_error)).check(matches(withText("Error fetching employees. Please try again in sometime.")));
    }

    @Test
    public void display_error_if_api_returns_malformed_json() throws InterruptedException{
        server.setDispatcher(new MockServerDispatcher().new MalformedJson());
        rule.launchActivity(new Intent());
        Thread.sleep(2000);
        onView(withId(R.id.tv_error)).check(matches(withText("Error fetching employees. Please try again in sometime.")));
    }

    @After
    public void tearDown() throws Exception {
        activity = null;
        server.shutdown();
    }

}
