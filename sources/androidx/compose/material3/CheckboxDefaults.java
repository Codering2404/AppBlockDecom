package androidx.compose.material3;

import androidx.compose.material3.tokens.CheckboxTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
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
public final class CheckboxDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CheckboxDefaults f16275a = new CheckboxDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f16276b = 0;

    private CheckboxDefaults() {
    }

    public final CheckboxColors a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-9530498, i3, -1, "androidx.compose.material3.CheckboxDefaults.colors (Checkbox.kt:193)");
        }
        CheckboxColors checkboxColorsC = c(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return checkboxColorsC;
    }

    public final CheckboxColors b(long j3, long j4, long j5, long j6, long j7, long j8, Composer composer, int i3, int i4) {
        long jK = (i4 & 1) != 0 ? Color.f25715b.k() : j3;
        long jK2 = (i4 & 2) != 0 ? Color.f25715b.k() : j4;
        long jK3 = (i4 & 4) != 0 ? Color.f25715b.k() : j5;
        long jK4 = (i4 & 8) != 0 ? Color.f25715b.k() : j6;
        long jK5 = (i4 & 16) != 0 ? Color.f25715b.k() : j7;
        long jK6 = (i4 & 32) != 0 ? Color.f25715b.k() : j8;
        if (ComposerKt.M()) {
            ComposerKt.U(-89536160, i3, -1, "androidx.compose.material3.CheckboxDefaults.colors (Checkbox.kt:219)");
        }
        CheckboxColors checkboxColorsC = c(MaterialTheme.f18110a.a(composer, 6));
        Color.Companion companion = Color.f25715b;
        CheckboxColors checkboxColorsD = checkboxColorsC.d(jK3, companion.j(), jK, companion.j(), jK4, companion.j(), jK6, jK, jK2, jK4, jK5, jK6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return checkboxColorsD;
    }

    public final CheckboxColors c(ColorScheme colorScheme) {
        CheckboxColors checkboxColorsH = colorScheme.h();
        if (checkboxColorsH != null) {
            return checkboxColorsH;
        }
        CheckboxTokens checkboxTokens = CheckboxTokens.f22334a;
        long jG = ColorSchemeKt.g(colorScheme, checkboxTokens.c());
        Color.Companion companion = Color.f25715b;
        CheckboxColors checkboxColors = new CheckboxColors(jG, companion.j(), ColorSchemeKt.g(colorScheme, checkboxTokens.a()), companion.j(), Color.r(ColorSchemeKt.g(colorScheme, checkboxTokens.b()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), companion.j(), Color.r(ColorSchemeKt.g(colorScheme, checkboxTokens.b()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, checkboxTokens.a()), ColorSchemeKt.g(colorScheme, checkboxTokens.f()), Color.r(ColorSchemeKt.g(colorScheme, checkboxTokens.b()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, checkboxTokens.e()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, checkboxTokens.b()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.E0(checkboxColors);
        return checkboxColors;
    }
}
