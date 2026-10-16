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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class VectorizedFloatAnimationSpec<V extends AnimationVector> implements VectorizedFiniteAnimationSpec<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Animations f4319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AnimationVector f4320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AnimationVector f4321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AnimationVector f4322d;

    public VectorizedFloatAnimationSpec(Animations animations) {
        this.f4319a = animations;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public long b(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        int iB = animationVector.b();
        long jMax = 0;
        for (int i3 = 0; i3 < iB; i3++) {
            jMax = Math.max(jMax, this.f4319a.get(i3).e(animationVector.a(i3), animationVector2.a(i3), animationVector3.a(i3)));
        }
        return jMax;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector d(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        if (this.f4322d == null) {
            this.f4322d = AnimationVectorsKt.g(animationVector3);
        }
        AnimationVector animationVector4 = this.f4322d;
        if (animationVector4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
            animationVector4 = null;
        }
        int iB = animationVector4.b();
        for (int i3 = 0; i3 < iB; i3++) {
            AnimationVector animationVector5 = this.f4322d;
            if (animationVector5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
                animationVector5 = null;
            }
            animationVector5.e(i3, this.f4319a.get(i3).b(animationVector.a(i3), animationVector2.a(i3), animationVector3.a(i3)));
        }
        AnimationVector animationVector6 = this.f4322d;
        if (animationVector6 != null) {
            return animationVector6;
        }
        Intrinsics.throwUninitializedPropertyAccessException("endVelocityVector");
        return null;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector f(long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        if (this.f4321c == null) {
            this.f4321c = AnimationVectorsKt.g(animationVector3);
        }
        AnimationVector animationVector4 = this.f4321c;
        if (animationVector4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            animationVector4 = null;
        }
        int iB = animationVector4.b();
        for (int i3 = 0; i3 < iB; i3++) {
            AnimationVector animationVector5 = this.f4321c;
            if (animationVector5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                animationVector5 = null;
            }
            animationVector5.e(i3, this.f4319a.get(i3).d(j3, animationVector.a(i3), animationVector2.a(i3), animationVector3.a(i3)));
        }
        AnimationVector animationVector6 = this.f4321c;
        if (animationVector6 != null) {
            return animationVector6;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    }

    @Override // androidx.compose.animation.core.VectorizedAnimationSpec
    public AnimationVector g(long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        if (this.f4320b == null) {
            this.f4320b = AnimationVectorsKt.g(animationVector);
        }
        AnimationVector animationVector4 = this.f4320b;
        if (animationVector4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            animationVector4 = null;
        }
        int iB = animationVector4.b();
        for (int i3 = 0; i3 < iB; i3++) {
            AnimationVector animationVector5 = this.f4320b;
            if (animationVector5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                animationVector5 = null;
            }
            animationVector5.e(i3, this.f4319a.get(i3).c(j3, animationVector.a(i3), animationVector2.a(i3), animationVector3.a(i3)));
        }
        AnimationVector animationVector6 = this.f4320b;
        if (animationVector6 != null) {
            return animationVector6;
        }
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        return null;
    }

    public VectorizedFloatAnimationSpec(final FloatAnimationSpec floatAnimationSpec) {
        this(new Animations() { // from class: androidx.compose.animation.core.VectorizedFloatAnimationSpec.1
            @Override // androidx.compose.animation.core.Animations
            public FloatAnimationSpec get(int i3) {
                return floatAnimationSpec;
            }
        });
    }
}
