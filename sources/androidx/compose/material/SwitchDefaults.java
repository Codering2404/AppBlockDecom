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
public final class SwitchDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SwitchDefaults f14418a = new SwitchDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f14419b = 0;

    private SwitchDefaults() {
    }

    public final SwitchColors a(long j3, long j4, float f3, long j5, long j6, float f4, long j7, long j8, long j9, long j10, Composer composer, int i3, int i4, int i5) {
        long j11;
        long j12;
        long jH;
        long j13;
        float f5;
        long j14;
        long jH2;
        long j15;
        int i6;
        long jH3;
        long jM = (i5 & 1) != 0 ? MaterialTheme.f13091a.a(composer, 6).m() : j3;
        long j16 = (i5 & 2) != 0 ? jM : j4;
        float f6 = (i5 & 4) != 0 ? 0.54f : f3;
        long jN = (i5 & 8) != 0 ? MaterialTheme.f13091a.a(composer, 6).n() : j5;
        long jI = (i5 & 16) != 0 ? MaterialTheme.f13091a.a(composer, 6).i() : j6;
        float f7 = (i5 & 32) != 0 ? 0.38f : f4;
        if ((i5 & 64) != 0) {
            long j17 = jM;
            long jR = Color.r(j17, ContentAlpha.f12529a.b(composer, 6), 0.0f, 0.0f, 0.0f, 14, null);
            j11 = j17;
            j12 = j16;
            jH = ColorKt.h(jR, MaterialTheme.f13091a.a(composer, 6).n());
        } else {
            j11 = jM;
            j12 = j16;
            jH = j7;
        }
        if ((i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            j13 = j12;
            f5 = f6;
            j14 = jH;
            jH2 = ColorKt.h(Color.r(j12, ContentAlpha.f12529a.b(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.f13091a.a(composer, 6).n());
        } else {
            j13 = j12;
            f5 = f6;
            j14 = jH;
            jH2 = j8;
        }
        if ((i5 & Function.MAX_NARGS) != 0) {
            i6 = 6;
            j15 = jH2;
            jH3 = ColorKt.h(Color.r(jN, ContentAlpha.f12529a.b(composer, 6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.f13091a.a(composer, 6).n());
        } else {
            j15 = jH2;
            i6 = 6;
            jH3 = j9;
        }
        long jH4 = (i5 & 512) != 0 ? ColorKt.h(Color.r(jI, ContentAlpha.f12529a.b(composer, i6), 0.0f, 0.0f, 0.0f, 14, null), MaterialTheme.f13091a.a(composer, i6).n()) : j10;
        if (ComposerKt.M()) {
            ComposerKt.U(-1032127534, i3, i4, "androidx.compose.material.SwitchDefaults.colors (Switch.kt:344)");
        }
        DefaultSwitchColors defaultSwitchColors = new DefaultSwitchColors(j11, Color.r(j13, f5, 0.0f, 0.0f, 0.0f, 14, null), jN, Color.r(jI, f7, 0.0f, 0.0f, 0.0f, 14, null), j14, Color.r(j15, f5, 0.0f, 0.0f, 0.0f, 14, null), jH3, Color.r(jH4, f7, 0.0f, 0.0f, 0.0f, 14, null), null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return defaultSwitchColors;
    }
}
