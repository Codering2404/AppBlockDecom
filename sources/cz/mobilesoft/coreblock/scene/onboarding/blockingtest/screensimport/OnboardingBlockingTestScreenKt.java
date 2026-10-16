package cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport;

import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.applovin.sdk.AppLovinErrorCodes;
import com.facebook.ads.AdError;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.BlockingTestAppIcon;
import cz.mobilesoft.coreblock.enums.BlockingTestRotatingScreens;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.scene.lockscreen.LockScreenKt;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewEvent;
import cz.mobilesoft.coreblock.scene.lockscreen.LockViewState;
import cz.mobilesoft.coreblock.storage.room.entity.core.ConfigType;
import cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.StringHelperExtKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
public final class OnboardingBlockingTestScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(boolean z2, long j3, int i3, Composer composer, int i4) {
        x(z2, j3, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void B(final java.lang.String r30, final boolean r31, androidx.compose.ui.Modifier r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instruction units count: 655
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.OnboardingBlockingTestScreenKt.B(java.lang.String, boolean, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ContentTransform C(AnimatedContentTransitionScope AnimatedContent) {
        Intrinsics.checkNotNullParameter(AnimatedContent, "$this$AnimatedContent");
        return AnimatedContent.b(AnimatedContentKt.f(EnterExitTransitionKt.o(AnimationSpecKt.n(300, 150, null, 4, null), 0.0f, 2, null), EnterExitTransitionKt.q(AnimationSpecKt.n(150, 0, null, 6, null), 0.0f, 2, null)), AnimatedContentKt.c(false, new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.k
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return OnboardingBlockingTestScreenKt.D((IntSize) obj, (IntSize) obj2);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec D(IntSize intSize, IntSize intSize2) {
        return AnimationSpecKt.j(0, 1, null);
    }

    private static final float E(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(String str, boolean z2, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        B(str, z2, modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void G(Function0 function0, Composer composer, final int i3, final int i4) {
        final Function0 function02;
        int i5;
        Composer composer2;
        final Function0 function03;
        MutableIntState mutableIntState;
        Integer num;
        HapticFeedback hapticFeedback;
        final MutableState mutableState;
        final MutableState mutableState2;
        boolean z2;
        String strB;
        Composer composerK = composer.k(-364109333);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            function02 = function0;
        } else if ((i3 & 6) == 0) {
            function02 = function0;
            i5 = (composerK.I(function02) ? 4 : 2) | i3;
        } else {
            function02 = function0;
            i5 = i3;
        }
        if (composerK.r((i5 & 3) != 2, i5 & 1)) {
            if (i6 != 0) {
                Object objG = composerK.G();
                if (objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.p
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OnboardingBlockingTestScreenKt.H();
                        }
                    };
                    composerK.w(objG);
                }
                function03 = (Function0) objG;
            } else {
                function03 = function02;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(-364109333, i5, -1, "cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.OnboardingBlockingTestScreen (OnboardingBlockingTestScreen.kt:101)");
            }
            HapticFeedback hapticFeedback2 = (HapticFeedback) composerK.q(CompositionLocalsKt.k());
            Object objG2 = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            MutableState mutableState3 = (MutableState) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG3);
            }
            final MutableState mutableState4 = (MutableState) objG3;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG4);
            }
            final MutableState mutableState5 = (MutableState) objG4;
            Object objG5 = composerK.G();
            if (objG5 == companion.a()) {
                objG5 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG5);
            }
            final MutableState mutableState6 = (MutableState) objG5;
            Object objG6 = composerK.G();
            if (objG6 == companion.a()) {
                objG6 = SnapshotIntStateKt.a(R.string.p4);
                composerK.w(objG6);
            }
            MutableIntState mutableIntState2 = (MutableIntState) objG6;
            Object objG7 = composerK.G();
            if (objG7 == companion.a()) {
                objG7 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG7);
            }
            final MutableState mutableState7 = (MutableState) objG7;
            Object objG8 = composerK.G();
            if (objG8 == companion.a()) {
                objG8 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG8);
            }
            final MutableState mutableState8 = (MutableState) objG8;
            Object objG9 = composerK.G();
            if (objG9 == companion.a()) {
                objG9 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG9);
            }
            MutableState mutableState9 = (MutableState) objG9;
            Object objG10 = composerK.G();
            if (objG10 == companion.a()) {
                objG10 = SnapshotStateKt__SnapshotStateKt.e(Offset.d(Offset.f25596b.c()), null, 2, null);
                composerK.w(objG10);
            }
            MutableState mutableState10 = (MutableState) objG10;
            Object objG11 = composerK.G();
            if (objG11 == companion.a()) {
                objG11 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG11);
            }
            final MutableState mutableState11 = (MutableState) objG11;
            Object objG12 = composerK.G();
            if (objG12 == companion.a()) {
                objG12 = AnimatableKt.b(1.0f, 0.0f, 2, null);
                composerK.w(objG12);
            }
            Animatable animatable = (Animatable) objG12;
            Unit unit = Unit.f139807a;
            boolean zI = composerK.I(hapticFeedback2);
            Object objG13 = composerK.G();
            if (zI || objG13 == companion.a()) {
                objG13 = new OnboardingBlockingTestScreenKt$OnboardingBlockingTestScreen$2$1(hapticFeedback2, mutableState3, null);
                composerK.w(objG13);
            }
            EffectsKt.g(unit, (Function2) objG13, composerK, 6);
            State stateD = AnimateAsStateKt.d(((Boolean) mutableState5.getValue()).booleanValue() ? 1.5f : 1.0f, AnimationSpecKt.n(1500, 0, null, 6, null), 0.0f, "scale", null, composerK, 3120, 20);
            Boolean boolValueOf = Boolean.valueOf(M(mutableState11));
            boolean zI2 = composerK.I(animatable) | composerK.I(hapticFeedback2);
            Object objG14 = composerK.G();
            if (zI2 || objG14 == companion.a()) {
                objG14 = new OnboardingBlockingTestScreenKt$OnboardingBlockingTestScreen$3$1(mutableState7, mutableState8, animatable, mutableIntState2, hapticFeedback2, mutableState11, null);
                mutableIntState = mutableIntState2;
                composerK.w(objG14);
            } else {
                mutableIntState = mutableIntState2;
            }
            EffectsKt.g(boolValueOf, (Function2) objG14, composerK, 0);
            Integer numValueOf = Integer.valueOf(mutableIntState.g());
            boolean zI3 = composerK.I(hapticFeedback2);
            Object objG15 = composerK.G();
            if (zI3 || objG15 == companion.a()) {
                num = numValueOf;
                OnboardingBlockingTestScreenKt$OnboardingBlockingTestScreen$4$1 onboardingBlockingTestScreenKt$OnboardingBlockingTestScreen$4$1 = new OnboardingBlockingTestScreenKt$OnboardingBlockingTestScreen$4$1(mutableIntState, hapticFeedback2, mutableState7, mutableState11, null);
                hapticFeedback = hapticFeedback2;
                composerK.w(onboardingBlockingTestScreenKt$OnboardingBlockingTestScreen$4$1);
                objG15 = onboardingBlockingTestScreenKt$OnboardingBlockingTestScreen$4$1;
            } else {
                hapticFeedback = hapticFeedback2;
                num = numValueOf;
            }
            EffectsKt.g(num, (Function2) objG15, composerK, 0);
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
            final MutableIntState mutableIntState3 = mutableIntState;
            B(StringResources_androidKt.c(mutableIntState.g(), new Object[]{"Instagram"}, composerK, 0), M(mutableState11), AlphaKt.a(companion2, ((Number) animatable.n()).floatValue()), composerK, 0, 0);
            boolean zN = N(mutableState3);
            float fP = P(stateD);
            boolean zV = V(mutableState4);
            Object objG16 = composerK.G();
            if (objG16 == companion.a()) {
                mutableState = mutableState9;
                objG16 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.r
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OnboardingBlockingTestScreenKt.Q(mutableState6, mutableState5, mutableIntState3, mutableState);
                    }
                };
                composerK.w(objG16);
            } else {
                mutableState = mutableState9;
            }
            Function0 function04 = (Function0) objG16;
            Object objG17 = composerK.G();
            if (objG17 == companion.a()) {
                mutableState2 = mutableState10;
                objG17 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.s
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingBlockingTestScreenKt.R(mutableState2, (Offset) obj);
                    }
                };
                composerK.w(objG17);
            } else {
                mutableState2 = mutableState10;
            }
            final MutableState mutableState12 = mutableState;
            final HapticFeedback hapticFeedback3 = hapticFeedback;
            int i7 = i5;
            g0(zN, mutableState5, fP, zV, mutableState6, mutableState7, mutableState8, function04, (Function1) objG17, composerK, 115040304);
            composer2 = composerK;
            x(((Boolean) mutableState6.getValue()).booleanValue(), K(mutableState2), composer2, 0);
            if (mutableIntState3.g() != R.string.v4) {
                composer2.a0(1058602904);
                Modifier modifierF3 = boxScopeInstance.f(SizeKt.h(companion2, 0.0f, 1, null), companion3.b());
                Alignment.Horizontal horizontalG = companion3.g();
                Arrangement arrangement = Arrangement.f6574a;
                MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composer2, 48);
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
                boolean zBooleanValue = ((Boolean) mutableState6.getValue()).booleanValue();
                EnterTransition enterTransitionC = EnterExitTransitionKt.o(AnimationSpecKt.n(500, 500, null, 4, null), 0.0f, 2, null).c(EnterExitTransitionKt.s(null, 0.0f, 0L, 7, null));
                ExitTransition exitTransitionC = EnterExitTransitionKt.q(null, 0.0f, 3, null).c(EnterExitTransitionKt.u(null, 0.0f, 0L, 7, null));
                float f3 = 8;
                Modifier modifierM = PaddingKt.m(companion2, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null);
                ComposableSingletons$OnboardingBlockingTestScreenKt composableSingletons$OnboardingBlockingTestScreenKt = ComposableSingletons$OnboardingBlockingTestScreenKt.f111072a;
                AnimatedVisibilityKt.g(columnScopeInstance, zBooleanValue, modifierM, enterTransitionC, exitTransitionC, null, composableSingletons$OnboardingBlockingTestScreenKt.g(), composer2, 1600902, 16);
                AnimatedVisibilityKt.g(columnScopeInstance, ((Boolean) mutableState8.getValue()).booleanValue(), PaddingKt.m(companion2, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null), EnterExitTransitionKt.o(AnimationSpecKt.n(500, 500, null, 4, null), 0.0f, 2, null), EnterExitTransitionKt.q(null, 0.0f, 3, null), null, composableSingletons$OnboardingBlockingTestScreenKt.e(), composer2, 1600902, 16);
                Modifier modifierM2 = PaddingKt.m(companion2, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null);
                if (!((Boolean) mutableState7.getValue()).booleanValue() || ((Boolean) mutableState8.getValue()).booleanValue()) {
                    z2 = false;
                    composer2.a0(829159228);
                    strB = StringResources_androidKt.b(R.string.l8, composer2, 0);
                    composer2.U();
                } else {
                    composer2.a0(829058757);
                    z2 = false;
                    strB = StringResources_androidKt.b(R.string.Ve, composer2, 0);
                    composer2.U();
                }
                String str = strB;
                boolean zI4 = composer2.I(hapticFeedback3) | ((i7 & 14) == 4 ? true : z2);
                Object objG18 = composer2.G();
                if (zI4 || objG18 == companion.a()) {
                    objG18 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.t
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return OnboardingBlockingTestScreenKt.S(mutableIntState3, mutableState5, mutableState6, mutableState7, mutableState8, function03, hapticFeedback3, mutableState4, mutableState12, mutableState11);
                        }
                    };
                    composer2.w(objG18);
                }
                ComposeButtonsKt.J(modifierM2, str, false, false, null, (Function0) objG18, composer2, 6, 28);
                composer2 = composer2;
                composer2.y();
                composer2.y();
            } else {
                composer2.a0(1049937629);
            }
            composer2.U();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            function02 = function03;
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingBlockingTestScreenKt.T(function02, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H() {
        return Unit.f139807a;
    }

    private static final boolean I(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void J(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    private static final long K(MutableState mutableState) {
        return ((Offset) mutableState.getValue()).u();
    }

    private static final void L(MutableState mutableState, long j3) {
        mutableState.setValue(Offset.d(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean M(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final boolean N(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void O(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    private static final float P(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(MutableState mutableState, MutableState mutableState2, MutableIntState mutableIntState, MutableState mutableState3) {
        Y(mutableState, mutableState2, mutableIntState, mutableState3);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(MutableState mutableState, Offset offset) {
        L(mutableState, offset.u());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(MutableIntState mutableIntState, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, Function0 function0, HapticFeedback hapticFeedback, MutableState mutableState5, MutableState mutableState6, MutableState mutableState7) {
        Z(mutableIntState, mutableState, mutableState2, mutableState3, mutableState4, function0, hapticFeedback, mutableState5, mutableState6, mutableState7);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(Function0 function0, int i3, int i4, Composer composer, int i5) {
        G(function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    private static final boolean V(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void W(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(MutableIntState mutableIntState, MutableState mutableState, MutableState mutableState2) {
        mutableIntState.a(R.string.Kl);
        mutableState.setValue(Boolean.TRUE);
        O(mutableState2, true);
    }

    private static final void Y(MutableState mutableState, MutableState mutableState2, MutableIntState mutableIntState, MutableState mutableState3) {
        Boolean bool = Boolean.FALSE;
        mutableState.setValue(bool);
        mutableState2.setValue(bool);
        mutableIntState.a(R.string.v4);
        J(mutableState3, true);
    }

    private static final void Z(MutableIntState mutableIntState, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, Function0 function0, HapticFeedback hapticFeedback, MutableState mutableState5, MutableState mutableState6, MutableState mutableState7) {
        if (!V(mutableState5)) {
            W(mutableState5, true);
            mutableIntState.a(R.string.m4);
        } else if (!((Boolean) mutableState.getValue()).booleanValue() && !I(mutableState6)) {
            Boolean bool = Boolean.TRUE;
            mutableState.setValue(bool);
            mutableState2.setValue(bool);
            mutableIntState.a(R.string.r4);
        } else if (((Boolean) mutableState2.getValue()).booleanValue()) {
            Y(mutableState2, mutableState, mutableIntState, mutableState6);
        } else if (!((Boolean) mutableState3.getValue()).booleanValue() && I(mutableState6)) {
            X(mutableIntState, mutableState3, mutableState7);
        } else if (!((Boolean) mutableState3.getValue()).booleanValue()) {
            mutableState3.setValue(Boolean.TRUE);
        } else if (((Boolean) mutableState4.getValue()).booleanValue()) {
            function0.invoke();
        } else {
            O(mutableState7, false);
        }
        hapticFeedback.a(HapticFeedbackType.f26611b.a());
    }

    private static final void a0(final boolean z2, final MutableState mutableState, final Function0 function0, final Function1 function1, Composer composer, final int i3) {
        int i4;
        MutableState mutableState2;
        Composer composer2;
        Composer composerK = composer.k(1419805256);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            mutableState2 = mutableState;
            i4 |= composerK.Z(mutableState2) ? 32 : 16;
        } else {
            mutableState2 = mutableState;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function0) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function1) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1419805256, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.PhoneAppGrid (OnboardingBlockingTestScreen.kt:482)");
            }
            final HapticFeedback hapticFeedback = (HapticFeedback) composerK.q(CompositionLocalsKt.k());
            GridCells.Fixed fixed = new GridCells.Fixed(5);
            float f3 = 24;
            float f4 = 16;
            Modifier modifierL = PaddingKt.l(SizeKt.f(Modifier.b8, 0.0f, 1, null), Dp.g(20), Dp.g(40), Dp.g(f3), Dp.g(f4));
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = InteractionSourceKt.a();
                composerK.w(objG);
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objG;
            boolean zBooleanValue = ((Boolean) mutableState2.getValue()).booleanValue();
            boolean zI = composerK.I(hapticFeedback) | ((i4 & 896) == 256);
            Object objG2 = composerK.G();
            if (zI || objG2 == companion.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.n
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OnboardingBlockingTestScreenKt.b0(hapticFeedback, function0);
                    }
                };
                composerK.w(objG2);
            }
            Modifier modifierD = ClickableKt.d(modifierL, mutableInteractionSource, null, zBooleanValue, null, null, (Function0) objG2, 24, null);
            PaddingValues paddingValuesB = PaddingKt.b(Dp.g(f3), Dp.g(f3));
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement.o(Dp.g(f4));
            Arrangement.HorizontalOrVertical horizontalOrVerticalO2 = arrangement.o(Dp.g(f4));
            boolean z3 = ((i4 & 14) == 4) | ((i4 & 7168) == 2048);
            Object objG3 = composerK.G();
            if (z3 || objG3 == companion.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingBlockingTestScreenKt.c0(z2, function1, (LazyGridScope) obj);
                    }
                };
                composerK.w(objG3);
            }
            composer2 = composerK;
            LazyGridDslKt.c(fixed, modifierD, null, paddingValuesB, false, horizontalOrVerticalO, horizontalOrVerticalO2, null, false, null, (Function1) objG3, composer2, 1772544, 0, 916);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingBlockingTestScreenKt.d0(z2, mutableState, function0, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0(HapticFeedback hapticFeedback, Function0 function0) {
        hapticFeedback.a(HapticFeedbackType.f26611b.a());
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(final boolean z2, final Function1 function1, LazyGridScope LazyVerticalGrid) {
        Intrinsics.checkNotNullParameter(LazyVerticalGrid, "$this$LazyVerticalGrid");
        final EnumEntries<BlockingTestAppIcon> entries = BlockingTestAppIcon.getEntries();
        final OnboardingBlockingTestScreenKt$PhoneAppGrid$lambda$2$0$$inlined$items$default$1 onboardingBlockingTestScreenKt$PhoneAppGrid$lambda$2$0$$inlined$items$default$1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.OnboardingBlockingTestScreenKt$PhoneAppGrid$lambda$2$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Object obj) {
                return null;
            }
        };
        LazyVerticalGrid.g(entries.size(), null, null, new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.OnboardingBlockingTestScreenKt$PhoneAppGrid$lambda$2$0$$inlined$items$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i3) {
                return onboardingBlockingTestScreenKt$PhoneAppGrid$lambda$2$0$$inlined$items$default$1.invoke(entries.get(i3));
            }
        }, ComposableLambdaKt.c(699646206, true, new Function4<LazyGridItemScope, Integer, Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.OnboardingBlockingTestScreenKt$PhoneAppGrid$lambda$2$0$$inlined$items$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                invoke((LazyGridItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                return Unit.f139807a;
            }

            public final void invoke(LazyGridItemScope lazyGridItemScope, int i3, Composer composer, int i4) {
                int i5;
                if ((i4 & 6) == 0) {
                    i5 = (composer.Z(lazyGridItemScope) ? 4 : 2) | i4;
                } else {
                    i5 = i4;
                }
                if ((i4 & 48) == 0) {
                    i5 |= composer.e(i3) ? 32 : 16;
                }
                if (!composer.r((i5 & 147) != 146, i5 & 1)) {
                    composer.Q();
                    return;
                }
                if (ComposerKt.M()) {
                    ComposerKt.U(699646206, i5, -1, "androidx.compose.foundation.lazy.grid.items.<anonymous> (LazyGridDsl.kt:542)");
                }
                BlockingTestAppIcon blockingTestAppIcon = (BlockingTestAppIcon) entries.get(i3);
                composer.a0(969537840);
                final boolean z3 = blockingTestAppIcon == BlockingTestAppIcon.Instagram;
                Modifier modifierA = AlphaKt.a(Modifier.b8, (!z2 || z3) ? 1.0f : 0.3f);
                boolean zB = composer.b(z3) | composer.Z(function1);
                Object objG = composer.G();
                if (zB || objG == Composer.f23746a.a()) {
                    final Function1 function12 = function1;
                    objG = new Function1<LayoutCoordinates, Unit>() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.OnboardingBlockingTestScreenKt$PhoneAppGrid$3$1$1$1$1
                        public final void c(LayoutCoordinates coordinates) {
                            Intrinsics.checkNotNullParameter(coordinates, "coordinates");
                            if (z3) {
                                function12.invoke(Offset.d(LayoutCoordinatesKt.f(coordinates)));
                            }
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            c((LayoutCoordinates) obj);
                            return Unit.f139807a;
                        }
                    };
                    composer.w(objG);
                }
                OnboardingBlockingTestScreenKt.v(blockingTestAppIcon, OnGloballyPositionedModifierKt.a(modifierA, (Function1) objG), composer, 0, 0);
                composer.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(boolean z2, MutableState mutableState, Function0 function0, Function1 function1, int i3, Composer composer, int i4) {
        a0(z2, mutableState, function0, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void e0(final BoxScope boxScope, final boolean z2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1528104252);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(boxScope) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1528104252, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.PhoneBackground (OnboardingBlockingTestScreen.kt:456)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 24;
            float f4 = 12;
            float f5 = 16;
            float f6 = 40;
            BoxKt.a(BackgroundKt.d(ClipKt.a(PaddingKt.l(boxScope.h(companion), Dp.g(f3), Dp.g(f4), Dp.g(f3), Dp.g(f5)), RoundedCornerShapeKt.d(Dp.g(f6))), Color.f25715b.a(), null, 2, null), composerK, 0);
            BoxKt.a(BackgroundKt.b(ClipKt.a(PaddingKt.l(SizeKt.f(companion, 0.0f, 1, null), Dp.g(f3), Dp.g(f4), Dp.g(f3), Dp.g(f5)), RoundedCornerShapeKt.d(Dp.g(f6))), Brush.Companion.m(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.n(ColorKt.d(4281308927L)), Color.n(ColorKt.d(4281291007L))}), 0.0f, 0.0f, 0, 14, null), null, z2 ? 0.2f : 1.0f, 2, null), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingBlockingTestScreenKt.f0(boxScope, z2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(BoxScope boxScope, boolean z2, int i3, Composer composer, int i4) {
        e0(boxScope, z2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void g0(final boolean z2, final MutableState mutableState, final float f3, final boolean z3, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final Function0 function0, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1404758747);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(mutableState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.c(f3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.b(z3) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.Z(mutableState2) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= composerK.Z(mutableState3) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if ((1572864 & i3) == 0) {
            i4 |= composerK.Z(mutableState4) ? 1048576 : 524288;
        }
        if ((12582912 & i3) == 0) {
            i4 |= composerK.I(function0) ? 8388608 : 4194304;
        }
        if ((100663296 & i3) == 0) {
            i4 |= composerK.I(function1) ? 67108864 : 33554432;
        }
        if (composerK.r((38347923 & i4) != 38347922, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1404758747, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.PhoneContent (OnboardingBlockingTestScreen.kt:349)");
            }
            int i5 = i4;
            final State stateC = AnimateAsStateKt.c(Dp.g(((Boolean) mutableState.getValue()).booleanValue() ? 160 : 80), AnimationSpecKt.n(1500, 0, null, 6, null), "offsetY", null, composerK, 432, 8);
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierM = PaddingKt.m(SizeKt.f(companion, 0.0f, 1, null), 0.0f, Dp.g(80), 0.0f, 0.0f, 13, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.b(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierM);
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
            TweenSpec tweenSpecN = AnimationSpecKt.n(AdError.SERVER_ERROR_CODE, 0, null, 6, null);
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.f
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Integer.valueOf(OnboardingBlockingTestScreenKt.h0(((Integer) obj).intValue()));
                    }
                };
                composerK.w(objG);
            }
            AnimatedVisibilityKt.j(z2, SizeKt.f(companion, 0.0f, 1, null), EnterExitTransitionKt.E(tweenSpecN, (Function1) objG).c(EnterExitTransitionKt.o(AnimationSpecKt.n(AdError.SERVER_ERROR_CODE, 0, null, 6, null), 0.0f, 2, null)), null, null, ComposableLambdaKt.e(-1896980601, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.g
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OnboardingBlockingTestScreenKt.i0(stateC, f3, mutableState3, z3, mutableState2, function0, function1, mutableState4, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, (i5 & 14) | 196656, 24);
            composerK = composerK;
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingBlockingTestScreenKt.n0(z2, mutableState, f3, z3, mutableState2, mutableState3, mutableState4, function0, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(State state, final float f3, MutableState mutableState, boolean z2, MutableState mutableState2, Function0 function0, Function1 function1, MutableState mutableState3, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        String blockedAppText;
        CustomBlockingScreenConfigEntity customBlockingScreenEntity;
        String counterText;
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(-1896980601, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.PhoneContent.<anonymous>.<anonymous> (OnboardingBlockingTestScreen.kt:369)");
        }
        Modifier.Companion companion = Modifier.b8;
        Modifier modifierD = OffsetKt.d(SizeKt.f(companion, 0.0f, 1, null), 0.0f, ((Dp) state.getValue()).l(), 1, null);
        boolean zC = composer.c(f3);
        Object objG = composer.G();
        if (zC || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OnboardingBlockingTestScreenKt.j0(f3, (GraphicsLayerScope) obj);
                }
            };
            composer.w(objG);
        }
        Modifier modifierA = GraphicsLayerModifierKt.a(modifierD, (Function1) objG);
        float f4 = 40;
        Modifier modifierA2 = ClipKt.a(modifierA, RoundedCornerShapeKt.d(Dp.g(f4)));
        Alignment.Companion companion2 = Alignment.f25072a;
        MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
        int iA = ComposablesKt.a(composer, 0);
        CompositionLocalMap compositionLocalMapU = composer.u();
        Modifier modifierF = ComposedModifierKt.f(composer, modifierA2);
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
        if (((Boolean) mutableState.getValue()).booleanValue()) {
            composer.a0(815837637);
            Modifier modifierF2 = SizeKt.f(companion, 0.0f, 1, null);
            float f5 = 24;
            Modifier modifierD2 = BackgroundKt.d(ClipKt.a(PaddingKt.l(modifierF2, Dp.g(f5), Dp.g(12), Dp.g(f5), Dp.g(16)), RoundedCornerShapeKt.d(Dp.g(f4))), ComposeColorsKt.j(composer, 0).H(), null, 2, null);
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierD2);
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
            Updater.e(composerA2, measurePolicyG2, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF3, companion3.f());
            Object objG2 = composer.G();
            Composer.Companion companion4 = Composer.f23746a;
            if (objG2 == companion4.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
                composer.w(objG2);
            }
            MutableState mutableState4 = (MutableState) objG2;
            Object value = mutableState3.getValue();
            boolean Z = composer.Z(mutableState3);
            Object objG3 = composer.G();
            if (Z || objG3 == companion4.a()) {
                objG3 = new OnboardingBlockingTestScreenKt$PhoneContent$1$2$2$1$1$1(mutableState3, 4000L, mutableState4, null);
                composer.w(objG3);
            }
            EffectsKt.g(value, (Function2) objG3, composer, 0);
            String strP = StringHelperExtKt.p(StringResources_androidKt.c(R.string.W3, new Object[]{"\"" + StringResources_androidKt.b(R.string.zD, composer, 0) + "\""}, composer, 0), StringResources_androidKt.c(R.string.CH, new Object[]{"Instagram"}, composer, 0), "\n\n");
            String strC = StringResources_androidKt.c(R.string.c4, new Object[]{2, 23}, composer, 0);
            BlockingTestRotatingScreens blockingTestRotatingScreensK0 = k0(mutableState4);
            boolean zE = composer.e(blockingTestRotatingScreensK0 == null ? -1 : blockingTestRotatingScreensK0.ordinal());
            Object objG4 = composer.G();
            if (zE || objG4 == companion4.a()) {
                BlockingTestRotatingScreens blockingTestRotatingScreensK02 = k0(mutableState4);
                if (blockingTestRotatingScreensK02 != null && (blockedAppText = blockingTestRotatingScreensK02.getBlockedAppText()) != null) {
                    strP = blockedAppText;
                }
                composer.w(strP);
                objG4 = strP;
            }
            String str = (String) objG4;
            BlockingTestRotatingScreens blockingTestRotatingScreensK03 = k0(mutableState4);
            boolean zE2 = composer.e(blockingTestRotatingScreensK03 == null ? -1 : blockingTestRotatingScreensK03.ordinal());
            Object objG5 = composer.G();
            if (zE2 || objG5 == companion4.a()) {
                BlockingTestRotatingScreens blockingTestRotatingScreensK04 = k0(mutableState4);
                objG5 = (blockingTestRotatingScreensK04 == null || (customBlockingScreenEntity = blockingTestRotatingScreensK04.toCustomBlockingScreenEntity()) == null) ? new CustomBlockingScreenConfigEntity(null, ConfigType.DEFAULT, null, false, 0, false, ScheduleEmoji.AppBLock.getId(), null, null, null, null, 1981, null) : customBlockingScreenEntity;
                composer.w(objG5);
            }
            CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity = (CustomBlockingScreenConfigEntity) objG5;
            BlockingTestRotatingScreens blockingTestRotatingScreensK05 = k0(mutableState4);
            boolean zE3 = composer.e(blockingTestRotatingScreensK05 != null ? blockingTestRotatingScreensK05.ordinal() : -1);
            Object objG6 = composer.G();
            if (zE3 || objG6 == companion4.a()) {
                BlockingTestRotatingScreens blockingTestRotatingScreensK06 = k0(mutableState4);
                if (blockingTestRotatingScreensK06 != null && (counterText = blockingTestRotatingScreensK06.getCounterText()) != null) {
                    strC = counterText;
                }
                composer.w(strC);
                objG6 = strC;
            }
            LockViewState lockViewState = new LockViewState(null, null, 0, 0, false, 0, false, false, false, false, true, false, false, null, false, str, null, (String) objG6, null, null, null, null, false, null, null, false, null, 0.0f, false, false, false, customBlockingScreenConfigEntity, null, null, false, PremiumState.Subscription.Yearly.INSTANCE, 2147318783, 7, null);
            Object objG7 = composer.G();
            if (objG7 == companion4.a()) {
                objG7 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingBlockingTestScreenKt.m0((LockViewEvent) obj);
                    }
                };
                composer.w(objG7);
            }
            LockScreenKt.D(lockViewState, (Function1) objG7, true, true, null, composer, 3504, 16);
            composer.y();
            composer.U();
        } else {
            composer.a0(819144159);
            e0(boxScopeInstance, z2, composer, 6);
            a0(z2, mutableState2, function0, function1, composer, 0);
            composer.U();
        }
        o0(composer, 0);
        composer.y();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(float f3, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.e(f3);
        graphicsLayer.k(f3);
        graphicsLayer.A0(TransformOriginKt.a(0.7f, 0.2f));
        return Unit.f139807a;
    }

    private static final BlockingTestRotatingScreens k0(MutableState mutableState) {
        return (BlockingTestRotatingScreens) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l0(MutableState mutableState, BlockingTestRotatingScreens blockingTestRotatingScreens) {
        mutableState.setValue(blockingTestRotatingScreens);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m0(LockViewEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(boolean z2, MutableState mutableState, float f3, boolean z3, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, Function0 function0, Function1 function1, int i3, Composer composer, int i4) {
        g0(z2, mutableState, f3, z3, mutableState2, mutableState3, mutableState4, function0, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void o0(Composer composer, final int i3) {
        Composer composerK = composer.k(436575802);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(436575802, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.PhoneFrame (OnboardingBlockingTestScreen.kt:522)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierK = PaddingKt.k(SizeKt.f(companion, 0.0f, 1, null), Dp.g(16), 0.0f, 2, null);
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
            ImageKt.a(PainterResources_androidKt.c(R.drawable.x8, composerK, 0), null, SizeKt.f(companion, 0.0f, 1, null), companion2.m(), ContentScale.f27054a.d(), 0.0f, null, composerK, 28080, 96);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingBlockingTestScreenKt.p0(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p0(int i3, Composer composer, int i4) {
        o0(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:75:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void v(final cz.mobilesoft.coreblock.enums.BlockingTestAppIcon r62, androidx.compose.ui.Modifier r63, androidx.compose.runtime.Composer r64, final int r65, final int r66) {
        /*
            Method dump skipped, instruction units count: 592
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.OnboardingBlockingTestScreenKt.v(cz.mobilesoft.coreblock.enums.BlockingTestAppIcon, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(BlockingTestAppIcon blockingTestAppIcon, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        v(blockingTestAppIcon, modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void x(final boolean z2, final long j3, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-153785312);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.f(j3) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-153785312, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.ArrowContent (OnboardingBlockingTestScreen.kt:542)");
            }
            int i5 = i4;
            final State stateA = InfiniteTransitionKt.a(InfiniteTransitionKt.c("arrowTransition", composerK, 6, 0), 0.0f, 30.0f, new InfiniteRepeatableSpec(AnimationSpecKt.n(500, 0, null, 6, null), RepeatMode.f4053b, 0L, 4, null), "arrowY", composerK, InfiniteTransition.f3967f | 25008 | (InfiniteRepeatableSpec.f3963d << 9), 0);
            final Density density = (Density) composerK.q(CompositionLocalsKt.f());
            boolean z3 = z2 && !Offset.j(j3, Offset.f25596b.c());
            EnterTransition enterTransitionO = EnterExitTransitionKt.o(AnimationSpecKt.n(1000, 1000, null, 4, null), 0.0f, 2, null);
            ExitTransition exitTransitionQ = EnterExitTransitionKt.q(null, 0.0f, 3, null);
            Modifier modifierA = RotateKt.a(Modifier.b8, -20.0f);
            boolean Z = composerK.Z(density) | ((i5 & 112) == 32) | composerK.Z(stateA);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.v
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return OnboardingBlockingTestScreenKt.z(density, j3, stateA, (Density) obj);
                    }
                };
                composerK.w(objG);
            }
            AnimatedVisibilityKt.j(z3, OffsetKt.b(modifierA, (Function1) objG), enterTransitionO, exitTransitionQ, null, ComposableSingletons$OnboardingBlockingTestScreenKt.f111072a.h(), composerK, 200064, 16);
            composer2 = composerK;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.blockingtest.screensimport.w
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingBlockingTestScreenKt.A(z2, j3, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float y(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset z(Density density, long j3, State state, Density offset) {
        Intrinsics.checkNotNullParameter(offset, "$this$offset");
        float fG = Dp.g(-100);
        float fG2 = Dp.g(AppLovinErrorCodes.UNABLE_TO_PRECACHE_RESOURCES);
        int iZ0 = density.z0(fG);
        return IntOffset.c(IntOffset.f((((long) (((int) Float.intBitsToFloat((int) (j3 & 4294967295L))) + density.z0(fG2) + ((int) y(state)))) & 4294967295L) | (((long) (((int) Float.intBitsToFloat((int) (j3 >> 32))) + iZ0)) << 32)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int h0(int i3) {
        return i3;
    }
}
