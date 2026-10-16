package androidx.compose.material3;

import androidx.compose.material3.tokens.ExtendedFabPrimaryTokens;
import androidx.compose.material3.tokens.FabPrimaryLargeTokens;
import androidx.compose.material3.tokens.FabPrimarySmallTokens;
import androidx.compose.material3.tokens.FabPrimaryTokens;
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
public final class FloatingActionButtonDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FloatingActionButtonDefaults f17759a = new FloatingActionButtonDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f17760b = FabPrimaryLargeTokens.f22563a.d();

    private FloatingActionButtonDefaults() {
    }

    public final FloatingActionButtonElevation a(float f3, float f4, float f5, float f6, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            f3 = FabPrimaryTokens.f22599a.b();
        }
        if ((i4 & 2) != 0) {
            f4 = FabPrimaryTokens.f22599a.h();
        }
        if ((i4 & 4) != 0) {
            f5 = FabPrimaryTokens.f22599a.f();
        }
        float f7 = f5;
        if ((i4 & 8) != 0) {
            f6 = FabPrimaryTokens.f22599a.g();
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-241106249, i3, -1, "androidx.compose.material3.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:446)");
        }
        float f8 = f3;
        FloatingActionButtonElevation floatingActionButtonElevation = new FloatingActionButtonElevation(f8, f4, f7, f6, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return floatingActionButtonElevation;
    }

    public final long b(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1855656391, i3, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-containerColor> (FloatingActionButton.kt:426)");
        }
        long jI = ColorSchemeKt.i(FabPrimaryTokens.f22599a.a(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final Shape c(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-536021915, i3, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-extendedFabShape> (FloatingActionButton.kt:422)");
        }
        Shape shapeE = ShapesKt.e(ExtendedFabPrimaryTokens.f22541a.a(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final Shape d(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1835912187, i3, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-largeShape> (FloatingActionButton.kt:418)");
        }
        Shape shapeE = ShapesKt.e(FabPrimaryLargeTokens.f22563a.b(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final Shape e(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-53247565, i3, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-shape> (FloatingActionButton.kt:410)");
        }
        Shape shapeE = ShapesKt.e(FabPrimaryTokens.f22599a.d(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final Shape f(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(394933381, i3, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-smallShape> (FloatingActionButton.kt:414)");
        }
        Shape shapeE = ShapesKt.e(FabPrimarySmallTokens.f22581a.b(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }
}
