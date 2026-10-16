package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import com.google.android.gms.common.api.Api;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@JvmInline
public final class Matrix {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f25814b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f25815a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private /* synthetic */ Matrix(float[] fArr) {
        this.f25815a = fArr;
    }

    public static final /* synthetic */ Matrix a(float[] fArr) {
        return new Matrix(fArr);
    }

    public static /* synthetic */ float[] c(float[] fArr, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 1) != 0) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        }
        return b(fArr);
    }

    public static boolean d(float[] fArr, Object obj) {
        return (obj instanceof Matrix) && Intrinsics.areEqual(fArr, ((Matrix) obj).p());
    }

    public static int e(float[] fArr) {
        return Arrays.hashCode(fArr);
    }

    public static final long f(float[] fArr, long j3) {
        if (fArr.length < 16) {
            return j3;
        }
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[3];
        float f6 = fArr[4];
        float f7 = fArr[5];
        float f8 = fArr[7];
        float f9 = fArr[12];
        float f10 = fArr[13];
        float f11 = fArr[15];
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j3 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j3 & 4294967295L));
        float f12 = 1 / (((f5 * fIntBitsToFloat) + (f8 * fIntBitsToFloat2)) + f11);
        if ((Float.floatToRawIntBits(f12) & Api.BaseClientBuilder.API_PRIORITY_OTHER) >= 2139095040) {
            f12 = 0.0f;
        }
        return Offset.e((((long) Float.floatToRawIntBits((((f3 * fIntBitsToFloat) + (f6 * fIntBitsToFloat2)) + f9) * f12)) << 32) | (((long) Float.floatToRawIntBits(f12 * ((f4 * fIntBitsToFloat) + (f7 * fIntBitsToFloat2) + f10))) & 4294967295L));
    }

    public static final void g(float[] fArr, MutableRect mutableRect) {
        if (fArr.length < 16) {
            return;
        }
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[3];
        float f6 = fArr[4];
        float f7 = fArr[5];
        float f8 = fArr[7];
        float f9 = fArr[12];
        float f10 = fArr[13];
        float f11 = fArr[15];
        float fB = mutableRect.b();
        float fD = mutableRect.d();
        float fC = mutableRect.c();
        float fA = mutableRect.a();
        float f12 = f5 * fB;
        float f13 = f8 * fD;
        float f14 = 1.0f / ((f12 + f13) + f11);
        if ((Float.floatToRawIntBits(f14) & Api.BaseClientBuilder.API_PRIORITY_OTHER) >= 2139095040) {
            f14 = 0.0f;
        }
        float f15 = f3 * fB;
        float f16 = f6 * fD;
        float f17 = f14 * (f15 + f16 + f9);
        float f18 = fB * f4;
        float f19 = fD * f7;
        float f20 = f14 * (f18 + f19 + f10);
        float f21 = f8 * fA;
        float f22 = 1.0f / ((f12 + f21) + f11);
        if ((Float.floatToRawIntBits(f22) & Api.BaseClientBuilder.API_PRIORITY_OTHER) >= 2139095040) {
            f22 = 0.0f;
        }
        float f23 = f6 * fA;
        float f24 = (f15 + f23 + f9) * f22;
        float f25 = f7 * fA;
        float f26 = f22 * (f18 + f25 + f10);
        float f27 = f5 * fC;
        float f28 = 1.0f / ((f13 + f27) + f11);
        if ((Float.floatToRawIntBits(f28) & Api.BaseClientBuilder.API_PRIORITY_OTHER) >= 2139095040) {
            f28 = 0.0f;
        }
        float f29 = f3 * fC;
        float f30 = f28 * (f29 + f16 + f9);
        float f31 = fC * f4;
        float f32 = f28 * (f19 + f31 + f10);
        float f33 = 1.0f / ((f27 + f21) + f11);
        float f34 = (Float.floatToRawIntBits(f33) & Api.BaseClientBuilder.API_PRIORITY_OTHER) < 2139095040 ? f33 : 0.0f;
        float f35 = (f29 + f23 + f9) * f34;
        float f36 = f34 * (f31 + f25 + f10);
        mutableRect.i(Math.min(f17, Math.min(f24, Math.min(f30, f35))));
        mutableRect.k(Math.min(f20, Math.min(f26, Math.min(f32, f36))));
        mutableRect.j(Math.max(f17, Math.max(f24, Math.max(f30, f35))));
        mutableRect.h(Math.max(f20, Math.max(f26, Math.max(f32, f36))));
    }

    public static final void h(float[] fArr) {
        if (fArr.length < 16) {
            return;
        }
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 1.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = 1.0f;
        fArr[11] = 0.0f;
        fArr[12] = 0.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 1.0f;
    }

    public static final void i(float[] fArr, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        double d3 = ((double) f8) * 0.017453292519943295d;
        float fSin = (float) Math.sin(d3);
        float fCos = (float) Math.cos(d3);
        float f14 = -fSin;
        float f15 = (f6 * fCos) - (f7 * fSin);
        float f16 = (f6 * fSin) + (f7 * fCos);
        double d4 = ((double) f9) * 0.017453292519943295d;
        float fSin2 = (float) Math.sin(d4);
        float fCos2 = (float) Math.cos(d4);
        float f17 = -fSin2;
        float f18 = fSin * fSin2;
        float f19 = fSin * fCos2;
        float f20 = fCos * fSin2;
        float f21 = fCos * fCos2;
        float f22 = (f5 * fCos2) + (f16 * fSin2);
        float f23 = ((-f5) * fSin2) + (f16 * fCos2);
        double d5 = ((double) f10) * 0.017453292519943295d;
        float fSin3 = (float) Math.sin(d5);
        float fCos3 = (float) Math.cos(d5);
        float f24 = -fSin3;
        float f25 = (f24 * fCos2) + (fCos3 * f18);
        float f26 = fCos * fCos3;
        float f27 = (f24 * f17) + (fCos3 * f19);
        float f28 = ((fCos2 * fCos3) + (f18 * fSin3)) * f11;
        float f29 = fSin3 * fCos * f11;
        float f30 = ((fCos3 * f17) + (fSin3 * f19)) * f11;
        float f31 = f25 * f12;
        float f32 = f26 * f12;
        float f33 = f27 * f12;
        float f34 = f20 * f13;
        float f35 = f14 * f13;
        float f36 = f21 * f13;
        if (fArr.length < 16) {
            return;
        }
        fArr[0] = f28;
        fArr[1] = f29;
        fArr[2] = f30;
        fArr[3] = 0.0f;
        fArr[4] = f31;
        fArr[5] = f32;
        fArr[6] = f33;
        fArr[7] = 0.0f;
        fArr[8] = f34;
        fArr[9] = f35;
        fArr[10] = f36;
        fArr[11] = 0.0f;
        float f37 = -f3;
        fArr[12] = ((f28 * f37) - (f31 * f4)) + f22 + f3;
        fArr[13] = ((f29 * f37) - (f32 * f4)) + f15 + f4;
        fArr[14] = ((f37 * f30) - (f4 * f33)) + f23;
        fArr[15] = 1.0f;
    }

    public static final void j(float[] fArr, float f3) {
        if (fArr.length < 16) {
            return;
        }
        double d3 = ((double) f3) * 0.017453292519943295d;
        float fSin = (float) Math.sin(d3);
        float fCos = (float) Math.cos(d3);
        float f4 = fArr[0];
        float f5 = fArr[4];
        float f6 = (fCos * f4) + (fSin * f5);
        float f7 = -fSin;
        float f8 = fArr[1];
        float f9 = fArr[5];
        float f10 = (fCos * f8) + (fSin * f9);
        float f11 = fArr[2];
        float f12 = fArr[6];
        float f13 = (fCos * f11) + (fSin * f12);
        float f14 = fArr[3];
        float f15 = fArr[7];
        fArr[0] = f6;
        fArr[1] = f10;
        fArr[2] = f13;
        fArr[3] = (fCos * f14) + (fSin * f15);
        fArr[4] = (f4 * f7) + (f5 * fCos);
        fArr[5] = (f8 * f7) + (f9 * fCos);
        fArr[6] = (f11 * f7) + (f12 * fCos);
        fArr[7] = (f7 * f14) + (fCos * f15);
    }

    public static final void k(float[] fArr, float f3, float f4, float f5) {
        if (fArr.length < 16) {
            return;
        }
        fArr[0] = fArr[0] * f3;
        fArr[1] = fArr[1] * f3;
        fArr[2] = fArr[2] * f3;
        fArr[3] = fArr[3] * f3;
        fArr[4] = fArr[4] * f4;
        fArr[5] = fArr[5] * f4;
        fArr[6] = fArr[6] * f4;
        fArr[7] = fArr[7] * f4;
        fArr[8] = fArr[8] * f5;
        fArr[9] = fArr[9] * f5;
        fArr[10] = fArr[10] * f5;
        fArr[11] = fArr[11] * f5;
    }

    public static final void l(float[] fArr, float[] fArr2) {
        if (fArr.length >= 16 && fArr2.length >= 16) {
            float f3 = fArr[0];
            float f4 = fArr2[0];
            float f5 = fArr[1];
            float f6 = fArr2[4];
            float f7 = fArr[2];
            float f8 = fArr2[8];
            float f9 = fArr[3];
            float f10 = fArr2[12];
            float f11 = (f3 * f4) + (f5 * f6) + (f7 * f8) + (f9 * f10);
            float f12 = fArr2[1];
            float f13 = fArr2[5];
            float f14 = fArr2[9];
            float f15 = fArr2[13];
            float f16 = (f3 * f12) + (f5 * f13) + (f7 * f14) + (f9 * f15);
            float f17 = fArr2[2];
            float f18 = fArr2[6];
            float f19 = fArr2[10];
            float f20 = fArr2[14];
            float f21 = (f3 * f17) + (f5 * f18) + (f7 * f19) + (f9 * f20);
            float f22 = fArr2[3];
            float f23 = fArr2[7];
            float f24 = fArr2[11];
            float f25 = fArr2[15];
            float f26 = (f3 * f22) + (f5 * f23) + (f7 * f24) + (f9 * f25);
            float f27 = fArr[4];
            float f28 = fArr[5];
            float f29 = fArr[6];
            float f30 = fArr[7];
            float f31 = (f27 * f4) + (f28 * f6) + (f29 * f8) + (f30 * f10);
            float f32 = (f27 * f12) + (f28 * f13) + (f29 * f14) + (f30 * f15);
            float f33 = (f27 * f17) + (f28 * f18) + (f29 * f19) + (f30 * f20);
            float f34 = (f27 * f22) + (f28 * f23) + (f29 * f24) + (f30 * f25);
            float f35 = fArr[8];
            float f36 = fArr[9];
            float f37 = fArr[10];
            float f38 = fArr[11];
            float f39 = (f35 * f4) + (f36 * f6) + (f37 * f8) + (f38 * f10);
            float f40 = (f35 * f12) + (f36 * f13) + (f37 * f14) + (f38 * f15);
            float f41 = (f35 * f17) + (f36 * f18) + (f37 * f19) + (f38 * f20);
            float f42 = (f35 * f22) + (f36 * f23) + (f37 * f24) + (f38 * f25);
            float f43 = fArr[12];
            float f44 = fArr[13];
            float f45 = (f4 * f43) + (f6 * f44);
            float f46 = fArr[14];
            float f47 = f45 + (f8 * f46);
            float f48 = fArr[15];
            fArr[0] = f11;
            fArr[1] = f16;
            fArr[2] = f21;
            fArr[3] = f26;
            fArr[4] = f31;
            fArr[5] = f32;
            fArr[6] = f33;
            fArr[7] = f34;
            fArr[8] = f39;
            fArr[9] = f40;
            fArr[10] = f41;
            fArr[11] = f42;
            fArr[12] = f47 + (f10 * f48);
            fArr[13] = (f12 * f43) + (f13 * f44) + (f14 * f46) + (f15 * f48);
            fArr[14] = (f17 * f43) + (f18 * f44) + (f19 * f46) + (f20 * f48);
            fArr[15] = (f43 * f22) + (f44 * f23) + (f46 * f24) + (f48 * f25);
        }
    }

    public static String m(float[] fArr) {
        return StringsKt.n("\n            |" + fArr[0] + ' ' + fArr[1] + ' ' + fArr[2] + ' ' + fArr[3] + "|\n            |" + fArr[4] + ' ' + fArr[5] + ' ' + fArr[6] + ' ' + fArr[7] + "|\n            |" + fArr[8] + ' ' + fArr[9] + ' ' + fArr[10] + ' ' + fArr[11] + "|\n            |" + fArr[12] + ' ' + fArr[13] + ' ' + fArr[14] + ' ' + fArr[15] + "|\n        ");
    }

    public static final void n(float[] fArr, float f3, float f4, float f5) {
        if (fArr.length < 16) {
            return;
        }
        float f6 = (fArr[0] * f3) + (fArr[4] * f4) + (fArr[8] * f5) + fArr[12];
        float f7 = (fArr[1] * f3) + (fArr[5] * f4) + (fArr[9] * f5) + fArr[13];
        float f8 = (fArr[2] * f3) + (fArr[6] * f4) + (fArr[10] * f5) + fArr[14];
        float f9 = (fArr[3] * f3) + (fArr[7] * f4) + (fArr[11] * f5) + fArr[15];
        fArr[12] = f6;
        fArr[13] = f7;
        fArr[14] = f8;
        fArr[15] = f9;
    }

    public static /* synthetic */ void o(float[] fArr, float f3, float f4, float f5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = 0.0f;
        }
        if ((i3 & 2) != 0) {
            f4 = 0.0f;
        }
        if ((i3 & 4) != 0) {
            f5 = 0.0f;
        }
        n(fArr, f3, f4, f5);
    }

    public boolean equals(Object obj) {
        return d(this.f25815a, obj);
    }

    public int hashCode() {
        return e(this.f25815a);
    }

    public final /* synthetic */ float[] p() {
        return this.f25815a;
    }

    public String toString() {
        return m(this.f25815a);
    }

    public static float[] b(float[] fArr) {
        return fArr;
    }
}
