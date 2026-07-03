package JSON.value;

import java.util.Map;

public record JSONMap(Map<String,JSONValue> value) implements JSONSpecifiedValue<Map<String,JSONValue>> {
    public JSONMap{
        checkedNonNull();
    }
}