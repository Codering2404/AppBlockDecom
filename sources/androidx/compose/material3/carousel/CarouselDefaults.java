package androidx.compose.material3.carousel;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.foundation.pager.PagerDefaults;
import androidx.compose.foundation.pager.PagerSnapDistance;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
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
public final class CarouselDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CarouselDefaults f21616a = new CarouselDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f21617b = Dp.g(40);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f21618c = Dp.g(56);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f21619d = Dp.g(10);

    private CarouselDefaults() {
    }

    public final float a() {
        return f21619d;
    }

    public final float b() {
        return f21618c;
    }

    public final float c() {
        return f21617b;
    }

    public final TargetedFlingBehavior d(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-418415756, i3, -1, "androidx.compose.material3.carousel.CarouselDefaults.noSnapFlingBehavior (Carousel.kt:673)");
        }
        Object objG = composer.G();
        if (objG == Composer.f23746a.a()) {
            objG = new SnapLayoutInfoProvider() { // from class: androidx.compose.material3.carousel.CarouselDefaults$noSnapFlingBehavior$decayLayoutInfoProvider$1$1
                @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
                public float a(float f3) {
                    return 0.0f;
                }
            };
            composer.w(objG);
        }
        TargetedFlingBehavior targetedFlingBehaviorN = SnapFlingBehaviorKt.n((CarouselDefaults$noSnapFlingBehavior$decayLayoutInfoProvider$1$1) objG, composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return targetedFlingBehaviorN;
    }

    public final TargetedFlingBehavior e(CarouselState carouselState, AnimationSpec animationSpec, Composer composer, int i3, int i4) {
        if ((i4 & 2) != 0) {
            animationSpec = AnimationSpecKt.l(0.0f, 400.0f, null, 5, null);
        }
        AnimationSpec animationSpec2 = animationSpec;
        if (ComposerKt.M()) {
            ComposerKt.U(1701587199, i3, -1, "androidx.compose.material3.carousel.CarouselDefaults.singleAdvanceFlingBehavior (Carousel.kt:611)");
        }
        TargetedFlingBehavior targetedFlingBehaviorA = PagerDefaults.f8668a.a(carouselState.h(), PagerSnapDistance.f8838a.a(1), null, animationSpec2, 0.0f, composer, ((i3 << 6) & 7168) | (PagerDefaults.f8669b << 15), 20);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return targetedFlingBehaviorA;
    }
}
