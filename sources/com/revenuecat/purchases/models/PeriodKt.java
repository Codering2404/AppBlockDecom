package com.revenuecat.purchases.models;

import com.revenuecat.purchases.models.Period;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class PeriodKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Period.Unit.values().length];
            try {
                iArr[Period.Unit.YEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Period.Unit.MONTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Period.Unit.WEEK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Period.Unit.DAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Period.Unit.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Pair<Integer, Period.Unit> toPeriod(String str) {
        double d3;
        double d4;
        double d5;
        MatchResult matchResultJ = new Regex("^P(?!$)(\\d+(?:\\.\\d+)?Y)?(\\d+(?:\\.\\d+)?M)?(\\d+(?:\\.\\d+)?W)?(\\d+(?:\\.\\d+)?D)?$").j(str);
        if (matchResultJ == null) {
            return new Pair<>(0, Period.Unit.UNKNOWN);
        }
        PeriodKt$toPeriod$1$toInt$1 periodKt$toPeriod$1$toInt$1 = new Function1<String, Integer>() { // from class: com.revenuecat.purchases.models.PeriodKt$toPeriod$1$toInt$1
            @Override // kotlin.jvm.functions.Function1
            public final Integer invoke(String part) {
                Intrinsics.checkNotNullParameter(part, "part");
                Integer numU = StringsKt.u(StringsKt.x1(part, 1));
                return Integer.valueOf(numU != null ? numU.intValue() : 0);
            }
        };
        MatchResult.Destructured destructuredA = matchResultJ.a();
        String str2 = (String) destructuredA.a().b().get(1);
        String str3 = (String) destructuredA.a().b().get(2);
        String str4 = (String) destructuredA.a().b().get(3);
        String str5 = (String) destructuredA.a().b().get(4);
        int iIntValue = ((Number) periodKt$toPeriod$1$toInt$1.invoke((Object) str2)).intValue();
        int iIntValue2 = ((Number) periodKt$toPeriod$1$toInt$1.invoke((Object) str3)).intValue();
        int iIntValue3 = ((Number) periodKt$toPeriod$1$toInt$1.invoke((Object) str4)).intValue();
        int iIntValue4 = ((Number) periodKt$toPeriod$1$toInt$1.invoke((Object) str5)).intValue();
        Period.Unit unit = iIntValue4 > 0 ? Period.Unit.DAY : iIntValue3 > 0 ? Period.Unit.WEEK : iIntValue2 > 0 ? Period.Unit.MONTH : iIntValue > 0 ? Period.Unit.YEAR : Period.Unit.UNKNOWN;
        int i3 = WhenMappings.$EnumSwitchMapping$0[unit.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                d4 = ((double) iIntValue) * 12.0d;
                d5 = iIntValue2;
            } else if (i3 == 3) {
                d4 = (((double) iIntValue) * 52.142857142857146d) + (((double) iIntValue2) * 4.345238095238096d);
                d5 = iIntValue3;
            } else if (i3 == 4) {
                d4 = (((double) iIntValue) * 365.0d) + (((double) iIntValue2) * 30.0d) + (((double) iIntValue3) * 7.0d);
                d5 = iIntValue4;
            } else {
                if (i3 != 5) {
                    throw new NoWhenBranchMatchedException();
                }
                d3 = 0.0d;
            }
            d3 = d4 + d5;
        } else {
            d3 = iIntValue;
        }
        return new Pair<>(Integer.valueOf(MathKt.c(d3)), unit);
    }
}
