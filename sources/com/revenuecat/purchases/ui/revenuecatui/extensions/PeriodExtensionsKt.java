package com.revenuecat.purchases.ui.revenuecatui.extensions;

import android.icu.text.MeasureFormat;
import android.icu.util.Measure;
import android.icu.util.MeasureUnit;
import com.facebook.appevents.AppEventsConstants;
import com.revenuecat.purchases.models.Period;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final /* synthetic */ class PeriodExtensionsKt {

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

    public static final /* synthetic */ MeasureUnit getMeasureUnit(Period.Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "<this>");
        int i3 = WhenMappings.$EnumSwitchMapping$0[unit.ordinal()];
        if (i3 == 1) {
            return MeasureUnit.DAY;
        }
        if (i3 == 2) {
            return MeasureUnit.WEEK;
        }
        if (i3 == 3) {
            return MeasureUnit.MONTH;
        }
        if (i3 == 4) {
            return MeasureUnit.YEAR;
        }
        if (i3 == 5) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final String localized(Period period, Locale locale, MeasureFormat.FormatWidth formatWidth) {
        String strLocalizedPeriod = localizedPeriod(period, locale, formatWidth);
        if (period.getValue() != 1 || !StringsKt.U(strLocalizedPeriod, AppEventsConstants.EVENT_PARAM_VALUE_YES, false, 2, null)) {
            return strLocalizedPeriod;
        }
        String strSubstring = strLocalizedPeriod.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return StringsKt.t1(strSubstring).toString();
    }

    public static final /* synthetic */ String localizedAbbreviatedPeriod(Period period, Locale locale) {
        Intrinsics.checkNotNullParameter(period, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return localized(period, locale, MeasureFormat.FormatWidth.SHORT);
    }

    public static final /* synthetic */ String localizedPeriod(Period period, Locale locale, MeasureFormat.FormatWidth formatWidth) {
        Intrinsics.checkNotNullParameter(period, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(formatWidth, "formatWidth");
        String str = MeasureFormat.getInstance(locale, formatWidth).format(new Measure(Integer.valueOf(period.getValue()), getMeasureUnit(period.getUnit())));
        Intrinsics.checkNotNullExpressionValue(str, "getInstance(locale, form… unit.measureUnit),\n    )");
        return str;
    }

    public static /* synthetic */ String localizedPeriod$default(Period period, Locale locale, MeasureFormat.FormatWidth formatWidth, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            formatWidth = MeasureFormat.FormatWidth.WIDE;
        }
        return localizedPeriod(period, locale, formatWidth);
    }

    public static final /* synthetic */ String localizedUnitPeriod(Period period, Locale locale) {
        Intrinsics.checkNotNullParameter(period, "<this>");
        Intrinsics.checkNotNullParameter(locale, "locale");
        return localized(period, locale, MeasureFormat.FormatWidth.WIDE);
    }
}
