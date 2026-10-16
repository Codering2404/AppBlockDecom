package com.revenuecat.purchases.ui.revenuecatui.components;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.Easing;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import com.revenuecat.purchases.paywalls.components.PaywallAnimation;
import com.revenuecat.purchases.paywalls.components.PaywallTransition;
import cz.mobilesoft.coreblock.scene.permission.permissions.success.lbR.YgVrd;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
public final class TransitionViewKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PaywallTransition.TransitionType.values().length];
            try {
                iArr[PaywallTransition.TransitionType.FADE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PaywallTransition.TransitionType.FADE_AND_SCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PaywallTransition.TransitionType.SCALE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PaywallTransition.TransitionType.SLIDE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[PaywallAnimation.AnimationType.values().length];
            try {
                iArr2[PaywallAnimation.AnimationType.EASE_IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[PaywallAnimation.AnimationType.EASE_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[PaywallAnimation.AnimationType.EASE_IN_OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[PaywallAnimation.AnimationType.LINEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AnimatedVisibility(final PaywallTransition paywallTransition, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(391884057);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(paywallTransition) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function2) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(391884057, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.AnimatedVisibility (TransitionView.kt:57)");
            }
            composerK.a0(1463461260);
            boolean Z = composerK.Z(paywallTransition);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            MutableState mutableState = (MutableState) objG;
            composerK.U();
            composerK.a0(1463463365);
            boolean Z2 = composerK.Z(mutableState);
            Object objG2 = composerK.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new TransitionViewKt$AnimatedVisibility$1$1(mutableState, null);
                composerK.w(objG2);
            }
            composerK.U();
            EffectsKt.g(paywallTransition, (Function2) objG2, composerK, i4 & 14);
            AnimatedVisibilityKt.j(AnimatedVisibility$lambda$3(mutableState), null, enterTransition(paywallTransition), null, null, ComposableLambdaKt.e(1879822145, true, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt.AnimatedVisibility.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((AnimatedVisibilityScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer2, int i5) {
                    Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
                    if (ComposerKt.M()) {
                        ComposerKt.U(1879822145, i5, -1, YgVrd.yznTuBg);
                    }
                    function2.invoke(composer2, 0);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, 196608, 26);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt.AnimatedVisibility.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    TransitionViewKt.AnimatedVisibility(paywallTransition, function2, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    private static final boolean AnimatedVisibility$lambda$3(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void AnimatedVisibility$lambda$4(MutableState<Boolean> mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    public static final void TransitionView(final PaywallTransition paywallTransition, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerK = composer.k(1753108978);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(paywallTransition) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(content) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1753108978, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.components.TransitionView (TransitionView.kt:29)");
            }
            if (paywallTransition == null) {
                composerK.a0(1473784896);
                content.invoke(composerK, Integer.valueOf((i4 >> 3) & 14));
                composerK.U();
            } else {
                composerK.a0(1473826622);
                if (paywallTransition.getDisplacementStrategy() == PaywallTransition.DisplacementStrategy.GREEDY) {
                    composerK.a0(1473916429);
                    Modifier.Companion companion = Modifier.b8;
                    Alignment.Companion companion2 = Alignment.f25072a;
                    MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
                    int iA = ComposablesKt.a(composerK, 0);
                    CompositionLocalMap compositionLocalMapU = composerK.u();
                    Modifier modifierF = ComposedModifierKt.f(composerK, companion);
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
                    Modifier modifierHidden = hidden(companion);
                    MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
                    int iA2 = ComposablesKt.a(composerK, 0);
                    CompositionLocalMap compositionLocalMapU2 = composerK.u();
                    Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierHidden);
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
                    Updater.e(composerA2, measurePolicyG2, companion3.e());
                    Updater.e(composerA2, compositionLocalMapU2, companion3.g());
                    Function2 function2B2 = companion3.b();
                    if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                        composerA2.w(Integer.valueOf(iA2));
                        composerA2.p(Integer.valueOf(iA2), function2B2);
                    }
                    Updater.e(composerA2, modifierF2, companion3.f());
                    content.invoke(composerK, Integer.valueOf((i4 >> 3) & 14));
                    composerK.y();
                    AnimatedVisibility(paywallTransition, ComposableLambdaKt.e(1120237739, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt$TransitionView$1$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.f139807a;
                        }

                        public final void invoke(Composer composer2, int i5) {
                            if ((i5 & 3) == 2 && composer2.l()) {
                                composer2.Q();
                                return;
                            }
                            if (ComposerKt.M()) {
                                ComposerKt.U(1120237739, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.components.TransitionView.<anonymous>.<anonymous> (TransitionView.kt:39)");
                            }
                            content.invoke(composer2, 0);
                            if (ComposerKt.M()) {
                                ComposerKt.T();
                            }
                        }
                    }, composerK, 54), composerK, (i4 & 14) | 48);
                    composerK.y();
                    composerK.U();
                } else {
                    composerK.a0(1474120502);
                    AnimatedVisibility(paywallTransition, ComposableLambdaKt.e(797485256, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt.TransitionView.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                            invoke((Composer) obj, ((Number) obj2).intValue());
                            return Unit.f139807a;
                        }

                        public final void invoke(Composer composer2, int i5) {
                            if ((i5 & 3) == 2 && composer2.l()) {
                                composer2.Q();
                                return;
                            }
                            if (ComposerKt.M()) {
                                ComposerKt.U(797485256, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.components.TransitionView.<anonymous> (TransitionView.kt:42)");
                            }
                            content.invoke(composer2, 0);
                            if (ComposerKt.M()) {
                                ComposerKt.T();
                            }
                        }
                    }, composerK, 54), composerK, (i4 & 14) | 48);
                    composerK.U();
                }
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt.TransitionView.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    TransitionViewKt.TransitionView(paywallTransition, content, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    private static final Easing easing(PaywallAnimation paywallAnimation) {
        Easing easing;
        return (paywallAnimation == null || (easing = getEasing(paywallAnimation)) == null) ? EasingKt.f() : easing;
    }

    private static final EnterTransition enterTransition(PaywallTransition paywallTransition) {
        int msDuration;
        int i3 = WhenMappings.$EnumSwitchMapping$0[paywallTransition.getType().ordinal()];
        if (i3 == 1) {
            PaywallAnimation animation = paywallTransition.getAnimation();
            msDuration = animation != null ? animation.getMsDuration() : 300;
            PaywallAnimation animation2 = paywallTransition.getAnimation();
            return EnterExitTransitionKt.o(AnimationSpecKt.m(msDuration, animation2 != null ? animation2.getMsDelay() : 0, easing(paywallTransition.getAnimation())), 0.0f, 2, null);
        }
        if (i3 == 2) {
            PaywallAnimation animation3 = paywallTransition.getAnimation();
            int msDuration2 = animation3 != null ? animation3.getMsDuration() : 300;
            PaywallAnimation animation4 = paywallTransition.getAnimation();
            EnterTransition enterTransitionO = EnterExitTransitionKt.o(AnimationSpecKt.m(msDuration2, animation4 != null ? animation4.getMsDelay() : 0, easing(paywallTransition.getAnimation())), 0.0f, 2, null);
            PaywallAnimation animation5 = paywallTransition.getAnimation();
            msDuration = animation5 != null ? animation5.getMsDuration() : 300;
            PaywallAnimation animation6 = paywallTransition.getAnimation();
            return enterTransitionO.c(EnterExitTransitionKt.s(AnimationSpecKt.m(msDuration, animation6 != null ? animation6.getMsDelay() : 0, easing(paywallTransition.getAnimation())), 0.0f, 0L, 6, null));
        }
        if (i3 == 3) {
            PaywallAnimation animation7 = paywallTransition.getAnimation();
            msDuration = animation7 != null ? animation7.getMsDuration() : 300;
            PaywallAnimation animation8 = paywallTransition.getAnimation();
            return EnterExitTransitionKt.s(AnimationSpecKt.m(msDuration, animation8 != null ? animation8.getMsDelay() : 0, easing(paywallTransition.getAnimation())), 0.0f, 0L, 6, null);
        }
        if (i3 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        PaywallAnimation animation9 = paywallTransition.getAnimation();
        msDuration = animation9 != null ? animation9.getMsDuration() : 300;
        PaywallAnimation animation10 = paywallTransition.getAnimation();
        return EnterExitTransitionKt.B(AnimationSpecKt.m(msDuration, animation10 != null ? animation10.getMsDelay() : 0, easing(paywallTransition.getAnimation())), new Function1<IntSize, IntOffset>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt.enterTransition.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return IntOffset.c(m700invokemHKZG7I(((IntSize) obj).j()));
            }

            /* JADX INFO: renamed from: invoke-mHKZG7I, reason: not valid java name */
            public final long m700invokemHKZG7I(long j3) {
                return IntOffsetKt.a(-180, 0);
            }
        });
    }

    private static final Easing getEasing(PaywallAnimation paywallAnimation) {
        int i3 = WhenMappings.$EnumSwitchMapping$1[paywallAnimation.getType().ordinal()];
        if (i3 == 1) {
            return EasingKt.d();
        }
        if (i3 == 2) {
            return EasingKt.c();
        }
        if (i3 == 3) {
            return EasingKt.f();
        }
        if (i3 == 4) {
            return EasingKt.e();
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final Modifier hidden(Modifier modifier) {
        return LayoutModifierKt.a(modifier, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt.hidden.1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return m701invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).r());
            }

            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m701invoke3p2s80s(MeasureScope layout, Measurable measurable, long j3) {
                Intrinsics.checkNotNullParameter(layout, "$this$layout");
                Intrinsics.checkNotNullParameter(measurable, "measurable");
                Placeable placeableN0 = measurable.n0(j3);
                return MeasureScope.B0(layout, placeableN0.X0(), placeableN0.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.TransitionViewKt.hidden.1.1
                    public final void invoke(Placeable.PlacementScope layout2) {
                        Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Placeable.PlacementScope) obj);
                        return Unit.f139807a;
                    }
                }, 4, null);
            }
        });
    }
}
