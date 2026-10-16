package cz.mobilesoft.coreblock.view.compose;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
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
public final class ComposeLoadingDotsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final float f130469a = Dp.g(2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f130470b = 300;

    public static final void e(Modifier modifier, long j3, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        long j4;
        final Modifier modifier3;
        final long j5;
        Modifier modifier4;
        Composer composerK = composer.k(-823589812);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = i3 | (composerK.Z(modifier2) ? 4 : 2);
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            if ((i4 & 2) == 0) {
                j4 = j3;
                int i7 = composerK.f(j4) ? 32 : 16;
                i5 |= i7;
            } else {
                j4 = j3;
            }
            i5 |= i7;
        } else {
            j4 = j3;
        }
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            composerK.J();
            if ((i3 & 1) == 0 || composerK.S()) {
                Modifier modifier5 = i6 != 0 ? Modifier.b8 : modifier2;
                if ((i4 & 2) != 0) {
                    j4 = MaterialTheme.f13091a.a(composerK, MaterialTheme.f13092b).j();
                    i5 &= -113;
                }
                modifier4 = modifier5;
            } else {
                composerK.Q();
                if ((i4 & 2) != 0) {
                    i5 &= -113;
                }
                modifier4 = modifier2;
            }
            long j6 = j4;
            composerK.z();
            if (ComposerKt.M()) {
                ComposerKt.U(-823589812, i5, -1, "cz.mobilesoft.coreblock.view.compose.CirclePulsing (ComposeLoadingDots.kt:39)");
            }
            InfiniteTransition infiniteTransitionC = InfiniteTransitionKt.c("infiniteTransition", composerK, 6, 0);
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.t7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ComposeLoadingDotsKt.f((KeyframesSpec.KeyframesSpecConfig) obj);
                    }
                };
                composerK.w(objG);
            }
            SpacerKt.a(BorderKt.f(ScaleKt.a(SizeKt.v(modifier4, Dp.g(10)), g(InfiniteTransitionKt.a(infiniteTransitionC, 0.5f, 1.0f, AnimationSpecKt.e(AnimationSpecKt.f((Function1) objG), null, 0L, 6, null), "scale", composerK, InfiniteTransition.f3967f | 25008 | (InfiniteRepeatableSpec.f3963d << 9), 0))), Dp.g(3), j6, RoundedCornerShapeKt.g()), composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier3 = modifier4;
            j5 = j6;
        } else {
            composerK.Q();
            modifier3 = modifier2;
            j5 = j4;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.u7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeLoadingDotsKt.h(modifier3, j5, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(KeyframesSpec.KeyframesSpecConfig keyframes) {
        Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
        keyframes.d(1000);
        Float fValueOf = Float.valueOf(0.7f);
        keyframes.e(keyframes.f(fValueOf, 0), EasingKt.e());
        keyframes.e(keyframes.f(Float.valueOf(1.0f), 500), EasingKt.e());
        keyframes.e(keyframes.f(fValueOf, 1000), EasingKt.e());
        return Unit.f139807a;
    }

    private static final float g(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Modifier modifier, long j3, int i3, int i4, Composer composer, int i5) {
        e(modifier, j3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void i(Composer composer, final int i3) {
        Composer composerK = composer.k(-1680442255);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1680442255, i3, -1, "cz.mobilesoft.coreblock.view.compose.DotsTyping (ComposeLoadingDots.kt:232)");
            }
            InfiniteTransition infiniteTransitionC = InfiniteTransitionKt.c("infiniteTransition", composerK, 6, 0);
            State stateK = k(infiniteTransitionC, 10.0f, 0, composerK, 6);
            int i4 = f130470b;
            State stateK2 = k(infiniteTransitionC, 10.0f, i4, composerK, 6);
            State stateK3 = k(infiniteTransitionC, 10.0f, i4 * 2, composerK, 6);
            Alignment.Vertical verticalI = Alignment.f25072a.i();
            Arrangement.HorizontalOrVertical horizontalOrVerticalB = Arrangement.f6574a.b();
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierM = PaddingKt.m(companion, 0.0f, Dp.g(10.0f), 0.0f, 0.0f, 13, null);
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalB, verticalI, composerK, 54);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            float fG = Dp.g(2);
            j(m(stateK), composerK, 0);
            SpacerKt.a(SizeKt.A(companion, fG), composerK, 6);
            j(n(stateK2), composerK, 0);
            SpacerKt.a(SizeKt.A(companion, fG), composerK, 6);
            j(o(stateK3), composerK, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.v7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ComposeLoadingDotsKt.p(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void j(float f3, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-170934942, i3, -1, "cz.mobilesoft.coreblock.view.compose.DotsTyping.Dot (ComposeLoadingDots.kt:238)");
        }
        SpacerKt.a(BackgroundKt.c(OffsetKt.d(SizeKt.v(Modifier.b8, f130469a), 0.0f, Dp.g(-Dp.g(f3)), 1, null), MaterialTheme.f13091a.a(composer, MaterialTheme.f13092b).j(), RoundedCornerShapeKt.g()), composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
    }

    private static final State k(InfiniteTransition infiniteTransition, final float f3, final int i3, Composer composer, int i4) {
        if (ComposerKt.M()) {
            ComposerKt.U(-121886758, i4, -1, "cz.mobilesoft.coreblock.view.compose.DotsTyping.animateOffsetWithDelay (ComposeLoadingDots.kt:253)");
        }
        boolean z2 = (((i4 & 14) ^ 6) > 4 && composer.e(i3)) || (i4 & 6) == 4;
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.w7
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ComposeLoadingDotsKt.l(i3, f3, (KeyframesSpec.KeyframesSpecConfig) obj);
                }
            };
            composer.w(objG);
        }
        State stateA = InfiniteTransitionKt.a(infiniteTransition, 0.0f, 0.0f, AnimationSpecKt.e(AnimationSpecKt.f((Function1) objG), null, 0L, 6, null), "animateOffsetWithDelay", composer, InfiniteTransition.f3967f | 25008 | (InfiniteRepeatableSpec.f3963d << 9), 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(int i3, float f3, KeyframesSpec.KeyframesSpecConfig keyframes) {
        Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
        int i4 = f130470b;
        keyframes.d(i4 * 4);
        Float fValueOf = Float.valueOf(0.0f);
        keyframes.e(keyframes.f(fValueOf, i3), EasingKt.e());
        keyframes.e(keyframes.f(Float.valueOf(f3), i3 + i4), EasingKt.e());
        keyframes.f(fValueOf, i3 + (i4 * 2));
        return Unit.f139807a;
    }

    private static final float m(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float n(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float o(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(int i3, Composer composer, int i4) {
        i(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
