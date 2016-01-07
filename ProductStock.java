package de.easeco;

/**
 * Created by kiindev on 1/7/16.
 */
public class ProductStock {
    private Product mProduct;
    private int mProductAmount;

    public ProductStock(Product paramProduct, int paramProductAmount) {
        this.mProduct = paramProduct;
        this.mProductAmount = paramProductAmount;
    }

    public Product getProduct() {
        return mProduct;
    }

    public void setProduct(Product paramProduct) {
        this.mProduct = paramProduct;
    }

    public int getProductAmount() {
        return mProductAmount;
    }

    public void setProductAmount(int paramProductAmount) {
        this.mProductAmount = paramProductAmount;
    }

    public boolean doSubtractStock(int paramAmountToSubtract){
        boolean canSubtractStock = isCanSubtractStock(paramAmountToSubtract);
        if(canSubtractStock){
            this.mProductAmount -= paramAmountToSubtract;
        }
        return canSubtractStock;
    }

    private boolean isCanSubtractStock(int paramAmountToSubtract){
        return ((this.mProductAmount - paramAmountToSubtract) >= 0);
    }

    public void addStock(int paramAmountToAddStock){
        mProductAmount += paramAmountToAddStock;
    }

    public boolean isProductOutOfStock(){
        return mProductAmount == 0;
    }
}
