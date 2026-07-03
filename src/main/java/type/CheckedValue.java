package type;

public sealed interface CheckedValue<ValueType> extends Value<ValueType>
permits NonBlank,
        NonEmpty,
        NonNull {

    /**
     * @return get value without check
     */
    ValueType unchecked_value();

    /**
     * @param value unchecked value
     * @return {@code true}: checked pass, {@code false}: otherwise
     */
    boolean check(final ValueType value);

    /**
     * @return get valid value with check
     * @throws IllegalArgumentException throw if {@code value} is invalid
     * @implNote <b>DO NOT OVERRIDE</b>
     */
    @Override
    default ValueType value() throws IllegalArgumentException{
        final ValueType value = unchecked_value();
        if(check(value)){
            return value;
        }else{
            switch (this){
                case NonBlank<? extends CharSequence> ignored ->
                        throw new IllegalArgumentException("value is not NonBlank");
                case NonEmpty<?> ignored ->
                        throw new IllegalArgumentException("value is not NonEmpty");
                case NonNull<?>  ignored ->
                        throw new IllegalArgumentException("value is not NonNull");
            }
        }
    }
}
