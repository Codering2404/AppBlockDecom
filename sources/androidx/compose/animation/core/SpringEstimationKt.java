package androidx.compose.animation.core;

import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SpringEstimationKt {
    public static final long a(double d3, double d4, double d5, double d6, double d7) {
        double dSqrt = 2.0d * d4 * Math.sqrt(d3);
        double d8 = (dSqrt * dSqrt) - (4.0d * d3);
        double dSqrt2 = d8 < 0.0d ? 0.0d : Math.sqrt(d8);
        double d9 = -dSqrt;
        return d((d9 + dSqrt2) * 0.5d, (d8 < 0.0d ? Math.sqrt(Math.abs(d8)) : 0.0d) * 0.5d, (d9 - dSqrt2) * 0.5d, d4, d5, d6, d7);
    }

    public static final long b(float f3, float f4, float f5, float f6, float f7) {
        if (f4 == 0.0f) {
            return 9223372036854L;
        }
        return a(f3, f4, f5, f6, f7);
    }

    private static final double c(double d3, double d4, double d5, double d6) {
        double d7 = d6;
        double d8 = d3 * d4;
        double d9 = d5 - d8;
        double dLog = Math.log(Math.abs(d7 / d4)) / d3;
        double dLog2 = Math.log(Math.abs(d7 / d9));
        int i3 = 0;
        double dLog3 = dLog2;
        for (int i4 = 0; i4 < 6; i4++) {
            dLog3 = dLog2 - Math.log(Math.abs(dLog3 / d3));
        }
        double d10 = dLog3 / d3;
        if (!((Double.doubleToRawLongBits(dLog) & Long.MAX_VALUE) < 9218868437227405312L)) {
            dLog = d10;
        } else if ((Double.doubleToRawLongBits(d10) & Long.MAX_VALUE) < 9218868437227405312L) {
            dLog = Math.max(dLog, d10);
        }
        double d11 = (-(d8 + d9)) / (d3 * d9);
        double d12 = d3 * d11;
        double dExp = (Math.exp(d12) * d4) + (d9 * d11 * Math.exp(d12));
        if (Double.isNaN(d11) || d11 <= 0.0d) {
            d7 = -d7;
        } else if (d11 <= 0.0d || (-dExp) >= d7) {
            dLog = (-(2.0d / d3)) - (d4 / d9);
        } else {
            if (d9 < 0.0d && d4 > 0.0d) {
                dLog = 0.0d;
            }
            d7 = -d7;
        }
        double dAbs = Double.MAX_VALUE;
        while (dAbs > 0.001d && i3 < 100) {
            i3++;
            double d13 = d3 * dLog;
            double d14 = d7;
            double dExp2 = dLog - ((((d4 + (d9 * dLog)) * Math.exp(d13)) + d7) / ((((((double) 1) + d13) * d9) + d8) * Math.exp(d13)));
            dAbs = Math.abs(dLog - dExp2);
            dLog = dExp2;
            d7 = d14;
        }
        return dLog;
    }

    private static final long d(double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        double d10 = d7;
        if (d8 == 0.0d && d10 == 0.0d) {
            return 0L;
        }
        if (d8 < 0.0d) {
            d10 = -d10;
        }
        double d11 = d10;
        double dAbs = Math.abs(d8);
        return (long) ((d6 > 1.0d ? e(d3, d5, dAbs, d11, d9) : d6 < 1.0d ? g(d3, d4, dAbs, d11, d9) : c(d3, dAbs, d11, d9)) * 1000.0d);
    }

    private static final double e(double d3, double d4, double d5, double d6, double d7) {
        double d8 = d7;
        double d9 = d3 - d4;
        double d10 = ((d3 * d5) - d6) / d9;
        double d11 = d5 - d10;
        double dLog = Math.log(Math.abs(d8 / d11)) / d3;
        double dLog2 = Math.log(Math.abs(d8 / d10)) / d4;
        if ((Double.doubleToRawLongBits(dLog) & Long.MAX_VALUE) < 9218868437227405312L) {
            if ((Double.doubleToRawLongBits(dLog2) & Long.MAX_VALUE) < 9218868437227405312L) {
                dLog = Math.max(dLog, dLog2);
            }
        } else {
            dLog = dLog2;
        }
        double d12 = d11 * d3;
        double dLog3 = Math.log(d12 / ((-d10) * d4)) / (d4 - d3);
        if (Double.isNaN(dLog3) || dLog3 <= 0.0d) {
            d8 = -d8;
        } else if (dLog3 <= 0.0d || (-f(d11, d3, dLog3, d10, d4)) >= d8) {
            dLog = Math.log((-((d10 * d4) * d4)) / (d12 * d3)) / d9;
        } else {
            if (d10 > 0.0d && d11 < 0.0d) {
                dLog = 0.0d;
            }
            d8 = -d8;
        }
        double d13 = d10 * d4;
        if (Math.abs((Math.exp(d3 * dLog) * d12) + (Math.exp(d4 * dLog) * d13)) < 1.0E-4d) {
            return dLog;
        }
        double dAbs = Double.MAX_VALUE;
        int i3 = 0;
        while (dAbs > 0.001d && i3 < 100) {
            i3++;
            double d14 = d3 * dLog;
            double d15 = d4 * dLog;
            double dExp = dLog - ((((Math.exp(d14) * d11) + (Math.exp(d15) * d10)) + d8) / ((Math.exp(d14) * d12) + (Math.exp(d15) * d13)));
            dAbs = Math.abs(dLog - dExp);
            dLog = dExp;
        }
        return dLog;
    }

    private static final double f(double d3, double d4, double d5, double d6, double d7) {
        return (d3 * Math.exp(d4 * d5)) + (d6 * Math.exp(d7 * d5));
    }

    private static final double g(double d3, double d4, double d5, double d6, double d7) {
        double d8 = (d6 - (d3 * d5)) / d4;
        return Math.log(d7 / Math.sqrt((d5 * d5) + (d8 * d8))) / d3;
    }
}
