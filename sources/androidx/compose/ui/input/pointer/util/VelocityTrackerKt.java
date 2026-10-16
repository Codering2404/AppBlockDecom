package androidx.compose.ui.input.pointer.util;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.HistoricalChange;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.internal.InlineClassHelperKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;

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
public final class VelocityTrackerKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f26999a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f27000b;

    public static final void c(VelocityTracker velocityTracker, PointerInputChange pointerInputChange) {
        if (f26999a) {
            e(velocityTracker, pointerInputChange);
        } else {
            d(velocityTracker, pointerInputChange);
        }
    }

    private static final void d(VelocityTracker velocityTracker, PointerInputChange pointerInputChange) {
        if (PointerEventKt.b(pointerInputChange)) {
            velocityTracker.g(pointerInputChange.h());
            velocityTracker.f();
        }
        long jK = pointerInputChange.k();
        List listE = pointerInputChange.e();
        int size = listE.size();
        int i3 = 0;
        while (i3 < size) {
            HistoricalChange historicalChange = (HistoricalChange) listE.get(i3);
            long jP = Offset.p(historicalChange.b(), jK);
            long jB = historicalChange.b();
            velocityTracker.g(Offset.q(velocityTracker.d(), jP));
            velocityTracker.a(historicalChange.c(), velocityTracker.d());
            i3++;
            jK = jB;
        }
        velocityTracker.g(Offset.q(velocityTracker.d(), Offset.p(pointerInputChange.h(), jK)));
        velocityTracker.a(pointerInputChange.o(), velocityTracker.d());
    }

    private static final void e(VelocityTracker velocityTracker, PointerInputChange pointerInputChange) {
        if (PointerEventKt.b(pointerInputChange)) {
            velocityTracker.f();
        }
        if (!PointerEventKt.d(pointerInputChange)) {
            List listE = pointerInputChange.e();
            int size = listE.size();
            for (int i3 = 0; i3 < size; i3++) {
                HistoricalChange historicalChange = (HistoricalChange) listE.get(i3);
                velocityTracker.a(historicalChange.c(), historicalChange.a());
            }
            velocityTracker.a(pointerInputChange.o(), pointerInputChange.g());
        }
        if (PointerEventKt.d(pointerInputChange) && pointerInputChange.o() - velocityTracker.e() > 40) {
            velocityTracker.f();
        }
        velocityTracker.h(pointerInputChange.o());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float f(float[] fArr, float[] fArr2, int i3, boolean z2) {
        int i4 = i3 - 1;
        float f3 = fArr2[i4];
        float fSignum = 0.0f;
        int i5 = i4;
        while (i5 > 0) {
            int i6 = i5 - 1;
            float f4 = fArr2[i6];
            if (f3 != f4) {
                float f5 = (z2 ? -fArr[i6] : fArr[i5] - fArr[i6]) / (f3 - f4);
                fSignum += (f5 - (Math.signum(fSignum) * ((float) Math.sqrt(2 * Math.abs(fSignum))))) * Math.abs(f5);
                if (i5 == i4) {
                    fSignum *= 0.5f;
                }
            }
            i5--;
            f3 = f4;
        }
        return Math.signum(fSignum) * ((float) Math.sqrt(2 * Math.abs(fSignum)));
    }

    private static final float g(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        float f3 = 0.0f;
        for (int i3 = 0; i3 < length; i3++) {
            f3 += fArr[i3] * fArr2[i3];
        }
        return f3;
    }

    public static final boolean h() {
        return f27000b;
    }

    public static final float[] i(float[] fArr, float[] fArr2, int i3, int i4, float[] fArr3) {
        int i5 = i4;
        if (i5 < 1) {
            InlineClassHelperKt.a("The degree must be at positive integer");
        }
        if (i3 == 0) {
            InlineClassHelperKt.a("At least one point must be provided");
        }
        if (i5 >= i3) {
            i5 = i3 - 1;
        }
        int i6 = i5 + 1;
        float[][] fArr4 = new float[i6][];
        for (int i7 = 0; i7 < i6; i7++) {
            fArr4[i7] = new float[i3];
        }
        for (int i8 = 0; i8 < i3; i8++) {
            fArr4[0][i8] = 1.0f;
            for (int i9 = 1; i9 < i6; i9++) {
                fArr4[i9][i8] = fArr4[i9 - 1][i8] * fArr[i8];
            }
        }
        float[][] fArr5 = new float[i6][];
        for (int i10 = 0; i10 < i6; i10++) {
            fArr5[i10] = new float[i3];
        }
        float[][] fArr6 = new float[i6][];
        for (int i11 = 0; i11 < i6; i11++) {
            fArr6[i11] = new float[i6];
        }
        int i12 = 0;
        while (i12 < i6) {
            float[] fArr7 = fArr5[i12];
            ArraysKt.copyInto(fArr4[i12], fArr7, 0, 0, i3);
            for (int i13 = 0; i13 < i12; i13++) {
                float[] fArr8 = fArr5[i13];
                float fG = g(fArr7, fArr8);
                for (int i14 = 0; i14 < i3; i14++) {
                    fArr7[i14] = fArr7[i14] - (fArr8[i14] * fG);
                }
            }
            float fSqrt = (float) Math.sqrt(g(fArr7, fArr7));
            if (fSqrt < 1.0E-6f) {
                fSqrt = 1.0E-6f;
            }
            float f3 = 1.0f / fSqrt;
            for (int i15 = 0; i15 < i3; i15++) {
                fArr7[i15] = fArr7[i15] * f3;
            }
            float[] fArr9 = fArr6[i12];
            int i16 = 0;
            while (i16 < i6) {
                fArr9[i16] = i16 < i12 ? 0.0f : g(fArr7, fArr4[i16]);
                i16++;
            }
            i12++;
        }
        for (int i17 = i5; -1 < i17; i17--) {
            float fG2 = g(fArr5[i17], fArr2);
            float[] fArr10 = fArr6[i17];
            int i18 = i17 + 1;
            if (i18 <= i5) {
                int i19 = i5;
                while (true) {
                    fG2 -= fArr10[i19] * fArr3[i19];
                    if (i19 != i18) {
                        i19--;
                    }
                }
            }
            fArr3[i17] = fG2 / fArr10[i17];
        }
        return fArr3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(DataPointAtTime[] dataPointAtTimeArr, int i3, long j3, float f3) {
        DataPointAtTime dataPointAtTime = dataPointAtTimeArr[i3];
        if (dataPointAtTime == null) {
            dataPointAtTimeArr[i3] = new DataPointAtTime(j3, f3);
        } else {
            dataPointAtTime.d(j3);
            dataPointAtTime.c(f3);
        }
    }
}
