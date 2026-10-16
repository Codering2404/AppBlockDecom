package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import com.facebook.share.HKJ.pnxuebdT;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ExpressiveNavigationBarItemDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExpressiveNavigationBarItemDefaults f17698a = new ExpressiveNavigationBarItemDefaults();

    private ExpressiveNavigationBarItemDefaults() {
    }

    public final NavigationItemColors b(ColorScheme colorScheme) {
        NavigationItemColors navigationItemColorsO = colorScheme.o();
        if (navigationItemColorsO != null) {
            return navigationItemColorsO;
        }
        NavigationItemColors navigationItemColors = new NavigationItemColors(ColorSchemeKt.g(colorScheme, ExpressiveNavigationBarKt.f17705g), ColorSchemeKt.g(colorScheme, ExpressiveNavigationBarKt.f17706h), ColorSchemeKt.g(colorScheme, ExpressiveNavigationBarKt.f17707i), ColorSchemeKt.g(colorScheme, ExpressiveNavigationBarKt.f17708j), ColorSchemeKt.g(colorScheme, ExpressiveNavigationBarKt.f17709k), Color.r(ColorSchemeKt.g(colorScheme, ExpressiveNavigationBarKt.f17708j), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, ExpressiveNavigationBarKt.f17709k), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.L0(navigationItemColors);
        return navigationItemColors;
    }

    public final NavigationItemColors a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1959617551, i3, -1, pnxuebdT.IdUrWFE);
        }
        NavigationItemColors navigationItemColorsB = b(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return navigationItemColorsB;
    }
}
