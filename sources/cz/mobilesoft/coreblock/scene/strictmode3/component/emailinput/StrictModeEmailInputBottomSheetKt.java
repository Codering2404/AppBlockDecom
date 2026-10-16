package cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.material3.SheetState;
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
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.StrictModeEmailInputBottomSheetViewEvent;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeBottomSheetsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeTextFieldsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
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
public final class StrictModeEmailInputBottomSheetKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Function1 function1, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        function1.invoke(StrictModeEmailInputBottomSheetViewEvent.OnEmailSet.f121863a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(MutableState mutableState, FocusState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        y(mutableState, it.a());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(Function1 function1, TextFieldValue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new StrictModeEmailInputBottomSheetViewEvent.OnEmailChanged(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(boolean z2, Composer composer, int i3) {
        long jM;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1001548181, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.StrictModeSetEmailBottomSheet.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StrictModeEmailInputBottomSheet.kt:156)");
            }
            Painter painterC = PainterResources_androidKt.c(R.drawable.G3, composer, 0);
            if (z2) {
                composer.a0(-15651848);
                jM = ComposeColorsKt.j(composer, 0).b();
                composer.U();
            } else {
                composer.a0(-15529646);
                jM = ComposeColorsKt.j(composer, 0).M();
                composer.U();
            }
            IconKt.a(painterC, "", null, jM, composer, 48, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(Function1 function1) {
        function1.invoke(StrictModeEmailInputBottomSheetViewEvent.OnEmailSet.f121863a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(TextFieldValue textFieldValue, Function1 function1, Function0 function0, boolean z2, int i3, Composer composer, int i4) {
        x(textFieldValue, function1, function0, z2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(final TextFieldValue textFieldValue, final Function1 function1, Function0 function0, Composer composer, final int i3) {
        int i4;
        final Function0 function02;
        Composer composerK = composer.k(285122095);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(textFieldValue) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function0) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(285122095, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.StrictModeApproveEmailBottomSheet (StrictModeEmailInputBottomSheet.kt:211)");
            }
            function02 = function0;
            ComposeBottomSheetsKt.f(null, null, false, ComposableLambdaKt.e(-1966820178, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.h
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return StrictModeEmailInputBottomSheetKt.p(textFieldValue, function1, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerK, 54), null, function02, composerK, ((i4 << 9) & 458752) | 3072, 23);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function02 = function0;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeEmailInputBottomSheetKt.s(textFieldValue, function1, function02, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(final TextFieldValue textFieldValue, final Function1 function1, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1966820178, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.StrictModeApproveEmailBottomSheet.<anonymous> (StrictModeEmailInputBottomSheet.kt:215)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierJ = PaddingKt.j(BackgroundKt.d(SizeKt.h(companion, 0.0f, 1, null), ComposeColorsKt.j(composer, 0).X(), null, 2, null), Dp.g(f3), Dp.g(32));
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierJ);
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
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.k(), composer, 0);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierH);
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
            String strB = StringResources_androidKt.b(R.string.Lx, composer, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composer, 0).f();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strB, PaddingKt.m(columnScopeInstance.c(companion, companion2.g()), 0.0f, 0.0f, 0.0f, Dp.g(f3), 7, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleF, composer, 0, 0, 65020);
            TextKt.c(textFieldValue.i(), PaddingKt.k(columnScopeInstance.c(companion, companion2.g()), 0.0f, Dp.g(8), 1, null), ComposeColorsKt.j(composer, 0).b(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65016);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.Qz, composer, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(true, null, false, null, 14, null);
            boolean Z = composer.Z(function1) | composer.Z(textFieldValue);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeEmailInputBottomSheetKt.q(function1, textFieldValue);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.i0(null, big, accent, (Function0) objG, composer, 0, 1);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            ButtonType.Big big2 = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.Mx, composer, 0), 0.0f, 11, null);
            ButtonColor.Light light = new ButtonColor.Light(false, null, false, null, null, 31, null);
            boolean Z2 = composer.Z(function1);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeEmailInputBottomSheetKt.r(function1);
                    }
                };
                composer.w(objG2);
            }
            ComposeButtonsKt.i0(null, big2, light, (Function0) objG2, composer, 0, 1);
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
    public static final Unit q(Function1 function1, TextFieldValue textFieldValue) {
        function1.invoke(new StrictModeEmailInputBottomSheetViewEvent.OnEmailDoubleChecked(textFieldValue.i()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(Function1 function1) {
        function1.invoke(StrictModeEmailInputBottomSheetViewEvent.OnDismiss.f121860a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(TextFieldValue textFieldValue, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        o(textFieldValue, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void t(final kotlin.jvm.functions.Function1 r23, final kotlin.jvm.functions.Function0 r24, java.lang.String r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 526
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.StrictModeEmailInputBottomSheetKt.t(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Function1 function1, Function0 function0) {
        function1.invoke(StrictModeEmailInputBottomSheetViewEvent.OnDismiss.f121860a);
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Function1 function1, Function0 function0) {
        function1.invoke(StrictModeEmailInputBottomSheetViewEvent.OnDismiss.f121860a);
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Function1 function1, Function0 function0, String str, int i3, int i4, Composer composer, int i5) {
        t(function1, function0, str, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(final TextFieldValue textFieldValue, final Function1 function1, Function0 function0, final boolean z2, Composer composer, final int i3) {
        int i4;
        Function0 function02;
        Composer composerK = composer.k(-1828786346);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(textFieldValue) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function0) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.b(z2) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1828786346, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.StrictModeSetEmailBottomSheet (StrictModeEmailInputBottomSheet.kt:102)");
            }
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            function02 = function0;
            ComposeBottomSheetsKt.f(null, null, true, ComposableLambdaKt.e(-154685867, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.n
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return StrictModeEmailInputBottomSheetKt.z(z2, function1, textFieldValue, mutableState, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerK, 54), null, function02, composerK, ((i4 << 9) & 458752) | 3456, 19);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function02 = function0;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final Function0 function03 = function02;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeEmailInputBottomSheetKt.F(textFieldValue, function1, function03, z2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void y(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(final boolean z2, final Function1 function1, TextFieldValue textFieldValue, final MutableState mutableState, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if (composer.r((i3 & 129) != 128, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-154685867, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.StrictModeSetEmailBottomSheet.<anonymous> (StrictModeEmailInputBottomSheet.kt:109)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            float f4 = 32;
            Modifier modifierL = PaddingKt.l(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), Dp.g(24), Dp.g(f3), Dp.g(f4));
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierL);
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
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion2.k(), composer, 0);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierH);
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
            String strB = StringResources_androidKt.b(R.string.Px, composer, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composer, 0).f();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strB, PaddingKt.m(columnScopeInstance.c(companion, companion2.g()), 0.0f, 0.0f, 0.0f, Dp.g(f3), 7, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleF, composer, 0, 0, 65020);
            TextKt.c(StringResources_androidKt.b(R.string.Ox, composer, 0), PaddingKt.m(columnScopeInstance.c(companion, companion2.g()), 0.0f, 0.0f, 0.0f, Dp.g(f4), 7, null), ComposeColorsKt.j(composer, 0).P(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65016);
            Modifier modifierF3 = BorderKt.f(SizeKt.h(companion, 0.0f, 1, null), Dp.g(1), Color.f25715b.j(), RoundedCornerShapeKt.d(Dp.g(f3)));
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer, modifierF3);
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
            Updater.e(composerA3, measurePolicyG2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF4, companion3.f());
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, null, KeyboardType.f29379b.c(), 0, null, null, null, 123, null);
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.s
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictModeEmailInputBottomSheetKt.A(function1, (KeyboardActionScope) obj);
                    }
                };
                composer.w(objG);
            }
            KeyboardActions keyboardActions = new KeyboardActions((Function1) objG, null, null, null, null, null, 62, null);
            TextStyle textStyleA = ComposeTypographyKt.g(composer, 0).a();
            PaddingValues paddingValuesC = PaddingKt.c(Dp.g(12), 0.0f, 2, null);
            Modifier modifierC = BackgroundKt.c(SizeKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(56)), ComposeColorsKt.j(composer, 0).N(), RoundedCornerShapeKt.d(Dp.g(f3)));
            Object objG2 = composer.G();
            Composer.Companion companion5 = Composer.f23746a;
            if (objG2 == companion5.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.t
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictModeEmailInputBottomSheetKt.B(mutableState, (FocusState) obj);
                    }
                };
                composer.w(objG2);
            }
            Modifier modifierA = FocusChangedModifierKt.a(modifierC, (Function1) objG2);
            boolean Z2 = composer.Z(function1);
            Object objG3 = composer.G();
            if (Z2 || objG3 == companion5.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.u
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictModeEmailInputBottomSheetKt.C(function1, (TextFieldValue) obj);
                    }
                };
                composer.w(objG3);
            }
            ComposeTextFieldsKt.g(textFieldValue, (Function1) objG3, modifierA, false, false, false, textStyleA, null, ComposableSingletons$StrictModeEmailInputBottomSheetKt.f121847a.h(), ComposableLambdaKt.e(1001548181, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeEmailInputBottomSheetKt.D(z2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, false, null, keyboardOptions, keyboardActions, true, 0, null, null, paddingValuesC, null, 0.0f, 0.0f, composer, 906166272, 805506048, 0, 7806104);
            composer.y();
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.Lt, composer, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(z2, null, false, null, 14, null);
            boolean Z3 = composer.Z(function1);
            Object objG4 = composer.G();
            if (Z3 || objG4 == companion5.a()) {
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StrictModeEmailInputBottomSheetKt.E(function1);
                    }
                };
                composer.w(objG4);
            }
            ComposeButtonsKt.i0(null, big, accent, (Function0) objG4, composer, 0, 1);
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
}
