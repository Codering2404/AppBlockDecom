package cz.mobilesoft.coreblock.scene.subscriptionob;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableLongState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
public final class WelcomeScreenKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f122744a;

        static {
            int[] iArr = new int[ConfettiShape.values().length];
            try {
                iArr[ConfettiShape.RECTANGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ConfettiShape.CIRCLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f122744a = iArr;
        }
    }

    private static final void A(DrawScope drawScope, ConfettiParticle confettiParticle) {
        float fD = confettiParticle.d();
        long jC = confettiParticle.c();
        DrawContext drawContextQ1 = drawScope.Q1();
        long jB = drawContextQ1.b();
        drawContextQ1.g().t();
        try {
            drawContextQ1.e().j(fD, jC);
            int i3 = WhenMappings.f122744a[confettiParticle.e().ordinal()];
            if (i3 == 1) {
                long jB2 = confettiParticle.b();
                long jC2 = confettiParticle.c();
                float fM1 = drawScope.M1(confettiParticle.f());
                DrawScope.L1(drawScope, jB2, jC2, Size.d((((long) Float.floatToRawIntBits(drawScope.M1(confettiParticle.f()))) & 4294967295L) | (Float.floatToRawIntBits(fM1) << 32)), confettiParticle.a(), null, null, 0, 112, null);
            } else {
                if (i3 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                DrawScope.e2(drawScope, confettiParticle.b(), drawScope.M1(confettiParticle.f()) / 2, confettiParticle.c(), confettiParticle.a(), null, null, 0, 112, null);
            }
            drawContextQ1.g().k();
            drawContextQ1.h(jB);
        } catch (Throwable th) {
            drawContextQ1.g().k();
            drawContextQ1.h(jB);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:122:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void i(androidx.compose.ui.Modifier r25, int r26, java.util.List r27, java.util.List r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instruction units count: 645
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.subscriptionob.WelcomeScreenKt.i(androidx.compose.ui.Modifier, int, java.util.List, java.util.List, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final long j(MutableLongState mutableLongState) {
        return mutableLongState.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(MutableLongState mutableLongState, long j3) {
        mutableLongState.t(j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(SnapshotStateList snapshotStateList, CoroutineScope coroutineScope, MutableLongState mutableLongState, DrawScope Canvas) {
        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
        float fJ = (r0 - j(mutableLongState)) / 1.0E9f;
        k(mutableLongState, System.nanoTime());
        Iterator<T> it = snapshotStateList.iterator();
        while (it.hasNext()) {
            ConfettiParticle confettiParticle = (ConfettiParticle) it.next();
            confettiParticle.g(fJ, Canvas);
            A(Canvas, confettiParticle);
        }
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new WelcomeScreenKt$ConfettiAnimation$2$1$1$2(null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Modifier modifier, int i3, List list, List list2, int i4, int i5, Composer composer, int i6) {
        i(modifier, i3, list, list2, composer, RecomposeScopeImplKt.a(i4 | 1), i5);
        return Unit.f139807a;
    }

    public static final void n(Function0 onNavigateToNext, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(onNavigateToNext, "onNavigateToNext");
        Composer composerK = composer.k(-40030994);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onNavigateToNext) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-40030994, i4, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.NextButton (WelcomeScreen.kt:176)");
            }
            function0 = onNavigateToNext;
            ComposeButtonsKt.i0(null, new ButtonType.Big(null, null, StringResources_androidKt.b(R.string.Vi, composerK, 0), 0.0f, 11, null), new ButtonColor.Accent(false, null, false, null, 15, null), function0, composerK, (i4 << 9) & 7168, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onNavigateToNext;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.f1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WelcomeScreenKt.o(function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Function0 function0, int i3, Composer composer, int i4) {
        n(function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void p(Composer composer, final int i3) {
        Composer composerK = composer.k(1575817416);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1575817416, i3, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.PremiumDiamond (WelcomeScreen.kt:143)");
            }
            ImageKt.a(PainterResources_androidKt.c(R.drawable.G7, composerK, 0), null, null, null, null, 0.0f, null, composerK, 48, 124);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.h1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WelcomeScreenKt.q(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(int i3, Composer composer, int i4) {
        p(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void r(final String str, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        String strC;
        Composer composerK = composer.k(600071246);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(str) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(600071246, i4, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.PremiumText (WelcomeScreen.kt:153)");
            }
            Modifier.Companion companion = Modifier.b8;
            SpacerKt.a(SizeKt.i(companion, Dp.g(36)), composerK, 6);
            if (str == null) {
                composerK.a0(1068738702);
                composerK.U();
                strC = null;
            } else {
                composerK.a0(1068738703);
                strC = StringResources_androidKt.c(R.string.QG, new Object[]{str}, composerK, 0);
                composerK.U();
            }
            if (strC == null) {
                composerK.a0(1142856418);
                strC = StringResources_androidKt.b(R.string.PG, composerK, 0);
            } else {
                composerK.a0(1142853845);
            }
            composerK.U();
            TextStyle textStyleE = ComposeTypographyKt.g(composerK, 0).e();
            long jL = ComposeColorsKt.j(composerK, 0).L();
            TextAlign.Companion companion2 = TextAlign.f29616b;
            composer2 = composerK;
            TextKt.c(strC, null, jL, 0L, null, null, null, 0L, null, TextAlign.h(companion2.a()), 0L, 0, false, 0, 0, null, textStyleE, composer2, 0, 0, 65018);
            SpacerKt.a(SizeKt.i(companion, Dp.g(24)), composer2, 6);
            TextKt.c(StringResources_androidKt.b(R.string.kp, composer2, 0), null, ComposeColorsKt.j(composer2, 0).L(), 0L, null, null, null, 0L, null, TextAlign.h(companion2.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).a(), composer2, 0, 0, 65018);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.g1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WelcomeScreenKt.s(str, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(String str, int i3, Composer composer, int i4) {
        r(str, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void t(final String str, final Function0 onNavigateToNext, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(onNavigateToNext, "onNavigateToNext");
        Composer composerK = composer.k(966379920);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(str) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onNavigateToNext) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(966379920, i4, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.WelcomeScreen (WelcomeScreen.kt:60)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            MutableState mutableState = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            MutableState mutableState2 = (MutableState) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG3);
            }
            MutableState mutableState3 = (MutableState) objG3;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG4);
            }
            MutableState mutableState4 = (MutableState) objG4;
            Unit unit = Unit.f139807a;
            Object objG5 = composerK.G();
            if (objG5 == companion.a()) {
                objG5 = new WelcomeScreenKt$WelcomeScreen$1$1(mutableState, mutableState2, mutableState3, mutableState4, null);
                composerK.w(objG5);
            }
            EffectsKt.g(unit, (Function2) objG5, composerK, 6);
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
            boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
            EnterTransition enterTransitionO = EnterExitTransitionKt.o(AnimationSpecKt.n(1000, 0, null, 6, null), 0.0f, 2, null);
            ComposableSingletons$WelcomeScreenKt composableSingletons$WelcomeScreenKt = ComposableSingletons$WelcomeScreenKt.f122680a;
            AnimatedVisibilityKt.j(zBooleanValue, null, enterTransitionO, null, null, composableSingletons$WelcomeScreenKt.c(), composerK, 196992, 26);
            composerK = composerK;
            Modifier modifierI = PaddingKt.i(SizeKt.f(companion2, 0.0f, 1, null), Dp.g(16));
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), companion3.k(), composerK, 0);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierI);
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
            Updater.e(composerA2, modifierF3, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            SpacerKt.a(ColumnScope.b(columnScopeInstance, companion2, 2.0f, false, 2, null), composerK, 0);
            Modifier modifierF4 = SizeKt.f(ColumnScope.b(columnScopeInstance, companion2, 5.0f, false, 2, null), 0.0f, 1, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion3.g(), composerK, 54);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF5 = ComposedModifierKt.f(composerK, modifierF4);
            Function0 function0A3 = companion4.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A3);
            } else {
                composerK.v();
            }
            Composer composerA3 = Updater.a(composerK);
            Updater.e(composerA3, measurePolicyA2, companion4.e());
            Updater.e(composerA3, compositionLocalMapU3, companion4.g());
            Function2 function2B3 = companion4.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF5, companion4.f());
            AnimatedVisibilityKt.g(columnScopeInstance, ((Boolean) mutableState2.getValue()).booleanValue(), null, EnterExitTransitionKt.o(AnimationSpecKt.n(1500, 0, null, 6, null), 0.0f, 2, null), null, null, composableSingletons$WelcomeScreenKt.d(), composerK, 1575942, 26);
            AnimatedVisibilityKt.g(columnScopeInstance, ((Boolean) mutableState3.getValue()).booleanValue(), null, EnterExitTransitionKt.o(AnimationSpecKt.n(1500, 0, null, 6, null), 0.0f, 2, null), null, null, ComposableLambdaKt.e(2095318511, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.c1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return WelcomeScreenKt.u(str, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 1575942, 26);
            AnimatedVisibilityKt.g(columnScopeInstance, ((Boolean) mutableState4.getValue()).booleanValue(), null, EnterExitTransitionKt.o(AnimationSpecKt.n(1500, 0, null, 6, null), 0.0f, 2, null), null, null, ComposableLambdaKt.e(-1715011954, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.d1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return WelcomeScreenKt.v(onNavigateToNext, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 1575942, 26);
            composerK.y();
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.e1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WelcomeScreenKt.w(str, onNavigateToNext, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(String str, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(2095318511, i3, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.WelcomeScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WelcomeScreen.kt:117)");
        }
        Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
        MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
        int iA = ComposablesKt.a(composer, 0);
        CompositionLocalMap compositionLocalMapU = composer.u();
        Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
        ComposeUiNode.Companion companion = ComposeUiNode.f8;
        Function0 function0A = companion.a();
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
        Updater.e(composerA, measurePolicyA, companion.e());
        Updater.e(composerA, compositionLocalMapU, companion.g());
        Function2 function2B = companion.b();
        if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
            composerA.w(Integer.valueOf(iA));
            composerA.p(Integer.valueOf(iA), function2B);
        }
        Updater.e(composerA, modifierF, companion.f());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
        r(str, composer, 0);
        composer.y();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(Function0 function0, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        if (ComposerKt.M()) {
            ComposerKt.U(-1715011954, i3, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.WelcomeScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (WelcomeScreen.kt:129)");
        }
        Modifier.Companion companion = Modifier.b8;
        Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
        MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
        int iA = ComposablesKt.a(composer, 0);
        CompositionLocalMap compositionLocalMapU = composer.u();
        Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
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
        SpacerKt.a(ColumnScope.b(ColumnScopeInstance.f6666a, companion, 1.0f, false, 2, null), composer, 0);
        n(function0, composer, 0);
        composer.y();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(String str, Function0 function0, int i3, Composer composer, int i4) {
        t(str, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConfettiParticle z(List list, List list2, float f3, float f4) {
        Random.Default r02 = Random.f140182a;
        long jB = ((Color) CollectionsKt.random(list, r02)).B();
        ConfettiShape confettiShape = (ConfettiShape) CollectionsKt.random(list2, r02);
        float fH = r02.h() * f3;
        long jE = Offset.e((((long) Float.floatToRawIntBits((r02.h() * f4) / 3)) & 4294967295L) | (Float.floatToRawIntBits(fH) << 32));
        float fG = Dp.g(r02.k(4, 16));
        float f5 = 200;
        float fH2 = (r02.h() * f5) - 100;
        return new ConfettiParticle(jE, jB, fG, Offset.e((((long) Float.floatToRawIntBits((r02.h() * f5) + 300)) & 4294967295L) | (Float.floatToRawIntBits(fH2) << 32)), r02.h() * 360, (r02.h() * RCHTTPStatusCodes.BAD_REQUEST) - f5, 0.0f, confettiShape, 64, null);
    }
}
