package androidx.compose.ui.tooling.animation.clock;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.RepeatableSpec;
import androidx.compose.animation.core.SnapSpec;
import androidx.compose.animation.core.StartOffset;
import androidx.compose.animation.core.StartOffsetType;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class Utils_androidKt$createTransitionInfo$startTimeMs$2 extends Lambda implements Function0<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AnimationSpec f29898a;

    @Override // kotlin.jvm.functions.Function0
    public final Long invoke() {
        Number numberValueOf = 0L;
        AnimationSpec animationSpec = this.f29898a;
        if (animationSpec instanceof TweenSpec) {
            numberValueOf = Integer.valueOf(((TweenSpec) animationSpec).f());
        } else if (animationSpec instanceof SnapSpec) {
            numberValueOf = Integer.valueOf(((SnapSpec) animationSpec).f());
        } else if (animationSpec instanceof KeyframesSpec) {
            numberValueOf = Integer.valueOf(((KeyframesSpec) animationSpec).f().a());
        } else if (animationSpec instanceof RepeatableSpec) {
            if (StartOffsetType.e(StartOffset.g(((RepeatableSpec) animationSpec).f()), StartOffsetType.f4149b.a())) {
                numberValueOf = Integer.valueOf(StartOffset.f(((RepeatableSpec) this.f29898a).f()));
            }
        } else if (animationSpec instanceof InfiniteRepeatableSpec) {
            if (StartOffsetType.e(StartOffset.g(((InfiniteRepeatableSpec) animationSpec).g()), StartOffsetType.f4149b.a())) {
                numberValueOf = Integer.valueOf(StartOffset.f(((InfiniteRepeatableSpec) this.f29898a).g()));
            }
        } else if (animationSpec instanceof VectorizedDurationBasedAnimationSpec) {
            numberValueOf = Integer.valueOf(((VectorizedDurationBasedAnimationSpec) animationSpec).c());
        }
        return Long.valueOf(numberValueOf.longValue());
    }
}
