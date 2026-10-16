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
final class StartDelayAnimationSpec<T> implements AnimationSpec<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnimationSpec f4144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f4145b;

    public StartDelayAnimationSpec(AnimationSpec animationSpec, long j3) {
        this.f4144a = animationSpec;
        this.f4145b = j3;
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public VectorizedAnimationSpec a(TwoWayConverter twoWayConverter) {
        return new StartDelayVectorizedAnimationSpec(this.f4144a.a(twoWayConverter), this.f4145b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof StartDelayAnimationSpec)) {
            return false;
        }
        StartDelayAnimationSpec startDelayAnimationSpec = (StartDelayAnimationSpec) obj;
        return startDelayAnimationSpec.f4145b == this.f4145b && Intrinsics.areEqual(startDelayAnimationSpec.f4144a, this.f4144a);
    }

    public int hashCode() {
        return (this.f4144a.hashCode() * 31) + Long.hashCode(this.f4145b);
    }
}
