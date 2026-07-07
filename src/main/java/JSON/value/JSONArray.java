package JSON.value;

import type.CheckedValue;

import java.util.List;
import java.util.Objects;

/**
 * @param value element in value also required non-null, otherwise throw {@link NullPointerException}
 */
public record JSONArray(List<JSONValue> value) implements JSONSpecifiedValue<List<JSONValue>> {
    public JSONArray{
        CheckedValue.requireCheckedValue(this,value);
        value.forEach(
                element -> Objects.requireNonNull(element,"element in value must not be null")
        );
    }
}