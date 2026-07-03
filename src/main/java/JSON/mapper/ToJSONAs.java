package JSON.mapper;

@FunctionalInterface
public interface ToJSONAs<Type> {
    /**
     * @return {@code this} to JSON is equals to {@link Type} to JSON
     */
    Type toJSONAs();
}
