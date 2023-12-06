package lotto.model;

public class Order {
    private final int buyAmount;

    public Order(int buyAmount) {
        this.buyAmount = buyAmount;
    }

    public int calculateBuyQuanity() {
        return buyAmount / 1000;
    }

    public int getBuyAmount() {
        return buyAmount;
    }


}
