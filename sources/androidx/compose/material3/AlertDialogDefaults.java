package androidx.compose.material3;

import androidx.compose.material3.tokens.DialogTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
public final class AlertDialogDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AlertDialogDefaults f15448a = new AlertDialogDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f15449b = Dp.g(0);

    private AlertDialogDefaults() {
    }

    public final long a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(616766901, i3, -1, "androidx.compose.material3.AlertDialogDefaults.<get-containerColor> (AlertDialog.kt:211)");
        }
        long jI = ColorSchemeKt.i(DialogTokens.f22476a.c(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final long b(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1646653461, i3, -1, "androidx.compose.material3.AlertDialogDefaults.<get-iconContentColor> (AlertDialog.kt:215)");
        }
        long jI = ColorSchemeKt.i(DialogTokens.f22476a.g(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final Shape c(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-952504159, i3, -1, "androidx.compose.material3.AlertDialogDefaults.<get-shape> (AlertDialog.kt:207)");
        }
        Shape shapeE = ShapesKt.e(DialogTokens.f22476a.d(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final long d(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1729845653, i3, -1, "androidx.compose.material3.AlertDialogDefaults.<get-textContentColor> (AlertDialog.kt:223)");
        }
        long jI = ColorSchemeKt.i(DialogTokens.f22476a.h(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final long e(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(247083549, i3, -1, "androidx.compose.material3.AlertDialogDefaults.<get-titleContentColor> (AlertDialog.kt:219)");
        }
        long jI = ColorSchemeKt.i(DialogTokens.f22476a.e(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final float f() {
        return f15449b;
    }
}
