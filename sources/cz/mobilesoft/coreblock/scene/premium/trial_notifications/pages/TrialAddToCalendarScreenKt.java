package cz.mobilesoft.coreblock.scene.premium.trial_notifications.pages;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
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
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.premium.trial_notifications.pages.TrialAddToCalendarScreenKt;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class TrialAddToCalendarScreenKt {
    public static final void c(final int i3, final boolean z2, final Function0 onAddToCalendarClicked, final Function0 onContinueClicked, Composer composer, final int i4) {
        int i5;
        int i6;
        Intrinsics.checkNotNullParameter(onAddToCalendarClicked, "onAddToCalendarClicked");
        Intrinsics.checkNotNullParameter(onContinueClicked, "onContinueClicked");
        Composer composerK = composer.k(45084976);
        if ((i4 & 6) == 0) {
            i5 = (composerK.e(i3) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.b(z2) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.I(onAddToCalendarClicked) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            i5 |= composerK.I(onContinueClicked) ? 2048 : 1024;
        }
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(45084976, i5, -1, "cz.mobilesoft.coreblock.scene.premium.trial_notifications.pages.TrialAddToCalendarScreen (TrialAddToCalendarScreen.kt:51)");
            }
            int i7 = i5;
            State stateA = InfiniteTransitionKt.a(InfiniteTransitionKt.c("infinite rotation", composerK, 6, 0), 360.0f, 0.0f, AnimationSpecKt.e(AnimationSpecKt.n(60000, 0, EasingKt.e(), 2, null), null, 0L, 6, null), "rotation", composerK, InfiniteTransition.f3967f | 25008 | (InfiniteRepeatableSpec.f3963d << 9), 0);
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierJ = PaddingKt.j(BackgroundKt.d(SizeKt.f(companion, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).e(), null, 2, null), Dp.g(f3), Dp.g(8));
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement.o(Dp.g(f3));
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalO, companion2.g(), composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierJ);
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
            Modifier modifierG = ScrollKt.g(ColumnScope.b(ColumnScopeInstance.f6666a, SizeKt.h(companion, 0.0f, 1, null), 1.0f, false, 2, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion2.g(), composerK, 54);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierG);
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
            Updater.e(composerA2, measurePolicyA2, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            String strC = StringResources_androidKt.c(R.string.JH, new Object[]{Integer.valueOf(i3)}, composerK, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composerK, 0).f();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            TextKt.c(strC, null, 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleF, composerK, 0, 0, 65022);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            TextKt.c(StringResources_androidKt.b(R.string.oE, composerK, 0), null, ComposeColorsKt.j(composerK, 0).L(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composerK, 0, 0, 65018);
            Composer composer2 = composerK;
            if (z2) {
                composer2.a0(1008817918);
                SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer2, 6);
                ButtonType.SmallRound smallRound = new ButtonType.SmallRound(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95561s0, composer2, 6), Color.n(ComposeColorsKt.j(composer2, 0).L()), StringResources_androidKt.b(R.string.T, composer2, 0), null, false, 24, null);
                ButtonColor.Surface surface = new ButtonColor.Surface(false, null, false, null, null, 31, null);
                i6 = i7;
                boolean z3 = (i6 & 896) == 256;
                Object objG = composer2.G();
                if (z3 || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: j1.f
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return TrialAddToCalendarScreenKt.e(onAddToCalendarClicked);
                        }
                    };
                    composer2.w(objG);
                }
                ComposeButtonsKt.i0(null, smallRound, surface, (Function0) objG, composer2, 0, 1);
                composer2 = composer2;
            } else {
                i6 = i7;
                composer2.a0(1004727902);
            }
            composer2.U();
            SpacerKt.a(SizeKt.i(companion, Dp.g(48)), composer2, 6);
            Modifier modifierB = AspectRatioKt.b(SizeKt.h(companion, 0.0f, 1, null), 1.0f, false, 2, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.e(), false);
            int iA3 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU3 = composer2.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer2, modifierB);
            Function0 function0A3 = companion3.a();
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
            Updater.e(composerA3, measurePolicyG, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierA = RotateKt.a(boxScopeInstance.f(SizeKt.h(companion, 0.0f, 1, null), companion2.e()), d(stateA));
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.mb, composer2, 6);
            ContentScale.Companion companion5 = ContentScale.f27054a;
            Composer composer3 = composer2;
            ImageKt.b(imageVectorB, null, modifierA, null, companion5.d(), 0.0f, ColorFilter.Companion.c(ColorFilter.f25730b, ComposeColorsKt.j(composer2, 0).P(), 0, 2, null), composer3, 24624, 40);
            ImageKt.a(PainterResources_androidKt.c(R.drawable.A8, composer3, 0), null, boxScopeInstance.f(SizeKt.c(companion, 0.75f), companion2.m()), null, companion5.e(), 0.0f, null, composer3, 24624, 104);
            composer3.y();
            composer3.y();
            TextKt.c(StringResources_androidKt.b(R.string.nE, composer3, 0), null, ComposeColorsKt.j(composer3, 0).P(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer3, 0).b(), composer3, 0, 0, 65018);
            composerK = composer3;
            ComposeButtonsKt.J(null, StringResources_androidKt.b(R.string.l8, composerK, 0), false, false, null, onContinueClicked, composerK, (458752 & (i6 << 6)) | 3072, 21);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: j1.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TrialAddToCalendarScreenKt.f(i3, z2, onAddToCalendarClicked, onContinueClicked, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float d(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(int i3, boolean z2, Function0 function0, Function0 function02, int i4, Composer composer, int i5) {
        c(i3, z2, function0, function02, composer, RecomposeScopeImplKt.a(i4 | 1));
        return Unit.f139807a;
    }
}
