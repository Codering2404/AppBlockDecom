package androidx.compose.foundation.pager;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.PagerSnapLayoutInfoProviderKt;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.IntCompanionObject;

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
public final class PagerDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PagerDefaults f8668a = new PagerDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f8669b = 0;

    private PagerDefaults() {
    }

    public final TargetedFlingBehavior a(final PagerState pagerState, PagerSnapDistance pagerSnapDistance, DecayAnimationSpec decayAnimationSpec, AnimationSpec animationSpec, final float f3, Composer composer, int i3, int i4) {
        boolean z2 = true;
        if ((i4 & 2) != 0) {
            pagerSnapDistance = PagerSnapDistance.f8838a.a(1);
        }
        if ((i4 & 4) != 0) {
            decayAnimationSpec = SplineBasedFloatDecayAnimationSpec_androidKt.b(composer, 0);
        }
        if ((i4 & 8) != 0) {
            animationSpec = AnimationSpecKt.l(0.0f, 400.0f, Float.valueOf(VisibilityThresholdsKt.b(IntCompanionObject.f140132a)), 1, null);
        }
        if ((i4 & 16) != 0) {
            f3 = 0.5f;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1559769181, i3, -1, "androidx.compose.foundation.pager.PagerDefaults.flingBehavior (Pager.kt:383)");
        }
        if (!(0.0f <= f3 && f3 <= 1.0f)) {
            InlineClassHelperKt.a("snapPositionalThreshold should be a number between 0 and 1. You've specified " + f3);
        }
        Object obj = (Density) composer.q(CompositionLocalsKt.f());
        final LayoutDirection layoutDirection = (LayoutDirection) composer.q(CompositionLocalsKt.m());
        boolean Z = ((((i3 & 14) ^ 6) > 4 && composer.Z(pagerState)) || (i3 & 6) == 4) | composer.Z(decayAnimationSpec) | composer.Z(animationSpec);
        if ((((i3 & 112) ^ 48) <= 32 || !composer.Z(pagerSnapDistance)) && (i3 & 48) != 32) {
            z2 = false;
        }
        boolean Z2 = Z | z2 | composer.Z(obj) | composer.Z(layoutDirection);
        Object objG = composer.G();
        if (Z2 || objG == Composer.f23746a.a()) {
            objG = SnapFlingBehaviorKt.o(PagerSnapLayoutInfoProviderKt.a(pagerState, pagerSnapDistance, new Function3<Float, Float, Float, Float>() { // from class: androidx.compose.foundation.pager.PagerDefaults$flingBehavior$2$snapLayoutInfoProvider$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                public final Float c(float f4, float f5, float f6) {
                    return Float.valueOf(PagerSnapLayoutInfoProviderKt.c(pagerState, layoutDirection, f3, f4, f5, f6));
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3, Object obj4) {
                    return c(((Number) obj2).floatValue(), ((Number) obj3).floatValue(), ((Number) obj4).floatValue());
                }
            }), decayAnimationSpec, animationSpec);
            composer.w(objG);
        }
        TargetedFlingBehavior targetedFlingBehavior = (TargetedFlingBehavior) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return targetedFlingBehavior;
    }

    public final NestedScrollConnection b(PagerState pagerState, Orientation orientation, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(877583120, i3, -1, "androidx.compose.foundation.pager.PagerDefaults.pageNestedScrollConnection (Pager.kt:432)");
        }
        boolean z2 = ((((i3 & 14) ^ 6) > 4 && composer.Z(pagerState)) || (i3 & 6) == 4) | ((((i3 & 112) ^ 48) > 32 && composer.Z(orientation)) || (i3 & 48) == 32);
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            objG = new DefaultPagerNestedScrollConnection(pagerState, orientation);
            composer.w(objG);
        }
        DefaultPagerNestedScrollConnection defaultPagerNestedScrollConnection = (DefaultPagerNestedScrollConnection) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return defaultPagerNestedScrollConnection;
    }
}
