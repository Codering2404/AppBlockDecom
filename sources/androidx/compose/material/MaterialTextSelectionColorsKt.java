package androidx.compose.material;

import androidx.compose.foundation.text.selection.TextSelectionColors;
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
public final class MaterialTextSelectionColorsKt {
    private static final float a(long j3, long j4, long j5) {
        int i3 = 0;
        float f3 = 0.2f;
        float f4 = 0.4f;
        float f5 = 0.4f;
        while (i3 < 7) {
            long j6 = j3;
            long j7 = j4;
            long j8 = j5;
            float fC = (c(j6, f4, j7, j8) / 4.5f) - 1.0f;
            if (0.0f <= fC && fC <= 0.01f) {
                return f4;
            }
            if (fC < 0.0f) {
                f5 = f4;
            } else {
                f3 = f4;
            }
            f4 = (f5 + f3) / 2.0f;
            i3++;
            j3 = j6;
            j4 = j7;
            j5 = j8;
        }
        return f4;
    }

    public static final float b(long j3, long j4) {
        float fJ = ColorKt.j(j3) + 0.05f;
        float fJ2 = ColorKt.j(j4) + 0.05f;
        return Math.max(fJ, fJ2) / Math.min(fJ, fJ2);
    }

    private static final float c(long j3, float f3, long j4, long j5) {
        long jH = ColorKt.h(Color.r(j3, f3, 0.0f, 0.0f, 0.0f, 14, null), j5);
        return b(ColorKt.h(j4, jH), jH);
    }

    public static final long d(long j3, long j4, long j5) {
        return Color.r(j3, c(j3, 0.4f, j4, j5) >= 4.5f ? 0.4f : c(j3, 0.2f, j4, j5) < 4.5f ? 0.2f : a(j3, j4, j5), 0.0f, 0.0f, 0.0f, 14, null);
    }

    public static final TextSelectionColors e(Colors colors, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-721696685, i3, -1, "androidx.compose.material.rememberTextSelectionColors (MaterialTextSelectionColors.kt:35)");
        }
        long j3 = colors.j();
        long jC = colors.c();
        composer.a0(1102762072);
        long jA = ColorsKt.a(colors, jC);
        if (jA == 16) {
            jA = ((Color) composer.q(ContentColorKt.a())).B();
        }
        long j4 = jA;
        composer.U();
        long jR = Color.r(j4, ContentAlpha.f12529a.d(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
        boolean zF = composer.f(j3) | composer.f(jC) | composer.f(jR);
        Object objG = composer.G();
        if (zF || objG == Composer.f23746a.a()) {
            TextSelectionColors textSelectionColors = new TextSelectionColors(colors.j(), d(j3, jR, jC), null);
            composer.w(textSelectionColors);
            objG = textSelectionColors;
        }
        TextSelectionColors textSelectionColors2 = (TextSelectionColors) objG;
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return textSelectionColors2;
    }
}
