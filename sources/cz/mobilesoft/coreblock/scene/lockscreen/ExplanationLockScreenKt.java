package cz.mobilesoft.coreblock.scene.lockscreen;

import android.content.Context;
import android.text.Spanned;
import android.text.style.StyleSpan;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.AndroidMenu_androidKt;
import androidx.compose.material.ButtonColors;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.IconButtonKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.compose.ConstrainedLayoutReference;
import androidx.constraintlayout.compose.ConstraintLayoutScope;
import androidx.constraintlayout.compose.ConstraintSetForInlineDsl;
import androidx.constraintlayout.compose.Measurer;
import androidx.constraintlayout.compose.ToolingUtilsKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.ContactReason;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewEvent;
import cz.mobilesoft.coreblock.scene.strictmode3.component.StrictModeBallKt;
import cz.mobilesoft.coreblock.scene.strictmode3.component.StrictModeGlowColor;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCountDownKt;
import cz.mobilesoft.coreblock.view.compose.LockScreensComponentsKt;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class ExplanationLockScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(MutableState mutableState) {
        y(mutableState, !v(mutableState));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(MutableState mutableState) {
        y(mutableState, false);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(final LockViewState lockViewState, final Function1 function1, ColumnScope DropdownMenu, Composer composer, int i3) {
        Composer composer2;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1102045265, i3, -1, "cz.mobilesoft.coreblock.scene.lockscreen.ExplanationLockScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ExplanationLockScreen.kt:241)");
            }
            if (lockViewState.y()) {
                composer.a0(-300307249);
                boolean zL = lockViewState.l();
                boolean Z = composer.Z(function1);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.z
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExplanationLockScreenKt.D(function1);
                        }
                    };
                    composer.w(objG);
                }
                composer2 = composer;
                AndroidMenu_androidKt.c((Function0) objG, null, zL, null, null, ComposableLambdaKt.e(1715042759, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.a0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ExplanationLockScreenKt.E(lockViewState, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer2, 196608, 26);
            } else {
                composer2 = composer;
                composer2.a0(-313227181);
            }
            composer2.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(Function1 function1) {
        AnswersHelper.f128199a.F2();
        function1.invoke(new LockViewEvent.LockScreenContactSupportClickEvent(ContactReason.Other, false, 2, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(LockViewState lockViewState, RowScope DropdownMenuItem, Composer composer, int i3) {
        long jM;
        Intrinsics.checkNotNullParameter(DropdownMenuItem, "$this$DropdownMenuItem");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1715042759, i3, -1, "cz.mobilesoft.coreblock.scene.lockscreen.ExplanationLockScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ExplanationLockScreen.kt:249)");
            }
            String strB = StringResources_androidKt.b(R.string.i8, composer, 0);
            if (lockViewState.l()) {
                composer.a0(-1111340981);
                jM = ComposeColorsKt.j(composer, 0).L();
            } else {
                composer.a0(-1111340429);
                jM = ComposeColorsKt.j(composer, 0).M();
            }
            composer.U();
            TextKt.c(strB, null, jM, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 131066);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(Function1 function1) {
        function1.invoke(LockViewEvent.LockScreenBlockedAppIconClickEvent.f105465a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(Function1 function1) {
        function1.invoke(LockViewEvent.LockScreenBlockedAppIconClickEvent.f105465a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(Function1 function1) {
        function1.invoke(LockViewEvent.LockScreenBlockedAppIconClickEvent.f105465a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(LockViewState lockViewState, Function1 function1, boolean z2, boolean z3, boolean z4, int i3, int i4, Composer composer, int i5) {
        q(lockViewState, function1, z2, z3, z4, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void q(final cz.mobilesoft.coreblock.scene.lockscreen.LockViewState r36, final kotlin.jvm.functions.Function1 r37, final boolean r38, boolean r39, boolean r40, androidx.compose.runtime.Composer r41, final int r42, final int r43) {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.lockscreen.ExplanationLockScreenKt.q(cz.mobilesoft.coreblock.scene.lockscreen.LockViewState, kotlin.jvm.functions.Function1, boolean, boolean, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(boolean z2, final boolean z3, LockViewState lockViewState, final boolean z4, final Function1 function1, Composer composer, int i3) {
        Object obj;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1672711282, i3, -1, "cz.mobilesoft.coreblock.scene.lockscreen.ExplanationLockScreen.<anonymous> (ExplanationLockScreen.kt:94)");
            }
            Alignment.Horizontal horizontalG = Alignment.f25072a.g();
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            if (z2 || (!z3 && (lockViewState.D() || !z4))) {
                composer.a0(1892313197);
                float f3 = (float) 0.5d;
                BoxKt.a(BorderKt.g(SizeKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3)), Dp.g(f3), Color.r(ComposeColorsKt.j(composer, 0).q0(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), null, 4, null), composer, 0);
                boolean zB = composer.b(z3) | composer.Z(function1) | composer.b(z4);
                Object objG = composer.G();
                if (zB || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.d0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExplanationLockScreenKt.s(z3, function1, z4);
                        }
                    };
                    composer.w(objG);
                }
                obj = null;
                ButtonKt.c((Function0) objG, PaddingKt.k(companion, 0.0f, Dp.g(16), 1, null), false, null, null, null, null, null, null, ComposableLambdaKt.e(1450921408, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.e0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return ExplanationLockScreenKt.t(z3, z4, (RowScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer, 54), composer, 805306416, 508);
                composer.U();
            } else {
                composer.a0(1887527386);
                composer.U();
                obj = null;
            }
            if (!lockViewState.u() || lockViewState.c() == null) {
                composer.a0(1887527386);
            } else {
                composer.a0(1894903774);
                LockScreensComponentsKt.f(SizeKt.k(SizeKt.h(companion, 0.0f, 1, obj), Dp.g(60), 0.0f, 2, obj), lockViewState.c(), composer, 6);
            }
            composer.U();
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
    public static final Unit s(boolean z2, Function1 function1, boolean z3) {
        if (z2) {
            function1.invoke(new LockViewEvent.LockScreenPopupCloseEvent(true));
        } else if (z3) {
            function1.invoke(LockViewEvent.LockScreenAvailableSettingsClickEvent.f105463a);
        } else {
            function1.invoke(LockViewEvent.LockScreenAllowThisAppClickEvent.f105462a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(boolean z2, boolean z3, RowScope TextButton, Composer composer, int i3) throws XmlPullParserException, IOException {
        ImageVector imageVectorB;
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1450921408, i3, -1, "cz.mobilesoft.coreblock.scene.lockscreen.ExplanationLockScreen.<anonymous>.<anonymous>.<anonymous> (ExplanationLockScreen.kt:118)");
            }
            if (z2) {
                composer.a0(-1528893037);
                imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.h5, composer, 6);
                composer.U();
            } else if (z3) {
                composer.a0(-1528885741);
                imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.h5, composer, 6);
                composer.U();
            } else {
                composer.a0(-1528889170);
                imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.A5, composer, 6);
                composer.U();
            }
            long jQ0 = ComposeColorsKt.j(composer, 0).q0();
            Modifier.Companion companion = Modifier.b8;
            IconKt.b(imageVectorB, "Av. settings", SizeKt.v(companion, Dp.g(24)), jQ0, composer, 432, 0);
            SpacerKt.a(SizeKt.v(companion, Dp.g(4)), composer, 6);
            TextKt.c(StringResources_androidKt.b(z2 ? R.string.qj : !z3 ? R.string.f95861y0 : R.string.f95837q2, composer, 0), null, ComposeColorsKt.j(composer, 0).q0(), 0L, null, FontWeight.f29233b.b(), null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composer, MaterialTheme.f13092b).j(), composer, 196608, 0, 65498);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(ScrollState scrollState, final LockViewState lockViewState, boolean z2, final Function1 function1, final boolean z3, Context context, boolean z4, PaddingValues it, Composer composer, int i3) {
        int i4;
        Composer composer2;
        int i5;
        int i6;
        Composer composer3;
        int i7;
        Composer composer4;
        int i8;
        int i9;
        float f3;
        final ConstraintSetForInlineDsl constraintSetForInlineDsl;
        final MutableState mutableState;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(it) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1134086250, i4, -1, "cz.mobilesoft.coreblock.scene.lockscreen.ExplanationLockScreen.<anonymous> (ExplanationLockScreen.kt:157)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = PaddingKt.h(BackgroundKt.d(SizeKt.f(companion, 0.0f, 1, null), ComposeColorsKt.j(composer, 0).H(), null, 2, null), it);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.m(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
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
            Modifier modifierF2 = SizeKt.f(WindowInsetsPaddingKt.d(companion, WindowInsets_androidKt.c(WindowInsets.f7172a, composer, 6)), 0.0f, 1, null);
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), companion2.k(), composer, 0);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierF2);
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
            Updater.e(composerA2, modifierF3, companion3.f());
            Modifier modifierB = ColumnScope.b(ColumnScopeInstance.f6666a, SizeKt.f(ScrollKt.g(companion, scrollState, false, null, false, 14, null), 0.0f, 1, null), 1.0f, false, 2, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion2.g(), composer, 48);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer, modifierB);
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
            Updater.e(composerA3, modifierF4, companion3.f());
            Object objG = composer.G();
            Composer.Companion companion4 = Composer.f23746a;
            if (objG == companion4.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composer.w(objG);
            }
            final MutableState mutableState2 = (MutableState) objG;
            Color.Companion companion5 = Color.f25715b;
            Modifier modifierM = PaddingKt.m(SizeKt.h(BackgroundKt.d(companion, companion5.j(), null, 2, null), 0.0f, 1, null), 0.0f, Dp.g(32), 0.0f, 0.0f, 13, null);
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
            int iA4 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU4 = composer.u();
            Modifier modifierF5 = ComposedModifierKt.f(composer, modifierM);
            Function0 function0A4 = companion3.a();
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
            Updater.e(composerA4, measurePolicyG2, companion3.e());
            Updater.e(composerA4, compositionLocalMapU4, companion3.g());
            Function2 function2B4 = companion3.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF5, companion3.f());
            Modifier modifierF6 = boxScopeInstance.f(companion, companion2.e());
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.b(), companion2.i(), composer, 54);
            int iA5 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU5 = composer.u();
            Modifier modifierF7 = ComposedModifierKt.f(composer, modifierF6);
            Function0 function0A5 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A5);
            } else {
                composer.v();
            }
            Composer composerA5 = Updater.a(composer);
            Updater.e(composerA5, measurePolicyB, companion3.e());
            Updater.e(composerA5, compositionLocalMapU5, companion3.g());
            Function2 function2B5 = companion3.b();
            if (composerA5.i() || !Intrinsics.areEqual(composerA5.G(), Integer.valueOf(iA5))) {
                composerA5.w(Integer.valueOf(iA5));
                composerA5.p(Integer.valueOf(iA5), function2B5);
            }
            Updater.e(composerA5, modifierF7, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            float f4 = 24;
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.A0, composer, 6), StringResources_androidKt.b(R.string.Yf, composer, 0), SizeKt.v(companion, Dp.g(f4)), ComposeColorsKt.j(composer, 0).b(), composer, 384, 0);
            Modifier.Companion companion6 = companion;
            TextKt.c(StringResources_androidKt.b(R.string.f95790f1, composer, 0), PaddingKt.m(companion, Dp.g(8), 0.0f, 0.0f, 0.0f, 14, null), ComposeColorsKt.j(composer, 0).b(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 48, 0, 65528);
            composer.y();
            Modifier modifierH2 = SizeKt.h(companion6, 0.0f, 1, null);
            MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.g(), companion2.l(), composer, 0);
            int iA6 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU6 = composer.u();
            Modifier modifierF8 = ComposedModifierKt.f(composer, modifierH2);
            Function0 function0A6 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A6);
            } else {
                composer.v();
            }
            Composer composerA6 = Updater.a(composer);
            Updater.e(composerA6, measurePolicyB2, companion3.e());
            Updater.e(composerA6, compositionLocalMapU6, companion3.g());
            Function2 function2B6 = companion3.b();
            if (composerA6.i() || !Intrinsics.areEqual(composerA6.G(), Integer.valueOf(iA6))) {
                composerA6.w(Integer.valueOf(iA6));
                composerA6.p(Integer.valueOf(iA6), function2B6);
            }
            Updater.e(composerA6, modifierF8, companion3.f());
            boolean zL = lockViewState.l();
            boolean zB = composer.b(z3) | composer.Z(function1);
            Object objG2 = composer.G();
            if (zB || objG2 == companion4.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.f0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ExplanationLockScreenKt.z(z3, function1);
                    }
                };
                composer.w(objG2);
            }
            ComposableSingletons$ExplanationLockScreenKt composableSingletons$ExplanationLockScreenKt = ComposableSingletons$ExplanationLockScreenKt.f105322a;
            IconButtonKt.a((Function0) objG2, null, zL, null, composableSingletons$ExplanationLockScreenKt.k(), composer, 24576, 10);
            if (lockViewState.B()) {
                composer.a0(1890888873);
                SpacerKt.a(RowScope.c(rowScopeInstance, companion6, 1.0f, false, 2, null), composer, 0);
                Object objG3 = composer.G();
                if (objG3 == companion4.a()) {
                    objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.g0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExplanationLockScreenKt.A(mutableState2);
                        }
                    };
                    composer.w(objG3);
                }
                companion6 = companion6;
                IconButtonKt.a((Function0) objG3, null, false, null, composableSingletons$ExplanationLockScreenKt.l(), composer, 24582, 14);
                MeasurePolicy measurePolicyB3 = RowKt.b(arrangement.c(), companion2.l(), composer, 6);
                int iA7 = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU7 = composer.u();
                Modifier modifierF9 = ComposedModifierKt.f(composer, companion6);
                Function0 function0A7 = companion3.a();
                if (composer.m() == null) {
                    ComposablesKt.c();
                }
                composer.L();
                if (composer.i()) {
                    composer.P(function0A7);
                } else {
                    composer.v();
                }
                Composer composerA7 = Updater.a(composer);
                Updater.e(composerA7, measurePolicyB3, companion3.e());
                Updater.e(composerA7, compositionLocalMapU7, companion3.g());
                Function2 function2B7 = companion3.b();
                if (composerA7.i() || !Intrinsics.areEqual(composerA7.G(), Integer.valueOf(iA7))) {
                    composerA7.w(Integer.valueOf(iA7));
                    composerA7.p(Integer.valueOf(iA7), function2B7);
                }
                Updater.e(composerA7, modifierF9, companion3.f());
                boolean zV = v(mutableState2);
                Object objG4 = composer.G();
                if (objG4 == companion4.a()) {
                    objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.h0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExplanationLockScreenKt.B(mutableState2);
                        }
                    };
                    composer.w(objG4);
                }
                i6 = 54;
                i5 = 6;
                AndroidMenu_androidKt.a(zV, (Function0) objG4, null, 0L, null, null, ComposableLambdaKt.e(-1102045265, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.i0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return ExplanationLockScreenKt.C(lockViewState, function1, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, 1572912, 60);
                composer2 = composer;
                composer2.y();
            } else {
                composer2 = composer;
                i5 = 6;
                i6 = 54;
                composer2.a0(1879232005);
            }
            composer2.U();
            composer2.y();
            composer2.y();
            SpacerKt.a(SizeKt.v(companion6, Dp.g(f4)), composer2, i5);
            if (z2) {
                composer2.a0(-183689827);
                StrictModeGlowColor strictModeGlowColor = StrictModeGlowColor.Purple;
                int i10 = R.drawable.U5;
                float fG = Dp.g(40);
                long jQ0 = ComposeColorsKt.j(composer2, 0).q0();
                Object objG5 = composer2.G();
                if (objG5 == companion4.a()) {
                    objG5 = InteractionSourceKt.a();
                    composer2.w(objG5);
                }
                MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objG5;
                boolean Z = composer2.Z(function1);
                Object objG6 = composer2.G();
                if (Z || objG6 == companion4.a()) {
                    objG6 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.j0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExplanationLockScreenKt.F(function1);
                        }
                    };
                    composer2.w(objG6);
                }
                StrictModeBallKt.q(ClickableKt.d(companion6, mutableInteractionSource, null, false, null, null, (Function0) objG6, 28, null), strictModeGlowColor, i10, fG, Color.n(jQ0), false, null, composer, 3120, 96);
                composer3 = composer;
                composer3.U();
            } else if (z3) {
                composer2.a0(-182628821);
                Painter painterC = PainterResources_androidKt.c(R.drawable.z3, composer2, 0);
                Modifier modifierV = SizeKt.v(companion6, Dp.g(140));
                boolean Z2 = composer2.Z(function1);
                Object objG7 = composer2.G();
                if (Z2 || objG7 == companion4.a()) {
                    objG7 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.v
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExplanationLockScreenKt.G(function1);
                        }
                    };
                    composer2.w(objG7);
                }
                ImageKt.a(painterC, null, ClickableKt.f(modifierV, false, null, null, (Function0) objG7, 7, null), null, null, 0.0f, null, composer, 48, 120);
                composer3 = composer;
                composer3.U();
            } else {
                composer2.a0(-181876668);
                Modifier modifierA = ClipKt.a(SizeKt.v(BorderKt.f(BackgroundKt.c(companion6, companion5.j(), RoundedCornerShapeKt.g()), Dp.g(2), ComposeColorsKt.j(composer2, 0).b(), RoundedCornerShapeKt.g()), Dp.g(140)), RoundedCornerShapeKt.g());
                boolean Z3 = composer2.Z(function1);
                Object objG8 = composer2.G();
                if (Z3 || objG8 == companion4.a()) {
                    objG8 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.w
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExplanationLockScreenKt.H(function1);
                        }
                    };
                    composer2.w(objG8);
                }
                Modifier modifierF10 = ClickableKt.f(modifierA, false, null, null, (Function0) objG8, 7, null);
                MeasurePolicy measurePolicyG3 = BoxKt.g(companion2.o(), false);
                int iA8 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU8 = composer2.u();
                Modifier modifierF11 = ComposedModifierKt.f(composer2, modifierF10);
                Function0 function0A8 = companion3.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A8);
                } else {
                    composer2.v();
                }
                Composer composerA8 = Updater.a(composer2);
                Updater.e(composerA8, measurePolicyG3, companion3.e());
                Updater.e(composerA8, compositionLocalMapU8, companion3.g());
                Function2 function2B8 = companion3.b();
                if (composerA8.i() || !Intrinsics.areEqual(composerA8.G(), Integer.valueOf(iA8))) {
                    composerA8.w(Integer.valueOf(iA8));
                    composerA8.p(Integer.valueOf(iA8), function2B8);
                }
                Updater.e(composerA8, modifierF11, companion3.f());
                ImageKt.a(PainterResources_androidKt.c(R.drawable.U6, composer2, 0), null, boxScopeInstance.f(SizeKt.v(companion6, Dp.g(40)), companion2.e()), null, null, 0.0f, null, composer, 48, 120);
                composer3 = composer;
                composer3.y();
                composer3.U();
            }
            float f5 = 16;
            SpacerKt.a(SizeKt.v(companion6, Dp.g(f5)), composer3, i5);
            String strK = lockViewState.k();
            if (strK == null) {
                composer3.a0(-698557143);
                i7 = 0;
                strK = StringResources_androidKt.b(R.string.ul, composer3, 0);
            } else {
                i7 = 0;
                composer3.a0(-698558135);
            }
            composer3.U();
            long jQ02 = ComposeColorsKt.j(composer3, i7).q0();
            MaterialTheme materialTheme = MaterialTheme.f13091a;
            int i11 = MaterialTheme.f13092b;
            TextStyle textStyleE = materialTheme.c(composer3, i11).e();
            TextAlign.Companion companion7 = TextAlign.f29616b;
            TextKt.c(strK, PaddingKt.k(companion6, Dp.g(f4), 0.0f, 2, null), jQ02, 0L, null, FontWeight.f29233b.b(), null, 0L, null, TextAlign.h(companion7.a()), 0L, 0, false, 0, 0, null, textStyleE, composer, 196656, 0, 64984);
            SpacerKt.a(SizeKt.v(companion6, Dp.g(f4)), composer, 6);
            if (z3) {
                composer.a0(-179814579);
                composer.a0(-698535852);
                AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
                CharSequence text = context.getText(z4 ? R.string.rj : R.string.sj);
                Intrinsics.checkNotNullExpressionValue(text, "getText(...)");
                builder.l(text.toString());
                if (text instanceof Spanned) {
                    composer.a0(777518482);
                    Spanned spanned = (Spanned) text;
                    int i12 = 0;
                    Object[] spans = spanned.getSpans(0, text.length(), StyleSpan.class);
                    Intrinsics.checkNotNullExpressionValue(spans, "getSpans(...)");
                    StyleSpan[] styleSpanArr = (StyleSpan[]) spans;
                    int length = styleSpanArr.length;
                    int i13 = 0;
                    while (i13 < length) {
                        StyleSpan styleSpan = styleSpanArr[i13];
                        builder.f(new SpanStyle(ComposeColorsKt.j(composer, i12).q0(), 0L, FontWeight.f29233b.b(), (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65530, (DefaultConstructorMarker) null), spanned.getSpanStart(styleSpan), spanned.getSpanEnd(styleSpan));
                        i13++;
                        i12 = 0;
                    }
                } else {
                    composer.a0(777518481);
                }
                composer.U();
                AnnotatedString annotatedStringT = builder.t();
                composer.U();
                TextKt.d(annotatedStringT, PaddingKt.k(Modifier.b8, Dp.g(f5), 0.0f, 2, null), Color.r(ComposeColorsKt.j(composer, 0).q0(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, null, MaterialTheme.f13091a.c(composer, MaterialTheme.f13092b).b(), composer, 48, 0, 130552);
                composer4 = composer;
                composer4.U();
            } else {
                composer.a0(-177954548);
                TextKt.c(lockViewState.J(), PaddingKt.k(companion6, Dp.g(f5), 0.0f, 2, null), Color.r(ComposeColorsKt.j(composer, 0).q0(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null), 0L, null, null, null, 0L, null, TextAlign.h(companion7.a()), 0L, 0, false, 0, 0, null, materialTheme.c(composer, i11).b(), composer, 48, 0, 65016);
                composer4 = composer;
                composer4.U();
            }
            Modifier.Companion companion8 = Modifier.b8;
            SpacerKt.a(SizeKt.v(companion8, Dp.g(f4)), composer4, 6);
            if (lockViewState.A()) {
                composer4.a0(-177346700);
                Modifier modifierK = PaddingKt.k(SizeKt.i(SizeKt.h(companion8, 0.0f, 1, null), Dp.g(64)), Dp.g(f5), 0.0f, 2, null);
                boolean Z4 = composer4.Z(function1);
                Object objG9 = composer4.G();
                if (Z4 || objG9 == Composer.f23746a.a()) {
                    objG9 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.x
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExplanationLockScreenKt.w(function1);
                        }
                    };
                    composer4.w(objG9);
                }
                LockScreensComponentsKt.l(modifierK, (Function0) objG9, composer4, 6);
                SpacerKt.a(SizeKt.v(companion8, Dp.g(f4)), composer4, 6);
            } else {
                composer4.a0(-198025498);
            }
            composer4.U();
            if (lockViewState.w()) {
                composer4.a0(-176630011);
                Modifier modifierK2 = PaddingKt.k(SizeKt.i(SizeKt.h(companion8, 0.0f, 1, null), Dp.g(90)), Dp.g(f5), 0.0f, 2, null);
                String strP = lockViewState.p();
                boolean Z5 = composer4.Z(function1);
                Object objG10 = composer4.G();
                if (Z5 || objG10 == Composer.f23746a.a()) {
                    objG10 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.y
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ExplanationLockScreenKt.x(function1);
                        }
                    };
                    composer4.w(objG10);
                }
                i8 = 6;
                LockScreensComponentsKt.i(modifierK2, strP, (Function0) objG10, composer4, 6);
                SpacerKt.a(SizeKt.v(companion8, Dp.g(f4)), composer4, 6);
            } else {
                i8 = 6;
                composer4.a0(-198025498);
            }
            composer4.U();
            composer4.y();
            if (lockViewState.x()) {
                composer4.a0(1309680319);
                Modifier modifierM2 = PaddingKt.m(SizeKt.h(companion8, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.g(f5), 7, null);
                composer4.a0(-1003410150);
                composer4.a0(212064437);
                composer4.U();
                Density density = (Density) composer4.q(CompositionLocalsKt.f());
                Object objG11 = composer4.G();
                Composer.Companion companion9 = Composer.f23746a;
                if (objG11 == companion9.a()) {
                    objG11 = new Measurer(density);
                    composer4.w(objG11);
                }
                final Measurer measurer = (Measurer) objG11;
                Object objG12 = composer4.G();
                if (objG12 == companion9.a()) {
                    objG12 = new ConstraintLayoutScope();
                    composer4.w(objG12);
                }
                final ConstraintLayoutScope constraintLayoutScope = (ConstraintLayoutScope) objG12;
                Object objG13 = composer4.G();
                if (objG13 == companion9.a()) {
                    objG13 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                    composer4.w(objG13);
                }
                final MutableState mutableState3 = (MutableState) objG13;
                Object objG14 = composer4.G();
                if (objG14 == companion9.a()) {
                    objG14 = new ConstraintSetForInlineDsl(constraintLayoutScope);
                    composer4.w(objG14);
                }
                final ConstraintSetForInlineDsl constraintSetForInlineDsl2 = (ConstraintSetForInlineDsl) objG14;
                Object objG15 = composer4.G();
                if (objG15 == companion9.a()) {
                    objG15 = SnapshotStateKt.i(Unit.f139807a, SnapshotStateKt.k());
                    composer4.w(objG15);
                }
                final MutableState mutableState4 = (MutableState) objG15;
                final int i14 = 257;
                boolean zI = composer4.I(measurer) | composer4.e(257);
                Object objG16 = composer4.G();
                if (zI || objG16 == companion9.a()) {
                    MeasurePolicy measurePolicy = new MeasurePolicy() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.ExplanationLockScreenKt$ExplanationLockScreen$lambda$1$0$0$$inlined$ConstraintLayout$2
                        @Override // androidx.compose.ui.layout.MeasurePolicy
                        /* JADX INFO: renamed from: measure-3p2s80s */
                        public final MeasureResult mo10measure3p2s80s(MeasureScope measureScope, final List list, long j3) {
                            mutableState4.getValue();
                            long jX = measurer.x(j3, measureScope.getLayoutDirection(), constraintSetForInlineDsl2, list, i14);
                            mutableState3.getValue();
                            int iG = IntSize.g(jX);
                            int iF = IntSize.f(jX);
                            final Measurer measurer2 = measurer;
                            return MeasureScope.B0(measureScope, iG, iF, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.ExplanationLockScreenKt$ExplanationLockScreen$lambda$1$0$0$$inlined$ConstraintLayout$2.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((Placeable.PlacementScope) obj);
                                    return Unit.f139807a;
                                }

                                public final void invoke(Placeable.PlacementScope placementScope) {
                                    measurer2.w(placementScope, list);
                                }
                            }, 4, null);
                        }
                    };
                    constraintSetForInlineDsl = constraintSetForInlineDsl2;
                    mutableState = mutableState3;
                    composer4.w(measurePolicy);
                    objG16 = measurePolicy;
                } else {
                    constraintSetForInlineDsl = constraintSetForInlineDsl2;
                    mutableState = mutableState3;
                }
                MeasurePolicy measurePolicy2 = (MeasurePolicy) objG16;
                Object objG17 = composer4.G();
                if (objG17 == companion9.a()) {
                    objG17 = new Function0<Unit>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.ExplanationLockScreenKt$ExplanationLockScreen$lambda$1$0$0$$inlined$ConstraintLayout$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1362invoke();
                            return Unit.f139807a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m1362invoke() {
                            mutableState.setValue(Boolean.valueOf(!((Boolean) r0.getValue()).booleanValue()));
                            constraintSetForInlineDsl.m(true);
                        }
                    };
                    composer4.w(objG17);
                }
                final Function0 function0 = (Function0) objG17;
                boolean zI2 = composer4.I(measurer);
                Object objG18 = composer4.G();
                if (zI2 || objG18 == companion9.a()) {
                    objG18 = new Function1<SemanticsPropertyReceiver, Unit>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.ExplanationLockScreenKt$ExplanationLockScreen$lambda$1$0$0$$inlined$ConstraintLayout$4
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((SemanticsPropertyReceiver) obj);
                            return Unit.f139807a;
                        }

                        public final void invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            ToolingUtilsKt.a(semanticsPropertyReceiver, measurer);
                        }
                    };
                    composer4.w(objG18);
                }
                Modifier modifierF12 = SemanticsModifierKt.f(modifierM2, false, (Function1) objG18, 1, null);
                f3 = f5;
                i9 = 6;
                LayoutKt.a(modifierF12, ComposableLambdaKt.e(1200550679, true, new Function2<Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.lockscreen.ExplanationLockScreenKt$ExplanationLockScreen$lambda$1$0$0$$inlined$ConstraintLayout$5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.f139807a;
                    }

                    /* JADX WARN: Type inference failed for: r15v1 */
                    /* JADX WARN: Type inference failed for: r15v2, types: [boolean, int] */
                    /* JADX WARN: Type inference failed for: r15v4 */
                    public final void invoke(Composer composer5, int i15) {
                        ?? r15;
                        int i16;
                        if ((i15 & 3) == 2 && composer5.l()) {
                            composer5.Q();
                            return;
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.U(1200550679, i15, -1, "androidx.constraintlayout.compose.ConstraintLayout.<anonymous> (ConstraintLayout.kt:454)");
                        }
                        mutableState4.setValue(Unit.f139807a);
                        int i17 = constraintLayoutScope.i();
                        constraintLayoutScope.j();
                        ConstraintLayoutScope constraintLayoutScope2 = constraintLayoutScope;
                        composer5.a0(-311106704);
                        ConstraintLayoutScope.ConstrainedLayoutReferences constrainedLayoutReferencesN = constraintLayoutScope2.n();
                        ConstrainedLayoutReference constrainedLayoutReferenceA = constrainedLayoutReferencesN.a();
                        ConstrainedLayoutReference constrainedLayoutReferenceB = constrainedLayoutReferencesN.b();
                        if (lockViewState.z()) {
                            composer5.a0(-311079208);
                            Modifier.Companion companion10 = Modifier.b8;
                            boolean Z6 = composer5.Z(constrainedLayoutReferenceB);
                            Object objG19 = composer5.G();
                            if (Z6 || objG19 == Composer.f23746a.a()) {
                                objG19 = new ExplanationLockScreenKt$ExplanationLockScreen$2$1$1$2$1$1(constrainedLayoutReferenceB);
                                composer5.w(objG19);
                            }
                            r15 = 0;
                            i16 = 3;
                            ComposeCountDownKt.b(SizeKt.v(PaddingKt.m(constraintLayoutScope2.l(companion10, constrainedLayoutReferenceA, (Function1) objG19), 0.0f, 0.0f, Dp.g(16), 0.0f, 11, null), Dp.g(40)), Dp.g(3), Dp.g(0), lockViewState.n(), 0L, ComposableLambdaKt.e(298736708, true, new ExplanationLockScreenKt$ExplanationLockScreen$2$1$1$2$2(lockViewState), composer5, 54), composer5, 197040, 16);
                        } else {
                            r15 = 0;
                            i16 = 3;
                            composer5.a0(-333699350);
                        }
                        composer5.U();
                        Modifier.Companion companion11 = Modifier.b8;
                        Object objG20 = composer5.G();
                        Composer.Companion companion12 = Composer.f23746a;
                        if (objG20 == companion12.a()) {
                            objG20 = ExplanationLockScreenKt$ExplanationLockScreen$2$1$1$2$3$1.f105341a;
                            composer5.w(objG20);
                        }
                        Modifier modifierI = SizeKt.I(SizeKt.i(constraintLayoutScope2.l(companion11, constrainedLayoutReferenceB, (Function1) objG20), Dp.g(48)), null, r15, i16, null);
                        boolean zL2 = lockViewState.l();
                        ButtonColors buttonColorsA = ButtonDefaults.f12323a.a(ComposeColorsKt.j(composer5, r15).b(), 0L, ComposeColorsKt.j(composer5, r15).f0(), 0L, composer5, ButtonDefaults.f12334l << 12, 10);
                        RoundedCornerShape roundedCornerShapeG = RoundedCornerShapeKt.g();
                        PaddingValues paddingValuesC = PaddingKt.c(Dp.g(52), 0.0f, 2, null);
                        boolean zB2 = composer5.b(z3) | composer5.Z(function1);
                        Object objG21 = composer5.G();
                        if (zB2 || objG21 == companion12.a()) {
                            objG21 = new ExplanationLockScreenKt$ExplanationLockScreen$2$1$1$2$4$1(z3, function1);
                            composer5.w(objG21);
                        }
                        ButtonKt.a((Function0) objG21, modifierI, zL2, null, null, roundedCornerShapeG, null, buttonColorsA, paddingValuesC, ComposableLambdaKt.e(1522667144, true, new ExplanationLockScreenKt$ExplanationLockScreen$2$1$1$2$5(lockViewState), composer5, 54), composer5, 905969664, 88);
                        composer5.U();
                        if (constraintLayoutScope.i() != i17) {
                            EffectsKt.j(function0, composer5, 6);
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                    }
                }, composer4, i6), measurePolicy2, composer4, 48, 0);
                composer4.U();
            } else {
                i9 = i8;
                f3 = f5;
                composer4.a0(1287372316);
            }
            composer4.U();
            SpacerKt.a(SizeKt.v(companion8, Dp.g(f3)), composer4, i9);
            composer4.y();
            composer4.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    private static final boolean v(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(Function1 function1) {
        function1.invoke(LockViewEvent.LockScreenInAppUpdateCardClickEvent.f105472a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(Function1 function1) {
        function1.invoke(LockViewEvent.LockScreenCampaignCardClickEvent.f105466a);
        return Unit.f139807a;
    }

    private static final void y(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(boolean z2, Function1 function1) {
        if (z2) {
            function1.invoke(new LockViewEvent.LockScreenPopupCloseEvent(false));
        } else {
            function1.invoke(LockViewEvent.LockScreenCloseButtonClickEvent.f105467a);
        }
        return Unit.f139807a;
    }
}
