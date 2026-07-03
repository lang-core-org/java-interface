package JSON.value;

public record JSONBoolean(Boolean value) implements JSONSpecifiedValue<Boolean> {
    public JSONBoolean{
        checkedNonNull();
    }
}