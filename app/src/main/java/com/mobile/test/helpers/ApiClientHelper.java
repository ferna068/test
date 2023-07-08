package com.mobile.test.helpers;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientHelper<T> {
    private static final String BASE_URL = "http://findtrack:3000/api/";
    private Retrofit retrofit;
    private Class<T> apiServiceClass;

    public ApiClientHelper(Class<T> apiServiceClass) {
        this.apiServiceClass = apiServiceClass;

        final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    public T createService() {
        return retrofit.create(apiServiceClass);
    }
}
