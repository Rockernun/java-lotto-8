package lotto;

import lotto.controller.LottoController;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.generator.RandomLottoGenerator;
import lotto.domain.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoGenerator generator = new RandomLottoGenerator();
        LottoService lottoService = new LottoService(generator);

        LottoController lottoController = new LottoController(inputView, outputView, lottoService);
        lottoController.run();
    }
}
