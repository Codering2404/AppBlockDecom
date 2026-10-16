package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.VectorizedAnimationSpec;
import androidx.compose.animation.core.VectorizedFiniteAnimationSpec;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
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
final class DelegatingAnimationSpec implements AnimationSpec<AnimationData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnimationSpec f5647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AnimationSpec f5648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AnimationSpec f5649c;

    @Override // androidx.compose.animation.core.AnimationSpec
    public VectorizedAnimationSpec a(final TwoWayConverter twoWayConverter) {
        AnimationSpec animationSpec = this.f5647a;
        FloatCompanionObject floatCompanionObject = FloatCompanionObject.f140130a;
        final VectorizedAnimationSpec vectorizedAnimationSpecA = animationSpec.a(VectorConvertersKt.i(floatCompanionObject));
        final VectorizedAnimationSpec vectorizedAnimationSpecA2 = this.f5648b.a(VectorConvertersKt.b(Offset.f25596b));
        final VectorizedAnimationSpec vectorizedAnimationSpecA3 = this.f5649c.a(VectorConvertersKt.i(floatCompanionObject));
        return new VectorizedFiniteAnimationSpec<AnimationVector>() { // from class: androidx.compose.foundation.gestures.DelegatingAnimationSpec$vectorize$1
            private final AnimationVector1D h(AnimationData animationData) {
                return (AnimationVector1D) VectorConvertersKt.i(FloatCompanionObject.f140130a).a().invoke(Float.valueOf(animationData.a()));
            }

            private final AnimationVector2D i(AnimationData animationData) {
                Function1 function1A = VectorConvertersKt.b(Offset.f25596b).a();
                float fIntBitsToFloat = Float.intBitsToFloat((int) (animationData.b() >> 32));
                float fIntBitsToFloat2 = Float.intBitsToFloat((int) (animationData.b() & 4294967295L));
                return (AnimationVector2D) function1A.invoke(Offset.d(Offset.e((((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L))));
            }

            private final AnimationVector j(AnimationVector1D animationVector1D, AnimationVector2D animationVector2D, AnimationVector1D animationVector1D2) {
                Function1 function1A = twoWayConverter.a();
                float f3 = animationVector1D.f();
                float f4 = animationVector2D.f();
                return (AnimationVector) function1A.invoke(new AnimationData(f3, Offset.e((((long) Float.floatToRawIntBits(animationVector2D.g())) & 4294967295L) | (Float.floatToRawIntBits(f4) << 32)), animationVector1D2.f(), null));
            }

            private final AnimationVector1D k(AnimationData animationData) {
                return (AnimationVector1D) VectorConvertersKt.i(FloatCompanionObject.f140130a).a().invoke(Float.valueOf(animationData.c()));
            }

            @Override // androidx.compose.animation.core.VectorizedAnimationSpec
            public long b(AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
                AnimationData animationData = (AnimationData) twoWayConverter.b().invoke(animationVector);
                AnimationData animationData2 = (AnimationData) twoWayConverter.b().invoke(animationVector2);
                AnimationData animationData3 = (AnimationData) twoWayConverter.b().invoke(animationVector3);
                return Math.max(vectorizedAnimationSpecA.b(k(animationData), k(animationData2), k(animationData3)), Math.max(vectorizedAnimationSpecA2.b(i(animationData), i(animationData2), i(animationData3)), vectorizedAnimationSpecA3.b(h(animationData), h(animationData2), h(animationData3))));
            }

            @Override // androidx.compose.animation.core.VectorizedAnimationSpec
            public AnimationVector f(long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
                AnimationData animationData = (AnimationData) twoWayConverter.b().invoke(animationVector);
                AnimationData animationData2 = (AnimationData) twoWayConverter.b().invoke(animationVector2);
                AnimationData animationData3 = (AnimationData) twoWayConverter.b().invoke(animationVector3);
                return j((AnimationVector1D) vectorizedAnimationSpecA.f(j3, k(animationData), k(animationData2), k(animationData3)), (AnimationVector2D) vectorizedAnimationSpecA2.f(j3, i(animationData), i(animationData2), i(animationData3)), (AnimationVector1D) vectorizedAnimationSpecA3.f(j3, h(animationData), h(animationData2), h(animationData3)));
            }

            @Override // androidx.compose.animation.core.VectorizedAnimationSpec
            public AnimationVector g(long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
                AnimationData animationData = (AnimationData) twoWayConverter.b().invoke(animationVector);
                AnimationData animationData2 = (AnimationData) twoWayConverter.b().invoke(animationVector2);
                AnimationData animationData3 = (AnimationData) twoWayConverter.b().invoke(animationVector3);
                return j((AnimationVector1D) vectorizedAnimationSpecA.g(j3, k(animationData), k(animationData2), k(animationData3)), (AnimationVector2D) vectorizedAnimationSpecA2.g(j3, i(animationData), i(animationData2), i(animationData3)), (AnimationVector1D) vectorizedAnimationSpecA3.g(j3, h(animationData), h(animationData2), h(animationData3)));
            }
        };
    }
}
