package androidx.compose.material3;

import androidx.compose.material3.tokens.SwitchTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
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
public final class SwitchDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SwitchDefaults f20446a = new SwitchDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f20447b = Dp.g(16);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f20448c = 0;

    private SwitchDefaults() {
    }

    public final SwitchColors a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(435552781, i3, -1, "androidx.compose.material3.SwitchDefaults.colors (Switch.kt:299)");
        }
        SwitchColors switchColorsB = b(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return switchColorsB;
    }

    public final SwitchColors b(ColorScheme colorScheme) {
        SwitchColors switchColorsM = colorScheme.M();
        if (switchColorsM != null) {
            return switchColorsM;
        }
        SwitchTokens switchTokens = SwitchTokens.f23467a;
        long jG = ColorSchemeKt.g(colorScheme, switchTokens.o());
        long jG2 = ColorSchemeKt.g(colorScheme, switchTokens.r());
        Color.Companion companion = Color.f25715b;
        SwitchColors switchColors = new SwitchColors(jG, jG2, companion.j(), ColorSchemeKt.g(colorScheme, switchTokens.q()), ColorSchemeKt.g(colorScheme, switchTokens.y()), ColorSchemeKt.g(colorScheme, switchTokens.B()), ColorSchemeKt.g(colorScheme, switchTokens.x()), ColorSchemeKt.g(colorScheme, switchTokens.A()), ColorKt.h(Color.r(ColorSchemeKt.g(colorScheme, switchTokens.a()), switchTokens.b(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.o0()), ColorKt.h(Color.r(ColorSchemeKt.g(colorScheme, switchTokens.e()), switchTokens.f(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.o0()), companion.j(), ColorKt.h(Color.r(ColorSchemeKt.g(colorScheme, switchTokens.c()), switchTokens.d(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.o0()), ColorKt.h(Color.r(ColorSchemeKt.g(colorScheme, switchTokens.g()), switchTokens.h(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.o0()), ColorKt.h(Color.r(ColorSchemeKt.g(colorScheme, switchTokens.k()), switchTokens.f(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.o0()), ColorKt.h(Color.r(ColorSchemeKt.g(colorScheme, switchTokens.l()), switchTokens.f(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.o0()), ColorKt.h(Color.r(ColorSchemeKt.g(colorScheme, switchTokens.i()), switchTokens.j(), 0.0f, 0.0f, 0.0f, 14, null), colorScheme.o0()), null);
        colorScheme.k1(switchColors);
        return switchColors;
    }
}
