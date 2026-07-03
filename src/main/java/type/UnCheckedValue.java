package type;

public sealed interface UnCheckedValue<ValueType> extends Value<ValueType>
permits NullAble,
        MaybeExist {}