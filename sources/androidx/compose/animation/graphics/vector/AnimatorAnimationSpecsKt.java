package androidx.compose.animation.graphics.vector;

import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.AnimationVector3D;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.FiniteAnimationSpec;
import java.util.List;
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
public final class AnimatorAnimationSpecsKt {
    public static final FiniteAnimationSpec b(List list) {
        return new CombinedSpec(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnimationVector c(AnimationVector animationVector) {
        if (animationVector instanceof AnimationVector1D) {
            return new AnimationVector1D(((AnimationVector1D) animationVector).f() * (-1));
        }
        if (animationVector instanceof AnimationVector2D) {
            AnimationVector2D animationVector2D = (AnimationVector2D) animationVector;
            float f3 = -1;
            return new AnimationVector2D(animationVector2D.f() * f3, animationVector2D.g() * f3);
        }
        if (animationVector instanceof AnimationVector3D) {
            AnimationVector3D animationVector3D = (AnimationVector3D) animationVector;
            float f4 = -1;
            return new AnimationVector3D(animationVector3D.f() * f4, animationVector3D.g() * f4, animationVector3D.h() * f4);
        }
        if (animationVector instanceof AnimationVector4D) {
            AnimationVector4D animationVector4D = (AnimationVector4D) animationVector;
            float f5 = -1;
            return new AnimationVector4D(animationVector4D.f() * f5, animationVector4D.g() * f5, animationVector4D.h() * f5, animationVector4D.i() * f5);
        }
        throw new RuntimeException("Unknown AnimationVector: " + animationVector);
    }

    public static final FiniteAnimationSpec d(FiniteAnimationSpec finiteAnimationSpec, int i3) {
        return new ReversedSpec(finiteAnimationSpec, i3);
    }
}
