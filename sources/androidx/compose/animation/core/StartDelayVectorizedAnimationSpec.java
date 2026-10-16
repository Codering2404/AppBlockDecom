package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
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
final class StartDelayVectorizedAnimationSpec<V extends AnimationVector> implements VectorizedAnimationSpec<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final VectorizedAnimationSpec f4146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f4147b;

    public StartDelayVectorizedAnimationSpec(VectorizedAnimationSpec vectorizedAnimationSpec, long j3) {
        this.f4146a = vectorizedAnimationSpec;
        this.f4147b = j3;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public boolean a() {
        return this.f4146a.a();
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long b(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return this.f4146a.b(animationVector, animationVector2, animationVector3) + this.f4147b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof StartDelayVectorizedAnimationSpec)) {
            return false;
        }
        StartDelayVectorizedAnimationSpec startDelayVectorizedAnimationSpec = (StartDelayVectorizedAnimationSpec) obj;
        return startDelayVectorizedAnimationSpec.f4147b == this.f4147b && Intrinsics.areEqual(startDelayVectorizedAnimationSpec.f4146a, this.f4146a);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector f(long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        long j4 = this.f4147b;
        return j3 < j4 ? animationVector3 : this.f4146a.f(j3 - j4, animationVector, animationVector2, animationVector3);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector g(long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        long j4 = this.f4147b;
        return j3 < j4 ? animationVector : this.f4146a.g(j3 - j4, animationVector, animationVector2, animationVector3);
    }

    public int hashCode() {
        return (this.f4146a.hashCode() * 31) + Long.hashCode(this.f4147b);
    }
}
