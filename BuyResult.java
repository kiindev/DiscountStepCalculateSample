package de.easeco;

/**
 * Created by kiindev on 1/7/16.
 */
public interface BuyResult {
    void onBuySuccess(int paramProductInStockTotalLeft,float paramTotalPriceSum, float paramTotalDiscount, float paramTotalPrice);
    void onProductOutOfStock();
    void onProductHaveNotEnoughToBuy();
}
