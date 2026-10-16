package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.BottomAppBarTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
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
public final class BottomAppBarDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final BottomAppBarDefaults f15934a = new BottomAppBarDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f15935b = Dp.g(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final PaddingValues f15936c = PaddingKt.e(AppBarKt.f15632a, AppBarKt.B(), AppBarKt.f15632a, 0.0f, 8, null);

    private BottomAppBarDefaults() {
    }

    public final long a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-368340078, i3, -1, "androidx.compose.material3.BottomAppBarDefaults.<get-containerColor> (AppBar.kt:1534)");
        }
        long jI = ColorSchemeKt.i(BottomAppBarTokens.f22329a.a(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return jI;
    }

    public final float b() {
        return f15935b;
    }

    public final PaddingValues c() {
        return f15936c;
    }

    public final WindowInsets d(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(688896409, i3, -1, "androidx.compose.material3.BottomAppBarDefaults.<get-windowInsets> (AppBar.kt:1553)");
        }
        WindowInsets windowInsetsA = SystemBarsDefaultInsets_androidKt.a(WindowInsets.f7172a, composer, 6);
        WindowInsetsSides.Companion companion = WindowInsetsSides.f7284b;
        WindowInsets windowInsetsI = WindowInsetsKt.i(windowInsetsA, WindowInsetsSides.r(companion.g(), companion.e()));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return windowInsetsI;
    }
}
