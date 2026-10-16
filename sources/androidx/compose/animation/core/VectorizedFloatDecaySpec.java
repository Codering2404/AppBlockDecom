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
final class VectorizedFloatDecaySpec<V extends AnimationVector> implements VectorizedDecayAnimationSpec<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FloatDecayAnimationSpec f4324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AnimationVector f4325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AnimationVector f4326c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AnimationVector f4327d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f4328e;

    public VectorizedFloatDecaySpec(FloatDecayAnimationSpec floatDecayAnimationSpec) {
        this.f4324a = floatDecayAnimationSpec;
        this.f4328e = floatDecayAnimationSpec.a();
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public float a() {
        return this.f4328e;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public AnimationVector b(long j3, AnimationVector animationVector, AnimationVector animationVector2) {
        if (this.f4326c == null) {
            this.f4326c = AnimationVectorsKt.g(animationVector);
        }
        AnimationVector animationVector3 = this.f4326c;
        if (animationVector3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            animationVector3 = null;
        }
        int iB = animationVector3.b();
        for (int i3 = 0; i3 < iB; i3++) {
            AnimationVector animationVector4 = this.f4326c;
            if (animationVector4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
                animationVector4 = null;
            }
            animationVector4.e(i3, this.f4324a.b(j3, animationVector.a(i3), animationVector2.a(i3)));
        }
        AnimationVector animationVector5 = this.f4326c;
        if (animationVector5 != null) {
            return animationVector5;
        }
        Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
        return null;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public long c(AnimationVector animationVector, AnimationVector animationVector2) {
        if (this.f4326c == null) {
            this.f4326c = AnimationVectorsKt.g(animationVector);
        }
        AnimationVector animationVector3 = this.f4326c;
        if (animationVector3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("velocityVector");
            animationVector3 = null;
        }
        int iB = animationVector3.b();
        long jMax = 0;
        for (int i3 = 0; i3 < iB; i3++) {
            jMax = Math.max(jMax, this.f4324a.c(animationVector.a(i3), animationVector2.a(i3)));
        }
        return jMax;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public AnimationVector d(AnimationVector animationVector, AnimationVector animationVector2) {
        if (this.f4327d == null) {
            this.f4327d = AnimationVectorsKt.g(animationVector);
        }
        AnimationVector animationVector3 = this.f4327d;
        if (animationVector3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("targetVector");
            animationVector3 = null;
        }
        int iB = animationVector3.b();
        for (int i3 = 0; i3 < iB; i3++) {
            AnimationVector animationVector4 = this.f4327d;
            if (animationVector4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("targetVector");
                animationVector4 = null;
            }
            animationVector4.e(i3, this.f4324a.d(animationVector.a(i3), animationVector2.a(i3)));
        }
        AnimationVector animationVector5 = this.f4327d;
        if (animationVector5 != null) {
            return animationVector5;
        }
        Intrinsics.throwUninitializedPropertyAccessException("targetVector");
        return null;
    }

    @Override // androidx.compose.animation.core.VectorizedDecayAnimationSpec
    public AnimationVector e(long j3, AnimationVector animationVector, AnimationVector animationVector2) {
        if (this.f4325b == null) {
            this.f4325b = AnimationVectorsKt.g(animationVector);
        }
        AnimationVector animationVector3 = this.f4325b;
        if (animationVector3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("valueVector");
            animationVector3 = null;
        }
        int iB = animationVector3.b();
        for (int i3 = 0; i3 < iB; i3++) {
            AnimationVector animationVector4 = this.f4325b;
            if (animationVector4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("valueVector");
                animationVector4 = null;
            }
            animationVector4.e(i3, this.f4324a.e(j3, animationVector.a(i3), animationVector2.a(i3)));
        }
        AnimationVector animationVector5 = this.f4325b;
        if (animationVector5 != null) {
            return animationVector5;
        }
        Intrinsics.throwUninitializedPropertyAccessException("valueVector");
        return null;
    }
}
