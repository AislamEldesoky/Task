package com.example.islameldesoky.task.businesslogic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by islam eldesoky on 17/07/2018.
 */

public interface ProductsAPI {
    @GET("products?count=10&from=1")
    Call<List<Products>> getProducts() ;
}
