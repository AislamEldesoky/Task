package com.example.islameldesoky.task.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.islameldesoky.task.R;
import com.example.islameldesoky.task.businesslogic.ProductController;
import com.example.islameldesoky.task.businesslogic.Products;
import com.example.islameldesoky.task.ui.adapter.ProductAdapter;

import java.util.List;

public class ProductsActivity extends AppCompatActivity {
    private RecyclerView recyclerView ;
    private ProductAdapter adapter;
    List<Products>products;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        recyclerView = (RecyclerView) findViewById(R.id.product_list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(recyclerView.getContext(),
                LinearLayoutManager.VERTICAL,
                false);
            recyclerView.setLayoutManager(manager);
            recyclerView.setHasFixedSize(true);

        ProductController productController = new ProductController(this);
        productController.start();

    }

    public void setProducts(List<Products> products) {
        if (adapter == null) {
            adapter = new ProductAdapter(products);
            recyclerView.setAdapter(adapter);
        } else {
            adapter.setData(products);
        }
    }
}
