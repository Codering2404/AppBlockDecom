package com.revenuecat.purchases.ui.revenuecatui.data.processed;

import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PackageType;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKey;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

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
public final class PackagePeriodExtensionsKt {

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

    public static final VariableLocalizationKey getPeriodUnitAbbreviatedLocalizationKey(Package r12) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        if (isLifetime(r12)) {
            return VariableLocalizationKey.LIFETIME;
        }
        Period period = r12.getProduct().getPeriod();
        if (period != null) {
            return PeriodExtensionsKt.getPeriodUnitAbbreviatedLocalizationKey(period);
        }
        return null;
    }

    public static final VariableLocalizationKey getPeriodUnitLocalizationKey(Package r12) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        if (isLifetime(r12)) {
            return VariableLocalizationKey.LIFETIME;
        }
        Period period = r12.getProduct().getPeriod();
        if (period != null) {
            return PeriodExtensionsKt.getPeriodUnitLocalizationKey(period);
        }
        return null;
    }

    public static final String getStringOrLogError(Map<VariableLocalizationKey, String> map, VariableLocalizationKey key) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        String str = map.get(key);
        if (str == null) {
            Logger.INSTANCE.e("Could not find localized string for variable key: " + key);
        }
        return str;
    }

    public static final boolean isLifetime(Package r12) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        return r12.getPackageType() == PackageType.LIFETIME;
    }

    public static final String productPeriod(Package r4, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        Period period = r4.getProduct().getPeriod();
        if (isLifetime(r4)) {
            return getStringOrLogError(localizedVariableKeys, VariableLocalizationKey.LIFETIME);
        }
        if (period == null) {
            return null;
        }
        if (period.getValue() <= 1) {
            VariableLocalizationKey periodUnitLocalizationKey = getPeriodUnitLocalizationKey(r4);
            if (periodUnitLocalizationKey != null) {
                return getStringOrLogError(localizedVariableKeys, periodUnitLocalizationKey);
            }
            return null;
        }
        String stringOrLogError = getStringOrLogError(localizedVariableKeys, PeriodExtensionsKt.getPeriodValueWithUnitLocalizationKey(period));
        if (stringOrLogError == null) {
            return null;
        }
        String str = String.format(stringOrLogError, Arrays.copyOf(new Object[]{Integer.valueOf(period.getValue())}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final String productPeriodAbbreviated(Package r4, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        String stringOrLogError;
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        Period period = r4.getProduct().getPeriod();
        if (isLifetime(r4)) {
            return getStringOrLogError(localizedVariableKeys, VariableLocalizationKey.LIFETIME);
        }
        if (period == null) {
            return null;
        }
        if (period.getValue() <= 1) {
            VariableLocalizationKey periodUnitAbbreviatedLocalizationKey = getPeriodUnitAbbreviatedLocalizationKey(r4);
            if (periodUnitAbbreviatedLocalizationKey != null) {
                return getStringOrLogError(localizedVariableKeys, periodUnitAbbreviatedLocalizationKey);
            }
            return null;
        }
        VariableLocalizationKey periodValueWithUnitAbbreviatedLocalizationKey = PeriodExtensionsKt.getPeriodValueWithUnitAbbreviatedLocalizationKey(period);
        if (periodValueWithUnitAbbreviatedLocalizationKey == null || (stringOrLogError = getStringOrLogError(localizedVariableKeys, periodValueWithUnitAbbreviatedLocalizationKey)) == null) {
            return null;
        }
        String str = String.format(stringOrLogError, Arrays.copyOf(new Object[]{Integer.valueOf(period.getValue())}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final String productPeriodWithUnit(Package r2, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        String stringOrLogError;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        if (isLifetime(r2)) {
            return getStringOrLogError(localizedVariableKeys, VariableLocalizationKey.LIFETIME);
        }
        Period period = r2.getProduct().getPeriod();
        if (period == null || (stringOrLogError = getStringOrLogError(localizedVariableKeys, PeriodExtensionsKt.getPeriodValueWithUnitLocalizationKey(period))) == null) {
            return null;
        }
        String str = String.format(stringOrLogError, Arrays.copyOf(new Object[]{Integer.valueOf(period.getValue())}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final String productPeriodly(Package r3, Map<VariableLocalizationKey, String> localizedVariableKeys) {
        VariableLocalizationKey variableLocalizationKey;
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(localizedVariableKeys, "localizedVariableKeys");
        Period period = r3.getProduct().getPeriod();
        if (isLifetime(r3)) {
            return getStringOrLogError(localizedVariableKeys, VariableLocalizationKey.LIFETIME);
        }
        if (period == null) {
            return null;
        }
        if (period.getValue() > 1) {
            String stringOrLogError = getStringOrLogError(localizedVariableKeys, PeriodExtensionsKt.getPeriodValueWithUnitLocalizationKey(period));
            if (stringOrLogError == null) {
                return null;
            }
            String str = String.format(stringOrLogError, Arrays.copyOf(new Object[]{Integer.valueOf(period.getValue())}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        }
        int i3 = WhenMappings.$EnumSwitchMapping$0[period.getUnit().ordinal()];
        if (i3 == 1) {
            variableLocalizationKey = VariableLocalizationKey.DAILY;
        } else if (i3 == 2) {
            variableLocalizationKey = VariableLocalizationKey.WEEKLY;
        } else if (i3 == 3) {
            variableLocalizationKey = VariableLocalizationKey.MONTHLY;
        } else if (i3 == 4) {
            variableLocalizationKey = VariableLocalizationKey.YEARLY;
        } else {
            if (i3 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            variableLocalizationKey = null;
        }
        if (variableLocalizationKey != null) {
            return getStringOrLogError(localizedVariableKeys, variableLocalizationKey);
        }
        return null;
    }
}
