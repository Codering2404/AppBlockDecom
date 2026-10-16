package androidx.compose.animation;

import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.ui.unit.Density;
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
public final class SplineBasedDecayKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(float[] fArr, float[] fArr2, int i3) {
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12 = 0.0f;
        int i4 = 0;
        float f13 = 0.0f;
        while (true) {
            float f14 = 1.0f;
            if (i4 >= i3) {
                fArr2[i3] = 1.0f;
                fArr[i3] = 1.0f;
                return;
            }
            float f15 = i4 / i3;
            float f16 = 1.0f;
            while (true) {
                f3 = ((f16 - f12) / 2.0f) + f12;
                f4 = f14 - f3;
                f5 = f3 * 3.0f * f4;
                f6 = f3 * f3 * f3;
                float f17 = (((f4 * 0.175f) + (f3 * 0.35000002f)) * f5) + f6;
                f7 = f14;
                if (Math.abs(f17 - f15) < 1.0E-5d) {
                    break;
                }
                if (f17 > f15) {
                    f16 = f3;
                } else {
                    f12 = f3;
                }
                f14 = f7;
            }
            float f18 = 0.5f;
            fArr[i4] = (f5 * ((f4 * 0.5f) + f3)) + f6;
            float f19 = f7;
            while (true) {
                f8 = ((f19 - f13) / 2.0f) + f13;
                f9 = f7 - f8;
                f10 = f8 * 3.0f * f9;
                f11 = f8 * f8 * f8;
                float f20 = (((f9 * f18) + f8) * f10) + f11;
                float f21 = f15;
                if (Math.abs(f20 - f15) >= 1.0E-5d) {
                    if (f20 > f21) {
                        f19 = f8;
                    } else {
                        f13 = f8;
                    }
                    f15 = f21;
                    f18 = 0.5f;
                }
            }
            fArr2[i4] = (f10 * ((f9 * 0.175f) + (f8 * 0.35000002f))) + f11;
            i4++;
        }
    }

    public static final DecayAnimationSpec c(Density density) {
        return DecayAnimationSpecKt.d(new SplineBasedFloatDecayAnimationSpec(density));
    }
}
