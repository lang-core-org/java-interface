package type;

public sealed interface UnionType<LeftType,RightType> extends Value<UnionType<LeftType,RightType>>
permits UnionType._Left,
        UnionType._Right {

    /**
     * @return {@code this}
     * @implNote <b>DO NOT OVERRIDE</b>
     */
    @Override
    default UnionType<LeftType, RightType> value(){
        return this;
    }


    /**
     * @param left left value
     * @return {@link UnionType} contains {@code left} only
     */
    static<LeftType,RightType> UnionType<LeftType,RightType> ofLeft(LeftType left){
        return new _Left<>(left);
    }


    /**
     * @param right right value
     * @return {@link UnionType} contains {@code right} only
     */
    static<LeftType,RightType> UnionType<LeftType,RightType> ofRight(RightType right){
        return new _Right<>(right);
    }

    record _Left<LeftType,RightType>(LeftType left) implements UnionType<LeftType, RightType>{}

    record _Right<LeftType,RightType>(RightType right) implements UnionType<LeftType, RightType>{}
}
