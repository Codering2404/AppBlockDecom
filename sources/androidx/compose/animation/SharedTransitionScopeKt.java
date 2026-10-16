package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.LookaheadScopeKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class SharedTransitionScopeKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SpringSpec f3691a = AnimationSpecKt.l(0.0f, 400.0f, VisibilityThresholdsKt.g(Rect.f25601e), 1, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final SharedTransitionScope.OverlayClip f3692b = new SharedTransitionScope.OverlayClip() { // from class: androidx.compose.animation.SharedTransitionScopeKt$ParentClip$1
        @Override // androidx.compose.animation.SharedTransitionScope.OverlayClip
        public Path a(SharedTransitionScope.SharedContentState sharedContentState, Rect rect, LayoutDirection layoutDirection, Density density) {
            SharedTransitionScope.SharedContentState sharedContentStateE = sharedContentState.e();
            if (sharedContentStateE != null) {
                return sharedContentStateE.a();
            }
            return null;
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Function2 f3693c = new Function2() { // from class: androidx.compose.animation.SharedTransitionScopeKt$DefaultClipInOverlayDuringTransition$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Void invoke(LayoutDirection layoutDirection, Density density) {
            return null;
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final BoundsTransform f3694d = new BoundsTransform() { // from class: androidx.compose.animation.c
        @Override // androidx.compose.animation.BoundsTransform
        public final FiniteAnimationSpec a(Rect rect, Rect rect2) {
            return SharedTransitionScopeKt.b(rect, rect2);
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final MutableScatterMap f3695e = new MutableScatterMap(0, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final FiniteAnimationSpec b(Rect rect, Rect rect2) {
        return f3691a;
    }

    public static final void c(final Modifier modifier, final Function3 function3, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composerK = composer.k(2043053727);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i4 & 2) != 0) {
            i5 |= 48;
        } else if ((i3 & 48) == 0) {
            i5 |= composerK.I(function3) ? 32 : 16;
        }
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            if (i6 != 0) {
                modifier = Modifier.b8;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(2043053727, i5, -1, "androidx.compose.animation.SharedTransitionLayout (SharedTransitionScope.kt:98)");
            }
            d(ComposableLambdaKt.e(-130587847, true, new Function4<SharedTransitionScope, Modifier, Composer, Integer, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionLayout$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                public final void c(SharedTransitionScope sharedTransitionScope, Modifier modifier2, Composer composer2, int i7) {
                    int i8;
                    if ((i7 & 6) == 0) {
                        i8 = (composer2.Z(sharedTransitionScope) ? 4 : 2) | i7;
                    } else {
                        i8 = i7;
                    }
                    if ((i7 & 48) == 0) {
                        i8 |= composer2.Z(modifier2) ? 32 : 16;
                    }
                    if (!composer2.r((i8 & 147) != 146, i8 & 1)) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-130587847, i8, -1, "androidx.compose.animation.SharedTransitionLayout.<anonymous> (SharedTransitionScope.kt:102)");
                    }
                    Modifier modifierThen = modifier.then(modifier2);
                    Function3 function32 = function3;
                    MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF = ComposedModifierKt.f(composer2, modifierThen);
                    ComposeUiNode.Companion companion = ComposeUiNode.f8;
                    Function0 function0A = companion.a();
                    if (composer2.m() == null) {
                        ComposablesKt.c();
                    }
                    composer2.L();
                    if (composer2.i()) {
                        composer2.P(function0A);
                    } else {
                        composer2.v();
                    }
                    Composer composerA = Updater.a(composer2);
                    Updater.e(composerA, measurePolicyG, companion.e());
                    Updater.e(composerA, compositionLocalMapU, companion.g());
                    Function2 function2B = companion.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    function32.invoke(sharedTransitionScope, composer2, Integer.valueOf(i8 & 14));
                    composer2.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    c((SharedTransitionScope) obj, (Modifier) obj2, (Composer) obj3, ((Number) obj4).intValue());
                    return Unit.f139807a;
                }
            }, composerK, 54), composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i7) {
                    SharedTransitionScopeKt.c(modifier, function3, composer2, RecomposeScopeImplKt.a(i3 | 1), i4);
                }
            });
        }
    }

    public static final void d(final Function4 function4, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-2093217917);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(function4) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2093217917, i4, -1, "androidx.compose.animation.SharedTransitionScope (SharedTransitionScope.kt:121)");
            }
            LookaheadScopeKt.a(ComposableLambdaKt.e(-863967934, true, new Function3<LookaheadScope, Composer, Integer, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionScope$1
                {
                    super(3);
                }

                public final void c(LookaheadScope lookaheadScope, Composer composer2, int i5) {
                    if (ComposerKt.M()) {
                        ComposerKt.U(-863967934, i5, -1, "androidx.compose.animation.SharedTransitionScope.<anonymous> (SharedTransitionScope.kt:123)");
                    }
                    Object objG = composer2.G();
                    Composer.Companion companion = Composer.f23746a;
                    if (objG == companion.a()) {
                        objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composer2);
                        composer2.w(objG);
                    }
                    CoroutineScope coroutineScope = (CoroutineScope) objG;
                    Object objG2 = composer2.G();
                    if (objG2 == companion.a()) {
                        objG2 = new SharedTransitionScopeImpl(lookaheadScope, coroutineScope);
                        composer2.w(objG2);
                    }
                    final SharedTransitionScopeImpl sharedTransitionScopeImpl = (SharedTransitionScopeImpl) objG2;
                    Function4 function42 = function4;
                    Modifier.Companion companion2 = Modifier.b8;
                    Object objG3 = composer2.G();
                    if (objG3 == companion.a()) {
                        objG3 = new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionScope$1$1$1
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                return m20invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).r());
                            }

                            /* JADX INFO: renamed from: invoke-3p2s80s, reason: not valid java name */
                            public final MeasureResult m20invoke3p2s80s(final MeasureScope measureScope, Measurable measurable, long j3) {
                                final Placeable placeableN0 = measurable.n0(j3);
                                int iX0 = placeableN0.X0();
                                int iO0 = placeableN0.O0();
                                final SharedTransitionScopeImpl sharedTransitionScopeImpl2 = sharedTransitionScopeImpl;
                                return MeasureScope.B0(measureScope, iX0, iO0, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionScope$1$1$1.1
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
                                        LayoutCoordinates layoutCoordinatesD = placementScope.d();
                                        if (layoutCoordinatesD != null) {
                                            if (measureScope.q0()) {
                                                sharedTransitionScopeImpl2.t(layoutCoordinatesD);
                                            } else {
                                                sharedTransitionScopeImpl2.v(layoutCoordinatesD);
                                            }
                                        }
                                        Placeable.PlacementScope.i(placementScope, placeableN0, 0, 0, 0.0f, 4, null);
                                    }
                                }, 4, null);
                            }
                        };
                        composer2.w(objG3);
                    }
                    Modifier modifierA = LayoutModifierKt.a(companion2, (Function3) objG3);
                    Object objG4 = composer2.G();
                    if (objG4 == companion.a()) {
                        objG4 = new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionScope$1$2$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((ContentDrawScope) obj);
                                return Unit.f139807a;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                contentDrawScope.i2();
                                sharedTransitionScopeImpl.g(contentDrawScope);
                            }
                        };
                        composer2.w(objG4);
                    }
                    function42.invoke(sharedTransitionScopeImpl, DrawModifierKt.d(modifierA, (Function1) objG4), composer2, 6);
                    Unit unit = Unit.f139807a;
                    Object objG5 = composer2.G();
                    if (objG5 == companion.a()) {
                        objG5 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionScope$1$3$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                                final SharedTransitionScopeImpl sharedTransitionScopeImpl2 = sharedTransitionScopeImpl;
                                return new DisposableEffectResult() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionScope$1$3$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        sharedTransitionScopeImpl2.l();
                                    }
                                };
                            }
                        };
                        composer2.w(objG5);
                    }
                    EffectsKt.c(unit, (Function1) objG5, composer2, 54);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    c((LookaheadScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }
            }, composerK, 54), composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.SharedTransitionScopeKt$SharedTransitionScope$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    SharedTransitionScopeKt.d(function4, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
