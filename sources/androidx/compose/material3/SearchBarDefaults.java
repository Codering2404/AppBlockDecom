package androidx.compose.material3;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.material3.tokens.SearchBarTokens;
import androidx.compose.material3.tokens.SearchViewTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import com.facebook.internal.Utility;
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
public final class SearchBarDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SearchBarDefaults f19467a = new SearchBarDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f19468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f19469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f19470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f19471e;

    static {
        ElevationTokens elevationTokens = ElevationTokens.f22534a;
        float fA = elevationTokens.a();
        f19468b = fA;
        f19469c = elevationTokens.a();
        f19470d = fA;
        f19471e = SearchBarTokens.f23313a.b();
    }

    private SearchBarDefaults() {
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0286  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x041a  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x04e6  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x04fe  */
    /* JADX WARN: Removed duplicated region for block: B:244:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0115  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(final java.lang.String r83, final kotlin.jvm.functions.Function1 r84, final kotlin.jvm.functions.Function1 r85, final boolean r86, final kotlin.jvm.functions.Function1 r87, androidx.compose.ui.Modifier r88, boolean r89, kotlin.jvm.functions.Function2 r90, kotlin.jvm.functions.Function2 r91, kotlin.jvm.functions.Function2 r92, androidx.compose.material3.TextFieldColors r93, androidx.compose.foundation.interaction.MutableInteractionSource r94, androidx.compose.runtime.Composer r95, final int r96, final int r97, final int r98) {
        /*
            Method dump skipped, instruction units count: 1310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.SearchBarDefaults.a(java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public final SearchBarColors b(long j3, long j4, Composer composer, int i3, int i4) {
        long jI = (i4 & 1) != 0 ? ColorSchemeKt.i(SearchBarTokens.f23313a.a(), composer, 6) : j3;
        long jI2 = (i4 & 2) != 0 ? ColorSchemeKt.i(SearchViewTokens.f23329a.a(), composer, 6) : j4;
        if (ComposerKt.M()) {
            ComposerKt.U(-1507037523, i3, -1, "androidx.compose.material3.SearchBarDefaults.colors (SearchBar.android.kt:378)");
        }
        SearchBarColors searchBarColors = new SearchBarColors(jI, jI2, j(0L, 0L, 0L, 0L, null, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 0, (i3 << 6) & 57344, 16383), null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return searchBarColors;
    }

    public final Shape c(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1006952150, i3, -1, "androidx.compose.material3.SearchBarDefaults.<get-dockedShape> (SearchBar.android.kt:357)");
        }
        Shape shapeE = ShapesKt.e(SearchViewTokens.f23329a.b(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final Shape d(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1665502056, i3, -1, "androidx.compose.material3.SearchBarDefaults.<get-fullScreenShape> (SearchBar.android.kt:353)");
        }
        Shape shapeE = ShapesKt.e(SearchViewTokens.f23329a.c(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final float e() {
        return f19471e;
    }

    public final Shape f(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-971556142, i3, -1, "androidx.compose.material3.SearchBarDefaults.<get-inputFieldShape> (SearchBar.android.kt:349)");
        }
        Shape shapeE = ShapesKt.e(SearchBarTokens.f23313a.c(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final float g() {
        return f19469c;
    }

    public final float h() {
        return f19468b;
    }

    public final WindowInsets i(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(2112270157, i3, -1, "androidx.compose.material3.SearchBarDefaults.<get-windowInsets> (SearchBar.android.kt:361)");
        }
        WindowInsets windowInsetsD = WindowInsets_androidKt.d(WindowInsets.f7172a, composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return windowInsetsD;
    }

    public final TextFieldColors j(long j3, long j4, long j5, long j6, TextSelectionColors textSelectionColors, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, Composer composer, int i3, int i4, int i5) {
        long jR;
        long jR2;
        long jR3;
        long jR4;
        long jI = (i5 & 1) != 0 ? ColorSchemeKt.i(SearchBarTokens.f23313a.d(), composer, 6) : j3;
        long jI2 = (i5 & 2) != 0 ? ColorSchemeKt.i(SearchBarTokens.f23313a.d(), composer, 6) : j4;
        if ((i5 & 4) != 0) {
            FilledTextFieldTokens filledTextFieldTokens = FilledTextFieldTokens.f22737a;
            jR = Color.r(ColorSchemeKt.i(filledTextFieldTokens.g(), composer, 6), filledTextFieldTokens.h(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jR = j5;
        }
        long jI3 = (i5 & 8) != 0 ? ColorSchemeKt.i(FilledTextFieldTokens.f22737a.b(), composer, 6) : j6;
        TextSelectionColors textSelectionColors2 = (i5 & 16) != 0 ? (TextSelectionColors) composer.q(TextSelectionColorsKt.b()) : textSelectionColors;
        long jI4 = (i5 & 32) != 0 ? ColorSchemeKt.i(SearchBarTokens.f23313a.e(), composer, 6) : j7;
        long jI5 = (i5 & 64) != 0 ? ColorSchemeKt.i(SearchBarTokens.f23313a.e(), composer, 6) : j8;
        if ((i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            FilledTextFieldTokens filledTextFieldTokens2 = FilledTextFieldTokens.f22737a;
            jR2 = Color.r(ColorSchemeKt.i(filledTextFieldTokens2.k(), composer, 6), filledTextFieldTokens2.l(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jR2 = j9;
        }
        long jI6 = (i5 & Function.MAX_NARGS) != 0 ? ColorSchemeKt.i(SearchBarTokens.f23313a.g(), composer, 6) : j10;
        long jI7 = (i5 & 512) != 0 ? ColorSchemeKt.i(SearchBarTokens.f23313a.g(), composer, 6) : j11;
        if ((i5 & 1024) != 0) {
            FilledTextFieldTokens filledTextFieldTokens3 = FilledTextFieldTokens.f22737a;
            jR3 = Color.r(ColorSchemeKt.i(filledTextFieldTokens3.o(), composer, 6), filledTextFieldTokens3.p(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jR3 = j12;
        }
        long jI8 = (i5 & 2048) != 0 ? ColorSchemeKt.i(SearchBarTokens.f23313a.f(), composer, 6) : j13;
        long jI9 = (i5 & 4096) != 0 ? ColorSchemeKt.i(SearchBarTokens.f23313a.f(), composer, 6) : j14;
        if ((i5 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0) {
            FilledTextFieldTokens filledTextFieldTokens4 = FilledTextFieldTokens.f22737a;
            jR4 = Color.r(ColorSchemeKt.i(filledTextFieldTokens4.g(), composer, 6), filledTextFieldTokens4.h(), 0.0f, 0.0f, 0.0f, 14, null);
        } else {
            jR4 = j15;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-602148837, i3, i4, "androidx.compose.material3.SearchBarDefaults.inputFieldColors (SearchBar.android.kt:437)");
        }
        int i6 = i4 << 18;
        int i7 = ((i3 >> 27) & 14) | ((i4 << 3) & 112) | (i6 & 29360128) | (i6 & 234881024) | (i6 & 1879048192);
        TextFieldColors textFieldColorsE = TextFieldDefaults.f20812a.e(jI, jI2, jR, 0L, 0L, 0L, 0L, 0L, jI3, 0L, textSelectionColors2, 0L, 0L, 0L, 0L, jI4, jI5, jR2, 0L, jI6, jI7, jR3, 0L, 0L, 0L, 0L, 0L, jI8, jI9, jR4, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, (i3 & 1022) | ((i3 << 15) & 234881024), ((i3 >> 12) & 14) | (458752 & i3) | (3670016 & i3) | (i3 & 29360128) | ((i3 << 3) & 1879048192), i7, 0, 3072, 1204058872, 4095);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return textFieldColorsE;
    }
}
