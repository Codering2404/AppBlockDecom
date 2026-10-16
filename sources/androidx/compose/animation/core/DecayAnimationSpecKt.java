package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;

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
public final class DecayAnimationSpecKt {
    public static final float a(DecayAnimationSpec decayAnimationSpec, float f3, float f4) {
        return ((AnimationVector1D) decayAnimationSpec.a(VectorConvertersKt.i(FloatCompanionObject.f140130a)).d(AnimationVectorsKt.a(f3), AnimationVectorsKt.a(f4))).f();
    }

    public static final DecayAnimationSpec b(float f3, float f4) {
        return d(new FloatExponentialDecaySpec(f3, f4));
    }

    public static /* synthetic */ DecayAnimationSpec c(float f3, float f4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = 1.0f;
        }
        if ((i3 & 2) != 0) {
            f4 = 0.1f;
        }
        return b(f3, f4);
    }

    public static final DecayAnimationSpec d(FloatDecayAnimationSpec floatDecayAnimationSpec) {
        return new DecayAnimationSpecImpl(floatDecayAnimationSpec);
    }
}
