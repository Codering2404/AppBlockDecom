package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class Oklab extends ColorSpace {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f26028e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float[] f26029f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float[] f26030g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final float[] f26031h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final float[] f26032i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        float[] fArrB = Adaptation.f25964b.a().b();
        Illuminant illuminant = Illuminant.f26016a;
        float[] fArrL = ColorSpaceKt.l(new float[]{0.818933f, 0.032984544f, 0.0482003f, 0.36186674f, 0.9293119f, 0.26436627f, -0.12885971f, 0.03614564f, 0.6338517f}, ColorSpaceKt.e(fArrB, illuminant.b().c(), illuminant.e().c()));
        f26029f = fArrL;
        float[] fArr = {0.21045426f, 1.9779985f, 0.025904037f, 0.7936178f, -2.4285922f, 0.78277177f, -0.004072047f, 0.4505937f, -0.80867577f};
        f26030g = fArr;
        f26031h = ColorSpaceKt.k(fArrL);
        f26032i = ColorSpaceKt.k(fArr);
    }

    public Oklab(String str, int i3) {
        super(str, ColorModel.f25969b.a(), i3, null);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] b(float[] fArr) {
        ColorSpaceKt.n(f26029f, fArr);
        fArr[0] = MathHelpersKt.a(fArr[0]);
        fArr[1] = MathHelpersKt.a(fArr[1]);
        fArr[2] = MathHelpersKt.a(fArr[2]);
        ColorSpaceKt.n(f26030g, fArr);
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float e(int i3) {
        return i3 == 0 ? 1.0f : 0.5f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float f(int i3) {
        return i3 == 0 ? 0.0f : -0.5f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long j(float f3, float f4, float f5) {
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        if (f4 < -0.5f) {
            f4 = -0.5f;
        }
        if (f4 > 0.5f) {
            f4 = 0.5f;
        }
        if (f5 < -0.5f) {
            f5 = -0.5f;
        }
        float f6 = f5 <= 0.5f ? f5 : 0.5f;
        float[] fArr = f26032i;
        float f7 = (fArr[0] * f3) + (fArr[3] * f4) + (fArr[6] * f6);
        float f8 = (fArr[1] * f3) + (fArr[4] * f4) + (fArr[7] * f6);
        float f9 = (fArr[2] * f3) + (fArr[5] * f4) + (fArr[8] * f6);
        float f10 = f7 * f7 * f7;
        float f11 = f8 * f8 * f8;
        float f12 = f9 * f9 * f9;
        float[] fArr2 = f26031h;
        return (((long) Float.floatToRawIntBits(((fArr2[0] * f10) + (fArr2[3] * f11)) + (fArr2[6] * f12))) << 32) | (((long) Float.floatToRawIntBits((fArr2[1] * f10) + (fArr2[4] * f11) + (fArr2[7] * f12))) & 4294967295L);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] l(float[] fArr) {
        float f3 = fArr[0];
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        fArr[0] = f3;
        float f4 = fArr[1];
        if (f4 < -0.5f) {
            f4 = -0.5f;
        }
        if (f4 > 0.5f) {
            f4 = 0.5f;
        }
        fArr[1] = f4;
        float f5 = fArr[2];
        float f6 = f5 >= -0.5f ? f5 : -0.5f;
        fArr[2] = f6 <= 0.5f ? f6 : 0.5f;
        ColorSpaceKt.n(f26032i, fArr);
        float f7 = fArr[0];
        fArr[0] = f7 * f7 * f7;
        float f8 = fArr[1];
        fArr[1] = f8 * f8 * f8;
        float f9 = fArr[2];
        fArr[2] = f9 * f9 * f9;
        ColorSpaceKt.n(f26031h, fArr);
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float m(float f3, float f4, float f5) {
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 1.0f) {
            f3 = 1.0f;
        }
        if (f4 < -0.5f) {
            f4 = -0.5f;
        }
        if (f4 > 0.5f) {
            f4 = 0.5f;
        }
        if (f5 < -0.5f) {
            f5 = -0.5f;
        }
        float f6 = f5 <= 0.5f ? f5 : 0.5f;
        float[] fArr = f26032i;
        float f7 = (fArr[0] * f3) + (fArr[3] * f4) + (fArr[6] * f6);
        float f8 = (fArr[1] * f3) + (fArr[4] * f4) + (fArr[7] * f6);
        float f9 = (fArr[2] * f3) + (fArr[5] * f4) + (fArr[8] * f6);
        float f10 = f7 * f7 * f7;
        float f11 = f8 * f8 * f8;
        float[] fArr2 = f26031h;
        return (fArr2[2] * f10) + (fArr2[5] * f11) + (fArr2[8] * f9 * f9 * f9);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long n(float f3, float f4, float f5, float f6, ColorSpace colorSpace) {
        float[] fArr = f26029f;
        float f7 = (fArr[0] * f3) + (fArr[3] * f4) + (fArr[6] * f5);
        float f8 = (fArr[1] * f3) + (fArr[4] * f4) + (fArr[7] * f5);
        float f9 = (fArr[2] * f3) + (fArr[5] * f4) + (fArr[8] * f5);
        float fA = MathHelpersKt.a(f7);
        float fA2 = MathHelpersKt.a(f8);
        float fA3 = MathHelpersKt.a(f9);
        float[] fArr2 = f26030g;
        return ColorKt.a((fArr2[0] * fA) + (fArr2[3] * fA2) + (fArr2[6] * fA3), (fArr2[1] * fA) + (fArr2[4] * fA2) + (fArr2[7] * fA3), (fArr2[2] * fA) + (fArr2[5] * fA2) + (fArr2[8] * fA3), f6, colorSpace);
    }
}
