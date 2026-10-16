package androidx.compose.animation.graphics.vector;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.VectorizedFiniteAnimationSpec;
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
final class VectorizedReversedSpec<V extends AnimationVector> implements VectorizedFiniteAnimationSpec<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final VectorizedFiniteAnimationSpec f4467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f4468b;

    public VectorizedReversedSpec(VectorizedFiniteAnimationSpec vectorizedFiniteAnimationSpec, long j3) {
        this.f4467a = vectorizedFiniteAnimationSpec;
        this.f4468b = j3;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long b(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return this.f4468b;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector f(long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return AnimatorAnimationSpecsKt.c(this.f4467a.f(this.f4468b - j3, animationVector2, animationVector, animationVector3));
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector g(long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return this.f4467a.g(this.f4468b - j3, animationVector2, animationVector, animationVector3);
    }
}
