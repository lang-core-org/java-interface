package type;

public sealed interface Value<ValueType>
permits CheckedValue,
        UnCheckedValue,
        UnionType{

    /**
     * @return get the value
     */
    ValueType value();
}