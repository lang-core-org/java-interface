package type;

import java.util.Collection;
import java.util.Map;

public sealed interface NonEmpty<ValueType> extends CheckedValue<ValueType>
permits NonEmpty._CharSequence,
        NonEmpty._Collection,
        NonEmpty._Map {


    /**
     * @param value unchecked value
     * @return {@link NonEmpty} contains {@code value}
     */
    static<ValueType extends CharSequence> NonEmpty<ValueType> of(ValueType value){
        return (_CharSequence<ValueType>) () -> value;
    }


    /**
     * @param value unchecked value
     * @return {@link NonEmpty} contains {@code value}
     */
    static<ValueType extends Collection<?>> NonEmpty<ValueType> of(ValueType value){
        return (_Collection<ValueType>) () -> value;
    }


    /**
     * @param value unchecked value
     * @return {@link NonEmpty} contains {@code value}
     */
    static<ValueType extends Map<?,?>> NonEmpty<ValueType> of(ValueType value){
        return (_Map<ValueType>) () -> value;
    }



    @FunctionalInterface
    non-sealed interface _CharSequence<ValueType extends CharSequence> extends NonEmpty<ValueType>{

        /**
         * @implNote <b>DO NOT OVERRIDE</b>
         */
        @Override
        default boolean check(final ValueType value){
            return (value != null)
                    && (! value.isEmpty());
        }
    }


    @FunctionalInterface
    non-sealed interface _Collection<ValueType extends Collection<?>> extends NonEmpty<ValueType>{

        /**
         * @implNote <b>DO NOT OVERRIDE</b>
         */
        @Override
        default boolean check(final ValueType value){
            return (value != null)
                    && (! value.isEmpty());
        }
    }

    @FunctionalInterface
    non-sealed interface _Map<ValueType extends Map<?,?>> extends NonEmpty<ValueType>{

        /**
         * @implNote <b>DO NOT OVERRIDE</b>
         */
        @Override
        default boolean check(final ValueType value){
            return (value != null)
                    && (! value.isEmpty());
        }
    }


}
