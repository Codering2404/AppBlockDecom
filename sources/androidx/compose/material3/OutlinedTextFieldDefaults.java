package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.material3.tokens.OutlinedTextFieldTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
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
public final class OutlinedTextFieldDefaults {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OutlinedTextFieldDefaults f18898a = new OutlinedTextFieldDefaults();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f18899b = Dp.g(56);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f18900c = Dp.g(280);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float f18901d = Dp.g(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final float f18902e = Dp.g(2);

    private OutlinedTextFieldDefaults() {
    }

    public static /* synthetic */ PaddingValues g(OutlinedTextFieldDefaults outlinedTextFieldDefaults, float f3, float f4, float f5, float f6, int i3, Object obj) {
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
        return outlinedTextFieldDefaults.f(f3, f4, f5, f6);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:153:? A[RETURN, SYNTHETIC] */
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
    public final void a(final boolean r21, final boolean r22, final androidx.compose.foundation.interaction.InteractionSource r23, androidx.compose.ui.Modifier r24, androidx.compose.material3.TextFieldColors r25, androidx.compose.ui.graphics.Shape r26, float r27, float r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldDefaults.a(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.ui.Modifier, androidx.compose.material3.TextFieldColors, androidx.compose.ui.graphics.Shape, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void b(final boolean r18, final boolean r19, final androidx.compose.foundation.interaction.InteractionSource r20, androidx.compose.material3.TextFieldColors r21, androidx.compose.ui.graphics.Shape r22, float r23, float r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instruction units count: 445
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldDefaults.b(boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.material3.TextFieldColors, androidx.compose.ui.graphics.Shape, float, float, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:258:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void c(final java.lang.String r37, final kotlin.jvm.functions.Function2 r38, final boolean r39, final boolean r40, final androidx.compose.ui.text.input.VisualTransformation r41, final androidx.compose.foundation.interaction.InteractionSource r42, boolean r43, kotlin.jvm.functions.Function2 r44, kotlin.jvm.functions.Function2 r45, kotlin.jvm.functions.Function2 r46, kotlin.jvm.functions.Function2 r47, kotlin.jvm.functions.Function2 r48, kotlin.jvm.functions.Function2 r49, kotlin.jvm.functions.Function2 r50, androidx.compose.material3.TextFieldColors r51, androidx.compose.foundation.layout.PaddingValues r52, kotlin.jvm.functions.Function2 r53, androidx.compose.runtime.Composer r54, final int r55, final int r56, final int r57) {
        /*
            Method dump skipped, instruction units count: 1051
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.OutlinedTextFieldDefaults.c(java.lang.String, kotlin.jvm.functions.Function2, boolean, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.interaction.InteractionSource, boolean, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.material3.TextFieldColors, androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public final TextFieldColors d(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-471651810, i3, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:921)");
        }
        TextFieldColors textFieldColorsH = h(MaterialTheme.f18110a.a(composer, 6), composer, (i3 << 3) & 112);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return textFieldColorsH;
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
            ComposerKt.U(1767617725, i3, i4, "androidx.compose.material3.OutlinedTextFieldDefaults.colors (TextFieldDefaults.kt:1023)");
        } else {
            j45 = jK42;
            textSelectionColors2 = textSelectionColors3;
        }
        TextFieldColors textFieldColorsB = h(MaterialTheme.f18110a.a(composer, 6), composer, (i7 >> 6) & 112).b(j46, jK2, jK3, jK4, jK5, jK6, jK7, jK8, jK9, jK10, textSelectionColors2, jK11, jK12, jK13, jK14, jK15, jK16, jK17, jK18, jK19, jK20, jK21, jK22, jK23, jK24, jK25, jK26, jK27, jK28, jK29, jK30, jK31, jK32, jK33, jK34, jK35, jK36, jK37, jK38, jK39, jK40, jK41, j45);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return textFieldColorsB;
    }

    public final PaddingValues f(float f3, float f4, float f5, float f6) {
        return PaddingKt.d(f3, f4, f5, f6);
    }

    public final TextFieldColors h(ColorScheme colorScheme, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-292363577, i3, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-defaultOutlinedTextFieldColors> (TextFieldDefaults.kt:1071)");
        }
        TextFieldColors textFieldColorsG = colorScheme.G();
        composer.a0(1540400102);
        if (textFieldColorsG == null) {
            OutlinedTextFieldTokens outlinedTextFieldTokens = OutlinedTextFieldTokens.f23157a;
            long jG = ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.p());
            long jG2 = ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.v());
            long jR = Color.r(ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.c()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null);
            long jG3 = ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.j());
            Color.Companion companion = Color.f25715b;
            TextFieldColors textFieldColors = new TextFieldColors(jG, jG2, jR, jG3, companion.j(), companion.j(), companion.j(), companion.j(), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.a()), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.i()), (TextSelectionColors) composer.q(TextSelectionColorsKt.b()), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.s()), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.B()), Color.r(ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.f()), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.m()), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.r()), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.A()), Color.r(ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.e()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.l()), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.u()), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.D()), Color.r(ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.h()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.o()), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.q()), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.z()), Color.r(ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.d()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.k()), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.w()), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.w()), Color.r(ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.c()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.w()), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.t()), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.C()), Color.r(ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.g()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.n()), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.x()), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.x()), Color.r(ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.x()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.x()), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.y()), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.y()), Color.r(ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.y()), 0.38f, 0.0f, 0.0f, 0.0f, 14, null), ColorSchemeKt.g(colorScheme, outlinedTextFieldTokens.y()), null);
            colorScheme.e1(textFieldColors);
            textFieldColorsG = textFieldColors;
        }
        composer.U();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return textFieldColorsG;
    }

    public final float i() {
        return f18902e;
    }

    public final float j() {
        return f18899b;
    }

    public final float k() {
        return f18900c;
    }

    public final Shape l(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1066756961, i3, -1, "androidx.compose.material3.OutlinedTextFieldDefaults.<get-shape> (TextFieldDefaults.kt:729)");
        }
        Shape shapeE = ShapesKt.e(OutlinedTextFieldTokens.f23157a.b(), composer, 6);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shapeE;
    }

    public final float m() {
        return f18901d;
    }
}
