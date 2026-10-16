package com.valentinilk.shimmer;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Rect;
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
public final class ShimmerKt {
    public static final Shimmer a(ShimmerBounds shimmerBounds, ShimmerTheme shimmerTheme, Composer composer, int i3, int i4) {
        Intrinsics.checkNotNullParameter(shimmerBounds, "shimmerBounds");
        composer.F(466348159);
        if ((i4 & 2) != 0) {
            shimmerTheme = (ShimmerTheme) composer.q(ShimmerThemeKt.b());
        }
        if (ComposerKt.M()) {
            ComposerKt.U(466348159, i3, -1, "com.valentinilk.shimmer.rememberShimmer (Shimmer.kt:8)");
        }
        ShimmerEffect shimmerEffectA = ShimmerEffectKt.a(shimmerTheme, composer, 8);
        Rect rectA = ShimmerBoundsKt.a(shimmerBounds, composer, i3 & 14);
        composer.F(1618982084);
        boolean Z = composer.Z(shimmerTheme) | composer.Z(shimmerEffectA) | composer.Z(rectA);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Shimmer(shimmerTheme, shimmerEffectA, rectA);
            composer.w(objG);
        }
        composer.Y();
        Shimmer shimmer = (Shimmer) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.Y();
        return shimmer;
    }
}
