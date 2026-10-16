package cz.mobilesoft.coreblock.scene.schedule.detail;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.dto.ConflictingSchedule;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.CardType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCardsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import java.util.Iterator;
import java.util.List;
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
public final class ConflictingSchedulesScreenKt {
    public static final void h(final ConflictingSchedule conflictingSchedule, final PackageManager packageManager, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(conflictingSchedule, "conflictingSchedule");
        Intrinsics.checkNotNullParameter(packageManager, "packageManager");
        Composer composerK = composer.k(1845367296);
        if ((i3 & 6) == 0) {
            i4 = ((i3 & 8) == 0 ? composerK.Z(conflictingSchedule) : composerK.I(conflictingSchedule) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(packageManager) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1845367296, i4, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ConflictingSchedule (ConflictingSchedulesScreen.kt:207)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            ComposeCardsKt.m(SizeKt.h(PaddingKt.k(Modifier.b8, Dp.g(16), 0.0f, 2, null), 0.0f, 1, null), new CardType.Bordered(null, Color.n(ComposeColorsKt.j(composerK, 0).v()), 1, null), null, ComposableLambdaKt.e(-283455643, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.e3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ConflictingSchedulesScreenKt.i(conflictingSchedule, packageManager, context, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, 3462, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.f3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ConflictingSchedulesScreenKt.j(conflictingSchedule, packageManager, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(ConflictingSchedule conflictingSchedule, PackageManager packageManager, Context context, Composer composer, int i3) throws Exception {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-283455643, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ConflictingSchedule.<anonymous> (ConflictingSchedulesScreen.kt:219)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(PaddingKt.i(companion, Dp.g(16)), 0.0f, 1, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
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
            ConflictingSchedulesRowKt.g(conflictingSchedule.a(), packageManager, composer, 0);
            float f3 = 4;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            String strC = conflictingSchedule.c(context);
            TextStyle textStyleI = ComposeTypographyKt.g(composer, 0).i();
            long jP = ComposeColorsKt.j(composer, 0).p();
            TextAlign.Companion companion3 = TextAlign.f29616b;
            TextKt.c(strC, null, jP, 0L, null, null, null, 0L, null, TextAlign.h(companion3.f()), 0L, 0, false, 0, 0, null, textStyleI, composer, 0, 0, 65018);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            TextKt.c(conflictingSchedule.b(context), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion3.f()), 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composer, 0).j(), 0L, 0L, FontWeight.f29233b.g(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 0, 0, 65018);
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
    public static final Unit j(ConflictingSchedule conflictingSchedule, PackageManager packageManager, int i3, Composer composer, int i4) {
        h(conflictingSchedule, packageManager, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void k(final java.util.List r19, final android.content.pm.PackageManager r20, final kotlin.jvm.functions.Function0 r21, final kotlin.jvm.functions.Function0 r22, kotlin.jvm.functions.Function0 r23, androidx.compose.runtime.Composer r24, final int r25, final int r26) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.schedule.detail.ConflictingSchedulesScreenKt.k(java.util.List, android.content.pm.PackageManager, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void l(List conflictingSchedules, Function0 onClose, Function0 onExplanationClicked, Function0 function0, Composer composer, final int i3, final int i4) {
        int i5;
        Function0 function02;
        final Function0 function03;
        final List list;
        final Function0 function04;
        Intrinsics.checkNotNullParameter(conflictingSchedules, "conflictingSchedules");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Intrinsics.checkNotNullParameter(onExplanationClicked, "onExplanationClicked");
        Composer composerK = composer.k(1256983177);
        if ((i3 & 6) == 0) {
            i5 = (composerK.I(conflictingSchedules) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(onClose) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(onExplanationClicked) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i6 = i4 & 8;
        if (i6 != 0) {
            i5 |= 3072;
        } else if ((i3 & 3072) == 0) {
            i5 |= composerK.I(function0) ? 2048 : 1024;
        }
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            if (i6 != 0) {
                function0 = null;
            }
            Function0 function05 = function0;
            if (ComposerKt.M()) {
                ComposerKt.U(1256983177, i5, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ConflictingSchedulesScreen (ConflictingSchedulesScreen.kt:58)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = context.getApplicationContext().getPackageManager();
                composerK.w(objG);
            }
            PackageManager packageManager = (PackageManager) objG;
            Intrinsics.checkNotNull(packageManager);
            int i7 = i5 & 14;
            int i8 = i5 << 3;
            function02 = onExplanationClicked;
            k(conflictingSchedules, packageManager, onClose, function02, function05, composerK, i7 | (i8 & 896) | (i8 & 7168) | (i8 & 57344), 0);
            list = conflictingSchedules;
            function03 = onClose;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            function04 = function05;
        } else {
            function02 = onExplanationClicked;
            function03 = onClose;
            list = conflictingSchedules;
            composerK.Q();
            function04 = function0;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final Function0 function06 = function02;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.g3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ConflictingSchedulesScreenKt.m(list, function03, function06, function04, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(List list, Function0 function0, Function0 function02, Function0 function03, int i3, int i4, Composer composer, int i5) {
        l(list, function0, function02, function03, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Function0 function0, final Function0 function02, List list, final Function0 function03, PackageManager packageManager, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(554359850, i3, -1, "cz.mobilesoft.coreblock.scene.schedule.detail.ConflictingSchedulesScreen.<anonymous> (ConflictingSchedulesScreen.kt:80)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(WindowInsetsPaddingKt.d(companion, WindowInsets_androidKt.c(WindowInsets.f7172a, composer, 6)), 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion2.g();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composer, 48);
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierH);
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
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            int i4 = R.drawable.G0;
            boolean Z = composer.Z(function02);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.c3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ConflictingSchedulesScreenKt.o(function02);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.o0(null, null, i4, (Function0) objG, composer, 0, 3);
            composer.y();
            Modifier modifierC = BackgroundKt.c(SizeKt.v(companion, Dp.g(56)), Color.r(ComposeColorsKt.j(composer, 0).z(), 0.18f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.a(50));
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer, modifierC);
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
            IconKt.a(PainterResources_androidKt.c(R.drawable.w5, composer, 0), null, boxScopeInstance.f(SizeKt.v(companion, Dp.g(40)), companion2.e()), ComposeColorsKt.j(composer, 0).p(), composer, 48, 0);
            composer.y();
            float f3 = 12;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            float f4 = 16;
            Modifier modifierK = PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f4), 0.0f, 2, null);
            String strB = StringResources_androidKt.b(R.string.N1, composer, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composer, 0).f();
            long jP = ComposeColorsKt.j(composer, 0).p();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strB, modifierK, jP, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleF, composer, 48, 0, 65016);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.O1, composer, 0), PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f4), 0.0f, 2, null), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 48, 0, 65016);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            Modifier modifierG = ScrollKt.g(ColumnScope.b(columnScopeInstance, SizeKt.h(companion, 0.0f, 1, null), 1.0f, false, 2, null), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.o(Dp.g(f3)), companion2.g(), composer, 54);
            int iA4 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU4 = composer.u();
            Modifier modifierF5 = ComposedModifierKt.f(composer, modifierG);
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
            Updater.e(composerA4, measurePolicyA2, companion3.e());
            Updater.e(composerA4, compositionLocalMapU4, companion3.g());
            Function2 function2B4 = companion3.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF5, companion3.f());
            composer.a0(77890717);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                h((ConflictingSchedule) it.next(), packageManager, composer, ConflictingSchedule.f96916j);
            }
            composer.U();
            Modifier.Companion companion5 = Modifier.b8;
            Modifier modifierM = PaddingKt.m(BackgroundKt.c(ClipKt.a(SizeKt.i(SizeKt.h(PaddingKt.k(companion5, Dp.g(f4), 0.0f, 2, null), 0.0f, 1, null), Dp.g(48)), RoundedCornerShapeKt.a(50)), ComposeColorsKt.j(composer, 0).E(), RoundedCornerShapeKt.a(50)), Dp.g(f4), 0.0f, Dp.g(8), 0.0f, 10, null);
            boolean Z2 = composer.Z(function03);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.d3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ConflictingSchedulesScreenKt.p(function03);
                    }
                };
                composer.w(objG2);
            }
            Modifier modifierF6 = ClickableKt.f(modifierM, false, null, null, (Function0) objG2, 7, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composer, 48);
            int iA5 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU5 = composer.u();
            Modifier modifierF7 = ComposedModifierKt.f(composer, modifierF6);
            ComposeUiNode.Companion companion6 = ComposeUiNode.f8;
            Function0 function0A5 = companion6.a();
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
            Updater.e(composerA5, measurePolicyB, companion6.e());
            Updater.e(composerA5, compositionLocalMapU5, companion6.g());
            Function2 function2B5 = companion6.b();
            if (composerA5.i() || !Intrinsics.areEqual(composerA5.G(), Integer.valueOf(iA5))) {
                composerA5.w(Integer.valueOf(iA5));
                composerA5.p(Integer.valueOf(iA5), function2B5);
            }
            Updater.e(composerA5, modifierF7, companion6.f());
            TextKt.c(StringResources_androidKt.b(R.string.Di, composer, 0), RowScope.c(RowScopeInstance.f7101a, companion5, 1.0f, false, 2, null), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.f()), 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composer, 0).j(), 0L, 0L, FontWeight.f29233b.g(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777211, null), composer, 0, 0, 65016);
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95580y1, composer, 6), null, SizeKt.v(companion5, Dp.g(24)), ComposeColorsKt.j(composer, 0).s(), composer, 432, 0);
            composer.y();
            SpacerKt.a(SizeKt.i(companion5, Dp.g(f3)), composer, 6);
            composer.y();
            if (function0 == null) {
                composer.a0(1484269453);
                composer.U();
            } else {
                composer.a0(1484269454);
                FlatButtonsKt.p(null, false, StringResources_androidKt.b(R.string.l8, composer, 0), false, function0, composer, 0, 11);
                Unit unit = Unit.f139807a;
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
    public static final Unit o(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(List list, PackageManager packageManager, Function0 function0, Function0 function02, Function0 function03, int i3, int i4, Composer composer, int i5) {
        k(list, packageManager, function0, function02, function03, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
