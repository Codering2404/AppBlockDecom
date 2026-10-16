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
public final class VectorizedRepeatableSpec<V extends AnimationVector> implements VectorizedFiniteAnimationSpec<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final VectorizedDurationBasedAnimationSpec f4364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RepeatMode f4365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f4366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f4367e;

    public /* synthetic */ VectorizedRepeatableSpec(int i3, VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec, RepeatMode repeatMode, long j3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, vectorizedDurationBasedAnimationSpec, repeatMode, j3);
    }

    private final long h(long j3) {
        long j4 = this.f4367e;
        if (j3 + j4 <= 0) {
            return 0L;
        }
        long j5 = j3 + j4;
        long jMin = Math.min(j5 / this.f4366d, ((long) this.f4363a) - 1);
        return (this.f4365c == RepeatMode.f4052a || jMin % ((long) 2) == 0) ? j5 - (jMin * this.f4366d) : ((jMin + 1) * this.f4366d) - j5;
    }

    private final AnimationVector i(long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        long j4 = this.f4367e;
        long j5 = j3 + j4;
        long j6 = this.f4366d;
        return j5 > j6 ? f(j6 - j4, animationVector, animationVector2, animationVector3) : animationVector2;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long b(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return (((long) this.f4363a) * this.f4366d) - this.f4367e;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector f(long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return this.f4364b.f(h(j3), animationVector, animationVector2, i(j3, animationVector, animationVector3, animationVector2));
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector g(long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return this.f4364b.g(h(j3), animationVector, animationVector2, i(j3, animationVector, animationVector3, animationVector2));
    }

    private VectorizedRepeatableSpec(int i3, VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec, RepeatMode repeatMode, long j3) {
        this.f4363a = i3;
        this.f4364b = vectorizedDurationBasedAnimationSpec;
        this.f4365c = repeatMode;
        if (i3 < 1) {
            throw new IllegalArgumentException("Iterations count can't be less than 1");
        }
        this.f4366d = ((long) (vectorizedDurationBasedAnimationSpec.c() + vectorizedDurationBasedAnimationSpec.e())) * 1000000;
        this.f4367e = j3 * 1000000;
    }
}
