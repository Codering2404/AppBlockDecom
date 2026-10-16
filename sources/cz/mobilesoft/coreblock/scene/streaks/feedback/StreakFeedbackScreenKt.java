package cz.mobilesoft.coreblock.scene.streaks.feedback;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.TextFieldColors;
import androidx.compose.material.TextFieldDefaults;
import androidx.compose.material.TextKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackScreenKt;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewEvent;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackViewState;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeTextFieldsKt;
import cz.mobilesoft.coreblock.view.compose.ToolbarKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
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
public final class StreakFeedbackScreenKt {
    public static final void e(final PaddingValues paddingValues, final FeedbackViewState viewState, final Function1 onEvent, final Function0 onCloseClick, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(onCloseClick, "onCloseClick");
        Composer composerK = composer.k(755243324);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(viewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onEvent) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onCloseClick) ? 2048 : 1024;
        }
        int i5 = i4;
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(755243324, i5, -1, "cz.mobilesoft.coreblock.scene.streaks.feedback.StreakFeedbackScreen (StreakFeedbackScreen.kt:48)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierD = BackgroundKt.d(PaddingKt.h(SizeKt.f(companion, 0.0f, 1, null), paddingValues), ComposeColorsKt.j(composerK, 0).e(), null, 2, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierD);
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
            composerK.a0(1759521426);
            ToolbarKt.d(StringResources_androidKt.b(R.string.AB, composerK, 0), null, onCloseClick, composerK, (i5 >> 3) & 896, 2);
            if (viewState.k()) {
                composerK.a0(1759578465);
                Modifier modifierF2 = SizeKt.f(companion, 0.0f, 1, null);
                MeasurePolicy measurePolicyG = BoxKt.g(companion2.e(), false);
                int iA2 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU2 = composerK.u();
                Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierF2);
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
                Updater.e(composerA2, measurePolicyG, companion3.e());
                Updater.e(composerA2, compositionLocalMapU2, companion3.g());
                Function2 function2B2 = companion3.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF3, companion3.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                ProgressIndicatorKt.b(null, ComposeColorsKt.j(composerK, 0).b(), 0.0f, 0L, 0, composerK, 0, 29);
                composerK.y();
                composerK.U();
                composerK.U();
                composer2 = composerK;
            } else {
                composerK.a0(1757042448);
                composerK.U();
                float f3 = 16;
                Modifier modifierK = PaddingKt.k(ScrollKt.g(ColumnScope.b(columnScopeInstance, companion, 1.0f, false, 2, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null), Dp.g(f3), 0.0f, 2, null);
                MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.o(Dp.g(f3)), companion2.k(), composerK, 6);
                int iA3 = ComposablesKt.a(composerK, 0);
                CompositionLocalMap compositionLocalMapU3 = composerK.u();
                Modifier modifierF4 = ComposedModifierKt.f(composerK, modifierK);
                Function0 function0A3 = companion3.a();
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
                Updater.e(composerA3, measurePolicyA2, companion3.e());
                Updater.e(composerA3, compositionLocalMapU3, companion3.g());
                Function2 function2B3 = companion3.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF4, companion3.f());
                String strB = StringResources_androidKt.b(R.string.xC, composerK, 0);
                MaterialTheme materialTheme = MaterialTheme.f13091a;
                int i6 = MaterialTheme.f13092b;
                TextKt.c(strB, null, ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, materialTheme.c(composerK, i6).f(), composerK, 0, 0, 65530);
                TextKt.c(StringResources_androidKt.b(R.string.yC, composerK, 0), null, ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, materialTheme.c(composerK, i6).b(), composerK, 0, 0, 65530);
                String strI = viewState.i();
                Modifier modifierK2 = SizeKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(150), 0.0f, 2, null);
                RoundedCornerShape roundedCornerShapeD = RoundedCornerShapeKt.d(PrimitiveResources_androidKt.a(R.dimen.f95478l, composerK, 0));
                boolean zContains = viewState.n().contains(FeedbackViewState.FeedbackValidationError.MessageIsEmpty);
                TextStyle textStyleA = materialTheme.c(composerK, i6).a();
                PaddingValues paddingValuesA = PaddingKt.a(Dp.g(f3));
                TextFieldColors textFieldColorsO = TextFieldDefaults.f14636a.o(ComposeColorsKt.j(composerK, 0).p(), 0L, ComposeColorsKt.j(composerK, 0).l0(), ComposeColorsKt.j(composerK, 0).b(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerK, 0, 0, 48, 2097138);
                int i7 = i5 & 896;
                boolean z2 = i7 == 256;
                Object objG = composerK.G();
                if (z2 || objG == Composer.f23746a.a()) {
                    objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.streaks.feedback.o
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return StreakFeedbackScreenKt.f(onEvent, (String) obj);
                        }
                    };
                    composerK.w(objG);
                }
                ComposeTextFieldsKt.h(strI, (Function1) objG, modifierK2, false, false, false, textStyleA, null, ComposableSingletons$StreakFeedbackScreenKt.f120836a.k(), null, null, zContains, null, null, null, false, 0, null, roundedCornerShapeD, paddingValuesA, textFieldColorsO, 0L, 0.0f, 0.0f, composerK, 100860288, 805306368, 0, 14939800);
                Composer composer3 = composerK;
                if (viewState.c()) {
                    composer3.a0(1154804544);
                    boolean zContains2 = viewState.n().contains(FeedbackViewState.FeedbackValidationError.EmailIsInvalid);
                    String strF = viewState.f();
                    boolean z3 = i7 == 256;
                    Object objG2 = composer3.G();
                    if (z3 || objG2 == Composer.f23746a.a()) {
                        objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.streaks.feedback.p
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return StreakFeedbackScreenKt.g(onEvent, (String) obj);
                            }
                        };
                        composer3.w(objG2);
                    }
                    FeedbackScreenKt.f0(null, strF, (Function1) objG2, StringResources_androidKt.b(R.string.Rc, composer3, 0), zContains2, composer3, 0, 1);
                    composer3 = composer3;
                    if (zContains2) {
                        composer3.a0(1155388801);
                        TextKt.c(StringResources_androidKt.b(R.string.zd, composer3, 0), null, ComposeColorsKt.j(composer3, 0).k(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, materialTheme.c(composer3, i6).d(), composer3, 0, 0, 65530);
                        composer3 = composer3;
                    } else {
                        composer3.a0(1149900282);
                    }
                    composer3.U();
                } else {
                    composer3.a0(1149900282);
                }
                composer3.U();
                composer3.y();
                FlatButtonColors.Primary primary = FlatButtonColors.Primary.f131166a;
                String strB2 = StringResources_androidKt.b(R.string.Pv, composer3, 0);
                boolean z4 = i7 == 256;
                Object objG3 = composer3.G();
                if (z4 || objG3 == Composer.f23746a.a()) {
                    objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.streaks.feedback.q
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return StreakFeedbackScreenKt.h(onEvent);
                        }
                    };
                    composer3.w(objG3);
                }
                composer2 = composer3;
                FlatButtonsKt.p(primary, false, strB2, false, (Function0) objG3, composer2, 6, 10);
                composer2.U();
            }
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.streaks.feedback.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StreakFeedbackScreenKt.i(paddingValues, viewState, onEvent, onCloseClick, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new FeedbackViewEvent.OnMessageChanged(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new FeedbackViewEvent.OnEmailChanged(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(Function1 function1) {
        function1.invoke(FeedbackViewEvent.OnSendClicked.f102079a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(PaddingValues paddingValues, FeedbackViewState feedbackViewState, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        e(paddingValues, feedbackViewState, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
