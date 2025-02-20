package onmyownn.support.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusEnum implements EnumBase<StatusEnum> {
  USE("Sử dụng", 1),
  NO_USE("Ngừng sử dụng", 2);

  private String name;
  private int value;
}
