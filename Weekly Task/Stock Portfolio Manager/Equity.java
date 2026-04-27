class Equity extends Asset{
    private int currentPrice;

    Equity(String symbol, int quantity, int purchasePrice, int currentPrice){
        super(symbol,quantity,purchasePrice);
        this.currentPrice = currentPrice;
    }

    public String getAssetType(){
        return "Equity";
    }

    public double getPnl(){
        return (currentPrice - getPurchasePrice()) * getQuantity();
    }

    public double currentValue(){
        return currentPrice * getQuantity();
    }
}