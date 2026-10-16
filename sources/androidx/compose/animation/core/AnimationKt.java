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
public final class AnimationKt {
    public static final DecayAnimation a(FloatDecayAnimationSpec floatDecayAnimationSpec, float f3, float f4) {
        return new DecayAnimation(DecayAnimationSpecKt.d(floatDecayAnimationSpec), VectorConvertersKt.i(FloatCompanionObject.f140130a), Float.valueOf(f3), AnimationVectorsKt.a(f4));
    }

    public static final TargetBasedAnimation b(AnimationSpec animationSpec, TwoWayConverter twoWayConverter, Object obj, Object obj2, Object obj3) {
        return new TargetBasedAnimation(animationSpec, twoWayConverter, obj, obj2, (AnimationVector) twoWayConverter.a().invoke(obj3));
    }

    public static final long c(Animation animation) {
        return animation.d() / 1000000;
    }
}
