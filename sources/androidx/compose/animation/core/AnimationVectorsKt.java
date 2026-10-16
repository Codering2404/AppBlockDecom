package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class AnimationVectorsKt {
    public static final AnimationVector1D a(float f3) {
        return new AnimationVector1D(f3);
    }

    public static final AnimationVector2D b(float f3, float f4) {
        return new AnimationVector2D(f3, f4);
    }

    public static final AnimationVector3D c(float f3, float f4, float f5) {
        return new AnimationVector3D(f3, f4, f5);
    }

    public static final AnimationVector4D d(float f3, float f4, float f5, float f6) {
        return new AnimationVector4D(f3, f4, f5, f6);
    }

    public static final AnimationVector e(AnimationVector animationVector) {
        AnimationVector animationVectorG = g(animationVector);
        int iB = animationVectorG.b();
        for (int i3 = 0; i3 < iB; i3++) {
            animationVectorG.e(i3, animationVector.a(i3));
        }
        return animationVectorG;
    }

    public static final void f(AnimationVector animationVector, AnimationVector animationVector2) {
        int iB = animationVector.b();
        for (int i3 = 0; i3 < iB; i3++) {
            animationVector.e(i3, animationVector2.a(i3));
        }
    }

    public static final AnimationVector g(AnimationVector animationVector) {
        AnimationVector animationVectorC = animationVector.c();
        Intrinsics.checkNotNull(animationVectorC, "null cannot be cast to non-null type T of androidx.compose.animation.core.AnimationVectorsKt.newInstance");
        return animationVectorC;
    }
}
