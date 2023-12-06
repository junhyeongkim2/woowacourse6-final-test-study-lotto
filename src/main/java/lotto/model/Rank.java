package lotto.model;

import java.util.List;

public enum Rank {

    NONE("NONE", 0, 0, false),
    FIFTH("3개 일치 (5,000원) - ", 5_000, 3, false),
    FOURTH("4개 일치 (50,000원) - ", 50_000, 4, false),
    THIRD("5개 일치 (1,500,000원) - ", 1_500_000, 5, false),
    SECOND("5개 일치, 보너스 볼 일치 (30,000,000원) - ", 30000000, 5, true),
    FIRST("6개 일치 (2,000,000,000원) - ", 2000_000_000, 6, false);

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
        if (matchCount == FIRST.matchCount) {
            return FIRST;
        }
        if (matchCount == SECOND.matchCount && isBonus) {
            return SECOND;
        }
        if (matchCount == THIRD.matchCount) {
            return THIRD;
        }
        if (matchCount == FOURTH.matchCount) {
            return FOURTH;
        }
        if (matchCount == FIFTH.matchCount) {
            return FIFTH;
        }
        return NONE;
    }

    public int getPrize() {
        return this.prize;
    }

    public String getCategory(){
        return this.category;
    }


}

