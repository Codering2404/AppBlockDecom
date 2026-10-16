package cz.mobilesoft.coreblock.view.badge;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
public final class PremiumGiftCardKt {
    /* JADX WARN: Removed duplicated region for block: B:121:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void g(androidx.compose.ui.Modifier r31, final java.lang.String r32, androidx.compose.ui.graphics.painter.Painter r33, kotlin.jvm.functions.Function2 r34, float r35, long r36, boolean r38, final kotlin.jvm.functions.Function0 r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instruction units count: 587
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.badge.PremiumGiftCardKt.g(androidx.compose.ui.Modifier, java.lang.String, androidx.compose.ui.graphics.painter.Painter, kotlin.jvm.functions.Function2, float, long, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final void h(final Modifier modifier, Function0 function0, Composer composer, final int i3, final int i4) {
        int i5;
        final Function0 function02;
        Composer composerK = composer.k(-1751322182);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(function0) ? 32 : 16;
        }
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (i6 != 0) {
                modifier = Modifier.b8;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-1751322182, i5, -1, "cz.mobilesoft.coreblock.view.badge.PremiumGiftCardButton (PremiumGiftCard.kt:178)");
            }
            int i7 = (i5 & 14) | 24624 | ((i5 << 12) & 458752);
            Modifier modifier2 = modifier;
            function02 = function0;
            FlatButtonsKt.K(modifier2, Dp.g(40), R.drawable.f95580y1, FlatButtonColors.b(FlatButtonColors.Secondary.f131167a, null, Color.n(ComposeColorsKt.j(composerK, 0).u()), 1, null), null, function02, composerK, i7, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier = modifier2;
        } else {
            function02 = function0;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.badge.d0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PremiumGiftCardKt.i(modifier, function02, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Modifier modifier, Function0 function0, int i3, int i4, Composer composer, int i5) {
        h(modifier, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void j(androidx.compose.ui.Modifier r17, androidx.compose.ui.graphics.painter.Painter r18, kotlin.jvm.functions.Function2 r19, final float r20, boolean r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instruction units count: 457
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.view.badge.PremiumGiftCardKt.j(androidx.compose.ui.Modifier, androidx.compose.ui.graphics.painter.Painter, kotlin.jvm.functions.Function2, float, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(float f3, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.l(Float.intBitsToFloat((int) (graphicsLayer.b() >> 32)) * f3);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Modifier modifier, Painter painter, Function2 function2, float f3, boolean z2, int i3, int i4, Composer composer, int i5) {
        j(modifier, painter, function2, f3, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void m(Modifier modifier, final String str, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        Composer composer2;
        final Modifier modifier3;
        Composer composerK = composer.k(1071968247);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = i3 | (composerK.Z(modifier2) ? 4 : 2);
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(str) ? 32 : 16;
        }
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            Modifier modifier4 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(1071968247, i5, -1, "cz.mobilesoft.coreblock.view.badge.PremiumGiftCardTitle (PremiumGiftCard.kt:140)");
            }
            composer2 = composerK;
            modifier3 = modifier4;
            TextKt.c(str, modifier3, ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).i(), composer2, ((i5 >> 3) & 14) | ((i5 << 3) & 112), 0, 65528);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.badge.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PremiumGiftCardKt.n(modifier3, str, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Modifier modifier, String str, int i3, int i4, Composer composer, int i5) {
        m(modifier, str, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(boolean z2, Brush brush, Painter painter, Function2 function2, float f3, String str, Function0 function0, ColumnScope BaseCard, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(70770914, i3, -1, "cz.mobilesoft.coreblock.view.badge.PremiumGiftCard.<anonymous> (PremiumGiftCard.kt:62)");
            }
            if (z2) {
                composer.a0(-492574416);
                Modifier.Companion companion = Modifier.b8;
                Modifier modifierI = PaddingKt.i(BackgroundKt.b(IntrinsicKt.a(SizeKt.d(SizeKt.h(companion, 0.0f, 1, null), 0.0f, 1, null), IntrinsicSize.f6987b), brush, null, 0.0f, 6, null), Dp.g(16));
                Alignment.Companion companion2 = Alignment.f25072a;
                Alignment.Vertical verticalI = companion2.i();
                Arrangement arrangement = Arrangement.f6574a;
                MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), verticalI, composer, 48);
                int iA = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU = composer.u();
                Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
                Modifier modifierD = SizeKt.d(RowScope.c(RowScopeInstance.f7101a, companion, 1.0f, false, 2, null), 0.0f, 1, null);
                MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.e(), companion2.k(), composer, 6);
                int iA2 = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU2 = composer.u();
                Modifier modifierF2 = ComposedModifierKt.f(composer, modifierD);
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
                m(null, str, composer, 0, 1);
                h(null, function0, composer, 0, 1);
                composer.y();
                j(null, painter, function2, f3, true, composer, 24576, 1);
                composer.y();
                composer.U();
            } else {
                composer.a0(-491311786);
                Modifier.Companion companion4 = Modifier.b8;
                float f4 = 16;
                Modifier modifierI2 = PaddingKt.i(BackgroundKt.b(SizeKt.f(companion4, 0.0f, 1, null), brush, null, 0.0f, 6, null), Dp.g(f4));
                Arrangement.HorizontalOrVertical horizontalOrVerticalE = Arrangement.f6574a.e();
                Alignment.Companion companion5 = Alignment.f25072a;
                MeasurePolicy measurePolicyA2 = ColumnKt.a(horizontalOrVerticalE, companion5.k(), composer, 6);
                int iA3 = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU3 = composer.u();
                Modifier modifierF3 = ComposedModifierKt.f(composer, modifierI2);
                ComposeUiNode.Companion companion6 = ComposeUiNode.f8;
                Function0 function0A3 = companion6.a();
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
                Updater.e(composerA3, measurePolicyA2, companion6.e());
                Updater.e(composerA3, compositionLocalMapU3, companion6.g());
                Function2 function2B3 = companion6.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF3, companion6.f());
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.f6666a;
                m(null, str, composer, 0, 1);
                SpacerKt.a(SizeKt.i(companion4, Dp.g(f4)), composer, 6);
                Modifier modifierF4 = SizeKt.f(companion4, 0.0f, 1, null);
                MeasurePolicy measurePolicyG = BoxKt.g(companion5.o(), false);
                int iA4 = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU4 = composer.u();
                Modifier modifierF5 = ComposedModifierKt.f(composer, modifierF4);
                Function0 function0A4 = companion6.a();
                if (composer.m() == null) {
                    ComposablesKt.c();
                }
                composer.L();
                if (composer.i()) {
                    composer.P(function0A4);
                } else {
                    composer.v();
                }
                Composer composerA4 = Updater.a(composer);
                Updater.e(composerA4, measurePolicyG, companion6.e());
                Updater.e(composerA4, compositionLocalMapU4, companion6.g());
                Function2 function2B4 = companion6.b();
                if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                    composerA4.w(Integer.valueOf(iA4));
                    composerA4.p(Integer.valueOf(iA4), function2B4);
                }
                Updater.e(composerA4, modifierF5, companion6.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                j(boxScopeInstance.f(companion4, companion5.c()), painter, function2, f3, false, composer, 24576, 0);
                h(boxScopeInstance.f(companion4, companion5.d()), function0, composer, 0, 0);
                composer.y();
                composer.y();
                composer.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Modifier modifier, String str, Painter painter, Function2 function2, float f3, long j3, boolean z2, Function0 function0, int i3, int i4, Composer composer, int i5) {
        g(modifier, str, painter, function2, f3, j3, z2, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
