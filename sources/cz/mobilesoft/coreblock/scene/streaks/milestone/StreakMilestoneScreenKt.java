package cz.mobilesoft.coreblock.scene.streaks.milestone;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.streaks.StreakWeekDayStatus;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
public final class StreakMilestoneScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f120943a = Dp.g(14);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final float f120944b = Dp.g(340);

    /* JADX INFO: Access modifiers changed from: private */
    public static final StreakMilestoneViewState B(int i3) {
        StreakWeekDayStatus streakWeekDayStatus = StreakWeekDayStatus.Obtained;
        StreakWeekDayStatus streakWeekDayStatus2 = StreakWeekDayStatus.Rest;
        StreakWeekDayStatus streakWeekDayStatus3 = StreakWeekDayStatus.Future;
        return new StreakMilestoneViewState(false, i3, CollectionsKt.listOf((Object[]) new StreakWeekDayStatus[]{streakWeekDayStatus, streakWeekDayStatus, streakWeekDayStatus2, streakWeekDayStatus, streakWeekDayStatus, streakWeekDayStatus3, streakWeekDayStatus3}), 4);
    }

    private static final Modifier C(Modifier modifier, boolean z2, int i3, Composer composer, int i4) {
        if (ComposerKt.M()) {
            ComposerKt.U(-634491775, i4, -1, "cz.mobilesoft.coreblock.scene.streaks.milestone.staggerReveal (StreakMilestoneScreen.kt:188)");
        }
        State stateD = AnimateAsStateKt.d(z2 ? 1.0f : 0.0f, AnimationSpecKt.m(300, i3 * 80, EasingKt.f()), 0.0f, "streakMilestoneStagger", null, composer, 3072, 20);
        Modifier modifierD = OffsetKt.d(AlphaKt.a(modifier, D(stateD)), 0.0f, Dp.g(f120943a * (1.0f - D(stateD))), 1, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return modifierD;
    }

    private static final float D(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    public static final void e(final boolean z2, final boolean z3, final boolean z4, Composer composer, final int i3) {
        int i4;
        int i5;
        Composer composerK = composer.k(2032192529);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z4) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i6 = i4;
        if (composerK.r((i6 & 147) != 146, i6 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2032192529, i6, -1, "cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneBolt (StreakMilestoneScreen.kt:212)");
            }
            State stateD = AnimateAsStateKt.d(z2 ? 1.0f : 0.0f, AnimationSpecKt.n(300, 0, null, 6, null), 0.0f, "streakMilestoneBolt", null, composerK, 3120, 20);
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            float f3 = f120944b;
            Modifier modifierI = SizeKt.i(modifierH, Dp.g(0.61f * f3));
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.m(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
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
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            if (z3) {
                composerK.a0(1533935603);
                i5 = 6;
                h(z4, composerK, (i6 >> 6) & 14);
            } else {
                i5 = 6;
                composerK.a0(1524565047);
            }
            composerK.U();
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.M5, composerK, i5), null, AlphaKt.a(SizeKt.o(companion, f3), f(stateD)), Color.f25715b.k(), composerK, 3120, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.milestone.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakMilestoneScreenKt.g(z2, z3, z4, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float f(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(boolean z2, boolean z3, boolean z4, int i3, Composer composer, int i4) {
        e(z2, z3, z4, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void h(final boolean z2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1766586415);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1766586415, i4, -1, "cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneGlow (StreakMilestoneScreen.kt:249)");
            }
            float fI = z2 ? i(InfiniteTransitionKt.a(InfiniteTransitionKt.c("streakMilestoneGlow", composerK, 6, 0), 0.01f, 1.0f, AnimationSpecKt.e(AnimationSpecKt.n(1500, 0, EasingKt.d(), 2, null), RepeatMode.f4053b, 0L, 4, null), "streakMilestoneGlowPulse", composerK, InfiniteTransition.f3967f | 25008 | (InfiniteRepeatableSpec.f3963d << 9), 0)) : 1.0f;
            IconKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.O5, composerK, 6), null, AlphaKt.a(ScaleKt.a(SizeKt.o(Modifier.b8, f120944b), fI), fI), Color.f25715b.k(), composerK, 3120, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.milestone.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakMilestoneScreenKt.j(z2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float i(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(boolean z2, int i3, Composer composer, int i4) {
        h(z2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void k(final androidx.compose.foundation.layout.PaddingValues r23, final cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneViewState r24, final kotlin.jvm.functions.Function0 r25, boolean r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 433
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneScreenKt.k(androidx.compose.foundation.layout.PaddingValues, cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneViewState, kotlin.jvm.functions.Function0, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final boolean l(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final boolean m(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    private static final float o(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(PaddingValues paddingValues, boolean z2, StreakMilestoneViewState streakMilestoneViewState, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, State state, Function0 function0, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(948069153, i3, -1, "cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneScreen.<anonymous> (StreakMilestoneScreen.kt:96)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierD = WindowInsetsPaddingKt.d(PaddingKt.h(SizeKt.f(companion, 0.0f, 1, null), paddingValues), WindowInsets_androidKt.c(WindowInsets.f7172a, composer, 6));
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierD);
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
            Updater.e(composerA, modifierF, companion3.f());
            float f3 = 16;
            Modifier modifierK = PaddingKt.k(ScrollKt.g(ColumnScope.b(ColumnScopeInstance.f6666a, companion, 1.0f, false, 2, null), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null), Dp.g(f3), 0.0f, 2, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion2.g(), composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierK);
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
            Updater.e(composerA2, measurePolicyA2, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            SpacerKt.a(SizeKt.i(companion, Dp.g(72)), composer, 6);
            e(l(mutableState), s(mutableState2), z2, composer, 0);
            TextKt.c(String.valueOf(streakMilestoneViewState.d()), C(companion, u(mutableState3), 0, composer, 390), ComposeColorsKt.j(composer, 0).p(), TextUnitKt.i(64), null, FontWeight.f29233b.h(), null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 199680, 0, 131024);
            String strB = StringResources_androidKt.b(streakMilestoneViewState.f(), composer, 0);
            MaterialTheme materialTheme = MaterialTheme.f13091a;
            int i4 = MaterialTheme.f13092b;
            TextStyle textStyleF = materialTheme.c(composer, i4).f();
            long jP = ComposeColorsKt.j(composer, 0).p();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strB, C(companion, u(mutableState3), 1, composer, 390), jP, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleF, composer, 0, 0, 65016);
            SpacerKt.a(SizeKt.i(companion, Dp.g(8)), composer, 6);
            TextKt.c(StringResources_androidKt.b(streakMilestoneViewState.e(), composer, 0), C(companion, u(mutableState3), 2, composer, 390), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, materialTheme.c(composer, i4).a(), composer, 0, 0, 65016);
            float f4 = 24;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, 6);
            StreakMilestoneWeekRowKt.k(streakMilestoneViewState.g(), streakMilestoneViewState.b(), C(companion, u(mutableState3), 3, composer, 390), z2, composer, 0, 0);
            Composer composer2 = composer;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer2, 6);
            composer2.y();
            Modifier modifierA = AlphaKt.a(SizeKt.h(companion, 0.0f, 1, null), o(state));
            MeasurePolicy measurePolicyA3 = ColumnKt.a(arrangement.h(), companion2.g(), composer2, 48);
            int iA3 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU3 = composer2.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer2, modifierA);
            Function0 function0A3 = companion3.a();
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
            Updater.e(composerA3, measurePolicyA3, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            if (streakMilestoneViewState.c()) {
                composer2.a0(-315543978);
                TextKt.c(StringResources_androidKt.b(R.string.jB, composer2, 0), PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null), ComposeColorsKt.j(composer2, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, materialTheme.c(composer2, i4).b(), composer, 48, 0, 65016);
                composer2 = composer;
            } else {
                composer2.a0(-322275938);
            }
            composer2.U();
            FlatButtonsKt.p(FlatButtonColors.Secondary.f131167a, false, StringResources_androidKt.b(R.string.ii, composer2, 0), false, function0, composer2, 6, 10);
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
    public static final Unit q(PaddingValues paddingValues, StreakMilestoneViewState streakMilestoneViewState, Function0 function0, boolean z2, int i3, int i4, Composer composer, int i5) {
        k(paddingValues, streakMilestoneViewState, function0, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    private static final boolean s(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    private static final boolean u(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }
}
