package cz.mobilesoft.coreblock.scene.onboarding.schedule;

import android.content.Context;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.ProfileViewDTO;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.view.AppIconCache;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarButtonType;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarKt;
import cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemEvent;
import cz.mobilesoft.coreblock.view.compose.profileitem.ProfileItemKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class OnboardingScheduleReadyScreenKt {
    /* JADX WARN: Removed duplicated region for block: B:30:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:83:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void h(final cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState r16, final cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO r17, kotlin.jvm.functions.Function0 r18, final kotlin.jvm.functions.Function0 r19, final kotlin.jvm.functions.Function0 r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instruction units count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.onboarding.schedule.OnboardingScheduleReadyScreenKt.h(cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState, cz.mobilesoft.coreblock.scene.schedule.ScheduleDTO, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Function0 function0, ScheduleViewState scheduleViewState, Context context, ScheduleDTO scheduleDTO, final Function0 function02, BoxScope GradientOnboardingBox, Composer composer, int i3) {
        int i4;
        Modifier.Companion companion;
        Composer composer2;
        Intrinsics.checkNotNullParameter(GradientOnboardingBox, "$this$GradientOnboardingBox");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(GradientOnboardingBox) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1884690047, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.schedule.OnboardingScheduleReadyScreen.<anonymous> (OnboardingScheduleReadyScreen.kt:56)");
            }
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierH = GradientOnboardingBox.h(companion2);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion3.k(), composer, 0);
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
            Updater.e(composerA, measurePolicyA, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            if (function0 == null) {
                composer.a0(-365199620);
                composer.U();
                companion = companion2;
                composer2 = composer;
            } else {
                composer.a0(-365199619);
                companion = companion2;
                ToolbarKt.e(null, function0, null, false, ToolbarButtonType.Back, false, false, null, null, composer, 1597440, 429);
                composer2 = composer;
                Unit unit = Unit.f139807a;
                composer2.U();
            }
            Alignment.Horizontal horizontalG = companion3.g();
            Modifier.Companion companion5 = companion;
            float f3 = 16;
            Modifier modifierM = PaddingKt.m(ScrollKt.g(ColumnScope.b(columnScopeInstance, companion5, 1.0f, false, 2, null), ScrollKt.c(0, composer2, 0, 1), false, null, false, 14, null), 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), horizontalG, composer2, 48);
            int iA2 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU2 = composer2.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierM);
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
            Updater.e(composerA2, measurePolicyA2, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            String strB = StringResources_androidKt.b(R.string.hu, composer2, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composer2, 0).f();
            TextAlign.Companion companion6 = TextAlign.f29616b;
            TextKt.c(strB, PaddingKt.k(companion5, Dp.g(f3), 0.0f, 2, null), 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion6.a()), 0L, 0, false, 0, 0, null, textStyleF, composer, 48, 0, 65020);
            SpacerKt.a(SizeKt.i(companion5, Dp.g(12)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.xm, composer, 0), PaddingKt.k(companion5, Dp.g(f3), 0.0f, 2, null), ComposeColorsKt.j(composer, 0).P(), 0L, null, null, null, 0L, null, TextAlign.h(companion6.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 48, 0, 65016);
            SpacerKt.a(SizeKt.i(companion5, Dp.g(24)), composer, 6);
            Alignment alignmentE = companion3.e();
            Modifier modifierM2 = PaddingKt.m(PaddingKt.k(companion5, Dp.g(f3), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.g(f3), 7, null);
            MeasurePolicy measurePolicyG = BoxKt.g(alignmentE, false);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierM2);
            Function0 function0A3 = companion4.a();
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
            Updater.e(composerA3, measurePolicyG, companion4.e());
            Updater.e(composerA3, compositionLocalMapU3, companion4.g());
            Function2 function2B3 = companion4.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion4.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composer, 0, 3);
            ProfileViewDTO profileViewDTOI = scheduleViewState.i(context, scheduleDTO);
            AppIconCache appIconCache = new AppIconCache();
            boolean Z = composer.Z(function02);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.schedule.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OnboardingScheduleReadyScreenKt.k(function02);
                    }
                };
                composer.w(objG);
            }
            Function0 function03 = (Function0) objG;
            Object objG2 = composer.G();
            if (objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.schedule.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingScheduleReadyScreenKt.l((ProfileItemEvent) obj);
                    }
                };
                composer.w(objG2);
            }
            ProfileItemKt.I0(scaffoldStateG, profileViewDTOI, appIconCache, null, false, function03, (Function1) objG2, composer, 1572864, 24);
            composer.y();
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
    public static final Unit k(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(ProfileItemEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(final Function0 function0, final MutableState mutableState, BoxScope GradientOnboardingBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientOnboardingBox, "$this$GradientOnboardingBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1191997632, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.schedule.OnboardingScheduleReadyScreen.<anonymous> (OnboardingScheduleReadyScreen.kt:107)");
            }
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.l8, composer, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.schedule.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OnboardingScheduleReadyScreenKt.n(function0, mutableState);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.i0(null, big, accent, (Function0) objG, composer, 0, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Function0 function0, MutableState mutableState) {
        function0.invoke();
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(ScheduleViewState scheduleViewState, ScheduleDTO scheduleDTO, Function0 function0, Function0 function02, Function0 function03, int i3, int i4, Composer composer, int i5) {
        h(scheduleViewState, scheduleDTO, function0, function02, function03, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
