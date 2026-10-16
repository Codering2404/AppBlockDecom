package com.revenuecat.purchases.ui.revenuecatui.helpers;

import androidx.compose.ui.graphics.Color;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ColorComputationHelpersKt {
    public static final double colorDistance(Triple<Double, Double, Double> color1, Triple<Double, Double, Double> color2) {
        Intrinsics.checkNotNullParameter(color1, "color1");
        Intrinsics.checkNotNullParameter(color2, "color2");
        double dDoubleValue = ((Number) color1.a()).doubleValue();
        double dDoubleValue2 = ((Number) color1.b()).doubleValue();
        double dDoubleValue3 = ((Number) color1.c()).doubleValue();
        double d3 = 2;
        return Math.sqrt(Math.pow(dDoubleValue - ((Number) color2.a()).doubleValue(), d3) + Math.pow(dDoubleValue2 - ((Number) color2.b()).doubleValue(), d3) + Math.pow(dDoubleValue3 - ((Number) color2.c()).doubleValue(), d3));
    }

    /* JADX INFO: renamed from: contrastRatio--OWjLjI, reason: not valid java name */
    public static final double m1166contrastRatioOWjLjI(long j3, long j4) {
        double dM1167relativeLuminance8_81llA = m1167relativeLuminance8_81llA(j3);
        double dM1167relativeLuminance8_81llA2 = m1167relativeLuminance8_81llA(j4);
        return (Math.max(dM1167relativeLuminance8_81llA, dM1167relativeLuminance8_81llA2) + 0.05d) / (Math.min(dM1167relativeLuminance8_81llA, dM1167relativeLuminance8_81llA2) + 0.05d);
    }

    /* JADX INFO: renamed from: relativeLuminance-8_81llA, reason: not valid java name */
    public static final double m1167relativeLuminance8_81llA(long j3) {
        return (relativeLuminance_8_81llA$adjust(Color.y(j3)) * 0.2126d) + (relativeLuminance_8_81llA$adjust(Color.x(j3)) * 0.7152d) + (relativeLuminance_8_81llA$adjust(Color.v(j3)) * 0.0722d);
    }

    private static final double relativeLuminance_8_81llA$adjust(float f3) {
        return f3 <= 0.03928f ? ((double) f3) / 12.92d : Math.pow((((double) f3) + 0.055d) / 1.055d, 2.4d);
    }

    /* JADX INFO: renamed from: selectColorWithBestContrast-4WTKRHQ, reason: not valid java name */
    public static final Color m1168selectColorWithBestContrast4WTKRHQ(List<Color> from, long j3) {
        Object obj;
        Intrinsics.checkNotNullParameter(from, "from");
        Iterator<T> it = from.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            if (it.hasNext()) {
                double dM1166contrastRatioOWjLjI = m1166contrastRatioOWjLjI(((Color) next).B(), j3);
                do {
                    Object next2 = it.next();
                    double dM1166contrastRatioOWjLjI2 = m1166contrastRatioOWjLjI(((Color) next2).B(), j3);
                    if (Double.compare(dM1166contrastRatioOWjLjI, dM1166contrastRatioOWjLjI2) < 0) {
                        next = next2;
                        dM1166contrastRatioOWjLjI = dM1166contrastRatioOWjLjI2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        } else {
            obj = null;
        }
        return (Color) obj;
    }
}
