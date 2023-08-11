package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private final SelenideElement fromInput = $("[data-test-id='from'] input");
    private final SelenideElement transferHead = $(byText("Пополнение карты"));
    private final SelenideElement errorMessage = $("[data-test-id='error-message']");
    private SelenideElement amountInputNew = $("[data-test-id=amount] input");
    private SelenideElement transferButton = $("[data-test-id=action-transfer] span");

    public TransferPage() {
        transferHead.shouldBe(Condition.visible);
    }

    public DashboardPage makeValidTransfer(String amountToTransfer, DataHelper.Card card) {
        makeTransfer(amountToTransfer, card);
        return new DashboardPage();
    }

    public void makeTransfer(String amountToTransfer, DataHelper.Card card) {
        amountInputNew.setValue(amountToTransfer);
        fromInput.setValue(card.getCardNumber());
        transferButton.click();
    }

    public void findErrorMessage(String expectedText) {
        errorMessage.shouldHave(Condition.exactText(expectedText)).shouldBe(Condition.visible);

    }
}