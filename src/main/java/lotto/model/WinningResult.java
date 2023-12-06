package lotto.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    private final int PROFIT_RATE_NUMBER = 100;
    private static final int MAP_STANDARD_SETTING_VALUE = 0;

    private static final String WINNING_RESULT_MESSAGE = "당첨 통계";
    private static final String SEPERATOR = "---";
    private static final String QUANITY = "개";
    private static final String SPACING = "\n";


    private Map<Rank, Integer> winningResult;

    private WinningResult(Map<Rank, Integer> winningResult) {
        this.winningResult = winningResult;
    }

    public static WinningResult of(Lottos lottos, WinningNumbers winningNumbers) {
        Map<Rank, Integer> winningResult = new EnumMap<Rank, Integer>(Rank.class);
        initializeResult(winningResult);
        return new WinningResult(lottos.compareNumbers(winningResult, winningNumbers));
    }

    public static void initializeResult(Map<Rank, Integer> winningResult) {
        Arrays.stream(Rank.values()).forEach(rank -> winningResult.put(rank, MAP_STANDARD_SETTING_VALUE));
    }


    public Map<Rank, Integer> getResult() {
        return Collections.unmodifiableMap(winningResult);
    }


    public double calculateTotalProfit(Order order) {
        return (calculateTotalPrize() / order.getBuyAmount()) * PROFIT_RATE_NUMBER;
    }

    private double calculateTotalPrize() {
        return (double) winningResult.entrySet().stream()
                .mapToInt(key -> key.getValue() * Rank.valueOf(String.valueOf(key.getKey())).getPrize()).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(WINNING_RESULT_MESSAGE + SPACING);
        sb.append(SEPERATOR + SPACING);
        winningResult.entrySet().stream().filter(key -> key.getKey() != Rank.NONE)
                .forEach(key -> sb.append(key.getKey().getCategory() + key.getValue() + QUANITY+SPACING));
        return sb.toString();
    }
}
