package androidx.compose.animation.core;

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
public final class VectorizedAnimationSpecKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f4314a = new int[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float[] f4315b = new float[0];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ArcSpline f4316c = new ArcSpline(new int[2], new float[2], new float[][]{new float[2], new float[2]});

    public static final long e(VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpec, long j3) {
        long jC = j3 - ((long) vectorizedDurationBasedAnimationSpec.c());
        long jE = vectorizedDurationBasedAnimationSpec.e();
        if (jC < 0) {
            jC = 0;
        }
        return jC > jE ? jE : jC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Animations f(final AnimationVector animationVector, final float f3, final float f4) {
        return animationVector != null ? new Animations(animationVector, f3, f4) { // from class: androidx.compose.animation.core.VectorizedAnimationSpecKt$createSpringAnimations$1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final FloatSpringSpec[] f4317a;

            {
                int iB = animationVector.b();
                FloatSpringSpec[] floatSpringSpecArr = new FloatSpringSpec[iB];
                for (int i3 = 0; i3 < iB; i3++) {
                    floatSpringSpecArr[i3] = new FloatSpringSpec(f3, f4, animationVector.a(i3));
                }
                this.f4317a = floatSpringSpecArr;
            }

            @Override // androidx.compose.animation.core.Animations
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public FloatSpringSpec get(int i3) {
                return this.f4317a[i3];
            }
        } : new Animations(f3, f4) { // from class: androidx.compose.animation.core.VectorizedAnimationSpecKt$createSpringAnimations$2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final FloatSpringSpec f4318a;

            {
                this.f4318a = new FloatSpringSpec(f3, f4, 0.0f, 4, null);
            }

            @Override // androidx.compose.animation.core.Animations
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public FloatSpringSpec get(int i3) {
                return this.f4318a;
            }
        };
    }

    public static final AnimationVector g(VectorizedAnimationSpec vectorizedAnimationSpec, long j3, AnimationVector animationVector, AnimationVector animationVector2, AnimationVector animationVector3) {
        return vectorizedAnimationSpec.g(j3 * 1000000, animationVector, animationVector2, animationVector3);
    }
}
