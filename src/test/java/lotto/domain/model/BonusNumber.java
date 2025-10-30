package lotto.domain.model;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validateBonusNumberIsPositive(bonusNumber);
        validateBonusNumberInRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumberIsPositive(int bonusNumber) {
        if (bonusNumber <= 0) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 양수여야 합니다.");
        }
    }

    private void validateBonusNumberInRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호가 범위를 벗어났습니다.");
        }
    }
}
