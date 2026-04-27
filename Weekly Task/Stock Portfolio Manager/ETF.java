class ETF extends Asset{
    private int indexReturn;

    ETF(String symbol, int quantity, int purchasePrice, int indexReturn){
        super(symbol,quantity,purchasePrice);
        this.indexReturn = indexReturn;
    }

    public String getAssetType(){
        return "ETF";
    }

    private double getCurrentPrice() {
        return getPurchasePrice() * (1 + indexReturn / 100.0);
    }

    public double getPnl() {
        return (getCurrentPrice() - getPurchasePrice()) * getQuantity();
    }

    public double currentValue() {
        return getCurrentPrice() * getQuantity();
    }
}