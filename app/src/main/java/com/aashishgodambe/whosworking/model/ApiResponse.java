package com.aashishgodambe.whosworking.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static com.aashishgodambe.whosworking.model.ApiStatus.ERROR;
import static com.aashishgodambe.whosworking.model.ApiStatus.LOADING;
import static com.aashishgodambe.whosworking.model.ApiStatus.SUCCESS;

public class ApiResponse<T> {

    @NonNull
    public final ApiStatus status;

    @Nullable
    public final T data;

    @Nullable
    public final String error;

    private ApiResponse(@NonNull ApiStatus status, @Nullable T data, @Nullable String error) {
        this.status = status;
        this.data = data;
        this.error = error;
    }

    public static <T> ApiResponse<T> success(@NonNull T data) {
        return new ApiResponse<>(SUCCESS, data, null);
    }

    public static <T> ApiResponse<T> error(String msg, @Nullable T data) {
        return new ApiResponse<>(ERROR, data, msg);
    }

    public static <T> ApiResponse<T> loading() {
        return new ApiResponse<>(LOADING, null, null);
    }


}

