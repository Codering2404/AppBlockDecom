package androidx.compose.material3;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
public final class MaterialTheme {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MaterialTheme f18110a = new MaterialTheme();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f18111b = 0;

    private MaterialTheme() {
    }

    public final ColorScheme a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-561618718, i3, -1, "androidx.compose.material3.MaterialTheme.<get-colorScheme> (MaterialTheme.kt:83)");
        }
        ColorScheme colorScheme = (ColorScheme) composer.q(ColorSchemeKt.h());
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return colorScheme;
    }

    public final Shapes b(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(419509830, i3, -1, "androidx.compose.material3.MaterialTheme.<get-shapes> (MaterialTheme.kt:99)");
        }
        Shapes shapes = (Shapes) composer.q(ShapesKt.d());
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapes;
    }

    public final Typography c(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-942794935, i3, -1, "androidx.compose.material3.MaterialTheme.<get-typography> (MaterialTheme.kt:91)");
        }
        Typography typography = (Typography) composer.q(TypographyKt.b());
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return typography;
    }
}
