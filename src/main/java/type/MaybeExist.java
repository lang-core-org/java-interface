package type;

public sealed interface MaybeExist<ValueType> extends UnCheckedValue<ValueType>
permits MaybeExist._Exist,
        MaybeExist._Absent {


    /**
     * @param value a value, maybe {@code null}
     * @return {@link MaybeExist} has {@code value}
     */
    static<ValueType> MaybeExist<ValueType> of(ValueType value){
        return new _Exist<>(value);
    }


    /**
     * @return {@link MaybeExist} has no value
     */
    static<ValueType> MaybeExist<ValueType> of(){
        return new _Absent<>();
    }


    record _Exist<ValueType>(ValueType value) implements MaybeExist<ValueType>{}

    record _Absent<ValueType>() implements MaybeExist<ValueType>{

        @Override
        @Deprecated
        public ValueType value() {
            throw new UnsupportedOperationException();
        }
    }


}
