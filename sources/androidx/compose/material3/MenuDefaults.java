package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.material3.tokens.MenuTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
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
public final class MenuDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MenuDefaults f18137a = new MenuDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f18138b = ElevationTokens.f22534a.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f18139c = MenuTokens.f22937a.b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final PaddingValues f18140d = PaddingKt.b(MenuKt.f18149c, Dp.g(0));

    private MenuDefaults() {
    }

    public final long a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1787427929, i3, -1, "androidx.compose.material3.MenuDefaults.<get-containerColor> (Menu.kt:198)");
        }
        long jI = ColorSchemeKt.i(MenuTokens.f22937a.a(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final MenuItemColors b(ColorScheme colorScheme) {
        MenuItemColors menuItemColorsA = colorScheme.A();
        if (menuItemColorsA != null) {
            return menuItemColorsA;
        }
        ListTokens listTokens = ListTokens.f22906a;
        MenuItemColors menuItemColors = new MenuItemColors(ColorSchemeKt.g(colorScheme, listTokens.j()), ColorSchemeKt.g(colorScheme, listTokens.l()), ColorSchemeKt.g(colorScheme, listTokens.t()), Color.r(ColorSchemeKt.g(colorScheme, listTokens.d()), listTokens.e(), 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, listTokens.f()), listTokens.g(), 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, listTokens.h()), listTokens.i(), 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.X0(menuItemColors);
        return menuItemColors;
    }

    public final PaddingValues c() {
        return f18140d;
    }

    public final float d() {
        return f18139c;
    }

    public final Shape e(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(218702739, i3, -1, "androidx.compose.material3.MenuDefaults.<get-shape> (Menu.kt:194)");
        }
        Shape shapeE = ShapesKt.e(MenuTokens.f22937a.c(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final float f() {
        return f18138b;
    }

    public final MenuItemColors g(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1326531516, i3, -1, "androidx.compose.material3.MenuDefaults.itemColors (Menu.kt:204)");
        }
        MenuItemColors menuItemColorsB = b(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return menuItemColorsB;
    }
}
