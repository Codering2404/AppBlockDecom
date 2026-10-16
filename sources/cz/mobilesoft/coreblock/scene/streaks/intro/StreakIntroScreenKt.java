package cz.mobilesoft.coreblock.scene.streaks.intro;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
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
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.streaks.milestone.StreakMilestoneScreenKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarKt;
import java.io.IOException;
import java.time.DayOfWeek;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import org.xmlpull.v1.XmlPullParserException;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StreakIntroScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f120898a = Dp.g(14);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final long f120899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f120900c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class EntriesMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f120909a = EnumEntriesKt.a(DayOfWeek.values());
    }

    static {
        Duration.Companion companion = Duration.f140631b;
        DurationUnit durationUnit = DurationUnit.f140640d;
        f120899b = DurationKt.s(1450, durationUnit);
        f120900c = DurationKt.s(150, durationUnit);
    }

    private static final Modifier I(Modifier modifier, boolean z2, int i3, Composer composer, int i4) {
        if (ComposerKt.M()) {
            ComposerKt.U(-2092432639, i4, -1, "cz.mobilesoft.coreblock.scene.streaks.intro.staggerReveal (StreakIntroScreen.kt:276)");
        }
        State stateD = AnimateAsStateKt.d(z2 ? 1.0f : 0.0f, AnimationSpecKt.m(300, i3 * 80, EasingKt.f()), 0.0f, "streakIntroStagger", null, composer, 3072, 20);
        Modifier modifierD = OffsetKt.d(AlphaKt.a(modifier, J(stateD)), 0.0f, Dp.g(f120898a * (1.0f - J(stateD))), 1, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return modifierD;
    }

    private static final float J(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void f(final boolean r42, androidx.compose.ui.Modifier r43, androidx.compose.runtime.Composer r44, final int r45, final int r46) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1012
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.intro.StreakIntroScreenKt.f(boolean, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int g(MutableIntState mutableIntState) {
        return mutableIntState.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(MutableIntState mutableIntState, int i3) {
        mutableIntState.a(i3);
    }

    private static final float i(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(boolean z2, Modifier modifier, int i3, int i4, Composer composer, int i5) throws XmlPullParserException, IOException {
        f(z2, modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void k(final androidx.compose.foundation.layout.PaddingValues r24, final kotlin.jvm.functions.Function0 r25, boolean r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instruction units count: 498
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.streaks.intro.StreakIntroScreenKt.k(androidx.compose.foundation.layout.PaddingValues, kotlin.jvm.functions.Function0, boolean, androidx.compose.runtime.Composer, int, int):void");
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

    private static final boolean o(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void p(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    private static final float q(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(PaddingValues paddingValues, Function0 function0, final MutableState mutableState, boolean z2, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, State state, BoxScope GradientBox, Composer composer, int i3) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(408538289, i3, -1, "cz.mobilesoft.coreblock.scene.streaks.intro.StreakIntroScreen.<anonymous> (StreakIntroScreen.kt:101)");
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
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            float f3 = 8;
            Modifier modifierJ = PaddingKt.j(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), Dp.g(4));
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.i(), composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierJ);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            ToolbarKt.h(null, R.drawable.C1, StringResources_androidKt.b(R.string.N7, composer, 0), null, 0.0f, function0, composer, 0, 25);
            SpacerKt.a(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), composer, 0);
            int i4 = R.drawable.M;
            String strB = StringResources_androidKt.b(R.string.Af, composer, 0);
            Object objG = composer.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.streaks.intro.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return StreakIntroScreenKt.s(mutableState);
                    }
                };
                composer.w(objG);
            }
            ToolbarKt.h(null, i4, strB, null, 0.0f, (Function0) objG, composer, 196608, 25);
            composer.y();
            float f4 = 16;
            Modifier modifierK = PaddingKt.k(ScrollKt.g(ColumnScope.b(columnScopeInstance, companion, 1.0f, false, 2, null), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null), Dp.g(f4), 0.0f, 2, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion2.g(), composer, 48);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierK);
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
            float f5 = 32;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f5)), composer, 6);
            StreakMilestoneScreenKt.e(l(mutableState2), w(mutableState3), z2, composer, 0);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f5)), composer, 6);
            String strB2 = StringResources_androidKt.b(R.string.iB, composer, 0);
            MaterialTheme materialTheme = MaterialTheme.f13091a;
            int i5 = MaterialTheme.f13092b;
            TextStyle textStyleF = materialTheme.c(composer, i5).f();
            long jP = ComposeColorsKt.j(composer, 0).p();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strB2, I(companion, y(mutableState4), 0, composer, 390), jP, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleF, composer, 0, 0, 65016);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.hB, composer, 0), I(companion, y(mutableState4), 1, composer, 390), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, materialTheme.c(composer, i5).a(), composer, 0, 0, 65016);
            float f6 = 24;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f6)), composer, 6);
            f(z2, I(companion, y(mutableState4), 2, composer, 390), composer, 0, 0);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f6)), composer, 6);
            composer.y();
            Modifier modifierA = AlphaKt.a(SizeKt.h(companion, 0.0f, 1, null), q(state));
            MeasurePolicy measurePolicyA3 = ColumnKt.a(arrangement.h(), companion2.g(), composer, 48);
            int iA4 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU4 = composer.u();
            Modifier modifierF4 = ComposedModifierKt.f(composer, modifierA);
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
            Updater.e(composerA4, measurePolicyA3, companion3.e());
            Updater.e(composerA4, compositionLocalMapU4, companion3.g());
            Function2 function2B4 = companion3.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF4, companion3.f());
            TextKt.c(StringResources_androidKt.b(R.string.gB, composer, 0), PaddingKt.k(companion, Dp.g(f4), 0.0f, 2, null), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, materialTheme.c(composer, i5).b(), composer, 48, 0, 65016);
            FlatButtonsKt.p(FlatButtonColors.Primary.f131166a, false, StringResources_androidKt.b(R.string.Vi, composer, 0), false, function0, composer, 6, 10);
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
    public static final Unit s(MutableState mutableState) {
        p(mutableState, true);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(MutableState mutableState) {
        p(mutableState, false);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(PaddingValues paddingValues, Function0 function0, boolean z2, int i3, int i4, Composer composer, int i5) {
        k(paddingValues, function0, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    private static final boolean w(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    private static final boolean y(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }
}
