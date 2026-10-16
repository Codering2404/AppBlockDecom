package cz.mobilesoft.coreblock.scene.feedback.backdoorcode.reasonpicker;

import android.content.Context;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.navigation.NavController;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.feedback.backdoorcode.BackdoorScreenHeadingKt;
import cz.mobilesoft.coreblock.scene.feedback.backdoorcode.NavBackdoorFeedback;
import cz.mobilesoft.coreblock.scene.feedback.backdoorcode.NavBackdoorThankYou;
import cz.mobilesoft.coreblock.scene.feedback.backdoorcode.reasonpicker.BackdoorReasonPickerScreenKt;
import cz.mobilesoft.coreblock.scene.feedback.backdoorcode.thankyou.BackdoorThankYouScreenKt;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsV2Kt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class BackdoorReasonPickerScreenKt {
    public static final void h(final NavController navController, final Function0 onFinish, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(navController, "navController");
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        Composer composerK = composer.k(1226925189);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(navController) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1226925189, i4, -1, "cz.mobilesoft.coreblock.scene.feedback.backdoorcode.reasonpicker.BackdoorReasonPicker (BackdoorReasonPickerScreen.kt:50)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierK = PaddingKt.k(SizeKt.f(companion, 0.0f, 1, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierK);
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
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Alignment.Horizontal horizontalG = companion2.g();
            Modifier modifierG = ScrollKt.g(boxScopeInstance.f(companion, companion2.m()), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composerK, 48);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierG);
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
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            composer2 = composerK;
            ImageKt.a(PainterResources_androidKt.c(R.drawable.w2, composerK, 0), null, PaddingKt.k(ColumnScopeInstance.f6666a.c(companion, companion2.g()), 0.0f, Dp.g(48), 1, null), null, null, 0.0f, null, composer2, 48, 120);
            BackdoorScreenHeadingKt.b(StringResources_androidKt.b(R.string.kd, composer2, 0), StringResources_androidKt.b(R.string.jd, composer2, 0), 0.0f, composer2, 0, 4);
            SpacerKt.a(SizeKt.i(companion, Dp.g(24)), composer2, 6);
            j(null, navController, composer2, (i4 << 3) & 112, 1);
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
            scopeUpdateScopeN.a(new Function2() { // from class: y0.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BackdoorReasonPickerScreenKt.i(navController, onFinish, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(NavController navController, Function0 function0, int i3, Composer composer, int i4) {
        h(navController, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void j(Modifier modifier, final NavController navController, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        Composer composerK = composer.k(2088721968);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(navController) ? 32 : 16;
        }
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            modifier3 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(2088721968, i5, -1, "cz.mobilesoft.coreblock.scene.feedback.backdoorcode.reasonpicker.PickerButtons (BackdoorReasonPickerScreen.kt:88)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Modifier modifierF = SizeKt.f(modifier3, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = Arrangement.f6574a.o(Dp.g(16));
            Alignment.Companion companion = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalO, companion.k(), composerK, 6);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.Zc, composerK, 0), 0.0f, 11, null);
            ButtonColor.Surface surface = new ButtonColor.Surface(false, null, false, null, null, 31, null);
            boolean zI = composerK.I(navController);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: y0.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BackdoorReasonPickerScreenKt.k(navController);
                    }
                };
                composerK.w(objG);
            }
            ComposeButtonsKt.i0(null, big, surface, (Function0) objG, composerK, 0, 1);
            ButtonType.Big big2 = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.Yc, composerK, 0), 0.0f, 11, null);
            ButtonColor.Surface surface2 = new ButtonColor.Surface(false, null, false, null, null, 31, null);
            boolean zI2 = composerK.I(navController);
            Object objG2 = composerK.G();
            if (zI2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: y0.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BackdoorReasonPickerScreenKt.l(navController);
                    }
                };
                composerK.w(objG2);
            }
            ComposeButtonsKt.i0(null, big2, surface2, (Function0) objG2, composerK, 0, 1);
            ButtonType.Big big3 = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.ad, composerK, 0), 0.0f, 11, null);
            ButtonColor.Surface surface3 = new ButtonColor.Surface(false, null, false, null, null, 31, null);
            boolean zI3 = composerK.I(navController);
            Object objG3 = composerK.G();
            if (zI3 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: y0.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BackdoorReasonPickerScreenKt.m(navController);
                    }
                };
                composerK.w(objG3);
            }
            ComposeButtonsKt.i0(null, big3, surface3, (Function0) objG3, composerK, 0, 1);
            ButtonType.Big big4 = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.bd, composerK, 0), 0.0f, 11, null);
            ButtonColor.Surface surface4 = new ButtonColor.Surface(false, null, false, null, null, 31, null);
            boolean zI4 = composerK.I(navController);
            Object objG4 = composerK.G();
            if (zI4 || objG4 == Composer.f23746a.a()) {
                objG4 = new Function0() { // from class: y0.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BackdoorReasonPickerScreenKt.n(navController);
                    }
                };
                composerK.w(objG4);
            }
            ComposeButtonsKt.i0(null, big4, surface4, (Function0) objG4, composerK, 0, 1);
            Modifier modifierC = columnScopeInstance.c(Modifier.b8, companion.g());
            String strB = StringResources_androidKt.b(R.string.cp, composerK, 0);
            boolean zI5 = composerK.I(context);
            Object objG5 = composerK.G();
            if (zI5 || objG5 == Composer.f23746a.a()) {
                objG5 = new Function0() { // from class: y0.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BackdoorReasonPickerScreenKt.o(context);
                    }
                };
                composerK.w(objG5);
            }
            ComposeButtonsV2Kt.d(modifierC, strB, (Function0) objG5, composerK, 0, 0);
            composerK = composerK;
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: y0.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BackdoorReasonPickerScreenKt.p(modifier3, navController, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(NavController navController) {
        AnswersHelper.f128199a.n7(BackdoorReason.NO_SELF_CONTROL, false);
        NavController.O(navController, NavBackdoorThankYou.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(NavController navController) {
        NavController.O(navController, new NavBackdoorFeedback(BackdoorReason.BLOCKING_WHAT_IT_SHOULDNT), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(NavController navController) {
        NavController.O(navController, new NavBackdoorFeedback(BackdoorReason.DIDNT_MEET_EXPECTATIONS), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(NavController navController) {
        AnswersHelper.f128199a.n7(BackdoorReason.URGENT_ACCESS_TO_APP, false);
        NavController.O(navController, NavBackdoorThankYou.INSTANCE, null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Context context) {
        BackdoorThankYouScreenKt.f(context);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Modifier modifier, NavController navController, int i3, int i4, Composer composer, int i5) {
        j(modifier, navController, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
