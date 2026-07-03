package type;

import java.util.regex.Pattern;

@FunctionalInterface
public non-sealed interface NonBlank<ValueType extends CharSequence> extends CheckedValue<ValueType> {

    /**
     * @implNote <b>DO NOT OVERRIDE</b>
     */
    @Override
    default boolean check(final ValueType value){
        return (value != null)
            && (Pattern.matches("^(?U)\\s*\\S[\\s\\S]*$", value));
    }
}
