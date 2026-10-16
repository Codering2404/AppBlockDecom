package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.material3.tokens.ScrimTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
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
public final class DrawerDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DrawerDefaults f17485a = new DrawerDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f17486b = ElevationTokens.f22534a.a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f17487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f17488d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f17489e;

    static {
        NavigationDrawerTokens navigationDrawerTokens = NavigationDrawerTokens.f22983a;
        f17487c = navigationDrawerTokens.l();
        f17488d = navigationDrawerTokens.l();
        f17489e = navigationDrawerTokens.g();
    }

    private DrawerDefaults() {
    }

    public final float a() {
        return f17488d;
    }

    public final float b() {
        return f17489e;
    }

    public final long c(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(706424321, i3, -1, "androidx.compose.material3.DrawerDefaults.<get-modalContainerColor> (NavigationDrawer.kt:888)");
        }
        long jI = ColorSchemeKt.i(NavigationDrawerTokens.f22983a.j(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final float d() {
        return f17486b;
    }

    public final float e() {
        return f17487c;
    }

    public final long f(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1055074989, i3, -1, "androidx.compose.material3.DrawerDefaults.<get-scrimColor> (NavigationDrawer.kt:869)");
        }
        long jR = Color.r(ColorSchemeKt.i(ScrimTokens.f23311a.a(), composer, 6), 0.32f, 0.0f, 0.0f, 0.0f, 14, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jR;
    }

    public final Shape g(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(928378975, i3, -1, "androidx.compose.material3.DrawerDefaults.<get-shape> (NavigationDrawer.kt:865)");
        }
        Shape shapeE = ShapesKt.e(NavigationDrawerTokens.f22983a.f(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final long h(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-125949421, i3, -1, "androidx.compose.material3.DrawerDefaults.<get-standardContainerColor> (NavigationDrawer.kt:884)");
        }
        long jI = ColorSchemeKt.i(NavigationDrawerTokens.f22983a.k(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final WindowInsets i(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-909973510, i3, -1, "androidx.compose.material3.DrawerDefaults.<get-windowInsets> (NavigationDrawer.kt:897)");
        }
        WindowInsets windowInsetsA = SystemBarsDefaultInsets_androidKt.a(WindowInsets.f7172a, composer, 6);
        WindowInsetsSides.Companion companion = WindowInsetsSides.f7284b;
        WindowInsets windowInsetsI = WindowInsetsKt.i(windowInsetsA, WindowInsetsSides.r(companion.l(), companion.j()));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return windowInsetsI;
    }
}
