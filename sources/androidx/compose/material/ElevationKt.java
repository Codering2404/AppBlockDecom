package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.CubicBezierEasing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

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
public final class ElevationKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final TweenSpec f12867a = new TweenSpec(120, 0, EasingKt.d(), 2, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final TweenSpec f12868b = new TweenSpec(150, 0, new CubicBezierEasing(0.4f, 0.0f, 0.6f, 1.0f), 2, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final TweenSpec f12869c = new TweenSpec(120, 0, new CubicBezierEasing(0.4f, 0.0f, 0.6f, 1.0f), 2, null);

    public static final Object d(Animatable animatable, float f3, Interaction interaction, Interaction interaction2, Continuation continuation) {
        AnimationSpec animationSpecA = interaction2 != null ? ElevationDefaults.f12866a.a(interaction2) : interaction != null ? ElevationDefaults.f12866a.b(interaction) : null;
        if (animationSpecA != null) {
            Object objF = Animatable.f(animatable, Dp.d(f3), animationSpecA, null, null, continuation, 12, null);
            return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
        }
        Object objU = animatable.u(Dp.d(f3), continuation);
        return objU == IntrinsicsKt.f() ? objU : Unit.f139807a;
    }
}
