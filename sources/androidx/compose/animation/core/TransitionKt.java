package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
public final class TransitionKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Function1 f4241a = new Function1<SeekableTransitionState<?>, Unit>() { // from class: androidx.compose.animation.core.TransitionKt$SeekableTransitionStateTotalDurationChanged$1
        public final void c(SeekableTransitionState seekableTransitionState) {
            seekableTransitionState.M();
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((SeekableTransitionState) obj);
            return Unit.f139807a;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Lazy f4242b = LazyKt.a(LazyThreadSafetyMode.f139763c, new Function0<SnapshotStateObserver>() { // from class: androidx.compose.animation.core.TransitionKt$SeekableStateObserver$2
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final SnapshotStateObserver invoke() {
            SnapshotStateObserver snapshotStateObserver = new SnapshotStateObserver(new Function1<Function0<? extends Unit>, Unit>() { // from class: androidx.compose.animation.core.TransitionKt$SeekableStateObserver$2.1
                public final void c(Function0 function0) {
                    function0.invoke();
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((Function0) obj);
                    return Unit.f139807a;
                }
            });
            snapshotStateObserver.t();
            return snapshotStateObserver;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final Transition transition, final Transition.TransitionAnimationState transitionAnimationState, final Object obj, final Object obj2, final FiniteAnimationSpec finiteAnimationSpec, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(867041821);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(transition) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(transitionAnimationState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= (i3 & 512) == 0 ? composerK.Z(obj) : composerK.I(obj) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= (i3 & 4096) == 0 ? composerK.Z(obj2) : composerK.I(obj2) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= (32768 & i3) == 0 ? composerK.Z(finiteAnimationSpec) : composerK.I(finiteAnimationSpec) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(867041821, i4, -1, "androidx.compose.animation.core.UpdateInitialAndTargetValues (Transition.kt:1880)");
            }
            if (transition.w()) {
                transitionAnimationState.L(obj, obj2, finiteAnimationSpec);
            } else {
                transitionAnimationState.N(obj2, finiteAnimationSpec);
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.core.TransitionKt$UpdateInitialAndTargetValues$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4) {
                    invoke((Composer) obj3, ((Number) obj4).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    TransitionKt.a(transition, transitionAnimationState, obj, obj2, finiteAnimationSpec, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final Transition d(final Transition transition, Object obj, Object obj2, String str, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-198307638, i3, -1, "androidx.compose.animation.core.createChildTransitionInternal (Transition.kt:1773)");
        }
        int i4 = (i3 & 14) ^ 6;
        boolean z2 = true;
        boolean z3 = (i4 > 4 && composer.Z(transition)) || (i3 & 6) == 4;
        Object objG = composer.G();
        if (z3 || objG == Composer.f23746a.a()) {
            objG = new Transition(new MutableTransitionState(obj), transition, transition.k() + " > " + str);
            composer.w(objG);
        }
        final Transition transition2 = (Transition) objG;
        if ((i4 <= 4 || !composer.Z(transition)) && (i3 & 6) != 4) {
            z2 = false;
        }
        boolean Z = composer.Z(transition2) | z2;
        Object objG2 = composer.G();
        if (Z || objG2 == Composer.f23746a.a()) {
            objG2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$createChildTransitionInternal$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    transition.d(transition2);
                    final Transition transition3 = transition;
                    final Transition transition4 = transition2;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createChildTransitionInternal$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            transition3.F(transition4);
                        }
                    };
                }
            };
            composer.w(objG2);
        }
        EffectsKt.c(transition2, (Function1) objG2, composer, 0);
        if (transition.w()) {
            transition2.H(obj, obj2, transition.l());
        } else {
            transition2.S(obj2);
            transition2.L(false);
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return transition2;
    }

    public static final Transition.DeferredAnimation e(final Transition transition, TwoWayConverter twoWayConverter, String str, Composer composer, int i3, int i4) {
        if ((i4 & 2) != 0) {
            str = "DeferredAnimation";
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-1714122528, i3, -1, "androidx.compose.animation.core.createDeferredAnimation (Transition.kt:1731)");
        }
        int i5 = (i3 & 14) ^ 6;
        boolean z2 = true;
        boolean z3 = (i5 > 4 && composer.Z(transition)) || (i3 & 6) == 4;
        Object objG = composer.G();
        if (z3 || objG == Composer.f23746a.a()) {
            objG = new Transition.DeferredAnimation(twoWayConverter, str);
            composer.w(objG);
        }
        final Transition.DeferredAnimation deferredAnimation = (Transition.DeferredAnimation) objG;
        if ((i5 <= 4 || !composer.Z(transition)) && (i3 & 6) != 4) {
            z2 = false;
        }
        boolean zI = composer.I(deferredAnimation) | z2;
        Object objG2 = composer.G();
        if (zI || objG2 == Composer.f23746a.a()) {
            objG2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$createDeferredAnimation$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    final Transition transition2 = transition;
                    final Transition.DeferredAnimation deferredAnimation2 = deferredAnimation;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createDeferredAnimation$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            transition2.D(deferredAnimation2);
                        }
                    };
                }
            };
            composer.w(objG2);
        }
        EffectsKt.c(deferredAnimation, (Function1) objG2, composer, 0);
        if (transition.w()) {
            deferredAnimation.d();
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return deferredAnimation;
    }

    public static final State f(final Transition transition, Object obj, Object obj2, FiniteAnimationSpec finiteAnimationSpec, TwoWayConverter twoWayConverter, String str, Composer composer, int i3) {
        Object obj3;
        if (ComposerKt.M()) {
            ComposerKt.U(-304821198, i3, -1, "androidx.compose.animation.core.createTransitionAnimation (Transition.kt:1848)");
        }
        int i4 = i3 & 14;
        int i5 = i4 ^ 6;
        boolean z2 = true;
        boolean z3 = (i5 > 4 && composer.Z(transition)) || (i3 & 6) == 4;
        Object objG = composer.G();
        if (z3 || objG == Composer.f23746a.a()) {
            obj3 = obj2;
            Object transitionAnimationState = new Transition.TransitionAnimationState(obj, AnimationStateKt.i(twoWayConverter, obj3), twoWayConverter, str);
            composer.w(transitionAnimationState);
            objG = transitionAnimationState;
        } else {
            obj3 = obj2;
        }
        final Transition.TransitionAnimationState transitionAnimationState2 = (Transition.TransitionAnimationState) objG;
        int i6 = (i3 >> 3) & 8;
        int i7 = i3 << 3;
        a(transition, transitionAnimationState2, obj, obj3, finiteAnimationSpec, composer, (i6 << 9) | (i6 << 6) | i4 | (i7 & 896) | (i7 & 7168) | (57344 & i7));
        if ((i5 <= 4 || !composer.Z(transition)) && (i3 & 6) != 4) {
            z2 = false;
        }
        boolean Z = composer.Z(transitionAnimationState2) | z2;
        Object objG2 = composer.G();
        if (Z || objG2 == Composer.f23746a.a()) {
            objG2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$createTransitionAnimation$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    transition.c(transitionAnimationState2);
                    final Transition transition2 = transition;
                    final Transition.TransitionAnimationState transitionAnimationState3 = transitionAnimationState2;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$createTransitionAnimation$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            transition2.E(transitionAnimationState3);
                        }
                    };
                }
            };
            composer.w(objG2);
        }
        EffectsKt.c(transitionAnimationState2, (Function1) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return transitionAnimationState2;
    }

    public static final SnapshotStateObserver g() {
        return (SnapshotStateObserver) f4242b.getValue();
    }

    public static final Transition h(TransitionState transitionState, String str, Composer composer, int i3, int i4) {
        if ((i4 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1643203617, i3, -1, "androidx.compose.animation.core.rememberTransition (Transition.kt:803)");
        }
        int i5 = (i3 & 14) ^ 6;
        boolean z2 = true;
        boolean z3 = (i5 > 4 && composer.Z(transitionState)) || (i3 & 6) == 4;
        Object objG = composer.G();
        if (z3 || objG == Composer.f23746a.a()) {
            objG = new Transition(transitionState, str);
            composer.w(objG);
        }
        final Transition transition = (Transition) objG;
        if (transitionState instanceof SeekableTransitionState) {
            composer.a0(1030829284);
            Object objA = transitionState.a();
            Object objB = transitionState.b();
            if ((i5 <= 4 || !composer.Z(transitionState)) && (i3 & 6) != 4) {
                z2 = false;
            }
            Object objG2 = composer.G();
            if (z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new TransitionKt$rememberTransition$1$1(transitionState, null);
                composer.w(objG2);
            }
            EffectsKt.f(objA, objB, (Function2) objG2, composer, 0);
            composer.U();
        } else {
            composer.a0(1031290843);
            transition.e(transitionState.b(), composer, 0);
            composer.U();
        }
        boolean Z = composer.Z(transition);
        Object objG3 = composer.G();
        if (Z || objG3 == Composer.f23746a.a()) {
            objG3 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$rememberTransition$2$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    final Transition transition2 = transition;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$rememberTransition$2$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            transition2.y();
                        }
                    };
                }
            };
            composer.w(objG3);
        }
        EffectsKt.c(transition, (Function1) objG3, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return transition;
    }

    public static final Transition i(MutableTransitionState mutableTransitionState, String str, Composer composer, int i3, int i4) {
        if ((i4 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(882913843, i3, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:856)");
        }
        Transition transitionH = h(mutableTransitionState, str, composer, i3 & 126, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return transitionH;
    }

    public static final Transition j(Object obj, String str, Composer composer, int i3, int i4) {
        if ((i4 & 2) != 0) {
            str = null;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(2029166765, i3, -1, "androidx.compose.animation.core.updateTransition (Transition.kt:86)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = new Transition(obj, str);
            composer.w(objG);
        }
        final Transition transition = (Transition) objG;
        transition.e(obj, composer, (i3 & 8) | 48 | (i3 & 14));
        Object objG2 = composer.G();
        if (objG2 == companion.a()) {
            objG2 = new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final DisposableEffectResult invoke(DisposableEffectScope disposableEffectScope) {
                    final Transition transition2 = transition;
                    return new DisposableEffectResult() { // from class: androidx.compose.animation.core.TransitionKt$updateTransition$1$1$invoke$$inlined$onDispose$1
                        @Override // androidx.compose.runtime.DisposableEffectResult
                        public void dispose() {
                            transition2.y();
                        }
                    };
                }
            };
            composer.w(objG2);
        }
        EffectsKt.c(transition, (Function1) objG2, composer, 54);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return transition;
    }
}
