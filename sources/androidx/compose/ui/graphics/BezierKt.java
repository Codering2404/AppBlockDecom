package androidx.compose.ui.graphics;

import androidx.collection.FloatFloatPair;
import androidx.compose.ui.graphics.PathSegment;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class BezierKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25666a;

        static {
            int[] iArr = new int[PathSegment.Type.values().length];
            try {
                iArr[PathSegment.Type.f25855a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PathSegment.Type.f25856b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PathSegment.Type.f25857c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PathSegment.Type.f25859f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PathSegment.Type.f25858d.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[PathSegment.Type.f25860g.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[PathSegment.Type.f25861h.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f25666a = iArr;
        }
    }

    public static final long b(float f3, float f4, float f5, float f6, float[] fArr, int i3) {
        float f7 = (f4 - f3) * 3.0f;
        float f8 = (f5 - f4) * 3.0f;
        float f9 = (f6 - f5) * 3.0f;
        int iO = o(f7, f8, f9, fArr, i3);
        float f10 = (f8 - f7) * 2.0f;
        int iQ = iO + q((-f10) / (((f9 - f8) * 2.0f) - f10), fArr, i3 + iO);
        float fMin = Math.min(f3, f6);
        float fMax = Math.max(f3, f6);
        for (int i4 = 0; i4 < iQ; i4++) {
            float f11 = f(f3, f4, f5, f6, fArr[i4]);
            fMin = Math.min(fMin, f11);
            fMax = Math.max(fMax, f11);
        }
        return FloatFloatPair.a(fMin, fMax);
    }

    public static final long c(PathSegment pathSegment, float[] fArr, int i3) {
        int iK = k(pathSegment, true, fArr, i3);
        float fMin = Math.min(pathSegment.a()[0], p(pathSegment));
        float fMax = Math.max(pathSegment.a()[0], p(pathSegment));
        for (int i4 = 0; i4 < iK; i4++) {
            float fI = i(pathSegment, fArr[i4]);
            fMin = Math.min(fMin, fI);
            fMax = Math.max(fMax, fI);
        }
        return FloatFloatPair.a(fMin, fMax);
    }

    public static /* synthetic */ long d(PathSegment pathSegment, float[] fArr, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        return c(pathSegment, fArr, i3);
    }

    public static final float e(float f3, float f4, float f5) {
        return ((((((f3 - f4) + 0.33333334f) * f5) + (f4 - (2.0f * f3))) * f5) + f3) * 3.0f * f5;
    }

    private static final float f(float f3, float f4, float f5, float f6, float f7) {
        float f8 = (f6 + ((f4 - f5) * 3.0f)) - f3;
        return (((((f8 * f7) + (((f5 - (2.0f * f4)) + f3) * 3.0f)) * f7) + ((f4 - f3) * 3.0f)) * f7) + f3;
    }

    private static final float g(float f3, float f4, float f5) {
        return ((f4 - f3) * f5) + f3;
    }

    private static final float h(float f3, float f4, float f5, float f6) {
        return (((((f5 - (f4 * 2.0f)) + f3) * f6) + ((f4 - f3) * 2.0f)) * f6) + f3;
    }

    private static final float i(PathSegment pathSegment, float f3) {
        float[] fArrA = pathSegment.a();
        int i3 = WhenMappings.f25666a[pathSegment.b().ordinal()];
        if (i3 == 1) {
            return fArrA[0];
        }
        if (i3 == 2) {
            return g(fArrA[0], fArrA[2], f3);
        }
        if (i3 == 3) {
            return h(fArrA[0], fArrA[2], fArrA[4], f3);
        }
        if (i3 != 4) {
            return Float.NaN;
        }
        return f(fArrA[0], fArrA[2], fArrA[4], fArrA[6], f3);
    }

    public static final float j(PathSegment pathSegment, float f3) {
        float[] fArrA = pathSegment.a();
        int i3 = WhenMappings.f25666a[pathSegment.b().ordinal()];
        if (i3 == 1) {
            return fArrA[1];
        }
        if (i3 == 2) {
            return g(fArrA[1], fArrA[3], f3);
        }
        if (i3 == 3) {
            return h(fArrA[1], fArrA[3], fArrA[5], f3);
        }
        if (i3 != 4) {
            return Float.NaN;
        }
        return f(fArrA[1], fArrA[3], fArrA[5], fArrA[7], f3);
    }

    private static final int k(PathSegment pathSegment, boolean z2, float[] fArr, int i3) {
        int i4 = !z2 ? 1 : 0;
        float[] fArrA = pathSegment.a();
        int i5 = WhenMappings.f25666a[pathSegment.b().ordinal()];
        if (i5 == 3) {
            float f3 = 2;
            float f4 = fArrA[i4 + 2];
            float f5 = (f4 - fArrA[i4]) * f3;
            return q((-f5) / ((f3 * (fArrA[i4 + 4] - f4)) - f5), fArr, i3);
        }
        if (i5 != 4) {
            return 0;
        }
        float f6 = fArrA[i4 + 2];
        float f7 = (f6 - fArrA[i4]) * 3.0f;
        float f8 = fArrA[i4 + 4];
        float f9 = (f8 - f6) * 3.0f;
        float f10 = (fArrA[i4 + 6] - f8) * 3.0f;
        int iO = o(f7, f9, f10, fArr, i3);
        float f11 = (f9 - f7) * 2.0f;
        return iO + q((-f11) / (((f10 - f9) * 2.0f) - f11), fArr, i3 + iO);
    }

    public static final float l(float f3, float f4, float f5, float f6) {
        float f7;
        float f8;
        double d3 = f3;
        double d4 = ((d3 - (((double) f4) * 2.0d)) + ((double) f5)) * 3.0d;
        double d5 = ((double) (f4 - f3)) * 3.0d;
        double d6 = ((double) (-f3)) + (((double) (f4 - f5)) * 3.0d) + ((double) f6);
        if (Math.abs(d6 - 0.0d) < 1.0E-7d) {
            if (Math.abs(d4 - 0.0d) < 1.0E-7d) {
                if (Math.abs(d5 - 0.0d) < 1.0E-7d) {
                    return Float.NaN;
                }
                float f9 = (float) ((-d3) / d5);
                f7 = f9 >= 0.0f ? f9 : 0.0f;
                f8 = f7 <= 1.0f ? f7 : 1.0f;
                if (Math.abs(f8 - f9) > 1.05E-6f) {
                    return Float.NaN;
                }
                return f8;
            }
            double dSqrt = Math.sqrt((d5 * d5) - ((4.0d * d4) * d3));
            double d7 = d4 * 2.0d;
            float f10 = (float) ((dSqrt - d5) / d7);
            float f11 = f10 < 0.0f ? 0.0f : f10;
            if (f11 > 1.0f) {
                f11 = 1.0f;
            }
            if (Math.abs(f11 - f10) > 1.05E-6f) {
                f11 = Float.NaN;
            }
            if (!Float.isNaN(f11)) {
                return f11;
            }
            float f12 = (float) (((-d5) - dSqrt) / d7);
            f7 = f12 >= 0.0f ? f12 : 0.0f;
            f8 = f7 <= 1.0f ? f7 : 1.0f;
            if (Math.abs(f8 - f12) > 1.05E-6f) {
                return Float.NaN;
            }
            return f8;
        }
        double d8 = d4 / d6;
        double d9 = d5 / d6;
        double d10 = d3 / d6;
        double d11 = ((d9 * 3.0d) - (d8 * d8)) / 9.0d;
        double d12 = (((((2.0d * d8) * d8) * d8) - ((9.0d * d8) * d9)) + (d10 * 27.0d)) / 54.0d;
        double d13 = d11 * d11 * d11;
        double d14 = (d12 * d12) + d13;
        double d15 = d8 / 3.0d;
        if (d14 >= 0.0d) {
            if (d14 != 0.0d) {
                double dSqrt2 = Math.sqrt(d14);
                float fA = (float) (((double) (MathHelpersKt.a((float) ((-d12) + dSqrt2)) - MathHelpersKt.a((float) (d12 + dSqrt2)))) - d15);
                f7 = fA >= 0.0f ? fA : 0.0f;
                f8 = f7 <= 1.0f ? f7 : 1.0f;
                if (Math.abs(f8 - fA) > 1.05E-6f) {
                    return Float.NaN;
                }
                return f8;
            }
            float f13 = -MathHelpersKt.a((float) d12);
            float f14 = (float) d15;
            float f15 = (2.0f * f13) - f14;
            float f16 = f15 < 0.0f ? 0.0f : f15;
            if (f16 > 1.0f) {
                f16 = 1.0f;
            }
            if (Math.abs(f16 - f15) > 1.05E-6f) {
                f16 = Float.NaN;
            }
            if (!Float.isNaN(f16)) {
                return f16;
            }
            float f17 = (-f13) - f14;
            f7 = f17 >= 0.0f ? f17 : 0.0f;
            f8 = f7 <= 1.0f ? f7 : 1.0f;
            if (Math.abs(f8 - f17) > 1.05E-6f) {
                return Float.NaN;
            }
            return f8;
        }
        double dSqrt3 = Math.sqrt(-d13);
        double d16 = (-d12) / dSqrt3;
        if (d16 < -1.0d) {
            d16 = -1.0d;
        }
        if (d16 > 1.0d) {
            d16 = 1.0d;
        }
        double dAcos = Math.acos(d16);
        double dA = MathHelpersKt.a((float) dSqrt3) * 2.0f;
        float fCos = (float) ((Math.cos(dAcos / 3.0d) * dA) - d15);
        float f18 = fCos < 0.0f ? 0.0f : fCos;
        if (f18 > 1.0f) {
            f18 = 1.0f;
        }
        if (Math.abs(f18 - fCos) > 1.05E-6f) {
            f18 = Float.NaN;
        }
        if (!Float.isNaN(f18)) {
            return f18;
        }
        float fCos2 = (float) ((Math.cos((6.283185307179586d + dAcos) / 3.0d) * dA) - d15);
        float f19 = fCos2 < 0.0f ? 0.0f : fCos2;
        if (f19 > 1.0f) {
            f19 = 1.0f;
        }
        if (Math.abs(f19 - fCos2) > 1.05E-6f) {
            f19 = Float.NaN;
        }
        if (!Float.isNaN(f19)) {
            return f19;
        }
        float fCos3 = (float) ((dA * Math.cos((dAcos + 12.566370614359172d) / 3.0d)) - d15);
        f7 = fCos3 >= 0.0f ? fCos3 : 0.0f;
        f8 = f7 <= 1.0f ? f7 : 1.0f;
        if (Math.abs(f8 - fCos3) > 1.05E-6f) {
            return Float.NaN;
        }
        return f8;
    }

    private static final float m(float f3, float f4, float f5) {
        float f6;
        float f7;
        double d3 = f3;
        double d4 = f4;
        double d5 = f5;
        double d6 = d4 * 2.0d;
        double d7 = (d3 - d6) + d5;
        if (d7 == 0.0d) {
            if (d4 == d5) {
                return Float.NaN;
            }
            float f8 = (float) ((d6 - d5) / (d6 - (d5 * 2.0d)));
            f6 = f8 >= 0.0f ? f8 : 0.0f;
            f7 = f6 <= 1.0f ? f6 : 1.0f;
            if (Math.abs(f7 - f8) > 1.05E-6f) {
                return Float.NaN;
            }
            return f7;
        }
        double d8 = -Math.sqrt((d4 * d4) - (d5 * d3));
        double d9 = (-d3) + d4;
        float f9 = (float) ((-(d8 + d9)) / d7);
        float f10 = f9 < 0.0f ? 0.0f : f9;
        if (f10 > 1.0f) {
            f10 = 1.0f;
        }
        if (Math.abs(f10 - f9) > 1.05E-6f) {
            f10 = Float.NaN;
        }
        if (!Float.isNaN(f10)) {
            return f10;
        }
        float f11 = (float) ((d8 - d9) / d7);
        f6 = f11 >= 0.0f ? f11 : 0.0f;
        f7 = f6 <= 1.0f ? f6 : 1.0f;
        if (Math.abs(f7 - f11) > 1.05E-6f) {
            return Float.NaN;
        }
        return f7;
    }

    public static final float n(PathSegment pathSegment, float f3) {
        float[] fArrA = pathSegment.a();
        switch (WhenMappings.f25666a[pathSegment.b().ordinal()]) {
            case 1:
                return Float.NaN;
            case 2:
                float f4 = fArrA[0] - f3;
                float f5 = (-f4) / ((fArrA[2] - f3) - f4);
                float f6 = f5 >= 0.0f ? f5 : 0.0f;
                if (f6 > 1.0f) {
                    f6 = 1.0f;
                }
                if (Math.abs(f6 - f5) > 1.05E-6f) {
                    return Float.NaN;
                }
                return f6;
            case 3:
                return m(fArrA[0] - f3, fArrA[2] - f3, fArrA[4] - f3);
            case 4:
                return l(fArrA[0] - f3, fArrA[2] - f3, fArrA[4] - f3, fArrA[6] - f3);
            case 5:
            case 6:
            case 7:
                return Float.NaN;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final int o(float f3, float f4, float f5, float[] fArr, int i3) {
        double d3 = f3;
        double d4 = f4;
        double d5 = f5;
        double d6 = d4 * 2.0d;
        double d7 = (d3 - d6) + d5;
        if (d7 == 0.0d) {
            if (d4 == d5) {
                return 0;
            }
            return q((float) ((d6 - d5) / (d6 - (d5 * 2.0d))), fArr, i3);
        }
        double d8 = -Math.sqrt((d4 * d4) - (d5 * d3));
        double d9 = (-d3) + d4;
        int iQ = q((float) ((-(d8 + d9)) / d7), fArr, i3);
        int iQ2 = iQ + q((float) ((d8 - d9) / d7), fArr, i3 + iQ);
        if (iQ2 <= 1) {
            return iQ2;
        }
        float f6 = fArr[i3];
        int i4 = i3 + 1;
        float f7 = fArr[i4];
        if (f6 <= f7) {
            return f6 == f7 ? iQ2 - 1 : iQ2;
        }
        fArr[i3] = f7;
        fArr[i4] = f6;
        return iQ2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final float p(androidx.compose.ui.graphics.PathSegment r3) {
        /*
            float[] r0 = r3.a()
            androidx.compose.ui.graphics.PathSegment$Type r3 = r3.b()
            int[] r1 = androidx.compose.ui.graphics.BezierKt.WhenMappings.f25666a
            int r3 = r3.ordinal()
            r3 = r1[r3]
            r1 = 2
            if (r3 == r1) goto L21
            r1 = 3
            r2 = 4
            if (r3 == r1) goto L1e
            if (r3 == r2) goto L20
            r1 = 5
            if (r3 == r1) goto L1e
            r1 = 0
            goto L21
        L1e:
            r1 = r2
            goto L21
        L20:
            r1 = 6
        L21:
            r3 = r0[r1]
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.BezierKt.p(androidx.compose.ui.graphics.PathSegment):float");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int q(float f3, float[] fArr, int i3) {
        float f4 = f3 >= 0.0f ? f3 : 0.0f;
        if (f4 > 1.0f) {
            f4 = 1.0f;
        }
        if (Math.abs(f4 - f3) > 1.05E-6f) {
            f4 = Float.NaN;
        }
        fArr[i3] = f4;
        return !Float.isNaN(f4) ? 1 : 0;
    }
}
