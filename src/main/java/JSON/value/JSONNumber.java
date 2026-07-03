package JSON.value;

public record JSONNumber(Number value) implements JSONSpecifiedValue<Number> {
    public JSONNumber{
        checkedNonNull();
    }
}
