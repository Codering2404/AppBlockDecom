package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
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
public final class VectorizedSpringSpec<V extends AnimationVector> implements VectorizedFiniteAnimationSpec<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f4369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f4370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final /* synthetic */ VectorizedFloatAnimationSpec f4371c;

    private VectorizedSpringSpec(float f3, float f4, Animations animations) {
        this.f4369a = f3;
        this.f4370b = f4;
        this.f4371c = new VectorizedFloatAnimationSpec(animations);
    }

    @Override // androidx.compose.animation.core.VectorizedFiniteAnimationSpec, androidx.compose.animation.core.VectorizedAnimationSpec
    public boolean a() {
        return this.f4371c.a();
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long b(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return this.f4371c.b(animationVector, animationVector2, animationVector3);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector d(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return this.f4371c.d(animationVector, animationVector2, animationVector3);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector f(long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return this.f4371c.f(j3, animationVector, animationVector2, animationVector3);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector g(long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return this.f4371c.g(j3, animationVector, animationVector2, animationVector3);
    }

    public VectorizedSpringSpec(float f3, float f4, AnimationVector animationVector) {
        this(f3, f4, VectorizedAnimationSpecKt.f(animationVector, f3, f4));
    }
}
