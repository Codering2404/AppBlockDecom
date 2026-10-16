package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey;
import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PeriodExtensionsKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Period.Unit.values().length];
            try {
                iArr[Period.Unit.DAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Period.Unit.WEEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Period.Unit.MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Period.Unit.YEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Period.Unit.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final VariableLocalizationKey getPeriodUnitAbbreviatedLocalizationKey(Period period) {
        Intrinsics.checkNotNullParameter(period, "<this>");
        int i3 = WhenMappings.$EnumSwitchMapping$0[period.getUnit().ordinal()];
        if (i3 == 1) {
            return VariableLocalizationKey.DAY_SHORT;
        }
        if (i3 == 2) {
            return VariableLocalizationKey.WEEK_SHORT;
        }
        if (i3 == 3) {
            return VariableLocalizationKey.MONTH_SHORT;
        }
        if (i3 == 4) {
            return VariableLocalizationKey.YEAR_SHORT;
        }
        if (i3 == 5) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final VariableLocalizationKey getPeriodValueWithUnitAbbreviatedLocalizationKey(Period period) {
        Intrinsics.checkNotNullParameter(period, "<this>");
        int i3 = WhenMappings.$EnumSwitchMapping$0[period.getUnit().ordinal()];
        if (i3 == 1) {
            return VariableLocalizationKey.NUM_DAYS_SHORT;
        }
        if (i3 == 2) {
            return VariableLocalizationKey.NUM_WEEKS_SHORT;
        }
        if (i3 == 3) {
            return VariableLocalizationKey.NUM_MONTHS_SHORT;
        }
        if (i3 == 4) {
            return VariableLocalizationKey.NUM_YEARS_SHORT;
        }
        if (i3 == 5) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final VariableLocalizationKey getPeriodValueWithUnitLocalizationKey(Period period) {
        Intrinsics.checkNotNullParameter(period, "<this>");
        if (period.getValue() == 0 && period.getUnit() == Period.Unit.DAY) {
            return VariableLocalizationKey.NUM_DAY_ZERO;
        }
        if (period.getValue() == 0 && period.getUnit() == Period.Unit.WEEK) {
            return VariableLocalizationKey.NUM_WEEK_ZERO;
        }
        if (period.getValue() == 0 && period.getUnit() == Period.Unit.MONTH) {
            return VariableLocalizationKey.NUM_MONTH_ZERO;
        }
        if (period.getValue() == 0 && period.getUnit() == Period.Unit.YEAR) {
            return VariableLocalizationKey.NUM_YEAR_ZERO;
        }
        if (period.getValue() == 1 && period.getUnit() == Period.Unit.DAY) {
            return VariableLocalizationKey.NUM_DAY_ONE;
        }
        if (period.getValue() == 1 && period.getUnit() == Period.Unit.WEEK) {
            return VariableLocalizationKey.NUM_WEEK_ONE;
        }
        if (period.getValue() == 1 && period.getUnit() == Period.Unit.MONTH) {
            return VariableLocalizationKey.NUM_MONTH_ONE;
        }
        if (period.getValue() == 1 && period.getUnit() == Period.Unit.YEAR) {
            return VariableLocalizationKey.NUM_YEAR_ONE;
        }
        if (period.getValue() == 2 && period.getUnit() == Period.Unit.DAY) {
            return VariableLocalizationKey.NUM_DAY_TWO;
        }
        if (period.getValue() == 2 && period.getUnit() == Period.Unit.WEEK) {
            return VariableLocalizationKey.NUM_WEEK_TWO;
        }
        if (period.getValue() == 2 && period.getUnit() == Period.Unit.MONTH) {
            return VariableLocalizationKey.NUM_MONTH_TWO;
        }
        if (period.getValue() == 2 && period.getUnit() == Period.Unit.YEAR) {
            return VariableLocalizationKey.NUM_YEAR_TWO;
        }
        int value = period.getValue();
        if (3 <= value && value < 5 && period.getUnit() == Period.Unit.DAY) {
            return VariableLocalizationKey.NUM_DAY_FEW;
        }
        int value2 = period.getValue();
        if (3 <= value2 && value2 < 5 && period.getUnit() == Period.Unit.WEEK) {
            return VariableLocalizationKey.NUM_WEEK_FEW;
        }
        int value3 = period.getValue();
        if (3 <= value3 && value3 < 5 && period.getUnit() == Period.Unit.MONTH) {
            return VariableLocalizationKey.NUM_MONTH_FEW;
        }
        int value4 = period.getValue();
        if (3 <= value4 && value4 < 5 && period.getUnit() == Period.Unit.YEAR) {
            return VariableLocalizationKey.NUM_YEAR_FEW;
        }
        int value5 = period.getValue();
        if (5 <= value5 && value5 < 11 && period.getUnit() == Period.Unit.DAY) {
            return VariableLocalizationKey.NUM_DAY_MANY;
        }
        int value6 = period.getValue();
        if (5 <= value6 && value6 < 11 && period.getUnit() == Period.Unit.WEEK) {
            return VariableLocalizationKey.NUM_WEEK_MANY;
        }
        int value7 = period.getValue();
        if (5 <= value7 && value7 < 11 && period.getUnit() == Period.Unit.MONTH) {
            return VariableLocalizationKey.NUM_MONTH_MANY;
        }
        int value8 = period.getValue();
        return (5 > value8 || value8 >= 11 || period.getUnit() != Period.Unit.YEAR) ? period.getUnit() == Period.Unit.DAY ? VariableLocalizationKey.NUM_DAY_OTHER : period.getUnit() == Period.Unit.WEEK ? VariableLocalizationKey.NUM_WEEK_OTHER : period.getUnit() == Period.Unit.MONTH ? VariableLocalizationKey.NUM_MONTH_OTHER : period.getUnit() == Period.Unit.YEAR ? VariableLocalizationKey.NUM_YEAR_OTHER : VariableLocalizationKey.NUM_DAY_OTHER : VariableLocalizationKey.NUM_YEAR_MANY;
    }

    public static /* synthetic */ void getPeriodValueWithUnitLocalizationKey$annotations(Period period) {
    }

    public static final String getRoundedValueInDays(Period period) {
        Intrinsics.checkNotNullParameter(period, "<this>");
        return String.valueOf(MathKt.c(period.getValueInDays()));
    }

    public static final String getRoundedValueInMonths(Period period) {
        Intrinsics.checkNotNullParameter(period, "<this>");
        return String.valueOf(MathKt.c(period.getValueInMonths()));
    }

    public static final String getRoundedValueInWeeks(Period period) {
        Intrinsics.checkNotNullParameter(period, "<this>");
        return String.valueOf(MathKt.c(period.getValueInWeeks()));
    }

    public static final String getRoundedValueInYears(Period period) {
        Intrinsics.checkNotNullParameter(period, "<this>");
        return String.valueOf(MathKt.c(period.getValueInYears()));
    }

    public static final VariableLocalizationKey getPeriodUnitLocalizationKey(Period period) {
        Intrinsics.checkNotNullParameter(period, MHoiDDglUlPJC.jShpNcnEaJD);
        int i3 = WhenMappings.$EnumSwitchMapping$0[period.getUnit().ordinal()];
        if (i3 == 1) {
            return VariableLocalizationKey.DAY;
        }
        if (i3 == 2) {
            return VariableLocalizationKey.WEEK;
        }
        if (i3 == 3) {
            return VariableLocalizationKey.MONTH;
        }
        if (i3 == 4) {
            return VariableLocalizationKey.YEAR;
        }
        if (i3 == 5) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
