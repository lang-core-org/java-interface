package type;

@FunctionalInterface
public non-sealed interface NonNull<ValueType> extends CheckedValue<ValueType> {

    /**
     * @implNote <b>DO NOT OVERRIDE</b>
     */
    @Override
    default boolean check(final ValueType value) {
        return (value != null);
    }
}
