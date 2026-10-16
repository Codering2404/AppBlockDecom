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
public final class VectorizedTweenSpec<V extends AnimationVector> implements VectorizedDurationBasedAnimationSpec<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4372a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f4373b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Easing f4374c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final VectorizedFloatAnimationSpec f4375d;

    public VectorizedTweenSpec(int i3, int i4, Easing easing) {
        this.f4372a = i3;
        this.f4373b = i4;
        this.f4374c = easing;
        this.f4375d = new VectorizedFloatAnimationSpec(new FloatTweenSpec(e(), c(), easing));
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int c() {
        return this.f4373b;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int e() {
        return this.f4372a;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector f(long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return this.f4375d.f(j3, animationVector, animationVector2, animationVector3);
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector g(long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return this.f4375d.g(j3, animationVector, animationVector2, animationVector3);
    }
}
