package cz.mobilesoft.coreblock.util.compose;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.animation.core.StartOffset;
import androidx.compose.animation.core.StartOffsetType;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import com.valentinilk.shimmer.Shimmer;
import com.valentinilk.shimmer.ShimmerBounds;
import com.valentinilk.shimmer.ShimmerKt;
import com.valentinilk.shimmer.ShimmerTheme;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ShimmerThemeKt {
    public static final Shimmer a(ShimmerBounds shimmerBounds, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            shimmerBounds = ShimmerBounds.Window.f93799b;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(646613501, i3, -1, "cz.mobilesoft.coreblock.util.compose.rememberThemedShimmer (ShimmerTheme.kt:17)");
        }
        Shimmer shimmerA = ShimmerKt.a(shimmerBounds, ShimmerTheme.b(com.valentinilk.shimmer.ShimmerThemeKt.a(), AnimationSpecKt.d(AnimationSpecKt.m(800, 500, EasingKt.e()), RepeatMode.f4052a, StartOffset.a(750, StartOffsetType.f4149b.b())), 0, 0.0f, CollectionsKt.listOf((Object[]) new Color[]{Color.n(ComposeColorsKt.j(composer, 0).g0()), Color.n(ComposeColorsKt.j(composer, 0).q()), Color.n(ComposeColorsKt.j(composer, 0).g0())}), null, 0.0f, 54, null), composer, (i3 & 14) | ShimmerBounds.f93796a | (ShimmerTheme.f93821g << 3), 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shimmerA;
    }
}
