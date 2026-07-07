package type;

import java.util.Objects;

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
     * @param checker check value via {@link CheckedValue#check(Object)}, <br>
     *                <b>required non-null</b>
     * @param unchecked_value unchecked value
     * @return checked value
     * @throws IllegalArgumentException  throw if {@code unchecked_value} checked fail
     * @throws NullPointerException throw if {@code checker == null}
     */
    static<ValueType> ValueType requireCheckedValue(CheckedValue<ValueType> checker, ValueType unchecked_value) throws IllegalArgumentException, NullPointerException {
        Objects.requireNonNull(checker,"checker is not allowed to be null");

        if(checker.check(unchecked_value)){
            return unchecked_value;
        }else{
            switch (checker){
                case NonBlank<? extends CharSequence> ignored ->
                        throw new IllegalArgumentException("value is not NonBlank");
                case NonEmpty<?> ignored ->
                        throw new IllegalArgumentException("value is not NonEmpty");
                case NonNull<?>  ignored ->
                        throw new IllegalArgumentException("value is not NonNull");
            }
        }
    }

    /**
     * @return get valid value with check
     * @throws IllegalArgumentException throw if {@code value} is invalid
     * @implNote <b>DO NOT OVERRIDE</b>
     */
    @Override
    default ValueType value() throws IllegalArgumentException{
        final ValueType value = unchecked_value();
        return requireCheckedValue(this, value);
    }
}
