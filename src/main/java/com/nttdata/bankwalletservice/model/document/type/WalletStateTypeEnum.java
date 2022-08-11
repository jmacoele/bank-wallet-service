package com.nttdata.bankwalletservice.model.document.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
/**
 * WalletStateTypeEnum Class.
 *
 * @author jmacoele
 *
 */

public enum WalletStateTypeEnum {
  REGISTERED("R"),
  CONFIRMED("C");

  private String value;

  @JsonValue
  public String getValue() {
    return value;
  }
  /** Function of that convert string into enum value.
   *
   * @param value Enum value string-converted.
   * @return WalletStateTypeEnum.
   */
  
  @JsonCreator
  public static WalletStateTypeEnum of(String value) {
    if (null == value) {
      return null;
    }

    for (WalletStateTypeEnum item : WalletStateTypeEnum.values()) {
      if (value.equals(item.getValue())) {
        return item;
      }
    }

    throw new RuntimeException("IdentityNumberTypeEnum: unknown value: " + value);
  }

  WalletStateTypeEnum(String value) {
    this.value = value;
  }

}