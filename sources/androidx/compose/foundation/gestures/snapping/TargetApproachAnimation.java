package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;

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
final class TargetApproachAnimation implements ApproachAnimation<Float, AnimationVector1D> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnimationSpec f6489a;

    public TargetApproachAnimation(AnimationSpec animationSpec) {
        this.f6489a = animationSpec;
    }

    @Override // androidx.compose.foundation.gestures.snapping.ApproachAnimation
    public /* bridge */ /* synthetic */ Object a(ScrollScope scrollScope, Object obj, Object obj2, Function1 function1, Continuation continuation) {
        return b(scrollScope, ((Number) obj).floatValue(), ((Number) obj2).floatValue(), function1, continuation);
    }

    public Object b(ScrollScope scrollScope, float f3, float f4, Function1 function1, Continuation continuation) throws Throwable {
        Object objH = SnapFlingBehaviorKt.h(scrollScope, Math.abs(f3) * Math.signum(f4), f3, AnimationStateKt.c(0.0f, f4, 0L, 0L, false, 28, null), this.f6489a, function1, continuation);
        return objH == IntrinsicsKt.f() ? objH : (AnimationResult) objH;
    }
}
