package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.NavigationDrawerTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
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
public final class NavigationDrawerItemDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NavigationDrawerItemDefaults f18494a = new NavigationDrawerItemDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final PaddingValues f18495b = PaddingKt.c(Dp.g(12), 0.0f, 2, null);

    private NavigationDrawerItemDefaults() {
    }

    public final NavigationDrawerItemColors a(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, Composer composer, int i3, int i4) {
        long j11;
        long jI = (i4 & 1) != 0 ? ColorSchemeKt.i(NavigationDrawerTokens.f22983a.b(), composer, 6) : j3;
        long j12 = (i4 & 2) != 0 ? Color.f25715b.j() : j4;
        long jI2 = (i4 & 4) != 0 ? ColorSchemeKt.i(NavigationDrawerTokens.f22983a.a(), composer, 6) : j5;
        long jI3 = (i4 & 8) != 0 ? ColorSchemeKt.i(NavigationDrawerTokens.f22983a.h(), composer, 6) : j6;
        long jI4 = (i4 & 16) != 0 ? ColorSchemeKt.i(NavigationDrawerTokens.f22983a.e(), composer, 6) : j7;
        long jI5 = (i4 & 32) != 0 ? ColorSchemeKt.i(NavigationDrawerTokens.f22983a.i(), composer, 6) : j8;
        long j13 = (i4 & 64) != 0 ? jI4 : j9;
        long j14 = (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? jI5 : j10;
        if (ComposerKt.M()) {
            j11 = jI5;
            ComposerKt.U(-1574983348, i3, -1, "androidx.compose.material3.NavigationDrawerItemDefaults.colors (NavigationDrawer.kt:1029)");
        } else {
            j11 = jI5;
        }
        DefaultDrawerItemsColor defaultDrawerItemsColor = new DefaultDrawerItemsColor(jI2, jI3, jI4, j11, jI, j12, j13, j14, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return defaultDrawerItemsColor;
    }
}
