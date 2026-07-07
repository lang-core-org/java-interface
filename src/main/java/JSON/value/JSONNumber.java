package JSON.value;

import type.CheckedValue;

/**
 * @param value finite value
 * @see Double#isFinite(double)
 * @implNote throw {@link NumberFormatException} if value is not finite
 */
public record JSONNumber(Double value) implements JSONSpecifiedValue<Double> {

    @SuppressWarnings("all")
    public JSONNumber{
        CheckedValue.requireCheckedValue(this,value);
        if(Double.isFinite(value)){
            //PASS
        }else{
            throw new NumberFormatException("value is not finite");
        }
    }
}
