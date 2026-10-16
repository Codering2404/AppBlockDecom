package androidx.compose.animation;

import android.view.ViewConfiguration;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
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
public final class SplineBasedFloatDecayAnimationSpec_androidKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f3755a = ViewConfiguration.getScrollFriction();

    public static final float a() {
        return f3755a;
    }

    public static final DecayAnimationSpec b(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(904445851, i3, -1, "androidx.compose.animation.rememberSplineBasedDecay (SplineBasedFloatDecayAnimationSpec.android.kt:40)");
        }
        Density density = (Density) composer.q(CompositionLocalsKt.f());
        boolean zC = composer.c(density.getDensity());
        Object objG = composer.G();
        if (zC || objG == Composer.f23746a.a()) {
            objG = DecayAnimationSpecKt.d(new SplineBasedFloatDecayAnimationSpec(density));
            composer.w(objG);
        }
        DecayAnimationSpec decayAnimationSpec = (DecayAnimationSpec) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return decayAnimationSpec;
    }
}
