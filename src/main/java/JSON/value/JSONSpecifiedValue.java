package JSON.value;


import type.NonNull;

public sealed interface JSONSpecifiedValue<ValueType> extends JSONValue permits
JSONArray,
JSONMap,
JSONBoolean,
JSONNumber,
JSONString,
JSONNull{

    /**
     * @return get specified value
     */
    ValueType value();

    /**
     * checked {@link JSONSpecifiedValue#value()} by {@link NonNull}
     * @implNote <b>DO NOT OVERRIDE</b>
     */
    default void checkedNonNull(){
        final NonNull<ValueType> checker = this::value;
        checker.value(); //checking value
    }
}
