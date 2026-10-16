package androidx.compose.material3;

import androidx.compose.material3.tokens.TimePickerTokens;
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
public final class TimePickerDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimePickerDefaults f21166a = new TimePickerDefaults();

    private TimePickerDefaults() {
    }

    public final TimePickerColors a(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-2085808058, i3, -1, "androidx.compose.material3.TimePickerDefaults.colors (TimePicker.kt:270)");
        }
        TimePickerColors timePickerColorsB = b(MaterialTheme.f18110a.a(composer, 6));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return timePickerColorsB;
    }

    public final TimePickerColors b(ColorScheme colorScheme) {
        TimePickerColors timePickerColorsP = colorScheme.P();
        if (timePickerColorsP != null) {
            return timePickerColorsP;
        }
        TimePickerTokens timePickerTokens = TimePickerTokens.f23541a;
        TimePickerColors timePickerColors = new TimePickerColors(ColorSchemeKt.g(colorScheme, timePickerTokens.a()), ColorSchemeKt.g(colorScheme, timePickerTokens.f()), ColorSchemeKt.g(colorScheme, timePickerTokens.j()), ColorSchemeKt.g(colorScheme, timePickerTokens.n()), ColorSchemeKt.g(colorScheme, timePickerTokens.d()), ColorSchemeKt.g(colorScheme, timePickerTokens.i()), ColorSchemeKt.g(colorScheme, timePickerTokens.p()), Color.f25715b.j(), ColorSchemeKt.g(colorScheme, timePickerTokens.q()), ColorSchemeKt.g(colorScheme, timePickerTokens.r()), ColorSchemeKt.g(colorScheme, timePickerTokens.y()), ColorSchemeKt.g(colorScheme, timePickerTokens.A()), ColorSchemeKt.g(colorScheme, timePickerTokens.z()), ColorSchemeKt.g(colorScheme, timePickerTokens.B()), null);
        colorScheme.n1(timePickerColors);
        return timePickerColors;
    }

    public final int c(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(517161502, i3, -1, "androidx.compose.material3.TimePickerDefaults.layoutType (TimePicker.kt:367)");
        }
        int iA = TimePicker_androidKt.a(composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return iA;
    }
}
