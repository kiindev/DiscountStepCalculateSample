package de.easeco;

import java.util.ArrayList;

/**
 * Created by kiindev on 1/7/16.
 */
public class RunApplication implements BuyResult{

    private ArrayList<ProductStock> mListProductInInventory;

    public RunApplication() {
        initialize();
        doBuy();
    }

    private void initialize(){
        mListProductInInventory = new ArrayList<>();
        doInsertTestRecord();
    }

    private void doInsertTestRecord(){
        mListProductInInventory.add(new ProductStock(new Product("P000000001", "Unsafe Kids Toy", 120.0f), 1000));
    }

    private void doBuy(){
        BuyProduct.getInstance(this)
                .setProductStockToBuy(mListProductInInventory.get(0))
                .setProductAmountToBuy(401)
                .beginTransaction();

    }

    @Override
    public void onBuySuccess(int paramProductInStockTotalLeft, float paramTotalPriceSum, float paramTotalDiscount, float paramTotalPrice) {
        System.out.printf(
                "Product Left : %d pcs\nSummary Price : %2f THB\nDiscount : %2f THB\nTotal Price : %2f",
                paramProductInStockTotalLeft,
                paramTotalPriceSum,
                paramTotalDiscount,
                paramTotalPrice
        );
    }

    @Override
    public void onProductOutOfStock() {
        System.out.println("Product : out of stock");
    }

    @Override
    public void onProductHaveNotEnoughToBuy() {
        System.out.println("Product : not enough to buy");
    }
}
