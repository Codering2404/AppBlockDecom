package cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.components;

import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.components.PresetTimerButtonKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class PresetTimerButtonKt {
    public static final void h(Modifier modifier, final String text, final boolean z2, final Function0 onClick, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        Composer composer2;
        final Modifier modifier3;
        long jS;
        Function0 function0;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerK = composer.k(513179148);
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
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(text) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.b(z2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.I(onClick) ? 2048 : 1024;
        }
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            Modifier modifier4 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(513179148, i5, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.components.PresetTimeButton (PresetTimerButton.kt:32)");
            }
            Modifier modifierF = BorderKt.f(modifier4, Dp.g(1), ComposeColorsKt.j(composerK, 0).s(), RoundedCornerShapeKt.g());
            ButtonType.SmallRound smallRound = new ButtonType.SmallRound(null, null, text, null, false, 27, null);
            long j3 = Color.f25715b.j();
            if (z2) {
                composerK.a0(-756060008);
                jS = ComposeColorsKt.j(composerK, 0).p();
            } else {
                composerK.a0(-756059207);
                jS = ComposeColorsKt.j(composerK, 0).s();
            }
            composerK.U();
            ButtonColor.Custom custom = new ButtonColor.Custom(false, null, false, Color.n(j3), null, Color.n(jS), 19, null);
            if (z2) {
                composerK.a0(-1962894961);
                composerK.U();
                function0 = onClick;
            } else {
                composerK.a0(-1962850445);
                Object objG = composerK.G();
                if (objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: t0.p
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return PresetTimerButtonKt.i();
                        }
                    };
                    composerK.w(objG);
                }
                composerK.U();
                function0 = (Function0) objG;
            }
            composer2 = composerK;
            ComposeButtonsKt.i0(modifierF, smallRound, custom, function0, composer2, 0, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier3 = modifier4;
        } else {
            composer2 = composerK;
            composer2.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: t0.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PresetTimerButtonKt.j(modifier3, text, z2, onClick, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Modifier modifier, String str, boolean z2, Function0 function0, int i3, int i4, Composer composer, int i5) {
        h(modifier, str, z2, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void k(boolean z2, final Function1 onPresetSelected, Composer composer, final int i3) {
        int i4;
        final boolean z3 = z2;
        Intrinsics.checkNotNullParameter(onPresetSelected, "onPresetSelected");
        Composer composerK = composer.k(-1789164317);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onPresetSelected) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1789164317, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.components.PresetTimeButtonRow (PresetTimerButton.kt:61)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierB = ScrollKt.b(SizeKt.h(companion, 0.0f, 1, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null);
            Arrangement arrangement = Arrangement.f6574a;
            float f3 = 8;
            float fG = Dp.g(f3);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.p(fG, companion2.g()), companion2.i(), composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierB);
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            SpacerKt.a(SizeKt.A(companion, Dp.g(f3)), composerK, 6);
            int i5 = R.string.Nj;
            String strC = StringResources_androidKt.c(i5, new Object[]{5}, composerK, 0);
            int i6 = i4 & 112;
            boolean z4 = i6 == 32;
            Object objG = composerK.G();
            if (z4 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: t0.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PresetTimerButtonKt.l(onPresetSelected);
                    }
                };
                composerK.w(objG);
            }
            Function0 function0 = (Function0) objG;
            int i7 = (i4 << 6) & 896;
            h(null, strC, z3, function0, composerK, i7, 1);
            String strC2 = StringResources_androidKt.c(i5, new Object[]{10}, composerK, 0);
            boolean z5 = i6 == 32;
            Object objG2 = composerK.G();
            if (z5 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: t0.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PresetTimerButtonKt.m(onPresetSelected);
                    }
                };
                composerK.w(objG2);
            }
            h(null, strC2, z2, (Function0) objG2, composerK, i7, 1);
            String strC3 = StringResources_androidKt.c(i5, new Object[]{30}, composerK, 0);
            boolean z6 = i6 == 32;
            Object objG3 = composerK.G();
            if (z6 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: t0.m
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PresetTimerButtonKt.n(onPresetSelected);
                    }
                };
                composerK.w(objG3);
            }
            h(null, strC3, z2, (Function0) objG3, composerK, i7, 1);
            String strC4 = StringResources_androidKt.c(R.string.wk, new Object[]{1}, composerK, 0);
            boolean z7 = i6 == 32;
            Object objG4 = composerK.G();
            if (z7 || objG4 == Composer.f23746a.a()) {
                objG4 = new Function0() { // from class: t0.n
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PresetTimerButtonKt.o(onPresetSelected);
                    }
                };
                composerK.w(objG4);
            }
            z3 = z2;
            h(null, strC4, z3, (Function0) objG4, composerK, i7, 1);
            SpacerKt.a(SizeKt.A(companion, Dp.g(f3)), composerK, 6);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: t0.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PresetTimerButtonKt.p(z3, onPresetSelected, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Function1 function1) {
        function1.invoke(300000L);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Function1 function1) {
        function1.invoke(600000L);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Function1 function1) {
        function1.invoke(1800000L);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Function1 function1) {
        function1.invoke(3600000L);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(boolean z2, Function1 function1, int i3, Composer composer, int i4) {
        k(z2, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
