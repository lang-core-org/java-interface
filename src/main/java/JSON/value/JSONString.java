package JSON.value;

import type.CheckedValue;

public record JSONString(String value) implements JSONSpecifiedValue<String> {
    public JSONString{
        CheckedValue.requireCheckedValue(this,value);
    }
}
