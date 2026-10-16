package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
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
public final class ChipDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ChipDefaults f12397a = new ChipDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f12398b = Dp.g(32);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f12399c = Dp.g(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f12400d = Dp.g(20);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f12401e = Dp.g(18);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f12402f = 0;

    private ChipDefaults() {
    }

    public final ChipColors a(long j3, long j4, long j5, long j6, long j7, long j8, Composer composer, int i3, int i4) {
        long jH;
        long jH2;
        long j9;
        long jR;
        if ((i4 & 1) != 0) {
            MaterialTheme materialTheme = MaterialTheme.f13091a;
            jH = ColorKt.h(Color.r(materialTheme.a(composer, 6).i(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.a(composer, 6).n());
        } else {
            jH = j3;
        }
        long jR2 = (i4 & 2) != 0 ? Color.r(MaterialTheme.f13091a.a(composer, 6).i(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        long jR3 = (i4 & 4) != 0 ? Color.r(jR2, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        if ((i4 & 8) != 0) {
            MaterialTheme materialTheme2 = MaterialTheme.f13091a;
            jH2 = ColorKt.h(Color.r(materialTheme2.a(composer, 6).i(), ContentAlpha.f12529a.b(composer, 6) * 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme2.a(composer, 6).n());
        } else {
            jH2 = j6;
        }
        if ((i4 & 16) != 0) {
            long j10 = jR2;
            jR = Color.r(j10, ContentAlpha.f12529a.b(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null);
            j9 = j10;
        } else {
            j9 = jR2;
            jR = j7;
        }
        long jR4 = (i4 & 32) != 0 ? Color.r(jR3, ContentAlpha.f12529a.b(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j8;
        if (ComposerKt.M()) {
            ComposerKt.U(1838505436, i3, -1, "androidx.compose.material.ChipDefaults.chipColors (Chip.kt:404)");
        }
        DefaultChipColors defaultChipColors = new DefaultChipColors(jH, j9, jR3, jH2, jR, jR4, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return defaultChipColors;
    }

    public final SelectableChipColors b(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, Composer composer, int i3, int i4) {
        long jH;
        long jH2;
        long j12;
        long jR;
        long j13;
        long jR2;
        long j14;
        long jH3;
        long j15;
        long jH4;
        long j16;
        if ((i4 & 1) != 0) {
            MaterialTheme materialTheme = MaterialTheme.f13091a;
            jH = ColorKt.h(Color.r(materialTheme.a(composer, 6).i(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme.a(composer, 6).n());
        } else {
            jH = j3;
        }
        long jR3 = (i4 & 2) != 0 ? Color.r(MaterialTheme.f13091a.a(composer, 6).i(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        long jR4 = (i4 & 4) != 0 ? Color.r(jR3, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        if ((i4 & 8) != 0) {
            MaterialTheme materialTheme2 = MaterialTheme.f13091a;
            jH2 = ColorKt.h(Color.r(materialTheme2.a(composer, 6).i(), ContentAlpha.f12529a.b(composer, 6) * 0.12f, 0.0f, 0.0f, 0.0f, 14, null), materialTheme2.a(composer, 6).n());
        } else {
            jH2 = j6;
        }
        if ((i4 & 16) != 0) {
            long j17 = jR3;
            jR = Color.r(j17, ContentAlpha.f12529a.b(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null);
            j12 = j17;
        } else {
            j12 = jR3;
            jR = j7;
        }
        if ((i4 & 32) != 0) {
            long j18 = jR4;
            jR2 = Color.r(j18, ContentAlpha.f12529a.b(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null);
            j13 = j18;
        } else {
            j13 = jR4;
            jR2 = j8;
        }
        if ((i4 & 64) != 0) {
            j14 = jR2;
            jH3 = ColorKt.h(Color.r(MaterialTheme.f13091a.a(composer, 6).i(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), jH);
        } else {
            j14 = jR2;
            jH3 = j9;
        }
        if ((i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            j15 = jH;
            jH4 = ColorKt.h(Color.r(MaterialTheme.f13091a.a(composer, 6).i(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), j12);
        } else {
            j15 = jH;
            jH4 = j10;
        }
        long jH5 = (i4 & Function.MAX_NARGS) != 0 ? ColorKt.h(Color.r(MaterialTheme.f13091a.a(composer, 6).i(), 0.16f, 0.0f, 0.0f, 0.0f, 14, null), j13) : j11;
        if (ComposerKt.M()) {
            j16 = jH5;
            ComposerKt.U(830140629, i3, -1, "androidx.compose.material.ChipDefaults.filterChipColors (Chip.kt:484)");
        } else {
            j16 = jH5;
        }
        long j19 = jH2;
        long j20 = j12;
        long j21 = j13;
        long j22 = j15;
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(j22, j20, j21, j19, jR, j14, jH3, jH4, j16, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return defaultSelectableChipColors;
    }

    public final float c() {
        return f12398b;
    }

    public final ChipColors d(long j3, long j4, long j5, long j6, long j7, long j8, Composer composer, int i3, int i4) {
        long jN = (i4 & 1) != 0 ? MaterialTheme.f13091a.a(composer, 6).n() : j3;
        long jR = (i4 & 2) != 0 ? Color.r(MaterialTheme.f13091a.a(composer, 6).i(), 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j4;
        long jR2 = (i4 & 4) != 0 ? Color.r(jR, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j5;
        long j9 = (i4 & 8) != 0 ? jN : j6;
        long jR3 = (i4 & 16) != 0 ? Color.r(jR, ContentAlpha.f12529a.b(composer, 6) * 0.87f, 0.0f, 0.0f, 0.0f, 14, null) : j7;
        long jR4 = (i4 & 32) != 0 ? Color.r(jR2, ContentAlpha.f12529a.b(composer, 6) * 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j8;
        if (ComposerKt.M()) {
            ComposerKt.U(-1763922662, i3, -1, "androidx.compose.material.ChipDefaults.outlinedChipColors (Chip.kt:436)");
        }
        ChipColors chipColorsA = a(jN, jR, jR2, j9, jR3, jR4, composer, i3 & 4194302, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return chipColorsA;
    }
}
