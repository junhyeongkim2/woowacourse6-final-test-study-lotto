package lotto.model;

import java.util.List;

public enum Rank {

    NONE("NONE", 0, 0, false),
    FIFTH("3개 일치", 5_000, 3, false),
    FOURTH("4개 일치", 50_000, 4, false),
    THIRD("5개 일치", 1_500_000, 5, false),
    SECOND("5개 일치, 보너스 볼 일치", 30000000, 5, true),
    FIRST("6개 일치", 2000_000_000, 6, false);

    Rank(String category, int prize, int matchCount, boolean isBonus) {
        this.category = category;
        this.prize = prize;
        this.matchCount = matchCount;
        this.isBonus = isBonus;
    }

    private final String category;
    private final int prize;
    private final int matchCount;

    private boolean isBonus;

    public static Rank valueOf(int matchCount, boolean isBonus) {
        if (matchCount == 6) {
            return FIRST;
        }
        if (matchCount == 5 && isBonus) {
            return SECOND;
        }
        if (matchCount == 5) {
            return THIRD;
        }
        if (matchCount == 4) {
            return FOURTH;
        }
        if (matchCount == 3) {
            return FIFTH;
        }
        return NONE;
    }


}

