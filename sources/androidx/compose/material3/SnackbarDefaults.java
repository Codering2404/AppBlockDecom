package androidx.compose.material3;

import androidx.compose.material3.tokens.SnackbarTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
public final class SnackbarDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SnackbarDefaults f20207a = new SnackbarDefaults();

    private SnackbarDefaults() {
    }

    public final long a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(743425465, i3, -1, "androidx.compose.material3.SnackbarDefaults.<get-actionColor> (Snackbar.kt:430)");
        }
        long jI = ColorSchemeKt.i(SnackbarTokens.f23422a.a(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final long b(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1313141593, i3, -1, "androidx.compose.material3.SnackbarDefaults.<get-actionContentColor> (Snackbar.kt:434)");
        }
        long jI = ColorSchemeKt.i(SnackbarTokens.f23422a.a(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final long c(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(987938253, i3, -1, "androidx.compose.material3.SnackbarDefaults.<get-color> (Snackbar.kt:422)");
        }
        long jI = ColorSchemeKt.i(SnackbarTokens.f23422a.c(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final long d(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1021310823, i3, -1, "androidx.compose.material3.SnackbarDefaults.<get-contentColor> (Snackbar.kt:426)");
        }
        long jI = ColorSchemeKt.i(SnackbarTokens.f23422a.h(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final long e(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-528602817, i3, -1, "androidx.compose.material3.SnackbarDefaults.<get-dismissActionContentColor> (Snackbar.kt:438)");
        }
        long jI = ColorSchemeKt.i(SnackbarTokens.f23422a.f(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final Shape f(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-551629101, i3, -1, "androidx.compose.material3.SnackbarDefaults.<get-shape> (Snackbar.kt:418)");
        }
        Shape shapeE = ShapesKt.e(SnackbarTokens.f23422a.e(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }
}
