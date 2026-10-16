package androidx.compose.material3;

import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
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
public final class NavigationBarItemDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NavigationBarItemDefaults f18412a = new NavigationBarItemDefaults();

    private NavigationBarItemDefaults() {
    }

    public final NavigationBarItemColors a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1018883954, i3, -1, "androidx.compose.material3.NavigationBarItemDefaults.colors (NavigationBar.kt:311)");
        }
        NavigationBarItemColors navigationBarItemColorsB = b(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return navigationBarItemColorsB;
    }

    public final NavigationBarItemColors b(ColorScheme colorScheme) {
        NavigationBarItemColors navigationBarItemColorsB = colorScheme.B();
        if (navigationBarItemColorsB != null) {
            return navigationBarItemColorsB;
        }
        NavigationBarTokens navigationBarTokens = NavigationBarTokens.f22957a;
        NavigationBarItemColors navigationBarItemColors = new NavigationBarItemColors(ColorSchemeKt.g(colorScheme, navigationBarTokens.a()), ColorSchemeKt.g(colorScheme, navigationBarTokens.f()), ColorSchemeKt.g(colorScheme, navigationBarTokens.b()), ColorSchemeKt.g(colorScheme, navigationBarTokens.j()), ColorSchemeKt.g(colorScheme, navigationBarTokens.k()), Color.r(ColorSchemeKt.g(colorScheme, navigationBarTokens.j()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, navigationBarTokens.k()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.Y0(navigationBarItemColors);
        return navigationBarItemColors;
    }
}
