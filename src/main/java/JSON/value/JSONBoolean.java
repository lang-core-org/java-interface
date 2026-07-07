package JSON.value;

import type.CheckedValue;

public record JSONBoolean(Boolean value) implements JSONSpecifiedValue<Boolean> {
    public JSONBoolean{
        CheckedValue.requireCheckedValue(this,value);
    }
}