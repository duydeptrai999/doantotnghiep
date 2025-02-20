package onmyownn.support.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleEnum implements EnumBase<RoleEnum> {
  ADMIN("Admin", 1),
  EMPLOYEE("EMPLOYEE", 2),
  CUSTOMER("CUSTOMER", 3);

  private String name;
  private int value;
}
