package androidx.compose.material;

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
    public static final MaterialTheme f13091a = new MaterialTheme();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f13092b = 0;

    private MaterialTheme() {
    }

    public final Colors a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1462282791, i3, -1, "androidx.compose.material.MaterialTheme.<get-colors> (MaterialTheme.kt:100)");
        }
        Colors colors = (Colors) composer.q(ColorsKt.c());
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return colors;
    }

    public final Shapes b(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1586253541, i3, -1, "androidx.compose.material.MaterialTheme.<get-shapes> (MaterialTheme.kt:118)");
        }
        Shapes shapes = (Shapes) composer.q(ShapesKt.a());
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapes;
    }

    public final Typography c(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1630198856, i3, -1, "androidx.compose.material.MaterialTheme.<get-typography> (MaterialTheme.kt:110)");
        }
        Typography typography = (Typography) composer.q(TypographyKt.c());
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return typography;
    }
}
