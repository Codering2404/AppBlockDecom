package com.valentinilk.shimmer;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ShimmerEffectKt {
    public static final ShimmerEffect a(ShimmerTheme theme, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(theme, "theme");
        composer.F(1265936280);
        if (ComposerKt.M()) {
            ComposerKt.U(1265936280, i3, -1, "com.valentinilk.shimmer.rememberShimmerEffect (ShimmerEffect.kt:21)");
        }
        float fM1 = ((Density) composer.q(CompositionLocalsKt.f())).M1(theme.h());
        composer.F(1157296644);
        boolean Z = composer.Z(theme);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            ShimmerEffect shimmerEffect = new ShimmerEffect(theme.c(), theme.d(), theme.e(), theme.g(), theme.f(), fM1, null);
            composer.w(shimmerEffect);
            objG = shimmerEffect;
        }
        composer.Y();
        ShimmerEffect shimmerEffect2 = (ShimmerEffect) objG;
        EffectsKt.g(shimmerEffect2, new ShimmerEffectKt$rememberShimmerEffect$1(shimmerEffect2, null), composer, 72);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return shimmerEffect2;
    }
}
