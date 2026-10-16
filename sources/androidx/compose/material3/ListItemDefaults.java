package androidx.compose.material3;

import androidx.compose.material3.tokens.ListTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
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
public final class ListItemDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ListItemDefaults f18044a = new ListItemDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f18045b = ListTokens.f22906a.b();

    private ListItemDefaults() {
    }

    public final ListItemColors a(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, Composer composer, int i3, int i4) {
        long jR;
        long jR2;
        long jR3;
        long j12;
        long jI = (i4 & 1) != 0 ? ColorSchemeKt.i(ListTokens.f22906a.a(), composer, 6) : j3;
        long jI2 = (i4 & 2) != 0 ? ColorSchemeKt.i(ListTokens.f22906a.j(), composer, 6) : j4;
        long jI3 = (i4 & 4) != 0 ? ColorSchemeKt.i(ListTokens.f22906a.l(), composer, 6) : j5;
        long jI4 = (i4 & 8) != 0 ? ColorSchemeKt.i(ListTokens.f22906a.o(), composer, 6) : j6;
        long jI5 = (i4 & 16) != 0 ? ColorSchemeKt.i(ListTokens.f22906a.q(), composer, 6) : j7;
        long jI6 = (i4 & 32) != 0 ? ColorSchemeKt.i(ListTokens.f22906a.t(), composer, 6) : j8;
        if ((i4 & 64) != 0) {
            ListTokens listTokens = ListTokens.f22906a;
            jR = Color.r(ColorSchemeKt.i(listTokens.d(), composer, 6), listTokens.e(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jR = j9;
        }
        if ((i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            ListTokens listTokens2 = ListTokens.f22906a;
            jR2 = Color.r(ColorSchemeKt.i(listTokens2.f(), composer, 6), listTokens2.g(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jR2 = j10;
        }
        if ((i4 & Function.MAX_NARGS) != 0) {
            ListTokens listTokens3 = ListTokens.f22906a;
            jR3 = Color.r(ColorSchemeKt.i(listTokens3.h(), composer, 6), listTokens3.i(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jR3 = j11;
        }
        if (ComposerKt.M()) {
            j12 = jR3;
            ComposerKt.U(-352515689, i3, -1, "androidx.compose.material3.ListItemDefaults.colors (ListItem.kt:582)");
        } else {
            j12 = jR3;
        }
        ListItemColors listItemColors = new ListItemColors(jI, jI2, jI3, jI4, jI5, jI6, jR, jR2, j12, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return listItemColors;
    }

    public final float b() {
        return f18045b;
    }

    public final Shape c(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-496871597, i3, -1, "androidx.compose.material3.ListItemDefaults.<get-shape> (ListItem.kt:535)");
        }
        Shape shapeE = ShapesKt.e(ListTokens.f22906a.c(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }
}
