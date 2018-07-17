package com.example.islameldesoky.task.businesslogic;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by islam eldesoky on 17/07/2018.
 */

public class Products implements Serializable {
    @SerializedName("id")
    @Expose
    private String Id ;

    @SerializedName("productDescription")
    @Expose
    private String ProductDescripton ;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getID() {

        return Id;
    }

    public void setID(String ID) {
        this.Id = ID;
    }

    public String getDescription() {
        return ProductDescripton;
    }

    public void setDescription(String description) {
        ProductDescripton = description;
    }


    public void setId(String id) {
        Id = id;
    }

    public void setProductDescripton(String productDescripton) {
        ProductDescripton = productDescripton;
    }

    public void setImages(Image images) {
        this.images = images;
    }

    public Image getImage() {
        return images;
    }

    @SerializedName("image")
    @Expose
    private Image images ;

    @SerializedName("price")
    @Expose
    private String price ;

}
