class MutualFund extends Asset{
    private int nav;

    MutualFund(String symbol, int quantity, int purchasePrice, int nav){
        super(symbol, quantity, purchasePrice);
        this.nav = nav;
    }

    public String getAssetType(){
        return "MFund";
    }

    @Override
    public double getPnl(){
        return (nav - getPurchasePrice()) * getQuantity();
    }

    public double currentValue(){
        return nav * getQuantity();
    }
}