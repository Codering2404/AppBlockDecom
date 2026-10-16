package cz.mobilesoft.coreblock.scene.premium;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
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
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.usecase.YearlySavingsData;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeSectionedButtonsKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
public final class ProductPlanPremiumScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(YearlySavingsData yearlySavingsData, Function0 function0, int i3, Composer composer, int i4) {
        z(yearlySavingsData, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void k(Composer composer, final int i3) {
        Composer composerK = composer.k(1698121478);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1698121478, i3, -1, "cz.mobilesoft.coreblock.scene.premium.PremiumBenefits (ProductPlanPremiumScreen.kt:53)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = InteractionSourceKt.a();
                composerK.w(objG2);
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objG2;
            Modifier.Companion companion2 = Modifier.b8;
            float f3 = 16;
            Modifier modifierM = PaddingKt.m(BackgroundKt.c(PaddingKt.m(SizeKt.h(companion2, 0.0f, 1, null), Dp.g(f3), 0.0f, Dp.g(f3), 0.0f, 10, null), ComposeColorsKt.j(composerK, 0).l0(), RoundedCornerShapeKt.d(Dp.g(f3))), Dp.g(f3), 0.0f, Dp.g(f3), 0.0f, 10, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion3.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyA, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Modifier modifierI = SizeKt.i(SizeKt.h(companion2, 0.0f, 1, null), Dp.g(56));
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.premium.t0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ProductPlanPremiumScreenKt.n(mutableState);
                    }
                };
                composerK.w(objG3);
            }
            Modifier modifierD = ClickableKt.d(modifierI, mutableInteractionSource, null, false, null, null, (Function0) objG3, 28, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion3.i(), composerK, 48);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierD);
            Function0 function0A2 = companion4.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A2);
            } else {
                composerK.v();
            }
            Composer composerA2 = Updater.a(composerK);
            Updater.e(composerA2, measurePolicyB, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.p4, composerK, 6), null, SizeKt.v(companion2, Dp.g(f3)), ComposeColorsKt.j(composerK, 0).Y(), composerK, 432, 0);
            SpacerKt.a(SizeKt.A(companion2, Dp.g(8)), composerK, 6);
            TextKt.c(StringResources_androidKt.b(R.string.sc, composerK, 0), null, ComposeColorsKt.j(composerK, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).h(), composerK, 0, 0, 65530);
            SpacerKt.a(RowScope.c(rowScopeInstance, companion2, 1.0f, false, 2, null), composerK, 0);
            Modifier modifierV = SizeKt.v(companion2, Dp.g(f3));
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.premium.u0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ProductPlanPremiumScreenKt.o(mutableState, (GraphicsLayerScope) obj);
                    }
                };
                composerK.w(objG4);
            }
            IconKt.a(PainterResources_androidKt.c(R.drawable.f95571v1, composerK, 0), null, GraphicsLayerModifierKt.a(modifierV, (Function1) objG4), ComposeColorsKt.j(composerK, 0).M(), composerK, 432, 0);
            composerK.y();
            AnimatedVisibilityKt.g(columnScopeInstance, l(mutableState), null, null, null, null, ComposableSingletons$ProductPlanPremiumScreenKt.f112342a.d(), composerK, 1572870, 30);
            composerK = composerK;
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.v0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProductPlanPremiumScreenKt.p(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean l(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void m(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(MutableState mutableState) {
        m(mutableState, !l(mutableState));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(MutableState mutableState, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        if (l(mutableState)) {
            graphicsLayer.j(180.0f);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(int i3, Composer composer, int i4) {
        k(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:96:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void q(final java.util.List r23, final boolean r24, kotlin.jvm.functions.Function0 r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 520
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.ProductPlanPremiumScreenKt.q(java.util.List, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(Function0 function0, BoxScope SectionRow, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(SectionRow, "$this$SectionRow");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(SectionRow) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1621700432, i4, -1, "cz.mobilesoft.coreblock.scene.premium.PremiumPlan.<anonymous>.<anonymous> (ProductPlanPremiumScreen.kt:149)");
            }
            ComposeButtonsKt.i0(SizeKt.i(SectionRow.f(Modifier.b8, Alignment.f25072a.e()), Dp.g(32)), new ButtonType.SmallRound(null, null, StringResources_androidKt.b(R.string.Xm, composer, 0), Dp.d(Dp.g(10)), false, 19, null), new ButtonColor.Light(false, null, false, null, null, 31, null), function0, composer, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(List list, boolean z2, Function0 function0, int i3, int i4, Composer composer, int i5) {
        q(list, z2, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void u(String subtitle, Function0 function0, Composer composer, final int i3) {
        int i4;
        final String str;
        final Function0 onFooterButtonClicked = function0;
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Intrinsics.checkNotNullParameter(onFooterButtonClicked, "onFooterButtonClicked");
        Composer composerK = composer.k(-120221093);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(subtitle) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onFooterButtonClicked) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-120221093, i4, -1, "cz.mobilesoft.coreblock.scene.premium.PremiumPlanFooter (ProductPlanPremiumScreen.kt:220)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            TextKt.c(subtitle, PaddingKt.m(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), 0.0f, Dp.g(f3), 0.0f, 10, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composerK, (i4 & 14) | 48, 0, 65020);
            str = subtitle;
            composerK = composerK;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            ComposeButtonsKt.i0(SizeKt.i(companion, Dp.g(32)), new ButtonType.SmallRound(null, null, StringResources_androidKt.b(R.string.Fj, composerK, 0), Dp.d(Dp.g(10)), true, 3, null), new ButtonColor.Light(false, null, false, null, null, 31, null), function0, composerK, ((i4 << 6) & 7168) | 6, 0);
            onFooterButtonClicked = function0;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            str = subtitle;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.s0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProductPlanPremiumScreenKt.v(str, onFooterButtonClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(String str, Function0 function0, int i3, Composer composer, int i4) {
        u(str, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void w(final Pair text, Shape corners, boolean z2, Composer composer, final int i3) {
        int i4;
        final Shape shape;
        final boolean z3;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(corners, "corners");
        Composer composerK = composer.k(724551023);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(text) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(corners) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(724551023, i4, -1, "cz.mobilesoft.coreblock.scene.premium.PremiumPlanSectionRow (ProductPlanPremiumScreen.kt:170)");
            }
            int i5 = i4 << 3;
            shape = corners;
            z3 = z2;
            ComposeSectionedButtonsKt.d(null, 0L, shape, z3, null, ComposableLambdaKt.e(1480263569, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.premium.z0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ProductPlanPremiumScreenKt.x(text, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, (i5 & 896) | 196608 | (i5 & 7168), 19);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            shape = corners;
            z3 = z2;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.a1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProductPlanPremiumScreenKt.y(text, shape, z3, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(Pair pair, BoxScope SectionRow, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(SectionRow, "$this$SectionRow");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(SectionRow) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1480263569, i4, -1, "cz.mobilesoft.coreblock.scene.premium.PremiumPlanSectionRow.<anonymous> (ProductPlanPremiumScreen.kt:175)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierK = PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), 0.0f, Dp.g(16), 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            Modifier modifierF = SectionRow.f(modifierK, companion2.e());
            Alignment.Vertical verticalL = companion2.l();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), verticalL, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierF);
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
            Updater.e(composerA, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            TextKt.c((String) pair.e(), null, ComposeColorsKt.j(composer, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
            Composer composer2 = composer;
            Modifier modifierC = RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null);
            int i5 = 0;
            SpacerKt.a(modifierC, composer2, 0);
            if (pair.f() instanceof Collection) {
                composer2.a0(-448077814);
                MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.o(Dp.g(4)), companion2.j(), composer2, 54);
                int iA2 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU2 = composer2.u();
                Modifier modifierF3 = ComposedModifierKt.f(composer2, companion);
                Function0 function0A2 = companion3.a();
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
                Updater.e(composerA2, measurePolicyA, companion3.e());
                Updater.e(composerA2, compositionLocalMapU2, companion3.g());
                Function2 function2B2 = companion3.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF3, companion3.f());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                composer2.a0(936068706);
                Object objF = pair.f();
                Intrinsics.checkNotNull(objF, "null cannot be cast to non-null type kotlin.collections.Collection<*>");
                Iterator it = ((Collection) objF).iterator();
                while (it.hasNext()) {
                    TextKt.c(String.valueOf(it.next()), null, ComposeColorsKt.j(composer2, i5).O(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.b()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, i5).i(), composer, 0, 0, 65018);
                    composer2 = composer;
                    i5 = 0;
                }
                composer2.U();
                composer2.y();
                composer2.U();
            } else {
                composer2.a0(-447508933);
                TextKt.c(pair.f().toString(), null, ComposeColorsKt.j(composer2, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).i(), composer, 0, 0, 65530);
                composer.U();
            }
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
    public static final Unit y(Pair pair, Shape shape, boolean z2, int i3, Composer composer, int i4) {
        w(pair, shape, z2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void z(final YearlySavingsData savings, final Function0 onSwitchToYearlyClicked, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(savings, "savings");
        Intrinsics.checkNotNullParameter(onSwitchToYearlyClicked, "onSwitchToYearlyClicked");
        Composer composerK = composer.k(-2072407120);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(savings) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onSwitchToYearlyClicked) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2072407120, i4, -1, "cz.mobilesoft.coreblock.scene.premium.YearlyUpgradeBanner (ProductPlanPremiumScreen.kt:249)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            float f4 = 24;
            Modifier modifierA = ClipKt.a(PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), 0.0f, 2, null), RoundedCornerShapeKt.d(Dp.g(f4)));
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierA);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ImageKt.a(PainterResources_androidKt.c(R.drawable.y8, composerK, 0), null, BoxScopeInstance.f6642a.h(companion), null, ContentScale.f27054a.a(), 0.0f, null, composerK, 24624, 104);
            Modifier modifierI = PaddingKt.i(IntrinsicKt.a(SizeKt.h(companion, 0.0f, 1, null), IntrinsicSize.f6987b), Dp.g(6));
            Alignment.Vertical verticalI = companion2.i();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), verticalI, composerK, 48);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierI);
            Function0 function0A2 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A2);
            } else {
                composerK.v();
            }
            Composer composerA2 = Updater.a(composerK);
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            Modifier modifierC = RowScope.c(RowScopeInstance.f7101a, PaddingKt.i(companion, Dp.g(10)), 1.0f, false, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), companion2.k(), composerK, 0);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierC);
            Function0 function0A3 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A3);
            } else {
                composerK.v();
            }
            Composer composerA3 = Updater.a(composerK);
            Updater.e(composerA3, measurePolicyA, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextKt.c(StringResources_androidKt.c(R.string.sH, new Object[]{StringHelperExtKt.p(String.valueOf(savings.b()), "%", "")}, composerK, 0), null, ComposeColorsKt.j(composerK, 0).q0(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).h(), composerK, 0, 0, 65530);
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion, 1.0f, false, 2, null), composerK, 0);
            float f5 = 12;
            float f6 = 8;
            Modifier modifierJ = PaddingKt.j(ClickableKt.f(BackgroundKt.c(companion, ComposeColorsKt.j(composerK, 0).q0(), RoundedCornerShapeKt.d(Dp.g(f4))), false, null, null, onSwitchToYearlyClicked, 7, null), Dp.g(f5), Dp.g(f6));
            MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.g(), companion2.i(), composerK, 48);
            int iA4 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU4 = composerK.u();
            Modifier modifierF4 = ComposedModifierKt.f(composerK, modifierJ);
            Function0 function0A4 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A4);
            } else {
                composerK.v();
            }
            Composer composerA4 = Updater.a(composerK);
            Updater.e(composerA4, measurePolicyB2, companion3.e());
            Updater.e(composerA4, compositionLocalMapU4, companion3.g());
            Function2 function2B4 = companion3.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF4, companion3.f());
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.p4, composerK, 6), null, SizeKt.v(companion, Dp.g(f3)), ComposeColorsKt.j(composerK, 0).V(), composerK, 432, 0);
            SpacerKt.a(SizeKt.A(companion, Dp.g(4)), composerK, 6);
            TextKt.c(StringResources_androidKt.b(R.string.yF, composerK, 0), null, ComposeColorsKt.j(composerK, 0).V(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).i(), composerK, 0, 0, 65530);
            composerK.y();
            composerK.y();
            SpacerKt.a(SizeKt.A(companion, Dp.g(f5)), composerK, 6);
            Modifier modifierJ2 = PaddingKt.j(BackgroundKt.c(companion, ComposeColorsKt.j(composerK, 0).l0(), RoundedCornerShapeKt.d(Dp.g(f4))), Dp.g(f5), Dp.g(f4));
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion2.g(), composerK, 48);
            int iA5 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU5 = composerK.u();
            Modifier modifierF5 = ComposedModifierKt.f(composerK, modifierJ2);
            Function0 function0A5 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A5);
            } else {
                composerK.v();
            }
            Composer composerA5 = Updater.a(composerK);
            Updater.e(composerA5, measurePolicyA2, companion3.e());
            Updater.e(composerA5, compositionLocalMapU5, companion3.g());
            Function2 function2B5 = companion3.b();
            if (composerA5.i() || !Intrinsics.areEqual(composerA5.G(), Integer.valueOf(iA5))) {
                composerA5.w(Integer.valueOf(iA5));
                composerA5.p(Integer.valueOf(iA5), function2B5);
            }
            Updater.e(composerA5, modifierF5, companion3.f());
            composer2 = composerK;
            TextKt.c(StringResources_androidKt.b(R.string.rH, composerK, 0), null, ComposeColorsKt.j(composerK, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).h(), composer2, 0, 0, 65530);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f6)), composer2, 6);
            TextKt.c(savings.e(), null, ComposeColorsKt.j(composer2, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).a(), composer2, 0, 0, 65530);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f6)), composer2, 6);
            TextKt.c(StringResources_androidKt.c(R.string.kq, new Object[]{savings.a()}, composer2, 0), null, ComposeColorsKt.j(composer2, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).d(), composer2, 0, 0, 65530);
            composer2.y();
            composer2.y();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.premium.b1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ProductPlanPremiumScreenKt.A(savings, onSwitchToYearlyClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
