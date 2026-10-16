package cz.mobilesoft.coreblock.scene.more.guestpassshare.screens;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.more.guestpassshare.screens.GuestPassShareContentComponentsKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class GuestPassShareContentComponentsKt {
    private static final State A(float f3, float f4, int i3, int i4, Composer composer, int i5) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1001111096, i5, -1, "cz.mobilesoft.coreblock.scene.more.guestpassshare.screens.rememberVerticalFloat (GuestPassShareContentComponents.kt:238)");
        }
        int i6 = i5 << 3;
        State stateA = InfiniteTransitionKt.a(InfiniteTransitionKt.c("GuestPassTagVerticalTransition", composer, 6, 0), f3, f4, AnimationSpecKt.e(AnimationSpecKt.m(i3, i4, EasingKt.d()), RepeatMode.f4053b, 0L, 4, null), "GuestPassTagVerticalFloat", composer, (i6 & 896) | InfiniteTransition.f3967f | 24576 | (i6 & 112) | (InfiniteRepeatableSpec.f3963d << 9), 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateA;
    }

    public static final void i(Composer composer, final int i3) {
        Composer composerK = composer.k(-269228608);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-269228608, i3, -1, "cz.mobilesoft.coreblock.scene.more.guestpassshare.screens.CardWithDiamond (GuestPassShareContentComponents.kt:193)");
            }
            Alignment.Companion companion = Alignment.f25072a;
            Alignment alignmentC = companion.c();
            Modifier.Companion companion2 = Modifier.b8;
            MeasurePolicy measurePolicyG = BoxKt.g(alignmentC, false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion2);
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
            ImageKt.a(PainterResources_androidKt.c(R.drawable.N, composerK, 0), null, SizeKt.i(SizeKt.A(companion2, Dp.g(90)), Dp.g(120)), null, null, 0.0f, null, composerK, 432, 120);
            ImageKt.a(PainterResources_androidKt.c(R.drawable.P, composerK, 0), null, OffsetKt.d(boxScopeInstance.f(companion2, companion.f()), Dp.g(12), 0.0f, 2, null), null, null, 0.0f, null, composerK, 48, 120);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: b1.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GuestPassShareContentComponentsKt.j(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(int i3, Composer composer, int i4) {
        i(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void k(Composer composer, final int i3) {
        Composer composerK = composer.k(423521678);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(423521678, i3, -1, "cz.mobilesoft.coreblock.scene.more.guestpassshare.screens.DoubleTagContent (GuestPassShareContentComponents.kt:38)");
            }
            final State stateA = A(-8.0f, 14.0f, 4200, 0, composerK, 3504);
            final State stateA2 = A(14.0f, -8.0f, 4800, 550, composerK, 3462);
            BoxWithConstraintsKt.a(SizeKt.f(Modifier.b8, 0.0f, 1, null), null, false, ComposableLambdaKt.e(1007167864, true, new Function3() { // from class: b1.g
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return GuestPassShareContentComponentsKt.n(stateA, stateA2, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 3078, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: b1.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GuestPassShareContentComponentsKt.o(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float l(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float m(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(State state, State state2, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i3) {
        int i4;
        RowScopeInstance rowScopeInstance;
        Modifier modifierD;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(BoxWithConstraints) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1007167864, i4, -1, "cz.mobilesoft.coreblock.scene.more.guestpassshare.screens.DoubleTagContent.<anonymous> (GuestPassShareContentComponents.kt:56)");
            }
            boolean z2 = Dp.f(BoxWithConstraints.d(), Dp.g((float) 600)) >= 0;
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierG = SizeKt.g(companion, z2 ? 1.0f : 0.88f);
            Alignment.Companion companion2 = Alignment.f25072a;
            Modifier modifierF = BoxWithConstraints.f(modifierG, companion2.e());
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.p(Dp.g(8), companion2.g()), companion2.a(), composer, 54);
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.f7101a;
            Painter painterC = PainterResources_androidKt.c(R.drawable.S, composer, 0);
            ContentScale.Companion companion4 = ContentScale.f27054a;
            ContentScale contentScaleE = companion4.e();
            if (z2) {
                modifierD = OffsetKt.d(SizeKt.g(companion, 0.2f), 0.0f, Dp.g(-l(state)), 1, null);
                rowScopeInstance = rowScopeInstance2;
            } else {
                rowScopeInstance = rowScopeInstance2;
                modifierD = OffsetKt.d(RowScope.c(rowScopeInstance2, companion, 1.0f, false, 2, null), 0.0f, Dp.g(-l(state)), 1, null);
            }
            ImageKt.a(painterC, null, modifierD, null, contentScaleE, 0.0f, null, composer, 24624, 104);
            ImageKt.a(PainterResources_androidKt.c(R.drawable.Q, composer, 0), null, z2 ? OffsetKt.d(SizeKt.g(companion, 0.2f), 0.0f, Dp.g(-m(state2)), 1, null) : OffsetKt.d(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), 0.0f, Dp.g(-m(state2)), 1, null), null, companion4.e(), 0.0f, null, composer, 24624, 104);
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
    public static final Unit o(int i3, Composer composer, int i4) {
        k(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void p(Composer composer, final int i3) {
        Composer composerK = composer.k(-770984813);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-770984813, i3, -1, "cz.mobilesoft.coreblock.scene.more.guestpassshare.screens.RotatingCardContent (GuestPassShareContentComponents.kt:162)");
            }
            final State stateZ = z(composerK, 0);
            BoxWithConstraintsKt.a(SizeKt.f(Modifier.b8, 0.0f, 1, null), Alignment.f25072a.e(), false, ComposableLambdaKt.e(604928105, true, new Function3() { // from class: b1.k
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return GuestPassShareContentComponentsKt.r(stateZ, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 3126, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: b1.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GuestPassShareContentComponentsKt.s(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float q(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(State state, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(BoxWithConstraints) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(604928105, i4, -1, "cz.mobilesoft.coreblock.scene.more.guestpassshare.screens.RotatingCardContent.<anonymous> (GuestPassShareContentComponents.kt:169)");
            }
            boolean z2 = Dp.f(BoxWithConstraints.d(), Dp.g((float) 600)) >= 0;
            Painter painterC = PainterResources_androidKt.c(R.drawable.O, composer, 0);
            ContentScale.Companion companion = ContentScale.f27054a;
            ContentScale contentScaleE = companion.e();
            ColorFilter colorFilterC = ColorFilter.Companion.c(ColorFilter.f25730b, ComposeColorsKt.j(composer, 0).q(), 0, 2, null);
            Modifier.Companion companion2 = Modifier.b8;
            ImageKt.a(painterC, null, ScaleKt.a(RotateKt.a(OffsetKt.d(SizeKt.g(companion2, 1.0f), 0.0f, Dp.g(40), 1, null), q(state)), z2 ? 1.1f : 1.2f), null, contentScaleE, 0.0f, colorFilterC, composer, 24624, 40);
            ImageKt.a(PainterResources_androidKt.c(R.drawable.N, composer, 0), null, SizeKt.g(companion2, 0.6f), null, companion.e(), 0.0f, null, composer, 25008, 104);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(int i3, Composer composer, int i4) {
        p(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void t(Composer composer, final int i3) {
        Composer composerK = composer.k(34369895);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(34369895, i3, -1, "cz.mobilesoft.coreblock.scene.more.guestpassshare.screens.TagWithDiamondContent (GuestPassShareContentComponents.kt:99)");
            }
            final State stateY = y(composerK, 0);
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(companion, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.e(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
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
            Updater.e(composerA, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            BoxWithConstraintsKt.a(SizeKt.h(companion, 0.0f, 1, null), companion2.e(), false, ComposableLambdaKt.e(1367309635, true, new Function3() { // from class: b1.i
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return GuestPassShareContentComponentsKt.v(stateY, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 3126, 4);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: b1.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GuestPassShareContentComponentsKt.x(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float u(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(State state, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(BoxWithConstraints) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1367309635, i4, -1, "cz.mobilesoft.coreblock.scene.more.guestpassshare.screens.TagWithDiamondContent.<anonymous>.<anonymous> (GuestPassShareContentComponents.kt:110)");
            }
            float fD = BoxWithConstraints.d();
            float f3 = 480;
            float fG = Dp.f(fD, Dp.g(f3)) > 0 ? Dp.g(f3) : Dp.g(fD * 0.72f);
            float fG2 = Dp.g(280);
            float fG3 = Dp.g(370);
            final float fO = RangesKt.o(fG / fG2, 1.0f, 1.8f);
            float f4 = Dp.f(fD, Dp.g((float) 360)) < 0 ? 1.72f : 2.25f;
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierI = SizeKt.i(SizeKt.A(companion, fG2), fG3);
            boolean zC = composer.c(fO);
            Object objG = composer.G();
            if (zC || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: b1.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GuestPassShareContentComponentsKt.w(fO, (GraphicsLayerScope) obj);
                    }
                };
                composer.w(objG);
            }
            Modifier modifierA = GraphicsLayerModifierKt.a(modifierI, (Function1) objG);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierA);
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
            Painter painterC = PainterResources_androidKt.c(R.drawable.R, composer, 0);
            ContentScale.Companion companion4 = ContentScale.f27054a;
            ImageKt.a(painterC, null, OffsetKt.d(SizeKt.i(SizeKt.A(boxScopeInstance.f(companion, companion2.e()), Dp.g(fG2 * f4)), Dp.g(fG3 * 0.72f)), 0.0f, Dp.g(50), 1, null), null, companion4.b(), 0.0f, null, composer, 24624, 104);
            ImageKt.a(PainterResources_androidKt.c(R.drawable.Q, composer, 0), null, SizeKt.h(OffsetKt.d(boxScopeInstance.f(companion, companion2.e()), 0.0f, Dp.g(-u(state)), 1, null), 0.0f, 1, null), null, companion4.e(), 0.0f, null, composer, 24624, 104);
            float f5 = -40;
            ImageKt.a(PainterResources_androidKt.c(R.drawable.P, composer, 0), null, OffsetKt.c(SizeKt.v(boxScopeInstance.f(companion, companion2.c()), Dp.g(74)), Dp.g(f5), Dp.g(f5)), null, null, 0.0f, null, composer, 48, 120);
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
    public static final Unit w(float f3, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.e(f3);
        graphicsLayer.k(f3);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(int i3, Composer composer, int i4) {
        t(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final State y(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-129925823, i3, -1, "cz.mobilesoft.coreblock.scene.more.guestpassshare.screens.rememberActivateTagVerticalFloat (GuestPassShareContentComponents.kt:215)");
        }
        State stateA = InfiniteTransitionKt.a(InfiniteTransitionKt.c("GuestPassActivateTagVerticalTransition", composer, 6, 0), -8.0f, 12.0f, AnimationSpecKt.e(AnimationSpecKt.m(3900, 120, EasingKt.d()), RepeatMode.f4053b, 0L, 4, null), "GuestPassActivateTagVerticalFloat", composer, InfiniteTransition.f3967f | 24960 | (InfiniteRepeatableSpec.f3963d << 9), 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateA;
    }

    private static final State z(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(1656771986, i3, -1, "cz.mobilesoft.coreblock.scene.more.guestpassshare.screens.rememberCircleRotation (GuestPassShareContentComponents.kt:256)");
        }
        State stateA = InfiniteTransitionKt.a(InfiniteTransitionKt.c("GuestPassCircleRotation", composer, 6, 0), 0.0f, 360.0f, AnimationSpecKt.e(AnimationSpecKt.n(40000, 0, EasingKt.e(), 2, null), RepeatMode.f4052a, 0L, 4, null), "GuestPassCircleRotationValue", composer, InfiniteTransition.f3967f | 25008 | (InfiniteRepeatableSpec.f3963d << 9), 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateA;
    }
}
