package androidx.compose.material3;

import androidx.compose.material3.tokens.RadioButtonTokens;
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
public final class RadioButtonDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RadioButtonDefaults f19329a = new RadioButtonDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f19330b = 0;

    private RadioButtonDefaults() {
    }

    public final RadioButtonColors a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1191566130, i3, -1, "androidx.compose.material3.RadioButtonDefaults.colors (RadioButton.kt:140)");
        }
        RadioButtonColors radioButtonColorsC = c(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return radioButtonColorsC;
    }

    public final RadioButtonColors b(long j3, long j4, long j5, long j6, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            j3 = Color.f25715b.k();
        }
        if ((i4 & 2) != 0) {
            j4 = Color.f25715b.k();
        }
        if ((i4 & 4) != 0) {
            j5 = Color.f25715b.k();
        }
        if ((i4 & 8) != 0) {
            j6 = Color.f25715b.k();
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-351083046, i3, -1, "androidx.compose.material3.RadioButtonDefaults.colors (RadioButton.kt:160)");
        }
        long j7 = j3;
        RadioButtonColors radioButtonColorsA = c(MaterialTheme.f18110a.a(composer, 6)).a(j7, j4, j5, j6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return radioButtonColorsA;
    }

    public final RadioButtonColors c(ColorScheme colorScheme) {
        RadioButtonColors radioButtonColorsH = colorScheme.H();
        if (radioButtonColorsH != null) {
            return radioButtonColorsH;
        }
        RadioButtonTokens radioButtonTokens = RadioButtonTokens.f23285a;
        RadioButtonColors radioButtonColors = new RadioButtonColors(ColorSchemeKt.g(colorScheme, radioButtonTokens.d()), ColorSchemeKt.g(colorScheme, radioButtonTokens.f()), Color.r(ColorSchemeKt.g(colorScheme, radioButtonTokens.a()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), Color.r(ColorSchemeKt.g(colorScheme, radioButtonTokens.b()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), null);
        colorScheme.f1(radioButtonColors);
        return radioButtonColors;
    }
}
