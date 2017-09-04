package leistung2.Service;

import leistung2.Constant.UnitValues;
import leistung2.Enum.Units;

public class Calculate {

    public static double convert(double value, double factor) {
        return (value / factor);
    }

    public static double round(double value) {
        return (Math.round(value * 1000.0) / 1000.0);
    }

    public static double returnFactorValue(Units valueLabelEnum, Units targetLabelEnum) {
        if (valueLabelEnum.equals(targetLabelEnum)) {
            return 1;
        }

        switch (valueLabelEnum) {
            case PS:
                return targetLabelEnum.equals(Units.HP) ? UnitValues.PS_TO_HP : UnitValues.PS_TO_KW;
            case HP:
                return targetLabelEnum.equals(Units.PS) ? UnitValues.HP_TO_PS : UnitValues.HP_TO_KW;
            case KW:
                return targetLabelEnum.equals(Units.HP) ? UnitValues.KW_TO_HP : UnitValues.KW_TO_PS;
        }

        return 0;
    }
}
