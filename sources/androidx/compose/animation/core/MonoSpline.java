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
public final class MonoSpline {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f4015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[][] f4016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float[][] f4017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f4018d;

    public MonoSpline(float[] fArr, float[][] fArr2, float f3) {
        int i3;
        int length = fArr.length;
        int i4 = 0;
        int length2 = fArr2[0].length;
        this.f4018d = new float[length2];
        int i5 = length - 1;
        float[][] fArrD = d(i5, length2);
        float[][] fArrD2 = d(length, length2);
        for (int i6 = 0; i6 < length2; i6++) {
            int i7 = 0;
            while (i7 < i5) {
                int i8 = i7 + 1;
                float f4 = fArr[i8] - fArr[i7];
                float[] fArr3 = fArrD[i7];
                float f5 = (fArr2[i8][i6] - fArr2[i7][i6]) / f4;
                fArr3[i6] = f5;
                if (i7 == 0) {
                    fArrD2[i7][i6] = f5;
                } else {
                    fArrD2[i7][i6] = (fArrD[i7 - 1][i6] + f5) * 0.5f;
                }
                i7 = i8;
            }
            fArrD2[i5][i6] = fArrD[length - 2][i6];
        }
        if (!Float.isNaN(f3)) {
            for (int i9 = 0; i9 < length2; i9++) {
                float[] fArr4 = fArrD[length - 2];
                float f6 = fArr4[i9] * (1 - f3);
                float[] fArr5 = fArrD[0];
                float f7 = f6 + (fArr5[i9] * f3);
                fArr5[i9] = f7;
                fArr4[i9] = f7;
                fArrD2[i5][i9] = f7;
                fArrD2[0][i9] = f7;
            }
        }
        int i10 = 0;
        while (i10 < i5) {
            int i11 = i4;
            while (i11 < length2) {
                float f8 = fArrD[i10][i11];
                if (f8 == 0.0f) {
                    fArrD2[i10][i11] = 0.0f;
                    fArrD2[i10 + 1][i11] = 0.0f;
                    i3 = length2;
                } else {
                    float f9 = fArrD2[i10][i11] / f8;
                    int i12 = i10 + 1;
                    float f10 = fArrD2[i12][i11] / f8;
                    i3 = length2;
                    float fHypot = (float) Math.hypot(f9, f10);
                    if (fHypot > 9.0d) {
                        float f11 = 3.0f / fHypot;
                        float[] fArr6 = fArrD2[i10];
                        float[] fArr7 = fArrD[i10];
                        fArr6[i11] = f9 * f11 * fArr7[i11];
                        fArrD2[i12][i11] = f11 * f10 * fArr7[i11];
                    }
                }
                i11++;
                length2 = i3;
            }
            i10++;
            i4 = 0;
        }
        this.f4015a = fArr;
        this.f4016b = fArr2;
        this.f4017c = fArrD2;
    }

    private final void c(float f3, float[] fArr) {
        int length = this.f4016b[0].length;
        float[] fArr2 = this.f4015a;
        int length2 = fArr2.length;
        float f4 = fArr2[0];
        int i3 = length2 - 1;
        float f5 = fArr2[i3];
        if (f3 < f4) {
            f3 = f4;
        }
        if (f3 <= f5) {
            f5 = f3;
        }
        if (fArr.length < length) {
            return;
        }
        int i4 = 0;
        while (i4 < i3) {
            float[] fArr3 = this.f4015a;
            int i5 = i4 + 1;
            float f6 = fArr3[i5];
            if (f5 <= f6) {
                float f7 = fArr3[i4];
                float f8 = f6 - f7;
                float f9 = (f5 - f7) / f8;
                for (int i6 = 0; i6 < length; i6++) {
                    float[][] fArr4 = this.f4016b;
                    float f10 = fArr4[i4][i6];
                    float f11 = fArr4[i5][i6];
                    float[][] fArr5 = this.f4017c;
                    fArr[i6] = MonoSplineKt.a(f8, f9, f10, f11, fArr5[i4][i6], fArr5[i5][i6]) / f8;
                }
                return;
            }
            i4 = i5;
        }
    }

    private final float[][] d(int i3, int i4) {
        float[][] fArr = new float[i3][];
        for (int i5 = 0; i5 < i3; i5++) {
            fArr[i5] = new float[i4];
        }
        return fArr;
    }

    public final void a(float f3, AnimationVector animationVector, int i3) {
        int i4;
        float[] fArr = this.f4015a;
        int length = fArr.length;
        int i5 = 0;
        int length2 = this.f4016b[0].length;
        if (f3 <= fArr[0]) {
            i4 = 0;
        } else {
            i4 = length - 1;
            if (f3 < fArr[i4]) {
                i4 = -1;
            }
        }
        if (i4 != -1) {
            c(fArr[i4], this.f4018d);
            while (i5 < length2) {
                animationVector.e(i5, this.f4016b[i4][i5] + ((f3 - this.f4015a[i4]) * this.f4018d[i5]));
                i5++;
            }
            return;
        }
        int i6 = length - 1;
        int i7 = i3;
        while (i7 < i6) {
            float[] fArr2 = this.f4015a;
            float f4 = fArr2[i7];
            if (f3 == f4) {
                while (i5 < length2) {
                    animationVector.e(i5, this.f4016b[i7][i5]);
                    i5++;
                }
                return;
            }
            int i8 = i7 + 1;
            float f5 = fArr2[i8];
            if (f3 < f5) {
                float f6 = f5 - f4;
                float f7 = (f3 - f4) / f6;
                while (i5 < length2) {
                    float[][] fArr3 = this.f4016b;
                    float f8 = fArr3[i7][i5];
                    float f9 = fArr3[i8][i5];
                    float[][] fArr4 = this.f4017c;
                    animationVector.e(i5, MonoSplineKt.b(f6, f7, f8, f9, fArr4[i7][i5], fArr4[i8][i5]));
                    i5++;
                }
                return;
            }
            i7 = i8;
        }
    }

    public final void b(float f3, AnimationVector animationVector, int i3) {
        int i4;
        float[] fArr = this.f4015a;
        float[][] fArr2 = this.f4016b;
        float[][] fArr3 = this.f4017c;
        int length = fArr.length;
        int i5 = 0;
        int length2 = fArr2[0].length;
        if (f3 <= fArr[0]) {
            i4 = 0;
        } else {
            i4 = length - 1;
            if (f3 < fArr[i4]) {
                i4 = -1;
            }
        }
        if (i4 != -1) {
            float[] fArr4 = fArr3[i4];
            if (fArr4.length < length2) {
                return;
            }
            while (i5 < length2) {
                animationVector.e(i5, fArr4[i5]);
                i5++;
            }
            return;
        }
        int i6 = length - 1;
        int i7 = i3;
        while (i7 < i6) {
            int i8 = i7 + 1;
            float f4 = fArr[i8];
            if (f3 <= f4) {
                float f5 = fArr[i7];
                float f6 = f4 - f5;
                float f7 = (f3 - f5) / f6;
                while (i5 < length2) {
                    animationVector.e(i5, MonoSplineKt.a(f6, f7, fArr2[i7][i5], fArr2[i8][i5], fArr3[i7][i5], fArr3[i8][i5]) / f6);
                    i5++;
                }
                return;
            }
            i7 = i8;
        }
    }
}
