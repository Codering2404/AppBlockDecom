package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.core.graphics.Insets;
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
public final class WindowInsets_androidKt {
    public static final ValueInsets a(Insets insets, String str) {
        return new ValueInsets(f(insets), str);
    }

    public static final WindowInsets b(WindowInsets.Companion companion, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1596175702, i3, -1, "androidx.compose.foundation.layout.<get-navigationBars> (WindowInsets.android.kt:171)");
        }
        AndroidWindowInsets androidWindowInsetsH = WindowInsetsHolder.f7180x.c(composer, 6).h();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return androidWindowInsetsH;
    }

    public static final WindowInsets c(WindowInsets.Companion companion, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-49441252, i3, -1, "androidx.compose.foundation.layout.<get-safeDrawing> (WindowInsets.android.kt:198)");
        }
        WindowInsets windowInsetsJ = WindowInsetsHolder.f7180x.c(composer, 6).j();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return windowInsetsJ;
    }

    public static final WindowInsets d(WindowInsets.Companion companion, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-675090670, i3, -1, "androidx.compose.foundation.layout.<get-statusBars> (WindowInsets.android.kt:175)");
        }
        AndroidWindowInsets androidWindowInsetsL = WindowInsetsHolder.f7180x.c(composer, 6).l();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return androidWindowInsetsL;
    }

    public static final WindowInsets e(WindowInsets.Companion companion, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-282936756, i3, -1, "androidx.compose.foundation.layout.<get-systemBars> (WindowInsets.android.kt:179)");
        }
        AndroidWindowInsets androidWindowInsetsM = WindowInsetsHolder.f7180x.c(composer, 6).m();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return androidWindowInsetsM;
    }

    public static final InsetsValues f(Insets insets) {
        return new InsetsValues(insets.f33964a, insets.f33965b, insets.f33966c, insets.f33967d);
    }
}
