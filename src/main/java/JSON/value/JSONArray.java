package JSON.value;

import java.util.List;

public record JSONArray(List<JSONValue> value) implements JSONSpecifiedValue<List<JSONValue>> {
    public JSONArray{
        checkedNonNull();
    }
}