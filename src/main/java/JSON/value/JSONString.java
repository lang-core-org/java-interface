package JSON.value;

public record JSONString(String value) implements JSONSpecifiedValue<String> {
    public JSONString{
        checkedNonNull();
    }
}
