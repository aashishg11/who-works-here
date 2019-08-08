package com.aashishgodambe.whosworking.test;

import com.aashishgodambe.whosworking.utils.Constants;

import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import okhttp3.mockwebserver.SocketPolicy;

public class MockServerDispatcher {

    /**
     * Return ok response from mock server
     */
    public class RequestDispatcher extends Dispatcher {
        private final String TAG = getClass().getSimpleName();
        @Override
        public MockResponse dispatch(RecordedRequest request) {
            return new MockResponse().setResponseCode(200).setBody(Constants.SUCCESS_200_3_EMPLOYEES);
        }
    }

    public class SuccessWithEmptyImage extends Dispatcher {
        @Override
        public MockResponse dispatch(RecordedRequest request) {
            return new MockResponse().setResponseCode(200).setBody(Constants.SUCCESS_200_2_EMPLOYEES_NO_IMAGE);
        }
    }

    public class SuccessWithEmployeesEmpty extends Dispatcher {
        @Override
        public MockResponse dispatch(RecordedRequest request) {
            return new MockResponse().setResponseCode(200).setBody(Constants.SUCCESS_200_EMPLOYEE_EMPTY);
        }
    }

    public class MalformedJson extends Dispatcher {
        @Override
        public MockResponse dispatch(RecordedRequest request) {
            return new MockResponse().setResponseCode(200).setBody(Constants.MALFORMED_2_EMPLOYEES);
        }
    }

    public class TimeoutDispatcher extends Dispatcher {
        private final String TAG = getClass().getSimpleName();
        @Override
        public MockResponse dispatch(RecordedRequest request) {
            return new MockResponse().setResponseCode(200).setBody(Constants.SUCCESS_200_3_EMPLOYEES)
                    .setSocketPolicy(SocketPolicy.NO_RESPONSE);
        }
    }

    /**
     * Return error response from mock server
     */
    public class ErrorDispatcher extends Dispatcher {
        @Override
        public MockResponse dispatch(RecordedRequest request) {
            return new MockResponse().setResponseCode(400);
        }
    }
}
