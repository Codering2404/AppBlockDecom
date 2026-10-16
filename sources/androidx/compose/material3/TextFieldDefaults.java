package androidx.compose.material3;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.tokens.FilledTextFieldTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

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
public final class TextFieldDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TextFieldDefaults f20812a = new TextFieldDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f20813b = Dp.g(56);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f20814c = Dp.g(280);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f20815d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f20816e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final float f20817f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final float f20818g;

    static {
        float fG = Dp.g(1);
        f20815d = fG;
        float fG2 = Dp.g(2);
        f20816e = fG2;
        f20817f = fG;
        f20818g = fG2;
    }

    private TextFieldDefaults() {
    }

    public static /* synthetic */ PaddingValues g(TextFieldDefaults textFieldDefaults, float f3, float f4, float f5, float f6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = TextFieldImplKt.r();
        }
        if ((i3 & 2) != 0) {
            f4 = TextFieldImplKt.r();
        }
        if ((i3 & 4) != 0) {
            f5 = TextFieldKt.l();
        }
        if ((i3 & 8) != 0) {
            f6 = TextFieldKt.l();
        }
        return textFieldDefaults.f(f3, f4, f5, f6);
    }

    public static /* synthetic */ PaddingValues i(TextFieldDefaults textFieldDefaults, float f3, float f4, float f5, float f6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = TextFieldImplKt.r();
        }
        if ((i3 & 2) != 0) {
            f4 = TextFieldImplKt.r();
        }
        if ((i3 & 4) != 0) {
            f5 = TextFieldImplKt.r();
        }
        if ((i3 & 8) != 0) {
            f6 = TextFieldImplKt.r();
        }
        return textFieldDefaults.h(f3, f4, f5, f6);
    }

    public static /* synthetic */ PaddingValues r(TextFieldDefaults textFieldDefaults, float f3, float f4, float f5, float f6, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f3 = TextFieldImplKt.r();
        }
        if ((i3 & 2) != 0) {
            f4 = TextFieldImplKt.q();
        }
        if ((i3 & 4) != 0) {
            f5 = TextFieldImplKt.r();
        }
        if ((i3 & 8) != 0) {
            f6 = Dp.g(0);
        }
        return textFieldDefaults.q(f3, f4, f5, f6);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:149:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(final boolean r22, final boolean r23, final androidx.compose.foundation.interaction.InteractionSource r24, androidx.compose.ui.Modifier r25, androidx.compose.material3.TextFieldColors r26, androidx.compose.ui.graphics.Shape r27, float r28, float r29, androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instruction units count: 535
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.a(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.ui.Modifier, androidx.compose.material3.TextFieldColors, androidx.compose.ui.graphics.Shape, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x012a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(final boolean r21, final boolean r22, final androidx.compose.foundation.interaction.InteractionSource r23, final androidx.compose.material3.TextFieldColors r24, androidx.compose.ui.graphics.Shape r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.b(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.material3.TextFieldColors, androidx.compose.ui.graphics.Shape, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0387  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:279:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(final java.lang.String r36, final kotlin.jvm.functions.Function2 r37, final boolean r38, final boolean r39, final androidx.compose.ui.text.input.VisualTransformation r40, final androidx.compose.foundation.interaction.InteractionSource r41, boolean r42, kotlin.jvm.functions.Function2 r43, kotlin.jvm.functions.Function2 r44, kotlin.jvm.functions.Function2 r45, kotlin.jvm.functions.Function2 r46, kotlin.jvm.functions.Function2 r47, kotlin.jvm.functions.Function2 r48, kotlin.jvm.functions.Function2 r49, androidx.compose.ui.graphics.Shape r50, androidx.compose.material3.TextFieldColors r51, androidx.compose.foundation.layout.PaddingValues r52, kotlin.jvm.functions.Function2 r53, androidx.compose.runtime.Composer r54, final int r55, final int r56, final int r57) {
        /*
            Method dump skipped, instruction units count: 1171
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.TextFieldDefaults.c(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.graphics.Shape, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public final TextFieldColors d(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(831731228, i3, -1, "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:336)");
        }
        TextFieldColors textFieldColorsJ = j(MaterialTheme.f18110a.a(composer, 6), composer, (i3 << 3) & 112);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return textFieldColorsJ;
    }

    public final TextFieldColors e(long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, TextSelectionColors textSelectionColors, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, long j32, long j33, long j34, long j35, long j36, long j37, long j38, long j39, long j40, long j41, long j42, long j43, long j44, Composer composer, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        long j45;
        TextSelectionColors textSelectionColors2;
        long jK = (i8 & 1) != 0 ? Color.f25715b.k() : j3;
        long jK2 = (i8 & 2) != 0 ? Color.f25715b.k() : j4;
        long jK3 = (i8 & 4) != 0 ? Color.f25715b.k() : j5;
        long jK4 = (i8 & 8) != 0 ? Color.f25715b.k() : j6;
        long jK5 = (i8 & 16) != 0 ? Color.f25715b.k() : j7;
        long jK6 = (i8 & 32) != 0 ? Color.f25715b.k() : j8;
        long jK7 = (i8 & 64) != 0 ? Color.f25715b.k() : j9;
        long j46 = jK;
        long jK8 = (i8 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? Color.f25715b.k() : j10;
        long jK9 = (i8 & Function.MAX_NARGS) != 0 ? Color.f25715b.k() : j11;
        long jK10 = (i8 & 512) != 0 ? Color.f25715b.k() : j12;
        TextSelectionColors textSelectionColors3 = (i8 & 1024) != 0 ? null : textSelectionColors;
        long jK11 = (i8 & 2048) != 0 ? Color.f25715b.k() : j13;
        long jK12 = (i8 & 4096) != 0 ? Color.f25715b.k() : j14;
        long jK13 = (i8 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? Color.f25715b.k() : j15;
        long jK14 = (i8 & 16384) != 0 ? Color.f25715b.k() : j16;
        long jK15 = (32768 & i8) != 0 ? Color.f25715b.k() : j17;
        long jK16 = (65536 & i8) != 0 ? Color.f25715b.k() : j18;
        long jK17 = (131072 & i8) != 0 ? Color.f25715b.k() : j19;
        long jK18 = (262144 & i8) != 0 ? Color.f25715b.k() : j20;
        long jK19 = (524288 & i8) != 0 ? Color.f25715b.k() : j21;
        long jK20 = (1048576 & i8) != 0 ? Color.f25715b.k() : j22;
        long jK21 = (2097152 & i8) != 0 ? Color.f25715b.k() : j23;
        long jK22 = (4194304 & i8) != 0 ? Color.f25715b.k() : j24;
        long jK23 = (8388608 & i8) != 0 ? Color.f25715b.k() : j25;
        long jK24 = (16777216 & i8) != 0 ? Color.f25715b.k() : j26;
        long jK25 = (33554432 & i8) != 0 ? Color.f25715b.k() : j27;
        long jK26 = (67108864 & i8) != 0 ? Color.f25715b.k() : j28;
        long jK27 = (134217728 & i8) != 0 ? Color.f25715b.k() : j29;
        long jK28 = (268435456 & i8) != 0 ? Color.f25715b.k() : j30;
        long jK29 = (536870912 & i8) != 0 ? Color.f25715b.k() : j31;
        long jK30 = (i8 & 1073741824) != 0 ? Color.f25715b.k() : j32;
        long jK31 = (i9 & 1) != 0 ? Color.f25715b.k() : j33;
        long jK32 = (i9 & 2) != 0 ? Color.f25715b.k() : j34;
        long jK33 = (i9 & 4) != 0 ? Color.f25715b.k() : j35;
        long jK34 = (i9 & 8) != 0 ? Color.f25715b.k() : j36;
        long jK35 = (i9 & 16) != 0 ? Color.f25715b.k() : j37;
        long jK36 = (i9 & 32) != 0 ? Color.f25715b.k() : j38;
        long jK37 = (i9 & 64) != 0 ? Color.f25715b.k() : j39;
        long jK38 = (i9 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? Color.f25715b.k() : j40;
        long jK39 = (i9 & Function.MAX_NARGS) != 0 ? Color.f25715b.k() : j41;
        long jK40 = (i9 & 512) != 0 ? Color.f25715b.k() : j42;
        long jK41 = (i9 & 1024) != 0 ? Color.f25715b.k() : j43;
        long jK42 = (i9 & 2048) != 0 ? Color.f25715b.k() : j44;
        if (ComposerKt.M()) {
            j45 = jK42;
            textSelectionColors2 = textSelectionColors3;
            ComposerKt.U(1513344955, i3, i4, "androidx.compose.material3.TextFieldDefaults.colors (TextFieldDefaults.kt:438)");
        } else {
            j45 = jK42;
            textSelectionColors2 = textSelectionColors3;
        }
        TextFieldColors textFieldColorsB = j(MaterialTheme.f18110a.a(composer, 6), composer, (i7 >> 6) & 112).b(j46, jK2, jK3, jK4, jK5, jK6, jK7, jK8, jK9, jK10, textSelectionColors2, jK11, jK12, jK13, jK14, jK15, jK16, jK17, jK18, jK19, jK20, jK21, jK22, jK23, jK24, jK25, jK26, jK27, jK28, jK29, jK30, jK31, jK32, jK33, jK34, jK35, jK36, jK37, jK38, jK39, jK40, jK41, j45);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return textFieldColorsB;
    }

    public final PaddingValues f(float f3, float f4, float f5, float f6) {
        return PaddingKt.d(f3, f5, f4, f6);
    }

    public final PaddingValues h(float f3, float f4, float f5, float f6) {
        return PaddingKt.d(f3, f4, f5, f6);
    }

    public final TextFieldColors j(ColorScheme colorScheme, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1341970309, i3, -1, "androidx.compose.material3.TextFieldDefaults.<get-defaultTextFieldColors> (TextFieldDefaults.kt:486)");
        }
        TextFieldColors textFieldColorsO = colorScheme.O();
        composer.a0(27085453);
        if (textFieldColorsO == null) {
            FilledTextFieldTokens filledTextFieldTokens = FilledTextFieldTokens.f22737a;
            TextFieldColors textFieldColors = new TextFieldColors(ColorSchemeKt.g(colorScheme, filledTextFieldTokens.y()), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.D()), Color.r(ColorSchemeKt.g(colorScheme, filledTextFieldTokens.g()), filledTextFieldTokens.h(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.s()), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.c()), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.c()), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.c()), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.c()), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.b()), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.r()), (TextSelectionColors) composer.q(TextSelectionColorsKt.b()), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.x()), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.a()), Color.r(ColorSchemeKt.g(colorScheme, filledTextFieldTokens.e()), filledTextFieldTokens.f(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.q()), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.A()), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.I()), Color.r(ColorSchemeKt.g(colorScheme, filledTextFieldTokens.k()), filledTextFieldTokens.l(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.u()), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.C()), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.K()), Color.r(ColorSchemeKt.g(colorScheme, filledTextFieldTokens.o()), filledTextFieldTokens.p(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.w()), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.z()), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.H()), Color.r(ColorSchemeKt.g(colorScheme, filledTextFieldTokens.i()), filledTextFieldTokens.j(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.t()), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.E()), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.E()), Color.r(ColorSchemeKt.g(colorScheme, filledTextFieldTokens.g()), filledTextFieldTokens.h(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.E()), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.B()), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.J()), Color.r(ColorSchemeKt.g(colorScheme, filledTextFieldTokens.m()), filledTextFieldTokens.n(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.v()), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.F()), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.F()), Color.r(ColorSchemeKt.g(colorScheme, filledTextFieldTokens.F()), filledTextFieldTokens.h(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.F()), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.G()), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.G()), Color.r(ColorSchemeKt.g(colorScheme, filledTextFieldTokens.G()), filledTextFieldTokens.h(), 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, filledTextFieldTokens.G()), null);
            colorScheme.m1(textFieldColors);
            textFieldColorsO = textFieldColors;
        }
        composer.U();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return textFieldColorsO;
    }

    public final float k() {
        return f20816e;
    }

    public final float l() {
        return f20813b;
    }

    public final float m() {
        return f20814c;
    }

    public final Shape n(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1941327459, i3, -1, "androidx.compose.material3.TextFieldDefaults.<get-shape> (TextFieldDefaults.kt:60)");
        }
        Shape shapeE = ShapesKt.e(FilledTextFieldTokens.f22737a.d(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final float o() {
        return f20815d;
    }

    public final Modifier p(Modifier modifier, final boolean z2, final boolean z3, final InteractionSource interactionSource, final TextFieldColors textFieldColors, final float f3, final float f4) {
        return ComposedModifierKt.b(modifier, InspectableValueKt.b() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TextFieldDefaults$indicatorLine-gv0btCI$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(InspectorInfo inspectorInfo) {
                inspectorInfo.d("indicatorLine");
                inspectorInfo.b().c("enabled", Boolean.valueOf(z2));
                inspectorInfo.b().c("isError", Boolean.valueOf(z3));
                inspectorInfo.b().c("interactionSource", interactionSource);
                inspectorInfo.b().c("colors", textFieldColors);
                inspectorInfo.b().c("focusedIndicatorLineThickness", Dp.d(f3));
                inspectorInfo.b().c("unfocusedIndicatorLineThickness", Dp.d(f4));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((InspectorInfo) obj);
                return Unit.f139807a;
            }
        } : InspectableValueKt.a(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.material3.TextFieldDefaults$indicatorLine$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public final Modifier c(Modifier modifier2, Composer composer, int i3) {
                composer.a0(-891038934);
                if (ComposerKt.M()) {
                    ComposerKt.U(-891038934, i3, -1, "androidx.compose.material3.TextFieldDefaults.indicatorLine.<anonymous> (TextFieldDefaults.kt:169)");
                }
                Modifier modifierK = TextFieldKt.k(Modifier.b8, TextFieldImplKt.h(z2, z3, ((Boolean) FocusInteractionKt.a(interactionSource, composer, 0).getValue()).booleanValue(), textFieldColors, f3, f4, composer, 0));
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                return modifierK;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }
        });
    }

    public final PaddingValues q(float f3, float f4, float f5, float f6) {
        return PaddingKt.d(f3, f4, f5, f6);
    }
}
