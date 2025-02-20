package onmyownn.support.enums;

import java.util.Arrays;
import java.util.Objects;

public interface EnumBase<E extends Enum<E>> {

  int getValue();

  static <E extends EnumBase<?>> E of(Class<E> emunClass, Integer value) {
    if (Objects.isNull(value)) {
      return null;
    }

    return Arrays.stream(emunClass.getEnumConstants())
        .filter(
            e -> e.getValue() == value
        )
        .findFirst()
        .orElseThrow(
            () -> new IllegalArgumentException(
                String.format(
                    "%s không tồn tại giá trị [%s]",
                    emunClass.getSimpleName(),
                    value
                )
            )
        );
  }

  static <E extends EnumBase<?>> boolean hasValue(Class<E> emunClass, Integer value) {
    if (Objects.isNull(value)) {
      return false;
    }

    return Arrays.stream(emunClass.getEnumConstants())
        .anyMatch(e -> e.getValue() == value);
  }
}
