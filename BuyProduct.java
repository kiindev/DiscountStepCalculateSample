package de.easeco;

/**
 * Created by kiindev on 1/7/16.
 */
public class BuyProduct {

    private static BuyProduct _instance;
    private static BuyResult mBuyResultDelegate;
    private ProductStock mProductStockToBuy;
    private int mProductAmountToBuy;


    public static BuyProduct getInstance(BuyResult paramBuyResultDelegate){
        if(_instance == null) {
            _instance = new BuyProduct();
        }
        mBuyResultDelegate = paramBuyResultDelegate;
        return _instance;
    }

    public BuyProduct setProductStockToBuy(ProductStock paramProductStockToBuy){
        this.mProductStockToBuy = paramProductStockToBuy;
        return this;
    }

    public BuyProduct setProductAmountToBuy(int paramProductAmountToBuy){
        this.mProductAmountToBuy = paramProductAmountToBuy;
        return this;
    }

    public void beginTransaction(){
        if(!mProductStockToBuy.isProductOutOfStock()){
            if(mProductStockToBuy.doSubtractStock(this.mProductAmountToBuy)){
                mBuyResultDelegate.onBuySuccess(
                        mProductStockToBuy.getProductAmount(),
                        doSummaryPrice(),
                        doCalculateTotalDiscount(),
                        doCalcTotalPrice()
                );
            }else{
                mBuyResultDelegate.onProductHaveNotEnoughToBuy();
            }
        }else{
            mBuyResultDelegate.onProductOutOfStock();
        }
    }

    private float doSummaryPrice(){
        return mProductStockToBuy.getProduct().getProductPrice() * this.mProductAmountToBuy;
    }

    private float doCalculateTotalDiscount(){
        return (((mProductAmountToBuy - 1) / 100) * Discount.DISCOUNT_STEP_FACTOR) * this.mProductAmountToBuy;
    }

    private float doCalcTotalPrice(){
        return (mProductStockToBuy.getProduct().getProductPrice() * this.mProductAmountToBuy) - doCalculateTotalDiscount();
    }

}
