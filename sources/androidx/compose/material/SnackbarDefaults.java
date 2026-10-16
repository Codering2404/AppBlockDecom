package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
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
    public static final SnackbarDefaults f14054a = new SnackbarDefaults();

    private SnackbarDefaults() {
    }

    public final long a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1630911716, i3, -1, "androidx.compose.material.SnackbarDefaults.<get-backgroundColor> (Snackbar.kt:204)");
        }
        MaterialTheme materialTheme = MaterialTheme.f13091a;
        long jH = ColorKt.h(Color.r(materialTheme.a(composer, 6).i(), 0.8f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.a(composer, 6).n());
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jH;
    }

    public final long b(Composer composer, int i3) {
        long jK;
        if (ComposerKt.M()) {
            ComposerKt.U(-810329402, i3, -1, "androidx.compose.material.SnackbarDefaults.<get-primaryActionColor> (Snackbar.kt:224)");
        }
        Colors colorsA = MaterialTheme.f13091a.a(composer, 6);
        if (colorsA.o()) {
            jK = ColorKt.h(Color.r(colorsA.n(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), colorsA.j());
        } else {
            jK = colorsA.k();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jK;
    }
}
