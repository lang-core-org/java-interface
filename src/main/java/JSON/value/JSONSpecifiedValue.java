package JSON.value;


import type.NonNull;

public sealed interface JSONSpecifiedValue<ValueType> extends JSONValue,NonNull<ValueType> permits
JSONArray,
JSONMap,
JSONBoolean,
JSONNumber,
JSONString{

    /**
     * throw {@link UnsupportedOperationException}
     */
    @Override
    default ValueType unchecked_value(){
        throw new UnsupportedOperationException();
    }
}
