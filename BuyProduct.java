package de.easeco;

/**
 * Created by kiindev on 1/7/16.
 */
public class BuyProduct {

    private static BuyProduct _instance;
    private static BuyResult _delegate;
    private ProductStock mProductStockToBuy;
    private int mProductAmountToBuy;


    public static BuyProduct getInstance(BuyResult paramBuyResultDelegate){
        if(_instance == null) {
            _instance = new BuyProduct();
        }
        _delegate = paramBuyResultDelegate;
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
                _delegate.onBuySuccess(
                        mProductStockToBuy.getProductAmount(),
                        doSummaryPrice(),
                        doCalculateTotalDiscount(),
                        doCalcTotalPrice()
                );
            }else{
                _delegate.onProductHaveNotEnoughToBuy();
            }
        }else{
            _delegate.onProductOutOfStock();
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
