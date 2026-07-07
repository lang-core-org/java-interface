package JSON.value;

import type.CheckedValue;

import java.util.Map;
import java.util.Objects;

/**
 * @param value both key and val of entry in value also required non-null,
 *              otherwise throw {@link NullPointerException}
 */
public record JSONMap(Map<String,JSONValue> value) implements JSONSpecifiedValue<Map<String,JSONValue>> {
    public JSONMap{
        CheckedValue.requireCheckedValue(this,value);

        value.forEach(
                (key, val) -> {
                    Objects.requireNonNull(
                            key,
                            "key of entry in value must not be null"
                    );
                    Objects.requireNonNull(
                            val,
                            "val of entry in value must not be null"
                    );
                }
        );
    }
}