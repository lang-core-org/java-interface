package JSON.mapper;

import JSON.value.JSONValue;

public interface JSONMapper<JSONThrowAble extends  Throwable>{

    /**
     * @param JSONValue tree represent for JSON
     * @param isPrettyJSON  {@code true}: output pretty JSON, {@code false}: non-pretty
     * @return {@link String} represent for JSON
     */
    String toJSONString(
            final JSONValue JSONValue,
            final boolean isPrettyJSON
    ) throws JSONThrowAble;

    /**
     * @param src src object
     * @param WriteKeyAssociatedNullOrIgnore {@code true}: write key associated with {@code null}, {@code false}: ignored
     * @param WriteNonFiniteAsStringOrThrow {@code true}: write non-finite value as {@link String}, {@code false}: throw {@link JSONThrowAble}
     * @return tree represent for JSON
     * @apiNote {@link ToJSONAs} for custom
     */
    <SrcType> JSONValue toJSONValue(
            final SrcType src,
            final boolean WriteKeyAssociatedNullOrIgnore,
            final boolean WriteNonFiniteAsStringOrThrow
    ) throws JSONThrowAble;

    /**
     * @param JSONString src {@link String} represent for JSON
     * @return {@link JSONValue} represent for JSON
     */
    JSONValue toJSONValue(
            final String JSONString
    ) throws JSONThrowAble;

}
