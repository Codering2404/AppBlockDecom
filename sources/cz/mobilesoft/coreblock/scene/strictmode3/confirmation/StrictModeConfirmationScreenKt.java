package cz.mobilesoft.coreblock.scene.strictmode3.confirmation;

import android.content.Context;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.pager.PagerScope;
import androidx.compose.foundation.pager.PagerState;
import androidx.compose.foundation.pager.PagerStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.TextKt;
import androidx.compose.material3.SheetState;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.Product;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.enums.StrictModeOption;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.strictmode3.confirmation.StrictModeConfirmationScreenKt;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.BottomSheetType;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeBottomSheetsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.IconCircleBackgroundKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;

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
public final class StrictModeConfirmationScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f121979a = Dp.g(104);

    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void A(final cz.mobilesoft.coreblock.enums.StrictModeAccessMethod r21, androidx.compose.ui.Modifier r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instruction units count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.confirmation.StrictModeConfirmationScreenKt.A(cz.mobilesoft.coreblock.enums.StrictModeAccessMethod, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(StrictModeAccessMethod strictModeAccessMethod, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        A(strictModeAccessMethod, modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void C(final kotlin.jvm.functions.Function0 r36, androidx.compose.ui.Modifier r37, androidx.compose.runtime.Composer r38, final int r39, final int r40) {
        /*
            Method dump skipped, instruction units count: 458
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.confirmation.StrictModeConfirmationScreenKt.C(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(Function0 function0, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        C(function0, modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void E(final java.util.List r30, final androidx.compose.foundation.pager.PagerState r31, androidx.compose.ui.Modifier r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instruction units count: 767
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.confirmation.StrictModeConfirmationScreenKt.E(java.util.List, androidx.compose.foundation.pager.PagerState, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(List list, PagerScope HorizontalPager, int i3, Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(HorizontalPager, "$this$HorizontalPager");
        if (ComposerKt.M()) {
            ComposerKt.U(-1117809768, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.confirmation.WarningCardsPager.<anonymous>.<anonymous>.<anonymous> (StrictModeConfirmationScreen.kt:366)");
        }
        n(((Number) list.get(i3)).intValue(), PaddingKt.k(SizeKt.h(Modifier.b8, 0.0f, 1, null), Dp.g(16), 0.0f, 2, null), composer, 48, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(List list, PagerState pagerState, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        E(list, pagerState, modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final List I(List list) {
        StrictModeOption strictModeOption = StrictModeOption.BlockSettings;
        if (list.contains(strictModeOption)) {
            List listListOf = CollectionsKt.listOf(strictModeOption);
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (((StrictModeOption) obj) != StrictModeOption.BlockSettings) {
                    arrayList.add(obj);
                }
            }
            list = CollectionsKt.plus((Collection) listListOf, (Iterable) arrayList);
        }
        return StrictModeOption.Companion.a(list);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:79:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void n(final int r32, androidx.compose.ui.Modifier r33, androidx.compose.runtime.Composer r34, final int r35, final int r36) {
        /*
            Method dump skipped, instruction units count: 819
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.confirmation.StrictModeConfirmationScreenKt.n(int, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(int i3, Modifier modifier, int i4, int i5, Composer composer, int i6) {
        n(i3, modifier, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    public static final void p(final StrictModeConfirmationViewState viewState, final Function0 onLockConfirmed, final Function0 onCloseClicked, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onLockConfirmed, "onLockConfirmed");
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Composer composerK = composer.k(275689959);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onLockConfirmed) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onCloseClicked) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(275689959, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.confirmation.StrictMode3ConfirmationScreen (StrictModeConfirmationScreen.kt:118)");
            }
            float f3 = 16;
            ComposeBottomSheetsKt.f(BottomSheetType.Default.f130300a, RoundedCornerShapeKt.f(Dp.g(f3), Dp.g(f3), 0.0f, 0.0f, 12, null), true, ComposableLambdaKt.e(822682790, true, new Function4() { // from class: y1.h
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return StrictModeConfirmationScreenKt.q(viewState, onLockConfirmed, onCloseClicked, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerK, 54), null, onCloseClicked, composerK, ((i4 << 9) & 458752) | 3462, 16);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: y1.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeConfirmationScreenKt.s(viewState, onLockConfirmed, onCloseClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(final StrictModeConfirmationViewState strictModeConfirmationViewState, final Function0 function0, Function0 function02, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(822682790, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.confirmation.StrictMode3ConfirmationScreen.<anonymous> (StrictModeConfirmationScreen.kt:125)");
            }
            boolean Z = composer.Z(strictModeConfirmationViewState) | composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: y1.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeConfirmationScreenKt.r(strictModeConfirmationViewState, function0);
                    }
                };
                composer.w(objG);
            }
            t(strictModeConfirmationViewState, (Function0) objG, function02, composer, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(StrictModeConfirmationViewState strictModeConfirmationViewState, Function0 function0) {
        ImmutableList immutableListC = strictModeConfirmationViewState.c();
        if (immutableListC == null || !immutableListC.isEmpty()) {
            Iterator<E> it = immutableListC.iterator();
            while (it.hasNext()) {
                if (((StrictModeOption) it.next()) != StrictModeOption.BlockEditing) {
                    AnswersHelper.f128199a.t7();
                    break;
                }
            }
            AnswersHelper.f128199a.f7();
        } else {
            AnswersHelper.f128199a.f7();
        }
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(StrictModeConfirmationViewState strictModeConfirmationViewState, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        p(strictModeConfirmationViewState, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(final StrictModeConfirmationViewState strictModeConfirmationViewState, Function0 function0, Function0 function02, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        final Function0 function03;
        float f3;
        Object obj;
        Modifier.Companion companion;
        int i5;
        Composer composer3;
        Modifier.Companion companion2;
        int i6;
        float f4;
        final Function0 function04 = function0;
        Composer composerK = composer.k(394288855);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(strictModeConfirmationViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function04) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function02) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(394288855, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.confirmation.StrictModeActivationSheetContent (StrictModeConfirmationScreen.kt:148)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            boolean Z = composerK.Z(strictModeConfirmationViewState.c());
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = I(strictModeConfirmationViewState.c());
                composerK.w(objG);
            }
            final List list = (List) objG;
            boolean zI = composerK.I(list);
            Object objG2 = composerK.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: y1.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Integer.valueOf(StrictModeConfirmationScreenKt.u(list));
                    }
                };
                composerK.w(objG2);
            }
            PagerState pagerStateL = PagerStateKt.l(0, 0.0f, (Function0) objG2, composerK, 0, 3);
            Alignment.Companion companion3 = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion3.g();
            Modifier.Companion companion4 = Modifier.b8;
            Modifier modifierK = PaddingKt.k(SizeKt.h(companion4, 0.0f, 1, null), PrimitiveResources_androidKt.a(R.dimen.f95486t, composerK, 0), 0.0f, 2, null);
            float f5 = 24;
            Modifier modifierM = PaddingKt.m(modifierK, 0.0f, 0.0f, 0.0f, Dp.g(f5), 7, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
            ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
            Function0 function0A = companion5.a();
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
            Updater.e(composerA, measurePolicyA, companion5.e());
            Updater.e(composerA, compositionLocalMapU, companion5.g());
            Function2 function2B = companion5.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion5.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Modifier modifierH = SizeKt.h(companion4, 0.0f, 1, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierH);
            Function0 function0A2 = companion5.a();
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
            Updater.e(composerA2, measurePolicyG, companion5.e());
            Updater.e(composerA2, compositionLocalMapU2, companion5.g());
            Function2 function2B2 = companion5.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion5.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            float f6 = 16;
            float f7 = 40;
            Modifier modifierF3 = ClickableKt.f(SizeKt.v(PaddingKt.k(boxScopeInstance.f(companion4, companion3.n()), Dp.g(f6), 0.0f, 2, null), Dp.g(f7)), false, null, null, function02, 7, null);
            function03 = function02;
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion3.o(), false);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF4 = ComposedModifierKt.f(composerK, modifierF3);
            Function0 function0A3 = companion5.a();
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
            Updater.e(composerA3, measurePolicyG2, companion5.e());
            Updater.e(composerA3, compositionLocalMapU3, companion5.g());
            Function2 function2B3 = companion5.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF4, companion5.f());
            Modifier modifierA = ClipKt.a(boxScopeInstance.f(companion4, companion3.e()), RoundedCornerShapeKt.g());
            boolean z2 = (i4 & 896) == 256;
            Object objG3 = composerK.G();
            if (z2 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: y1.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeConfirmationScreenKt.v(function03);
                    }
                };
                composerK.w(objG3);
            }
            float f8 = 10;
            IconCircleBackgroundKt.c(ClickableKt.f(modifierA, false, null, null, (Function0) objG3, 7, null), Dp.g(f7), Dp.g(f8), VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composerK, 6), ComposeColorsKt.j(composerK, 0).O(), ComposeColorsKt.j(composerK, 0).e0(), null, composerK, 432, 64);
            Composer composer4 = composerK;
            composer4.y();
            composer4.y();
            StrictModeAccessMethod strictModeAccessMethodA = strictModeConfirmationViewState.a();
            if (strictModeAccessMethodA == null) {
                composer4.a0(964693915);
                composer4.U();
                companion = companion4;
                obj = null;
                f3 = 0.0f;
                i5 = 2;
            } else {
                composer4.a0(964693916);
                A(strictModeAccessMethodA, PaddingKt.m(companion4, 0.0f, Dp.g(4), 0.0f, 0.0f, 13, null), composer4, 48, 0);
                f3 = 0.0f;
                obj = null;
                TextKt.c(StringResources_androidKt.b(R.string.RB, composer4, 0), PaddingKt.m(SizeKt.h(companion4, 0.0f, 1, null), 0.0f, Dp.g(20), 0.0f, 0.0f, 13, null), ComposeColorsKt.j(composer4, 0).L(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer4, 0).f(), composer4, 48, 0, 65016);
                composer4 = composer4;
                companion = companion4;
                i5 = 2;
                y(strictModeConfirmationViewState, PaddingKt.k(PaddingKt.m(companion, 0.0f, Dp.g(f8), 0.0f, 0.0f, 13, null), Dp.g(f6), 0.0f, 2, null), composer4, (i4 & 14) | 48, 0);
                if (strictModeConfirmationViewState.d().f(Product.STRICT_MODE)) {
                    composer4.a0(-3506413);
                } else {
                    composer4.a0(4444870);
                    boolean zI2 = composer4.I(context);
                    Object objG4 = composer4.G();
                    if (zI2 || objG4 == Composer.f23746a.a()) {
                        objG4 = new Function0() { // from class: y1.l
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return StrictModeConfirmationScreenKt.w(context);
                            }
                        };
                        composer4.w(objG4);
                    }
                    C((Function0) objG4, PaddingKt.m(companion, 0.0f, Dp.g(f5), 0.0f, 0.0f, 13, null), composer4, 48, 0);
                }
                composer4.U();
                Unit unit = Unit.f139807a;
                composer4.U();
            }
            if (list.isEmpty()) {
                composer3 = composer4;
                companion2 = companion;
                i6 = 6;
                f4 = f3;
                composer3.a0(957543797);
            } else {
                composer4.a0(966271630);
                companion2 = companion;
                Composer composer5 = composer4;
                f4 = f3;
                i6 = 6;
                E(list, pagerStateL, PaddingKt.m(companion, 0.0f, Dp.g(f5), 0.0f, 0.0f, 13, null), composer5, 384, 0);
                composer3 = composer5;
            }
            composer3.U();
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f5)), composer3, i6);
            function04 = function0;
            ComposeButtonsKt.i0(PaddingKt.k(companion2, Dp.g(f6), f4, i5, obj), new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.vH, composer3, 0), 0.0f, 11, null), new ButtonColor.Accent(false, null, false, null, 15, null), function04, composer3, ((i4 << i6) & 7168) | 6, 0);
            composer2 = composer3;
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            function03 = function02;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: y1.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return StrictModeConfirmationScreenKt.x(strictModeConfirmationViewState, function04, function03, i3, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int u(List list) {
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Context context) {
        AnswersHelper.f128199a.g7();
        context.startActivity(Paywall.c(Paywall.f113165a, context, new PaywallTarget.LimitScreen(PremiumFeature.STRICT_MODE_TIMER), "strict_mode_activating", "unlimited_strict_mode", false, false, false, null, 240, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(StrictModeConfirmationViewState strictModeConfirmationViewState, Function0 function0, Function0 function02, int i3, Composer composer, int i4) {
        t(strictModeConfirmationViewState, function0, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void y(final cz.mobilesoft.coreblock.scene.strictmode3.confirmation.StrictModeConfirmationViewState r38, androidx.compose.ui.Modifier r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instruction units count: 619
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.confirmation.StrictModeConfirmationScreenKt.y(cz.mobilesoft.coreblock.scene.strictmode3.confirmation.StrictModeConfirmationViewState, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(StrictModeConfirmationViewState strictModeConfirmationViewState, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        y(strictModeConfirmationViewState, modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
