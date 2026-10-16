package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
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
public final class SliderDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SliderDefaults f13759a = new SliderDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f13760b = 0;

    private SliderDefaults() {
    }

    public final SliderColors a(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, Composer composer, int i3, int i4, int i5) {
        long jH;
        long j13;
        long jR;
        long j14;
        long jR2;
        long j15;
        long jR3;
        long j16;
        long jR4;
        long j17;
        long jR5;
        long j18;
        long j19 = (i5 & 1) != 0 ? MaterialTheme.f13091a.a(composer, 6).j() : j3;
        if ((i5 & 2) != 0) {
            MaterialTheme materialTheme = MaterialTheme.f13091a;
            jH = ColorKt.h(Color.r(materialTheme.a(composer, 6).i(), ContentAlpha.f12529a.b(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), materialTheme.a(composer, 6).n());
        } else {
            jH = j4;
        }
        long j20 = (i5 & 4) != 0 ? MaterialTheme.f13091a.a(composer, 6).j() : j5;
        if ((i5 & 8) != 0) {
            long j21 = j20;
            jR = Color.r(j21, 0.24f, 0.0f, 0.0f, 0.0f, 14, null);
            j13 = j21;
        } else {
            j13 = j20;
            jR = j6;
        }
        long jR6 = (i5 & 16) != 0 ? Color.r(MaterialTheme.f13091a.a(composer, 6).i(), 0.32f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        if ((i5 & 32) != 0) {
            long j22 = jR6;
            jR2 = Color.r(j22, 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
            j14 = j22;
        } else {
            j14 = jR6;
            jR2 = j8;
        }
        long jR7 = (i5 & 64) != 0 ? Color.r(ColorsKt.b(j13, composer, (i3 >> 6) & 14), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j9;
        if ((i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            long j23 = j13;
            jR3 = Color.r(j23, 0.54f, 0.0f, 0.0f, 0.0f, 14, null);
            j15 = j23;
        } else {
            j15 = j13;
            jR3 = j10;
        }
        if ((i5 & Function.MAX_NARGS) != 0) {
            long j24 = jR7;
            jR4 = Color.r(j24, 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
            j16 = j24;
        } else {
            j16 = jR7;
            jR4 = j11;
        }
        if ((i5 & 512) != 0) {
            long j25 = jR2;
            jR5 = Color.r(j25, 0.12f, 0.0f, 0.0f, 0.0f, 14, null);
            j17 = j25;
        } else {
            j17 = jR2;
            jR5 = j12;
        }
        if (ComposerKt.M()) {
            j18 = jR5;
            ComposerKt.U(436017687, i3, i4, "androidx.compose.material.SliderDefaults.colors (Slider.kt:500)");
        } else {
            j18 = jR5;
        }
        DefaultSliderColors defaultSliderColors = new DefaultSliderColors(j19, jH, j15, jR, j14, j17, j16, jR3, jR4, j18, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return defaultSliderColors;
    }
}
