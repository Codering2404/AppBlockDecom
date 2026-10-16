package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class VectorizedInfiniteRepeatableSpec<V extends AnimationVector> implements VectorizedAnimationSpec<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final VectorizedDurationBasedAnimationSpec f4329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final RepeatMode f4330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f4331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f4332d;

    public /* synthetic */ VectorizedInfiniteRepeatableSpec(VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec, RepeatMode repeatMode, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(vectorizedDurationBasedAnimationSpec, repeatMode, j3);
    }

    private final long h(long j3) {
        long j4 = this.f4332d;
        if (j3 + j4 <= 0) {
            return 0L;
        }
        long j5 = j3 + j4;
        long j6 = this.f4331c;
        long j7 = j5 / j6;
        return (this.f4330b == RepeatMode.f4052a || j7 % ((long) 2) == 0) ? j5 - (j7 * j6) : ((j7 + 1) * j6) - j5;
    }

    private final AnimationVector i(long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        long j4 = this.f4332d;
        long j5 = j3 + j4;
        long j6 = this.f4331c;
        return j5 > j6 ? this.f4329a.f(j6 - j4, animationVector, animationVector3, animationVector2) : animationVector2;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public boolean a() {
        return true;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long b(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return Long.MAX_VALUE;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector f(long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return this.f4329a.f(h(j3), animationVector, animationVector2, i(j3, animationVector, animationVector3, animationVector2));
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector g(long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return this.f4329a.g(h(j3), animationVector, animationVector2, i(j3, animationVector, animationVector3, animationVector2));
    }

    private VectorizedInfiniteRepeatableSpec(VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec, RepeatMode repeatMode, long j3) {
        this.f4329a = vectorizedDurationBasedAnimationSpec;
        this.f4330b = repeatMode;
        this.f4331c = ((long) (vectorizedDurationBasedAnimationSpec.c() + vectorizedDurationBasedAnimationSpec.e())) * 1000000;
        this.f4332d = j3 * 1000000;
    }
}
