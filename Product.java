package de.easeco;

/**
 * Created by kiindev on 1/7/16.
 */
public class Product {
    private String mProductId;
    private String mProductName;
    private float mProductPrice;

    public Product(String paramProductId, String paramProductName, float paramProductPrice) {
        this.mProductId = paramProductId;
        this.mProductName = paramProductName;
        this.mProductPrice = paramProductPrice;
    }

    public String getProductId() {
        return mProductId;
    }

    public void setProductId(String paramProductId) {
        this.mProductId = paramProductId;
    }

    public String getProductName() {
        return mProductName;
    }

    public void setProductName(String paramProductName) {
        this.mProductName = paramProductName;
    }

    public float getProductPrice() {
        return mProductPrice;
    }

    public void setProductPrice(float paramProductPrice) {
        this.mProductPrice = paramProductPrice;
    }
}
