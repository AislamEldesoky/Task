package com.example.islameldesoky.task.businesslogic;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.islameldesoky.task.ui.ProductsActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by islam eldesoky on 17/07/2018.
 */

public class ProductController implements Callback<List<Products>> {
    static final String BASE_URL = "http://grapesnberries.getsandbox.com/";
    List<Products> products ;
    private ProductsActivity activity;
    public ProductController(AppCompatActivity activity) {
        this.activity = (ProductsActivity) activity;
    }
    public void start(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ProductsAPI productsAPI = retrofit.create(ProductsAPI.class);
        Call<List<Products>> call = productsAPI.getProducts();
        call.enqueue(this);



    }

    @Override
    public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
        if(response.isSuccessful()){
            Log.d("RC", response.body().toString());
            activity.setProducts(response.body());
        }

    }

    @Override
    public void onFailure(Call<List<Products>> call, Throwable t) {

    }
}
