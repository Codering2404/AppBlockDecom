package androidx.compose.ui.platform;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class InvertMatrixKt {
    public static final boolean a(float[] fArr, float[] fArr2) {
        if (fArr.length < 16 || fArr2.length < 16) {
            return false;
        }
        float f3 = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[2];
        float f6 = fArr[3];
        float f7 = fArr[4];
        float f8 = fArr[5];
        float f9 = fArr[6];
        float f10 = fArr[7];
        float f11 = fArr[8];
        float f12 = fArr[9];
        float f13 = fArr[10];
        float f14 = fArr[11];
        float f15 = fArr[12];
        float f16 = fArr[13];
        float f17 = fArr[14];
        float f18 = fArr[15];
        float f19 = (f3 * f8) - (f4 * f7);
        float f20 = (f3 * f9) - (f5 * f7);
        float f21 = (f3 * f10) - (f6 * f7);
        float f22 = (f4 * f9) - (f5 * f8);
        float f23 = (f4 * f10) - (f6 * f8);
        float f24 = (f5 * f10) - (f6 * f9);
        float f25 = (f11 * f16) - (f12 * f15);
        float f26 = (f11 * f17) - (f13 * f15);
        float f27 = (f11 * f18) - (f14 * f15);
        float f28 = (f12 * f17) - (f13 * f16);
        float f29 = (f12 * f18) - (f14 * f16);
        float f30 = (f13 * f18) - (f14 * f17);
        float f31 = (((((f19 * f30) - (f20 * f29)) + (f21 * f28)) + (f22 * f27)) - (f23 * f26)) + (f24 * f25);
        if (f31 != 0.0f) {
            float f32 = 1.0f / f31;
            fArr2[0] = (((f8 * f30) - (f9 * f29)) + (f10 * f28)) * f32;
            fArr2[1] = ((((-f4) * f30) + (f5 * f29)) - (f6 * f28)) * f32;
            fArr2[2] = (((f16 * f24) - (f17 * f23)) + (f18 * f22)) * f32;
            fArr2[3] = ((((-f12) * f24) + (f13 * f23)) - (f14 * f22)) * f32;
            float f33 = -f7;
            fArr2[4] = (((f33 * f30) + (f9 * f27)) - (f10 * f26)) * f32;
            fArr2[5] = (((f30 * f3) - (f5 * f27)) + (f6 * f26)) * f32;
            float f34 = -f15;
            fArr2[6] = (((f34 * f24) + (f17 * f21)) - (f18 * f20)) * f32;
            fArr2[7] = (((f24 * f11) - (f13 * f21)) + (f14 * f20)) * f32;
            fArr2[8] = (((f7 * f29) - (f8 * f27)) + (f10 * f25)) * f32;
            fArr2[9] = ((((-f3) * f29) + (f27 * f4)) - (f6 * f25)) * f32;
            fArr2[10] = (((f15 * f23) - (f16 * f21)) + (f18 * f19)) * f32;
            fArr2[11] = ((((-f11) * f23) + (f21 * f12)) - (f14 * f19)) * f32;
            fArr2[12] = (((f33 * f28) + (f8 * f26)) - (f9 * f25)) * f32;
            fArr2[13] = (((f3 * f28) - (f4 * f26)) + (f5 * f25)) * f32;
            fArr2[14] = (((f34 * f22) + (f16 * f20)) - (f17 * f19)) * f32;
            fArr2[15] = (((f11 * f22) - (f12 * f20)) + (f13 * f19)) * f32;
        }
        return !(f31 == 0.0f);
    }
}
