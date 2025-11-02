package lotto.controller;

import java.util.List;
import lotto.domain.model.Lotto;
import lotto.domain.model.Purchase;
import lotto.domain.model.Result;
import lotto.domain.model.WinningNumbers;
import lotto.domain.parser.CommaParser;
import lotto.domain.parser.Parser;
import lotto.domain.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        Purchase purchase = readPurchase();
        List<Lotto> lottoList = lottoService.initLottoList(purchase);
        outputView.printPurchased(lottoList, purchase);

        WinningNumbers winningNumbers = readWinningNumbers();
        Result result = lottoService.evaluate(lottoList, winningNumbers);
        outputView.printResult(result, purchase.getPayment());
    }

    private Purchase readPurchase() {
        while (true) {
            try {
                String payment = inputView.inputPayment();
                return Purchase.of(Integer.parseInt(payment.trim()));
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private WinningNumbers readWinningNumbers() {
        Parser parser = new CommaParser();
        while (true) {
            try {
                String winningNumbers = inputView.inputWinningNumbers();
                String bonusNumber = inputView.inputBonusNumber();
                return WinningNumbers.of(parser.parse(winningNumbers), Integer.parseInt(bonusNumber.trim()));
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}