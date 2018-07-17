package com.example.islameldesoky.task.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.islameldesoky.task.R;
import com.example.islameldesoky.task.businesslogic.Image;
import com.example.islameldesoky.task.businesslogic.Products;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by islam eldesoky on 17/07/2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Products> products ;
    private Image image ;

    public ProductAdapter(List<Products> products) {

        this.products = products;

    }

    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_content,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        image = products.get(position).getImage();
        holder.product = products.get(position);
        holder.price.setText(products.get(position).getPrice());
        holder.productDes.setText(products.get(position).getDescription());
        Picasso.get().load(image.getUrl()).into(holder.image);
       // Glide.with(holder.view.getContext())
             //   .load(image.getUrl())
              //  .into(holder.image);

        String Url = image.getUrl();
        Log.d("url is ",Url);

    }

    public void setData(List<Products> products){
        this.products = products;
        notifyDataSetChanged();

    }

    @Override
    public void onBindViewHolder(ProductAdapter.ViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        final View view;
        final TextView productDes;
        final TextView price ;
        final ImageView image ;
        Products product;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView ;
            productDes = (TextView) view.findViewById(R.id.productdescription);
            price= (TextView) view.findViewById(R.id.price);
            image = (ImageView) view.findViewById(R.id.productimage);



        }

    }
}
