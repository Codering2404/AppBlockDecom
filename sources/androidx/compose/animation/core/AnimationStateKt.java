package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.internal.FloatCompanionObject;

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
public final class AnimationStateKt {
    public static final AnimationState a(float f3, float f4, long j3, long j4, boolean z2) {
        return new AnimationState(VectorConvertersKt.i(FloatCompanionObject.f140130a), Float.valueOf(f3), AnimationVectorsKt.a(f4), j3, j4, z2);
    }

    public static final AnimationState b(TwoWayConverter twoWayConverter, Object obj, Object obj2, long j3, long j4, boolean z2) {
        return new AnimationState(twoWayConverter, obj, (AnimationVector) twoWayConverter.a().invoke(obj2), j3, j4, z2);
    }

    public static /* synthetic */ AnimationState c(float f3, float f4, long j3, long j4, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            f4 = 0.0f;
        }
        if ((i3 & 4) != 0) {
            j3 = Long.MIN_VALUE;
        }
        if ((i3 & 8) != 0) {
            j4 = Long.MIN_VALUE;
        }
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        return a(f3, f4, j3, j4, z2);
    }

    public static /* synthetic */ AnimationState d(TwoWayConverter twoWayConverter, Object obj, Object obj2, long j3, long j4, boolean z2, int i3, Object obj3) {
        if ((i3 & 8) != 0) {
            j3 = Long.MIN_VALUE;
        }
        if ((i3 & 16) != 0) {
            j4 = Long.MIN_VALUE;
        }
        if ((i3 & 32) != 0) {
            z2 = false;
        }
        return b(twoWayConverter, obj, obj2, j3, j4, z2);
    }

    public static final AnimationState e(AnimationState animationState, float f3, float f4, long j3, long j4, boolean z2) {
        return new AnimationState(animationState.n(), Float.valueOf(f3), AnimationVectorsKt.a(f4), j3, j4, z2);
    }

    public static final AnimationState f(AnimationState animationState, Object obj, AnimationVector animationVector, long j3, long j4, boolean z2) {
        return new AnimationState(animationState.n(), obj, animationVector, j3, j4, z2);
    }

    public static /* synthetic */ AnimationState g(AnimationState animationState, float f3, float f4, long j3, long j4, boolean z2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = ((Number) animationState.getValue()).floatValue();
        }
        if ((i3 & 2) != 0) {
            f4 = ((AnimationVector1D) animationState.q()).f();
        }
        if ((i3 & 4) != 0) {
            j3 = animationState.i();
        }
        if ((i3 & 8) != 0) {
            j4 = animationState.b();
        }
        if ((i3 & 16) != 0) {
            z2 = animationState.r();
        }
        boolean z3 = z2;
        long j5 = j4;
        return e(animationState, f3, f4, j3, j5, z3);
    }

    public static /* synthetic */ AnimationState h(AnimationState animationState, Object obj, AnimationVector animationVector, long j3, long j4, boolean z2, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            obj = animationState.getValue();
        }
        if ((i3 & 2) != 0) {
            animationVector = AnimationVectorsKt.e(animationState.q());
        }
        if ((i3 & 4) != 0) {
            j3 = animationState.i();
        }
        if ((i3 & 8) != 0) {
            j4 = animationState.b();
        }
        if ((i3 & 16) != 0) {
            z2 = animationState.r();
        }
        boolean z3 = z2;
        long j5 = j4;
        return f(animationState, obj, animationVector, j3, j5, z3);
    }

    public static final AnimationVector i(TwoWayConverter twoWayConverter, Object obj) {
        AnimationVector animationVector = (AnimationVector) twoWayConverter.a().invoke(obj);
        animationVector.d();
        return animationVector;
    }
}
