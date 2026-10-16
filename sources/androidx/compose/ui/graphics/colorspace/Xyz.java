package androidx.compose.ui.graphics.colorspace;

import androidx.compose.ui.graphics.ColorKt;
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
public final class Xyz extends ColorSpace {
    public Xyz(String str, int i3) {
        super(str, ColorModel.f25969b.c(), i3, null);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] b(float[] fArr) {
        float f3 = fArr[0];
        if (f3 < -2.0f) {
            f3 = -2.0f;
        }
        if (f3 > 2.0f) {
            f3 = 2.0f;
        }
        fArr[0] = f3;
        float f4 = fArr[1];
        if (f4 < -2.0f) {
            f4 = -2.0f;
        }
        if (f4 > 2.0f) {
            f4 = 2.0f;
        }
        fArr[1] = f4;
        float f5 = fArr[2];
        float f6 = f5 >= -2.0f ? f5 : -2.0f;
        fArr[2] = f6 <= 2.0f ? f6 : 2.0f;
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float e(int i3) {
        return 2.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float f(int i3) {
        return -2.0f;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long j(float f3, float f4, float f5) {
        if (f3 < -2.0f) {
            f3 = -2.0f;
        }
        if (f3 > 2.0f) {
            f3 = 2.0f;
        }
        if (f4 < -2.0f) {
            f4 = -2.0f;
        }
        return (((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f4 <= 2.0f ? f4 : 2.0f)) & 4294967295L);
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float[] l(float[] fArr) {
        float f3 = fArr[0];
        if (f3 < -2.0f) {
            f3 = -2.0f;
        }
        if (f3 > 2.0f) {
            f3 = 2.0f;
        }
        fArr[0] = f3;
        float f4 = fArr[1];
        if (f4 < -2.0f) {
            f4 = -2.0f;
        }
        if (f4 > 2.0f) {
            f4 = 2.0f;
        }
        fArr[1] = f4;
        float f5 = fArr[2];
        float f6 = f5 >= -2.0f ? f5 : -2.0f;
        fArr[2] = f6 <= 2.0f ? f6 : 2.0f;
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public float m(float f3, float f4, float f5) {
        if (f5 < -2.0f) {
            f5 = -2.0f;
        }
        if (f5 > 2.0f) {
            return 2.0f;
        }
        return f5;
    }

    @Override // androidx.compose.ui.graphics.colorspace.ColorSpace
    public long n(float f3, float f4, float f5, float f6, ColorSpace colorSpace) {
        if (f3 < -2.0f) {
            f3 = -2.0f;
        }
        if (f3 > 2.0f) {
            f3 = 2.0f;
        }
        if (f4 < -2.0f) {
            f4 = -2.0f;
        }
        if (f4 > 2.0f) {
            f4 = 2.0f;
        }
        if (f5 < -2.0f) {
            f5 = -2.0f;
        }
        return ColorKt.a(f3, f4, f5 <= 2.0f ? f5 : 2.0f, f6, colorSpace);
    }
}
