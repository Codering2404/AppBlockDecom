package cz.mobilesoft.coreblock.scene.emergency_unblock.screens;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotLongStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.emergency_unblock.EmergencyUnblockViewState;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class EmergencyUnblockDeactivationCooldownScreenKt {
    public static final void i(final EmergencyUnblockViewState viewState, final Function0 onCloseClicked, final Function0 onKeepStrictModeActive, final Function0 onCooldownFinished, Composer composer, final int i3) {
        int i4;
        MutableLongState mutableLongState;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Intrinsics.checkNotNullParameter(onKeepStrictModeActive, "onKeepStrictModeActive");
        Intrinsics.checkNotNullParameter(onCooldownFinished, "onCooldownFinished");
        Composer composerK = composer.k(1762359897);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onCloseClicked) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onKeepStrictModeActive) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onCooldownFinished) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1762359897, i4, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.screens.EmergencyUnblockDeactivationCooldownScreen (EmergencyUnblockDeactivationCooldownScreen.kt:60)");
            }
            boolean zE = composerK.e(viewState.d());
            Object objG = composerK.G();
            if (zE || objG == Composer.f23746a.a()) {
                TimeUnit timeUnit = TimeUnit.MINUTES;
                objG = Long.valueOf(RangesKt.l(timeUnit.toMillis(((long) viewState.d()) + 1), timeUnit.toMillis(10L)));
                composerK.w(objG);
            }
            final long jLongValue = ((Number) objG).longValue();
            Object objG2 = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG2 == companion.a()) {
                objG2 = AnimatableKt.b(0.0f, 0.0f, 2, null);
                composerK.w(objG2);
            }
            final Animatable animatable = (Animatable) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotLongStateKt.a(jLongValue);
                composerK.w(objG3);
            }
            final MutableLongState mutableLongState2 = (MutableLongState) objG3;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = SnapshotLongStateKt.a(0L);
                composerK.w(objG4);
            }
            final MutableLongState mutableLongState3 = (MutableLongState) objG4;
            Unit unit = Unit.f139807a;
            boolean zF = composerK.f(jLongValue);
            Object objG5 = composerK.G();
            if (zF || objG5 == companion.a()) {
                objG5 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return EmergencyUnblockDeactivationCooldownScreenKt.t(jLongValue, mutableLongState2, mutableLongState3, (DisposableEffectScope) obj);
                    }
                };
                composerK.w(objG5);
            }
            EffectsKt.c(unit, (Function1) objG5, composerK, 6);
            Long lValueOf = Long.valueOf(r(mutableLongState3));
            Long lValueOf2 = Long.valueOf(jLongValue);
            boolean zI = ((i4 & 7168) == 2048) | composerK.I(animatable) | composerK.f(jLongValue);
            Object objG6 = composerK.G();
            if (zI || objG6 == companion.a()) {
                mutableLongState = mutableLongState2;
                EmergencyUnblockDeactivationCooldownScreenKt$EmergencyUnblockDeactivationCooldownScreen$2$1 emergencyUnblockDeactivationCooldownScreenKt$EmergencyUnblockDeactivationCooldownScreen$2$1 = new EmergencyUnblockDeactivationCooldownScreenKt$EmergencyUnblockDeactivationCooldownScreen$2$1(animatable, jLongValue, onCooldownFinished, mutableLongState, null);
                composerK.w(emergencyUnblockDeactivationCooldownScreenKt$EmergencyUnblockDeactivationCooldownScreen$2$1);
                objG6 = emergencyUnblockDeactivationCooldownScreenKt$EmergencyUnblockDeactivationCooldownScreen$2$1;
            } else {
                mutableLongState = mutableLongState2;
            }
            EffectsKt.f(lValueOf, lValueOf2, (Function2) objG6, composerK, 0);
            long j3 = 1000;
            long j4 = 60;
            long jP = (p(mutableLongState) / j3) / j4;
            long jP2 = (p(mutableLongState) / j3) % j4;
            StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
            final String str = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(jP), Long.valueOf(jP2)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(-2106023577, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.k
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return EmergencyUnblockDeactivationCooldownScreenKt.j(onKeepStrictModeActive, onCloseClicked, str, animatable, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 12582912, 127);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EmergencyUnblockDeactivationCooldownScreenKt.o(viewState, onCloseClicked, onKeepStrictModeActive, onCooldownFinished, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(final Function0 function0, final Function0 function02, final String str, final Animatable animatable, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2106023577, i3, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.screens.EmergencyUnblockDeactivationCooldownScreen.<anonymous> (EmergencyUnblockDeactivationCooldownScreen.kt:118)");
            }
            ScaffoldKt.a(SizeKt.f(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.c(WindowInsets.f7172a, composer, 6)), 0.0f, 1, null), null, null, ComposableLambdaKt.e(1343138785, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return EmergencyUnblockDeactivationCooldownScreenKt.k(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, Color.f25715b.j(), 0L, ComposableLambdaKt.e(-1772676887, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.n
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return EmergencyUnblockDeactivationCooldownScreenKt.m(function02, str, animatable, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 3072, 12779520, 98294);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(final Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1343138785, i3, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.screens.EmergencyUnblockDeactivationCooldownScreen.<anonymous>.<anonymous> (EmergencyUnblockDeactivationCooldownScreen.kt:190)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierK = PaddingKt.k(companion, Dp.g(16), 0.0f, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
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
            ButtonType.Big big = new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.li, composer, 0), 0.0f, 11, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(false, null, false, null, 15, null);
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.p
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EmergencyUnblockDeactivationCooldownScreenKt.l(function0);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.i0(null, big, accent, (Function0) objG, composer, 0, 1);
            SpacerKt.a(SizeKt.i(companion, Dp.g(32)), composer, 6);
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
    public static final Unit l(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(final Function0 function0, String str, Animatable animatable, PaddingValues paddingValues, Composer composer, int i3) throws XmlPullParserException, IOException {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(paddingValues) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1772676887, i4, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.screens.EmergencyUnblockDeactivationCooldownScreen.<anonymous>.<anonymous> (EmergencyUnblockDeactivationCooldownScreen.kt:124)");
            }
            Alignment.Companion companion = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion.g();
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierG = ScrollKt.g(PaddingKt.h(SizeKt.f(companion2, 0.0f, 1, null), paddingValues), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierG);
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
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6);
            Modifier modifierC = columnScopeInstance.c(companion2, companion.k());
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return EmergencyUnblockDeactivationCooldownScreenKt.n(function0);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.q0(modifierC, imageVectorB, null, false, 0.0f, 0.0f, 0L, null, (Function0) objG, composer, 0, 252);
            float f3 = 24;
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composer, 6);
            MeasurePolicy measurePolicyG = BoxKt.g(companion.o(), false);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, companion2);
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
            Updater.e(composerA2, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            ProgressIndicatorKt.a(((Number) animatable.n()).floatValue(), SizeKt.v(boxScopeInstance.f(companion2, companion.e()), Dp.g(124)), ComposeColorsKt.j(composer, 0).b(), Dp.g(4), ComposeColorsKt.j(composer, 0).f0(), StrokeCap.f25935b.b(), composer, 3072, 0);
            IconKt.a(PainterResources_androidKt.c(R.drawable.U5, composer, 0), null, boxScopeInstance.f(companion2, companion.e()), ComposeColorsKt.j(composer, 0).p(), composer, 48, 0);
            composer.y();
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composer, 6);
            String strB = StringResources_androidKt.b(R.string.i9, composer, 0);
            long jP = ComposeColorsKt.j(composer, 0).p();
            TextStyle textStyleF = ComposeTypographyKt.g(composer, 0).f();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            float f4 = 16;
            TextKt.c(strB, PaddingKt.k(columnScopeInstance.c(companion2, companion.g()), Dp.g(f4), 0.0f, 2, null), jP, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleF, composer, 0, 0, 65016);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f4)), composer, 6);
            TextKt.c(str, PaddingKt.k(columnScopeInstance.c(companion2, companion.g()), Dp.g(f4), 0.0f, 2, null), ComposeColorsKt.j(composer, 0).b(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, cz.mobilesoft.coreblock.view.compose.TextKt.d(ComposeTypographyKt.g(composer, 0).f()), composer, 0, 0, 65016);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f4)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.hd, composer, 0), PaddingKt.k(columnScopeInstance.c(companion2, companion.g()), Dp.g(f4), 0.0f, 2, null), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65016);
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
    public static final Unit n(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(EmergencyUnblockViewState emergencyUnblockViewState, Function0 function0, Function0 function02, Function0 function03, int i3, Composer composer, int i4) {
        i(emergencyUnblockViewState, function0, function02, function03, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long p(MutableLongState mutableLongState) {
        return mutableLongState.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(MutableLongState mutableLongState, long j3) {
        mutableLongState.t(j3);
    }

    private static final long r(MutableLongState mutableLongState) {
        return mutableLongState.d();
    }

    private static final void s(MutableLongState mutableLongState, long j3) {
        mutableLongState.t(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult t(final long j3, final MutableLongState mutableLongState, final MutableLongState mutableLongState2, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.o
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void j(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                EmergencyUnblockDeactivationCooldownScreenKt.u(j3, mutableLongState, mutableLongState2, lifecycleOwner, event);
            }
        };
        final Lifecycle lifecycle = ProcessLifecycleOwner.f40032j.a().getLifecycle();
        lifecycle.addObserver(lifecycleEventObserver);
        return new DisposableEffectResult() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.EmergencyUnblockDeactivationCooldownScreenKt$EmergencyUnblockDeactivationCooldownScreen$lambda$8$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                lifecycle.removeObserver(lifecycleEventObserver);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(long j3, MutableLongState mutableLongState, MutableLongState mutableLongState2, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            q(mutableLongState, j3);
            s(mutableLongState2, System.currentTimeMillis());
        }
    }
}
