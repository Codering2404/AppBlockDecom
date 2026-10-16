package cz.mobilesoft.coreblock.view.compose.slider;

import android.content.res.Configuration;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.slider.NumberedKeyboardButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

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
public final class NumberKeyboardKt {
    public static final void g(final int i3, final boolean z2, final Function1 onKeyboardButtonClicked, Composer composer, final int i4) {
        int i5;
        Intrinsics.checkNotNullParameter(onKeyboardButtonClicked, "onKeyboardButtonClicked");
        Composer composerK = composer.k(2019115396);
        if ((i4 & 6) == 0) {
            i5 = (composerK.e(i3) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.I(onKeyboardButtonClicked) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2019115396, i5, -1, "cz.mobilesoft.coreblock.view.compose.slider.KeyboardButton (NumberKeyboard.kt:95)");
            }
            Modifier modifierI = PaddingKt.i(Modifier.b8, Dp.g(8));
            ButtonType smallRound = z2 ? new ButtonType.SmallRound(null, null, String.valueOf(i3), null, false, 27, null) : new ButtonType.BigRound(null, null, String.valueOf(i3), 3, null);
            ButtonColor.Surface surface = new ButtonColor.Surface(false, null, false, null, null, 31, null);
            boolean z3 = ((i5 & 896) == 256) | ((i5 & 14) == 4);
            Object objG = composerK.G();
            if (z3 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.slider.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NumberKeyboardKt.h(onKeyboardButtonClicked, i3);
                    }
                };
                composerK.w(objG);
            }
            ComposeButtonsKt.i0(modifierI, smallRound, surface, (Function0) objG, composerK, 6, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.slider.j
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NumberKeyboardKt.i(i3, z2, onKeyboardButtonClicked, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Function1 function1, int i3) {
        function1.invoke(new NumberedKeyboardButton.Number(i3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(int i3, boolean z2, Function1 function1, int i4, Composer composer, int i5) {
        g(i3, z2, function1, composer, RecomposeScopeImplKt.a(i4 | 1));
        return Unit.f139807a;
    }

    public static final void j(final IntRange range, final boolean z2, final Function1 onKeyboardButtonClicked, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(range, "range");
        Intrinsics.checkNotNullParameter(onKeyboardButtonClicked, "onKeyboardButtonClicked");
        Composer composerK = composer.k(-1940686233);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(range) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onKeyboardButtonClicked) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1940686233, i4, -1, "cz.mobilesoft.coreblock.view.compose.slider.KeyboardRow (NumberKeyboard.kt:77)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.l(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
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
            SpacerKt.a(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), composerK, 0);
            composerK.a0(-1885573250);
            int iG = range.g();
            int iH = range.h();
            if (iG <= iH) {
                while (true) {
                    g(iG, z2, onKeyboardButtonClicked, composerK, i4 & 1008);
                    if (iG == iH) {
                        break;
                    } else {
                        iG++;
                    }
                }
            }
            composerK.U();
            SpacerKt.a(RowScope.c(rowScopeInstance, Modifier.b8, 1.0f, false, 2, null), composerK, 0);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.slider.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NumberKeyboardKt.k(range, z2, onKeyboardButtonClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(IntRange intRange, boolean z2, Function1 function1, int i3, Composer composer, int i4) {
        j(intRange, z2, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void l(boolean z2, final Function1 onKeyboardButtonClicked, Composer composer, final int i3, final int i4) {
        boolean z3;
        int i5;
        final boolean z4;
        int i6;
        int i7;
        ButtonType bigRound;
        Intrinsics.checkNotNullParameter(onKeyboardButtonClicked, "onKeyboardButtonClicked");
        Composer composerK = composer.k(1049553879);
        int i8 = i4 & 1;
        if (i8 != 0) {
            i5 = i3 | 6;
            z3 = z2;
        } else if ((i3 & 6) == 0) {
            z3 = z2;
            i5 = (composerK.b(z3) ? 4 : 2) | i3;
        } else {
            z3 = z2;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(onKeyboardButtonClicked) ? 32 : 16;
        }
        int i9 = i5;
        if (composerK.r((i9 & 19) != 18, i9 & 1)) {
            z4 = i8 != 0 ? false : z3;
            if (ComposerKt.M()) {
                ComposerKt.U(1049553879, i9, -1, "cz.mobilesoft.coreblock.view.compose.slider.NumberedKeyboard (NumberKeyboard.kt:25)");
            }
            boolean z5 = Dp.f(Dp.g((float) ((Configuration) composerK.q(AndroidCompositionLocals_androidKt.f())).screenHeightDp), Dp.g((float) 600)) < 0;
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalA = arrangement.a();
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalA, companion2.k(), composerK, 6);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierH);
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            int i10 = (i9 << 3) & 896;
            j(new IntRange(1, 3), z5, onKeyboardButtonClicked, composerK, i10);
            j(new IntRange(4, 6), z5, onKeyboardButtonClicked, composerK, i10);
            j(new IntRange(7, 9), z5, onKeyboardButtonClicked, composerK, i10);
            Modifier modifierH2 = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.l(), composerK, 0);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierH2);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            SpacerKt.a(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), composerK, 0);
            if (z4) {
                composerK.a0(-857640667);
                Modifier modifierI = PaddingKt.i(companion, Dp.g(8));
                ButtonType smallRound = z5 ? new ButtonType.SmallRound(null, null, "00", null, false, 27, null) : new ButtonType.BigRound(null, null, "00", 3, null);
                ButtonColor.Surface surface = new ButtonColor.Surface(false, null, false, null, null, 31, null);
                boolean z6 = (i9 & 112) == 32;
                Object objG = composerK.G();
                if (z6 || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.slider.e
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NumberKeyboardKt.m(onKeyboardButtonClicked);
                        }
                    };
                    composerK.w(objG);
                }
                i6 = 8;
                ComposeButtonsKt.i0(modifierI, smallRound, surface, (Function0) objG, composerK, 6, 0);
                composerK.U();
                i7 = 0;
            } else {
                i6 = 8;
                composerK.a0(-857229173);
                i7 = 0;
                SpacerKt.a(SizeKt.v(PaddingKt.i(companion, Dp.g(8)), Dp.g(z5 ? 46 : 72)), composerK, 0);
                composerK.U();
            }
            g(i7, z5, onKeyboardButtonClicked, composerK, i10 | 6);
            Modifier modifierI2 = PaddingKt.i(companion, Dp.g(i6));
            if (z5) {
                composerK.a0(1080741295);
                bigRound = new ButtonType.SmallRound(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.M0, composerK, 6), null, null, null, false, 30, null);
                composerK.U();
            } else {
                composerK.a0(1080745869);
                bigRound = new ButtonType.BigRound(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.M0, composerK, 6), null, null, 6, null);
                composerK.U();
            }
            ButtonType buttonType = bigRound;
            ButtonColor.Surface surface2 = new ButtonColor.Surface(false, null, false, null, null, 31, null);
            boolean z7 = (i9 & 112) == 32;
            Object objG2 = composerK.G();
            if (z7 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.view.compose.slider.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NumberKeyboardKt.n(onKeyboardButtonClicked);
                    }
                };
                composerK.w(objG2);
            }
            ComposeButtonsKt.i0(modifierI2, buttonType, surface2, (Function0) objG2, composerK, 6, 0);
            SpacerKt.a(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), composerK, 0);
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
            z4 = z3;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.view.compose.slider.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NumberKeyboardKt.o(z4, onKeyboardButtonClicked, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Function1 function1) {
        function1.invoke(NumberedKeyboardButton.DoubleZeroes.f132027a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Function1 function1) {
        function1.invoke(NumberedKeyboardButton.Backspace.f132026a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(boolean z2, Function1 function1, int i3, int i4, Composer composer, int i5) {
        l(z2, function1, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
