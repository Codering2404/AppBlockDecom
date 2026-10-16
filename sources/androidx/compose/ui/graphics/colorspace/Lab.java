package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
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
public final class Lab extends ColorSpace {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f26027e = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public Lab(String str, int i3) {
        super(str, ColorModel.f25969b.a(), i3, null);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] b(float[] fArr) {
        float f3 = fArr[0];
        Illuminant illuminant = Illuminant.f26016a;
        float f4 = f3 / illuminant.c()[0];
        float f5 = fArr[1] / illuminant.c()[1];
        float f6 = fArr[2] / illuminant.c()[2];
        float fCbrt = f4 > 0.008856452f ? (float) Math.cbrt(f4) : (f4 * 7.787037f) + 0.13793103f;
        float fCbrt2 = f5 > 0.008856452f ? (float) Math.cbrt(f5) : (f5 * 7.787037f) + 0.13793103f;
        float fCbrt3 = f6 > 0.008856452f ? (float) Math.cbrt(f6) : (f6 * 7.787037f) + 0.13793103f;
        float f7 = (116.0f * fCbrt2) - 16.0f;
        float f8 = (fCbrt - fCbrt2) * 500.0f;
        float f9 = (fCbrt2 - fCbrt3) * 200.0f;
        if (f7 < 0.0f) {
            f7 = 0.0f;
        }
        if (f7 > 100.0f) {
            f7 = 100.0f;
        }
        fArr[0] = f7;
        if (f8 < -128.0f) {
            f8 = -128.0f;
        }
        if (f8 > 128.0f) {
            f8 = 128.0f;
        }
        fArr[1] = f8;
        if (f9 < -128.0f) {
            f9 = -128.0f;
        }
        fArr[2] = f9 <= 128.0f ? f9 : 128.0f;
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float e(int i3) {
        return i3 == 0 ? 100.0f : 128.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float f(int i3) {
        return i3 == 0 ? 0.0f : -128.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long j(float f3, float f4, float f5) {
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 100.0f) {
            f3 = 100.0f;
        }
        if (f4 < -128.0f) {
            f4 = -128.0f;
        }
        if (f4 > 128.0f) {
            f4 = 128.0f;
        }
        float f6 = (f3 + 16.0f) / 116.0f;
        float f7 = (f4 * 0.002f) + f6;
        float f8 = f7 > 0.20689656f ? f7 * f7 * f7 : (f7 - 0.13793103f) * 0.12841855f;
        float f9 = f6 > 0.20689656f ? f6 * f6 * f6 : (f6 - 0.13793103f) * 0.12841855f;
        Illuminant illuminant = Illuminant.f26016a;
        return (((long) Float.floatToRawIntBits(f9 * illuminant.c()[1])) & 4294967295L) | (((long) Float.floatToRawIntBits(f8 * illuminant.c()[0])) << 32);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] l(float[] fArr) {
        float f3 = fArr[0];
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 100.0f) {
            f3 = 100.0f;
        }
        fArr[0] = f3;
        float f4 = fArr[1];
        if (f4 < -128.0f) {
            f4 = -128.0f;
        }
        if (f4 > 128.0f) {
            f4 = 128.0f;
        }
        fArr[1] = f4;
        float f5 = fArr[2];
        float f6 = f5 >= -128.0f ? f5 : -128.0f;
        float f7 = f6 <= 128.0f ? f6 : 128.0f;
        fArr[2] = f7;
        float f8 = (f3 + 16.0f) / 116.0f;
        float f9 = (f4 * 0.002f) + f8;
        float f10 = f8 - (f7 * 0.005f);
        float f11 = f9 > 0.20689656f ? f9 * f9 * f9 : (f9 - 0.13793103f) * 0.12841855f;
        float f12 = f8 > 0.20689656f ? f8 * f8 * f8 : (f8 - 0.13793103f) * 0.12841855f;
        float f13 = f10 > 0.20689656f ? f10 * f10 * f10 : (f10 - 0.13793103f) * 0.12841855f;
        Illuminant illuminant = Illuminant.f26016a;
        fArr[0] = f11 * illuminant.c()[0];
        fArr[1] = f12 * illuminant.c()[1];
        fArr[2] = f13 * illuminant.c()[2];
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float m(float f3, float f4, float f5) {
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f3 > 100.0f) {
            f3 = 100.0f;
        }
        if (f5 < -128.0f) {
            f5 = -128.0f;
        }
        if (f5 > 128.0f) {
            f5 = 128.0f;
        }
        float f6 = ((f3 + 16.0f) / 116.0f) - (f5 * 0.005f);
        return (f6 > 0.20689656f ? f6 * f6 * f6 : 0.12841855f * (f6 - 0.13793103f)) * Illuminant.f26016a.c()[2];
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long n(float f3, float f4, float f5, float f6, ColorSpace colorSpace) {
        Illuminant illuminant = Illuminant.f26016a;
        float f7 = f3 / illuminant.c()[0];
        float f8 = f4 / illuminant.c()[1];
        float f9 = f5 / illuminant.c()[2];
        float fCbrt = f7 > 0.008856452f ? (float) Math.cbrt(f7) : (f7 * 7.787037f) + 0.13793103f;
        float fCbrt2 = f8 > 0.008856452f ? (float) Math.cbrt(f8) : (f8 * 7.787037f) + 0.13793103f;
        float f10 = (116.0f * fCbrt2) - 16.0f;
        float f11 = (fCbrt - fCbrt2) * 500.0f;
        float fCbrt3 = (fCbrt2 - (f9 > 0.008856452f ? (float) Math.cbrt(f9) : (f9 * 7.787037f) + 0.13793103f)) * 200.0f;
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        if (f10 > 100.0f) {
            f10 = 100.0f;
        }
        if (f11 < -128.0f) {
            f11 = -128.0f;
        }
        if (f11 > 128.0f) {
            f11 = 128.0f;
        }
        if (fCbrt3 < -128.0f) {
            fCbrt3 = -128.0f;
        }
        return ColorKt.a(f10, f11, fCbrt3 <= 128.0f ? fCbrt3 : 128.0f, f6, colorSpace);
    }
}
