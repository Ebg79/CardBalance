package ru.netology.data;

import lombok.Value;
import ru.netology.page.CardChoosePage;
import java.util.Random;

public class DataHelper {

  private DataHelper() { }

  @Value
  public static class AuthInfo {
    String login;
    String password;
  }
  @Value
  public static class VerificationCode {
    String code;
  }
  @Value
  public static class CardInfo {
    String cardNumber;

  }

  public static AuthInfo getAuthInfo() {

    return new AuthInfo("vasya", "qwerty123");
  }



  public static VerificationCode getVerificationCodeFor(AuthInfo authInfo) {

    return new VerificationCode("12345");
  }

  public static CardInfo firstCardInfo() {

    return new CardInfo("5559 0000 0000 0001");
  }
  public static CardInfo secondCardInfo() {

    return new CardInfo("5559 0000 0000 0002");

  }
}