package cz.mobilesoft.coreblock.view.compose;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import java.io.IOException;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserException;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ComposeCardsKt {
    /* JADX WARN: Removed duplicated region for block: B:136:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void j(androidx.compose.ui.Modifier r20, kotlin.jvm.functions.Function0 r21, final long r22, androidx.compose.ui.graphics.Color r24, float r25, androidx.compose.ui.unit.Dp r26, androidx.compose.foundation.shape.RoundedCornerShape r27, final kotlin.jvm.functions.Function2 r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 559
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeCardsKt.j(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function0, long, androidx.compose.ui.graphics.Color, float, androidx.compose.ui.unit.Dp, androidx.compose.foundation.shape.RoundedCornerShape, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Modifier modifier, Function0 function0, long j3, Color color, float f3, Dp dp, RoundedCornerShape roundedCornerShape, Function2 function2, int i3, int i4, Composer composer, int i5) {
        j(modifier, function0, j3, color, f3, dp, roundedCornerShape, function2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x024a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void m(androidx.compose.ui.Modifier r23, final cz.mobilesoft.coreblock.view.compose.CardType r24, kotlin.jvm.functions.Function0 r25, kotlin.jvm.functions.Function2 r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 609
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeCardsKt.m(androidx.compose.ui.Modifier, cz.mobilesoft.coreblock.view.compose.CardType, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Modifier modifier, CardType cardType, Function0 function0, Function2 function2, int i3, int i4, Composer composer, int i5) {
        m(modifier, cardType, function0, function2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void p(final java.lang.String r21, final java.lang.String r22, final java.lang.String r23, final int r24, final kotlin.jvm.functions.Function0 r25, final kotlin.jvm.functions.Function0 r26, androidx.compose.ui.Modifier r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeCardsKt.p(java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(String str, String str2, String str3, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        if (composer.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(720852564, i4, -1, "cz.mobilesoft.coreblock.view.compose.HintCard.<anonymous> (ComposeCards.kt:283)");
            }
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.HorizontalOrVertical horizontalOrVerticalE = arrangement.e();
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierA = IntrinsicKt.a(companion, IntrinsicSize.f6987b);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalE, companion2.l(), composer, 6);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierA);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            Modifier modifierC = RowScope.c(RowScopeInstance.f7101a, companion, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), companion2.k(), composer, 0);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierC);
            Function0 function0A2 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A2);
            } else {
                composer.v();
            }
            Composer composerA2 = Updater.a(composer);
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            float f3 = 16;
            androidx.compose.material.TextKt.c(str, PaddingKt.m(companion, Dp.g(f3), Dp.g(f3), 0.0f, 0.0f, 12, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).i(), composer, 48, 0, 65532);
            float f4 = 4;
            androidx.compose.material.TextKt.c(str2, PaddingKt.m(companion, Dp.g(f3), Dp.g(f4), 0.0f, 0.0f, 12, null), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 48, 0, 65528);
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion, 1.0f, false, 2, null), composer, 0);
            ComposeButtonsKt.c0(str3, PaddingKt.j(companion, Dp.g(8), Dp.g(f4)), false, 0L, null, 0.0f, null, function0, composer, 48, 124);
            composer.y();
            Arrangement.HorizontalOrVertical horizontalOrVerticalE2 = arrangement.e();
            Alignment.Horizontal horizontalJ = companion2.j();
            Modifier modifierD = SizeKt.d(SizeKt.I(companion, null, false, 3, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(horizontalOrVerticalE2, horizontalJ, composer, 54);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierD);
            Function0 function0A3 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A3);
            } else {
                composer.v();
            }
            Composer composerA3 = Updater.a(composer);
            Updater.e(composerA3, measurePolicyA2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            ImageVector.Companion companion4 = ImageVector.f26323k;
            ComposeButtonsKt.q0(null, VectorResources_androidKt.b(companion4, R.drawable.C1, composer, 6), null, false, 0.0f, 0.0f, 0L, StringResources_androidKt.b(R.string.N7, composer, 0), function02, composer, 0, 125);
            androidx.compose.foundation.ImageKt.b(VectorResources_androidKt.b(companion4, i3, composer, 6), null, null, null, null, 0.0f, null, composer, 48, 124);
            composer.y();
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(String str, String str2, String str3, int i3, Function0 function0, Function0 function02, Modifier modifier, int i4, int i5, Composer composer, int i6) {
        p(str, str2, str3, i3, function0, function02, modifier, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0412  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:267:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void s(androidx.compose.ui.Modifier r34, final cz.mobilesoft.coreblock.enums.PremiumFeature r35, boolean r36, androidx.compose.ui.graphics.Shape r37, long r38, long r40, boolean r42, boolean r43, boolean r44, androidx.compose.ui.graphics.vector.ImageVector r45, java.lang.String r46, java.lang.String r47, boolean r48, androidx.compose.foundation.layout.PaddingValues r49, boolean r50, kotlin.jvm.functions.Function0 r51, androidx.compose.runtime.Composer r52, final int r53, final int r54, final int r55) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1125
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.compose.ComposeCardsKt.s(androidx.compose.ui.Modifier, cz.mobilesoft.coreblock.enums.PremiumFeature, boolean, androidx.compose.ui.graphics.Shape, long, long, boolean, boolean, boolean, androidx.compose.ui.graphics.vector.ImageVector, java.lang.String, java.lang.String, boolean, androidx.compose.foundation.layout.PaddingValues, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(PaddingValues paddingValues, boolean z2, ImageVector imageVector, long j3, PremiumFeature premiumFeature, boolean z3, boolean z4, String str, boolean z5, boolean z6, String str2, Context context, boolean z7, Composer composer, int i3) throws XmlPullParserException, IOException {
        int i4;
        int i5;
        Composer composer2;
        int i6;
        TextStyle textStyleJ;
        Modifier.Companion companion;
        Composer composer3;
        int i7;
        Modifier modifierI;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1710307642, i3, -1, "cz.mobilesoft.coreblock.view.compose.PremiumFeatureCard.<anonymous> (ComposeCards.kt:172)");
            }
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.HorizontalOrVertical horizontalOrVerticalE = arrangement.e();
            Alignment.Companion companion2 = Alignment.f25072a;
            Alignment.Vertical verticalI = companion2.i();
            Modifier.Companion companion3 = Modifier.b8;
            Modifier modifierH = PaddingKt.h(companion3, paddingValues);
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalE, verticalI, composer, 54);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyB, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            if (z2) {
                composer.a0(168697077);
                i4 = 8;
                i5 = 6;
                IconKt.b(imageVector, StringResources_androidKt.b(R.string.Yf, composer, 0), SizeKt.v(PaddingKt.m(companion3, 0.0f, 0.0f, Dp.g(12), 0.0f, 11, null), Dp.g(24)), j3, composer, 384, 0);
                composer.U();
                Unit unit = Unit.f139807a;
                composer2 = composer;
            } else {
                i4 = 8;
                i5 = 6;
                composer.a0(169098248);
                Integer smallIconResId = premiumFeature.getSmallIconResId();
                if (smallIconResId == null) {
                    composer.a0(169098247);
                    composer.U();
                    composer2 = composer;
                } else {
                    composer.a0(169098248);
                    i4 = 8;
                    i5 = 6;
                    IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, smallIconResId.intValue(), composer, 6), StringResources_androidKt.b(R.string.Yf, composer, 0), PaddingKt.m(companion3, 0.0f, 0.0f, Dp.g(8), 0.0f, 11, null), j3, composer, 384, 0);
                    composer2 = composer;
                    Unit unit2 = Unit.f139807a;
                    composer2.U();
                }
                composer2.U();
            }
            if (z3) {
                composer2.a0(169538417);
                Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement.o(Dp.g(4));
                Modifier modifierC = RowScope.c(rowScopeInstance, companion3, 1.0f, false, 2, null);
                MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalO, companion2.k(), composer2, i5);
                int iA2 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU2 = composer2.u();
                Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierC);
                Function0 function0A2 = companion4.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A2);
                } else {
                    composer2.v();
                }
                Composer composerA2 = Updater.a(composer2);
                Updater.e(composerA2, measurePolicyA, companion4.e());
                Updater.e(composerA2, compositionLocalMapU2, companion4.g());
                Function2 function2B2 = companion4.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion4.f());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.g(), companion2.l(), composer2, 0);
                int iA3 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU3 = composer2.u();
                Modifier modifierF3 = ComposedModifierKt.f(composer2, companion3);
                Function0 function0A3 = companion4.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A3);
                } else {
                    composer2.v();
                }
                Composer composerA3 = Updater.a(composer2);
                Updater.e(composerA3, measurePolicyB2, companion4.e());
                Updater.e(composerA3, compositionLocalMapU3, companion4.g());
                Function2 function2B3 = companion4.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF3, companion4.f());
                Composer composer4 = composer2;
                cz.mobilesoft.coreblock.view.TextKt.g(str, null, ComposeTypographyKt.g(composer2, 0).i(), ComposeColorsKt.j(composer2, 0).p(), null, 0, null, composer4, 0, 114);
                Composer composer5 = composer4;
                if (z7) {
                    composer5.a0(-752692577);
                    SpacerKt.a(SizeKt.A(companion3, Dp.g(i4)), composer5, i5);
                    String upperCase = StringResources_androidKt.b(R.string.b7, composer5, 0).toUpperCase(Locale.ROOT);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
                    LabelsKt.e(upperCase, ComposeColorsKt.j(composer5, 0).q0(), j3, 0.0f, 0.0f, null, null, composer, 0, 120);
                    composer5 = composer;
                } else {
                    composer5.a0(-761652104);
                }
                composer5.U();
                composer5.y();
                androidx.compose.material.TextKt.c(str2 == null ? premiumFeature.getDescription(context).toString() : str2, null, ComposeColorsKt.j(composer5, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer5, 0).d(), composer, 0, 0, 65530);
                composer3 = composer;
                composer3.y();
                composer3.U();
                companion = companion3;
                i6 = 0;
            } else {
                Composer composer6 = composer2;
                composer6.a0(170803930);
                if (z4) {
                    composer6.a0(-133034336);
                    i6 = 0;
                    textStyleJ = ComposeTypographyKt.g(composer6, 0).i();
                } else {
                    i6 = 0;
                    composer6.a0(-133033728);
                    textStyleJ = ComposeTypographyKt.g(composer6, 0).j();
                }
                composer6.U();
                long jQ = ComposeColorsKt.j(composer6, i6).q();
                Modifier modifierC2 = RowScope.c(rowScopeInstance, companion3, 1.0f, false, 2, null);
                companion = companion3;
                cz.mobilesoft.coreblock.view.TextKt.g(str, modifierC2, textStyleJ, jQ, null, 1, null, composer, 196608, 80);
                composer3 = composer;
                composer3.U();
            }
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.r4, composer3, 6);
            String strB = StringResources_androidKt.b(R.string.Me, composer3, i6);
            long jY = ComposeColorsKt.j(composer3, i6).Y();
            if (z5) {
                composer3.a0(171444483);
                i7 = 8;
                modifierI = PaddingKt.i(BackgroundKt.c(PaddingKt.m(companion, Dp.g(16), 0.0f, 0.0f, 0.0f, 14, null), ComposeColorsKt.j(composer3, i6).l0(), RoundedCornerShapeKt.g()), Dp.g(8));
                composer3.U();
            } else {
                i7 = 8;
                composer3.a0(171852908);
                composer3.U();
                modifierI = companion;
            }
            IconKt.b(imageVectorB, strB, modifierI, jY, composer3, 0, 0);
            if (z6) {
                composer3.a0(171981434);
                androidx.compose.material.TextKt.c(StringResources_androidKt.b(R.string.JD, composer3, i6), PaddingKt.m(companion, Dp.g(i7), 0.0f, 0.0f, 0.0f, 14, null), ComposeColorsKt.j(composer3, i6).Y(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, null, ComposeTypographyKt.g(composer3, i6).j(), composer, 48, 3072, 57336);
                composer3 = composer;
            } else {
                composer3.a0(161102852);
            }
            composer3.U();
            composer3.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Modifier modifier, PremiumFeature premiumFeature, boolean z2, Shape shape, long j3, long j4, boolean z3, boolean z4, boolean z5, ImageVector imageVector, String str, String str2, boolean z6, PaddingValues paddingValues, boolean z7, Function0 function0, int i3, int i4, int i5, Composer composer, int i6) throws XmlPullParserException, IOException {
        s(modifier, premiumFeature, z2, shape, j3, j4, z3, z4, z5, imageVector, str, str2, z6, paddingValues, z7, function0, composer, RecomposeScopeImplKt.a(i3 | 1), RecomposeScopeImplKt.a(i4), i5);
        return Unit.f139807a;
    }

    public static final RoundedCornerShape w(Alignment.Vertical vertical, Composer composer, int i3) {
        RoundedCornerShape roundedCornerShapeD;
        if (ComposerKt.M()) {
            ComposerKt.U(-109271336, i3, -1, "cz.mobilesoft.coreblock.view.compose.cardCornerShape (ComposeCards.kt:121)");
        }
        Alignment.Companion companion = Alignment.f25072a;
        if (Intrinsics.areEqual(vertical, companion.l())) {
            composer.a0(282962230);
            int i4 = R.dimen.f95480n;
            float f3 = 2;
            roundedCornerShapeD = RoundedCornerShapeKt.e(PrimitiveResources_androidKt.a(i4, composer, 0), PrimitiveResources_androidKt.a(i4, composer, 0), Dp.g(f3), Dp.g(f3));
            composer.U();
        } else if (Intrinsics.areEqual(vertical, companion.i())) {
            composer.a0(-1930526992);
            composer.U();
            roundedCornerShapeD = RoundedCornerShapeKt.d(Dp.g(2));
        } else if (Intrinsics.areEqual(vertical, companion.a())) {
            composer.a0(283263798);
            int i5 = R.dimen.f95480n;
            float f4 = 2;
            roundedCornerShapeD = RoundedCornerShapeKt.e(Dp.g(f4), Dp.g(f4), PrimitiveResources_androidKt.a(i5, composer, 0), PrimitiveResources_androidKt.a(i5, composer, 0));
            composer.U();
        } else {
            composer.a0(-1930517925);
            roundedCornerShapeD = RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(R.dimen.f95480n, composer, 0));
            composer.U();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return roundedCornerShapeD;
    }
}
