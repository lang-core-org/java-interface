package JSON.value;

public final class JSONNull implements JSONSpecifiedValue<Object>{

    /**
     * @return {@code null}
     */
    @Override
    public Object value() {
        return null;
    }

    @Override
    public String toString() {
        return "null";
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof JSONNull);
    }
}
