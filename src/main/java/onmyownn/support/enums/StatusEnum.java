package onmyownn.support.enums;

import java.util.Arrays;
import java.util.List;

public enum StatusEnum {
  ACTIVE("Hoạt động"),
  INACTIVE("Không hoạt động");

  private String displayName;

  StatusEnum(String displayName) {
    this.displayName = displayName;
  }

  public String getDisplayName() {
    return displayName;
  }

  public static List<StatusEnum> getAllStatuses() {
    return Arrays.asList(StatusEnum.values());
  }
}