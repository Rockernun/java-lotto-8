package lotto.view;

import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.model.Purchase;
import lotto.domain.model.Rank;
import lotto.domain.model.Result;

public class OutputView {

    public void printPurchased(List<Lotto> lottoList, Purchase purchase) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", purchase.getPurchasedLottoCount());
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getLottoNumbers());
        }
        System.out.println();
    }

    public void printResult(Result result, int payment) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("%d개 일치 (%s원) - %d개\n", Rank.FIFTH.getMatchedNumberCount(), getFormat(Rank.FIFTH),
                result.count(Rank.FIFTH));
        System.out.printf("%d개 일치 (%s원) - %d개\n", Rank.FOURTH.getMatchedNumberCount(), getFormat(Rank.FOURTH),
                result.count(Rank.FOURTH));
        System.out.printf("%d개 일치 (%s원) - %d개\n", Rank.THIRD.getMatchedNumberCount(), getFormat(Rank.THIRD),
                result.count(Rank.THIRD));
        System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", Rank.SECOND.getMatchedNumberCount(), getFormat(Rank.SECOND),
                result.count(Rank.SECOND));
        System.out.printf("%d개 일치 (%s원) - %d개\n", Rank.FIRST.getMatchedNumberCount(), getFormat(Rank.FIRST),
                result.count(Rank.FIRST));
        System.out.printf("총 수익률은 %s입니다.\n", result.yieldRate(payment));
    }

    public void printError(String message) {
        System.out.println(message);
    }

    private static String getFormat(Rank rank) {
        return String.format("%,d", rank.getPrize());
    }
}
