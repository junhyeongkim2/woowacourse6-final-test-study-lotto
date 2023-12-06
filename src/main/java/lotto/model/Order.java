package lotto.model;

public class Order {
    private final int buyAmount;

    public Order(int buyAmount) {
        validateIsDivideByThousand(buyAmount);
        this.buyAmount = buyAmount;
    }

    public int calculateBuyQuanity() {
        return buyAmount / 1000;
    }

    public int getBuyAmount() {
        return buyAmount;
    }

    private void validateIsDivideByThousand(int buyAmount) {
        if (buyAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1000원 단위로 나누어떨어져야 합니다. 다시 입력해 주세요.");
        }
    }


}
