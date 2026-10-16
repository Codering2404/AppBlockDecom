package cz.mobilesoft.coreblock.scene.intro.strictmode;

import android.content.Context;
import android.content.res.Configuration;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.window.AndroidPopup_androidKt;
import androidx.compose.ui.window.PopupProperties;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class StrictModeBlockingTestScreenKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f105008a;

        static {
            int[] iArr = new int[TestSteps.values().length];
            try {
                iArr[TestSteps.STEP1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TestSteps.STEP2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TestSteps.STEP3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TestSteps.STEP4.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[TestSteps.STEP5.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f105008a = iArr;
        }
    }

    public static final void i(Modifier modifier, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        Composer composerK = composer.k(95358495);
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
        if (composerK.r((i5 & 3) != 2, i5 & 1)) {
            modifier3 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(95358495, i5, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.AnimatedPointingArrow (StrictModeBlockingTestScreen.kt:240)");
            }
            final State stateA = InfiniteTransitionKt.a(InfiniteTransitionKt.c("arrowTransition", composerK, 6, 0), -10.0f, 10.0f, AnimationSpecKt.e(AnimationSpecKt.n(600, 0, EasingKt.e(), 2, null), RepeatMode.f4053b, 0L, 4, null), null, composerK, InfiniteTransition.f3967f | 384 | (InfiniteRepeatableSpec.f3963d << 9), 8);
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.bb, composerK, 6);
            boolean Z = composerK.Z(stateA);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.u
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictModeBlockingTestScreenKt.k(stateA, (GraphicsLayerScope) obj);
                    }
                };
                composerK.w(objG);
            }
            ImageKt.b(imageVectorB, null, GraphicsLayerModifierKt.a(modifier3, (Function1) objG), null, null, 0.0f, null, composerK, 48, 120);
            composerK = composerK;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeBlockingTestScreenKt.l(modifier3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float j(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(State state, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.d(j(state));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Modifier modifier, int i3, int i4, Composer composer, int i5) {
        i(modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void m(Function0 onContinueClicked, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Composer composer2;
        MutableState mutableState;
        Intrinsics.checkNotNullParameter(onContinueClicked, "onContinueClicked");
        Composer composerK = composer.k(-32213477);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.I(onContinueClicked) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-32213477, i4, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeBlockingTestScreen (StrictModeBlockingTestScreen.kt:60)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            MutableState mutableState2 = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e("", null, 2, null);
                composerK.w(objG2);
            }
            MutableState mutableState3 = (MutableState) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotIntStateKt.a(R.drawable.Ta);
                composerK.w(objG3);
            }
            final MutableIntState mutableIntState = (MutableIntState) objG3;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG4);
            }
            final MutableState mutableState4 = (MutableState) objG4;
            Object objG5 = composerK.G();
            if (objG5 == companion.a()) {
                objG5 = SnapshotStateKt__SnapshotStateKt.e(TestSteps.STEP1, null, 2, null);
                composerK.w(objG5);
            }
            MutableState mutableState5 = (MutableState) objG5;
            Object value = mutableState5.getValue();
            boolean zI = composerK.I(context);
            Object objG6 = composerK.G();
            if (zI || objG6 == companion.a()) {
                objG6 = new StrictModeBlockingTestScreenKt$StrictModeBlockingTestScreen$1$1(mutableState5, mutableState3, context, mutableIntState, mutableState4, null);
                mutableState = mutableState5;
                composerK.w(objG6);
            } else {
                mutableState = mutableState5;
            }
            EffectsKt.g(value, (Function2) objG6, composerK, 0);
            Unit unit = Unit.f139807a;
            Object objG7 = composerK.G();
            if (objG7 == companion.a()) {
                objG7 = new StrictModeBlockingTestScreenKt$StrictModeBlockingTestScreen$2$1(mutableState, mutableState2, null);
                composerK.w(objG7);
            }
            EffectsKt.g(unit, (Function2) objG7, composerK, 6);
            Modifier.Companion companion2 = Modifier.b8;
            Modifier modifierF = SizeKt.f(companion2, 0.0f, 1, null);
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
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
            Updater.e(composerA, measurePolicyG, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion4.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            SpacerKt.a(SizeKt.v(companion2, Dp.g(24)), composerK, 6);
            Modifier modifierF3 = boxScopeInstance.f(PaddingKt.k(SizeKt.i(SizeKt.h(companion2, 0.0f, 1, null), Dp.g(150)), Dp.g(16), 0.0f, 2, null), companion3.m());
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), companion3.k(), composerK, 6);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF4 = ComposedModifierKt.f(composerK, modifierF3);
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
            Updater.e(composerA2, measurePolicyA, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF4, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            final MutableState mutableState6 = mutableState;
            TextKt.c((String) mutableState3.getValue(), SizeKt.h(companion2, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).f(), composerK, 48, 0, 65016);
            composerK.y();
            boolean zN = n(mutableState2);
            TweenSpec tweenSpecN = AnimationSpecKt.n(500, 0, null, 6, null);
            Object objG8 = composerK.G();
            if (objG8 == companion.a()) {
                objG8 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Integer.valueOf(StrictModeBlockingTestScreenKt.q(((Integer) obj).intValue()));
                    }
                };
                composerK.w(objG8);
            }
            function0 = onContinueClicked;
            AnimatedVisibilityKt.j(zN, boxScopeInstance.f(PaddingKt.m(SizeKt.f(companion2, 0.0f, 1, null), 0.0f, Dp.g(120), 0.0f, 0.0f, 13, null), companion3.b()), EnterExitTransitionKt.E(tweenSpecN, (Function1) objG8).c(EnterExitTransitionKt.o(AnimationSpecKt.n(500, 0, null, 6, null), 0.0f, 2, null)), null, null, ComposableLambdaKt.e(-1544158855, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.p
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return StrictModeBlockingTestScreenKt.r(mutableState4, mutableIntState, mutableState6, function0, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 196608, 24);
            composer2 = composerK;
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onContinueClicked;
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictModeBlockingTestScreenKt.o(function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean n(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Function0 function0, int i3, Composer composer, int i4) {
        m(function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(final MutableState mutableState, MutableIntState mutableIntState, final MutableState mutableState2, final Function0 function0, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        int i4;
        Modifier.Companion companion;
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(-1544158855, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeBlockingTestScreen.<anonymous>.<anonymous> (StrictModeBlockingTestScreen.kt:138)");
        }
        Modifier.Companion companion2 = Modifier.b8;
        Modifier modifierK = PaddingKt.k(SizeKt.f(companion2, 0.0f, 1, null), Dp.g(16), 0.0f, 2, null);
        Alignment.Companion companion3 = Alignment.f25072a;
        MeasurePolicy measurePolicyG = BoxKt.g(companion3.o(), false);
        int iA = ComposablesKt.a(composer, 0);
        CompositionLocalMap compositionLocalMapU = composer.u();
        Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
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
        Updater.e(composerA, measurePolicyG, companion4.e());
        Updater.e(composerA, compositionLocalMapU, companion4.g());
        Function2 function2B = companion4.b();
        if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
            composerA.w(Integer.valueOf(iA));
            composerA.p(Integer.valueOf(iA), function2B);
        }
        Updater.e(composerA, modifierF, companion4.f());
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
        Density density = (Density) composer.q(CompositionLocalsKt.f());
        final long jF = IntOffset.f((((long) ((int) (density.M1(Dp.g(((Configuration) composer.q(AndroidCompositionLocals_androidKt.f())).screenWidthDp)) / 2))) << 32) | (((long) ((int) density.M1(Dp.g(88)))) & 4294967295L));
        AnimatedVisibilityKt.j(((Boolean) mutableState.getValue()).booleanValue(), null, EnterExitTransitionKt.o(AnimationSpecKt.n(1500, 0, null, 6, null), 0.0f, 2, null), EnterExitTransitionKt.q(AnimationSpecKt.n(500, 0, null, 6, null), 0.0f, 2, null), null, ComposableLambdaKt.e(256314199, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.r
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return StrictModeBlockingTestScreenKt.s(jF, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 200064, 18);
        Composer composer2 = composer;
        Painter painterC = PainterResources_androidKt.c(mutableIntState.g(), composer2, 0);
        Modifier modifierF2 = SizeKt.f(companion2, 0.0f, 1, null);
        Object value = mutableState2.getValue();
        TestSteps testSteps = TestSteps.STEP3;
        boolean z2 = value == testSteps;
        Object objG = composer2.G();
        Composer.Companion companion5 = Composer.f23746a;
        if (objG == companion5.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.s
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StrictModeBlockingTestScreenKt.t(mutableState2, mutableState);
                }
            };
            composer2.w(objG);
        }
        ImageKt.a(painterC, null, ClickableKt.f(modifierF2, z2, null, null, (Function0) objG, 6, null), null, null, 0.0f, null, composer2, 48, 120);
        Modifier modifierF3 = boxScopeInstance.f(SizeKt.h(companion2, 0.0f, 1, null), companion3.b());
        Arrangement arrangement = Arrangement.f6574a;
        MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), companion3.k(), composer2, 0);
        int iA2 = ComposablesKt.a(composer2, 0);
        CompositionLocalMap compositionLocalMapU2 = composer2.u();
        Modifier modifierF4 = ComposedModifierKt.f(composer2, modifierF3);
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
        Updater.e(composerA2, measurePolicyA, companion4.e());
        Updater.e(composerA2, compositionLocalMapU2, companion4.g());
        Function2 function2B2 = companion4.b();
        if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
            composerA2.w(Integer.valueOf(iA2));
            composerA2.p(Integer.valueOf(iA2), function2B2);
        }
        Updater.e(composerA2, modifierF4, companion4.f());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
        BoxKt.a(BackgroundKt.b(SizeKt.i(SizeKt.h(companion2, 0.0f, 1, null), Dp.g(24)), Brush.Companion.m(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.n(Color.r(ComposeColorsKt.j(composer2, 0).e(), 0.0f, 0.0f, 0.0f, 0.0f, 14, null)), Color.n(ComposeColorsKt.j(composer2, 0).e())}), 0.0f, 0.0f, 0, 14, null), null, 0.0f, 6, null), composer2, 0);
        Modifier modifierD = BackgroundKt.d(SizeKt.h(companion2, 0.0f, 1, null), ComposeColorsKt.j(composer2, 0).e(), null, 2, null);
        MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion3.g(), composer2, 48);
        int iA3 = ComposablesKt.a(composer2, 0);
        CompositionLocalMap compositionLocalMapU3 = composer2.u();
        Modifier modifierF5 = ComposedModifierKt.f(composer2, modifierD);
        Function0 function0A3 = companion4.a();
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
        Updater.e(composerA3, measurePolicyA2, companion4.e());
        Updater.e(composerA3, compositionLocalMapU3, companion4.g());
        Function2 function2B3 = companion4.b();
        if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
            composerA3.w(Integer.valueOf(iA3));
            composerA3.p(Integer.valueOf(iA3), function2B3);
        }
        Updater.e(composerA3, modifierF5, companion4.f());
        if (mutableState2.getValue() == testSteps) {
            composer2.a0(1360830224);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(8)), composer2, 6);
            i4 = 8;
            companion = companion2;
            TextKt.c(StringResources_androidKt.b(R.string.Fy, composer2, 0), SizeKt.h(companion2, 0.0f, 1, null), ComposeColorsKt.j(composer2, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).b(), composer, 48, 0, 65016);
            composer2 = composer;
        } else {
            i4 = 8;
            companion = companion2;
            composer2.a0(1352242263);
        }
        composer2.U();
        SpacerKt.a(SizeKt.i(companion, Dp.g(i4)), composer2, 6);
        String strB = StringResources_androidKt.b(R.string.l8, composer2, 0);
        boolean Z = composer2.Z(function0);
        Object objG2 = composer2.G();
        if (Z || objG2 == companion5.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.intro.strictmode.t
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return StrictModeBlockingTestScreenKt.u(mutableState2, function0);
                }
            };
            composer2.w(objG2);
        }
        ComposeButtonsKt.J(null, strB, false, false, null, (Function0) objG2, composer2, 3072, 21);
        composer.y();
        composer.y();
        composer.y();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(long j3, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(256314199, i3, -1, "cz.mobilesoft.coreblock.scene.intro.strictmode.StrictModeBlockingTestScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (StrictModeBlockingTestScreen.kt:158)");
        }
        AndroidPopup_androidKt.c(null, j3, null, new PopupProperties(false, false, false, false, 14, (DefaultConstructorMarker) null), ComposableSingletons$StrictModeBlockingTestScreenKt.f104982a.b(), composer, 27648, 5);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(MutableState mutableState, MutableState mutableState2) {
        mutableState.setValue(TestSteps.STEP4);
        mutableState2.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(MutableState mutableState, Function0 function0) {
        int i3 = WhenMappings.f105008a[((TestSteps) mutableState.getValue()).ordinal()];
        if (i3 == 1) {
            mutableState.setValue(TestSteps.STEP2);
        } else if (i3 == 2) {
            mutableState.setValue(TestSteps.STEP3);
        } else if (i3 == 3) {
            mutableState.setValue(TestSteps.STEP4);
        } else if (i3 == 4) {
            mutableState.setValue(TestSteps.STEP5);
        } else {
            if (i3 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            function0.invoke();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int q(int i3) {
        return i3;
    }
}
