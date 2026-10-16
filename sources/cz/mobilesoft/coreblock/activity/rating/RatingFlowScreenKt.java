package cz.mobilesoft.coreblock.activity.rating;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.compose.NavGraphBuilderKt;
import com.facebook.internal.FacebookRequestErrorClassification;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.activity.rating.RatingDialogActivity;
import cz.mobilesoft.coreblock.activity.rating.RatingFlowEvent;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.material3.CardsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarButtonType;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class RatingFlowScreenKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List f96135a = CollectionsKt.listOf((Object[]) new UserReview[]{new UserReview(R.string.Hr, "Penny HA"), new UserReview(R.string.Ir, "Saksham Sharma"), new UserReview(R.string.Jr, "Loreen Dawn Pal"), new UserReview(R.string.Kr, "Nicolás Rojas")});

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B(NavHostController navHostController, Function1 function1, String str, String str2, int i3, int i4, Composer composer, int i5) {
        u(navHostController, function1, str, str2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void C(final kotlin.jvm.functions.Function1 r19, java.lang.String r20, java.lang.String r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.activity.rating.RatingFlowScreenKt.C(kotlin.jvm.functions.Function1, java.lang.String, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(final Function1 function1, final RatingFlowPhase ratingFlowPhase, NavHostController navHostController, String str, String str2, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1446951085, i3, -1, "cz.mobilesoft.coreblock.activity.rating.RatingFlowContent.<anonymous> (RatingFlowScreen.kt:90)");
            }
            Modifier modifierD = WindowInsetsPaddingKt.d(SizeKt.f(Modifier.b8, 0.0f, 1, null), WindowInsets_androidKt.b(WindowInsets.f7172a, composer, 6));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierD);
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
            boolean Z = composer.Z(function1) | composer.e(ratingFlowPhase.ordinal());
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.activity.rating.x0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RatingFlowScreenKt.E(function1, ratingFlowPhase);
                    }
                };
                composer.w(objG);
            }
            ToolbarKt.e(null, (Function0) objG, null, false, ToolbarButtonType.Close, false, false, null, null, composer, 24576, FacebookRequestErrorClassification.ESC_APP_INACTIVE);
            u(navHostController, function1, str, str2, composer, 0, 0);
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
    public static final Unit E(Function1 function1, RatingFlowPhase ratingFlowPhase) {
        function1.invoke(new RatingFlowEvent.OnCloseClicked(ratingFlowPhase));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(Function1 function1, String str, String str2, int i3, int i4, Composer composer, int i5) {
        C(function1, str, str2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0619  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0624  */
    /* JADX WARN: Removed duplicated region for block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void G(java.lang.String r37, java.lang.String r38, final kotlin.jvm.functions.Function0 r39, androidx.compose.runtime.Composer r40, final int r41, final int r42) {
        /*
            Method dump skipped, instruction units count: 1587
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.activity.rating.RatingFlowScreenKt.G(java.lang.String, java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(MutableIntState mutableIntState, IntSize intSize) {
        mutableIntState.a((int) (intSize.j() & 4294967295L));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(MutableIntState mutableIntState, IntSize intSize) {
        mutableIntState.a((int) (intSize.j() & 4294967295L));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(String str, Composer composer, int i3) {
        Composer composer2 = composer;
        if (composer2.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-979666608, i3, -1, "cz.mobilesoft.coreblock.activity.rating.RatingOnboardingScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RatingFlowScreen.kt:283)");
            }
            if (str == null || !(!StringsKt.p0(str))) {
                composer2.a0(-957494990);
            } else {
                composer2.a0(-945027286);
                TextKt.c(str, null, ComposeColorsKt.j(composer2, 0).c0(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).i(), composer2, 0, 0, 65018);
                composer2 = composer2;
            }
            composer2.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(String str, Composer composer, int i3) {
        Composer composer2 = composer;
        if (composer2.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1599702097, i3, -1, "cz.mobilesoft.coreblock.activity.rating.RatingOnboardingScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RatingFlowScreen.kt:293)");
            }
            if (str == null || !(!StringsKt.p0(str))) {
                composer2.a0(-244799023);
            } else {
                composer2.a0(-231826205);
                TextKt.c(str, null, ComposeColorsKt.j(composer2, 0).b(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).i(), composer2, 0, 0, 65018);
                composer2 = composer2;
            }
            composer2.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(String str, String str2, Function0 function0, int i3, int i4, Composer composer, int i5) {
        G(str, str2, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(Function1 function1, Composer composer, final int i3) {
        final Function1 function12;
        Composer composerK = composer.k(467115312);
        int i4 = (i3 & 6) == 0 ? i3 | (composerK.I(function1) ? 4 : 2) : i3;
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(467115312, i4, -1, "cz.mobilesoft.coreblock.activity.rating.RatingReviewScreen (RatingFlowScreen.kt:334)");
            }
            ScrollState scrollStateC = ScrollKt.c(0, composerK, 0, 1);
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierD = SizeKt.d(companion, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            Alignment.Horizontal horizontalG = companion2.g();
            Arrangement arrangement = Arrangement.f6574a;
            MeasurePolicy measurePolicyA = ColumnKt.a(arrangement.h(), horizontalG, composerK, 48);
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
            Modifier modifierB = ColumnScope.b(ColumnScopeInstance.f6666a, companion, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierB);
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
            Updater.e(composerA2, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierG = ScrollKt.g(SizeKt.h(companion, 0.0f, 1, null), scrollStateC, false, null, false, 14, null);
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.h(), companion2.g(), composerK, 48);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierG);
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
            Updater.e(composerA3, modifierF3, companion3.f());
            float f3 = 16;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            Modifier modifierK = PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), 0.0f, 2, null);
            String strB = StringResources_androidKt.b(R.string.Lr, composerK, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composerK, 0).f();
            long jP = ComposeColorsKt.j(composerK, 0).p();
            TextAlign.Companion companion4 = TextAlign.f29616b;
            int i5 = i4;
            TextKt.c(strB, modifierK, jP, 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, textStyleF, composerK, 48, 0, 65016);
            float f4 = 12;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composerK, 6);
            TextKt.c(StringResources_androidKt.c(R.string.Gr, new Object[]{85}, composerK, 0), PaddingKt.k(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), 0.0f, 2, null), ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, TextAlign.h(companion4.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composerK, 48, 0, 65016);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composerK, 6);
            Modifier modifierE = SizeKt.E(PaddingKt.k(companion, Dp.g(f3), 0.0f, 2, null), null, false, 3, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.o(Dp.g(8)), companion2.i(), composerK, 54);
            int iA4 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU4 = composerK.u();
            Modifier modifierF4 = ComposedModifierKt.f(composerK, modifierE);
            Function0 function0A4 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A4);
            } else {
                composerK.v();
            }
            Composer composerA4 = Updater.a(composerK);
            Updater.e(composerA4, measurePolicyB, companion3.e());
            Updater.e(composerA4, compositionLocalMapU4, companion3.g());
            Function2 function2B4 = companion3.b();
            if (composerA4.i() || !Intrinsics.areEqual(composerA4.G(), Integer.valueOf(iA4))) {
                composerA4.w(Integer.valueOf(iA4));
                composerA4.p(Integer.valueOf(iA4), function2B4);
            }
            Updater.e(composerA4, modifierF4, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            IconKt.d(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.H8, composerK, 6), null, SizeKt.d(companion, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).p(), composerK, 432, 0);
            MeasurePolicy measurePolicyA3 = ColumnKt.a(arrangement.h(), companion2.g(), composerK, 48);
            int iA5 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU5 = composerK.u();
            Modifier modifierF5 = ComposedModifierKt.f(composerK, companion);
            Function0 function0A5 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A5);
            } else {
                composerK.v();
            }
            Composer composerA5 = Updater.a(composerK);
            Updater.e(composerA5, measurePolicyA3, companion3.e());
            Updater.e(composerA5, compositionLocalMapU5, companion3.g());
            Function2 function2B5 = companion3.b();
            if (composerA5.i() || !Intrinsics.areEqual(composerA5.G(), Integer.valueOf(iA5))) {
                composerA5.w(Integer.valueOf(iA5));
                composerA5.p(Integer.valueOf(iA5), function2B5);
            }
            Updater.e(composerA5, modifierF5, companion3.f());
            float f5 = 2;
            MeasurePolicy measurePolicyB2 = RowKt.b(arrangement.o(Dp.g(f5)), companion2.i(), composerK, 54);
            int iA6 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU6 = composerK.u();
            Modifier modifierF6 = ComposedModifierKt.f(composerK, companion);
            Function0 function0A6 = companion3.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A6);
            } else {
                composerK.v();
            }
            Composer composerA6 = Updater.a(composerK);
            Updater.e(composerA6, measurePolicyB2, companion3.e());
            Updater.e(composerA6, compositionLocalMapU6, companion3.g());
            Function2 function2B6 = companion3.b();
            if (composerA6.i() || !Intrinsics.areEqual(composerA6.G(), Integer.valueOf(iA6))) {
                composerA6.w(Integer.valueOf(iA6));
                composerA6.p(Integer.valueOf(iA6), function2B6);
            }
            Updater.e(composerA6, modifierF6, companion3.f());
            TextKt.c("4.7", null, ComposeColorsKt.j(composerK, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TextStyle.e(ComposeTypographyKt.g(composerK, 0).g(), 0L, TextUnitKt.i(22), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null), composerK, 6, 0, 65530);
            Composer composer2 = composerK;
            composer2.a0(-1856868770);
            for (int i6 = 0; i6 < 5; i6++) {
                Composer composer3 = composer2;
                ImageKt.a(PainterResources_androidKt.c(R.drawable.J8, composer2, 0), null, SizeKt.v(Modifier.b8, Dp.g(20)), null, null, 0.0f, null, composer3, 432, 120);
                composer2 = composer3;
            }
            composer2.U();
            composer2.y();
            Composer composer4 = composer2;
            TextKt.c(StringResources_androidKt.c(R.string.Dr, new Object[]{"230K"}, composer2, 0), null, ComposeColorsKt.j(composer2, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).a(), composer4, 0, 0, 65530);
            composer4.y();
            Modifier.Companion companion5 = Modifier.b8;
            IconKt.d(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.I8, composer4, 6), null, SizeKt.d(companion5, 0.0f, 1, null), ComposeColorsKt.j(composer4, 0).p(), composer4, 432, 0);
            composer4.y();
            float f6 = 32;
            SpacerKt.a(SizeKt.i(companion5, Dp.g(f6)), composer4, 6);
            Modifier modifierC = SizeKt.C(companion5, 0.0f, Dp.g(240), 1, null);
            String strB2 = StringResources_androidKt.b(R.string.Mr, composer4, 0);
            TextStyle textStyleH = ComposeTypographyKt.g(composer4, 0).h();
            long jP2 = ComposeColorsKt.j(composer4, 0).p();
            TextAlign.Companion companion6 = TextAlign.f29616b;
            TextKt.c(strB2, modifierC, jP2, 0L, null, null, null, 0L, null, TextAlign.h(companion6.a()), 0L, 0, false, 0, 0, null, textStyleH, composer4, 48, 0, 65016);
            SpacerKt.a(SizeKt.i(companion5, Dp.g(f3)), composer4, 6);
            ImageKt.a(PainterResources_androidKt.c(R.drawable.a8, composer4, 0), null, SizeKt.i(companion5, Dp.g(40)), null, null, 0.0f, null, composer4, 432, 120);
            SpacerKt.a(SizeKt.i(companion5, Dp.g(f5)), composer4, 6);
            TextKt.c(StringResources_androidKt.c(R.string.Cr, new Object[]{"15M"}, composer4, 0), PaddingKt.k(companion5, Dp.g(64), 0.0f, 2, null), ComposeColorsKt.j(composer4, 0).q(), 0L, null, null, null, 0L, null, TextAlign.h(companion6.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer4, 0).j(), composer4, 48, 0, 65016);
            composerK = composer4;
            SpacerKt.a(SizeKt.i(companion5, Dp.g(f6)), composerK, 6);
            composerK.a0(-755350261);
            Iterator it = f96135a.iterator();
            while (it.hasNext()) {
                Q((UserReview) it.next(), composerK, 0);
                SpacerKt.a(SizeKt.i(Modifier.b8, Dp.g(f3)), composerK, 6);
            }
            composerK.U();
            composerK.y();
            Modifier.Companion companion7 = Modifier.b8;
            BoxKt.a(BackgroundKt.b(SizeKt.i(SizeKt.h(boxScopeInstance.f(companion7, Alignment.f25072a.b()), 0.0f, 1, null), Dp.g(24)), Brush.Companion.m(Brush.Companion, CollectionsKt.listOf((Object[]) new Color[]{Color.n(Color.f25715b.j()), Color.n(ComposeColorsKt.j(composerK, 0).e())}), 0.0f, 0.0f, 0, 14, null), null, 0.0f, 6, null), composerK, 0);
            composerK.y();
            SpacerKt.a(SizeKt.i(companion7, Dp.g(f4)), composerK, 6);
            String strB3 = StringResources_androidKt.b(R.string.Nr, composerK, 0);
            int i7 = i5 & 14;
            boolean z2 = i7 == 4;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                function12 = function1;
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.activity.rating.u0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RatingFlowScreenKt.N(function12);
                    }
                };
                composerK.w(objG);
            } else {
                function12 = function1;
            }
            FlatButtonsKt.p(null, false, strB3, false, (Function0) objG, composerK, 3072, 3);
            SpacerKt.a(SizeKt.i(companion7, Dp.g(f3)), composerK, 6);
            String strB4 = StringResources_androidKt.b(R.string.xr, composerK, 0);
            FlatButtonColors.Secondary secondary = FlatButtonColors.Secondary.f131167a;
            boolean z3 = i7 == 4;
            Object objG2 = composerK.G();
            if (z3 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.activity.rating.f1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RatingFlowScreenKt.O(function12);
                    }
                };
                composerK.w(objG2);
            }
            FlatButtonsKt.p(secondary, false, strB4, false, (Function0) objG2, composerK, 3078, 2);
            SpacerKt.a(SizeKt.i(companion7, Dp.g(f4)), composerK, 6);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function12 = function1;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.activity.rating.g1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RatingFlowScreenKt.P(function12, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(Function1 function1) {
        function1.invoke(RatingFlowEvent.OnLoveItClicked.f96128a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(Function1 function1) {
        function1.invoke(RatingFlowEvent.OnRateNoClicked.f96129a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(Function1 function1, int i3, Composer composer, int i4) {
        M(function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void Q(final UserReview userReview, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-869722150);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(userReview) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-869722150, i4, -1, "cz.mobilesoft.coreblock.activity.rating.UserReviewCard (RatingFlowScreen.kt:508)");
            }
            CardsKt.k(PaddingKt.k(SizeKt.h(Modifier.b8, 0.0f, 1, null), Dp.g(16), 0.0f, 2, null), 0L, 0.0f, null, null, ComposableLambdaKt.e(-1195853635, true, new Function3() { // from class: cz.mobilesoft.coreblock.activity.rating.m1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RatingFlowScreenKt.R(userReview, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 221190, 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.activity.rating.n1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RatingFlowScreenKt.S(userReview, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(UserReview userReview, ColumnScope BaseCard, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1195853635, i3, -1, "cz.mobilesoft.coreblock.activity.rating.UserReviewCard.<anonymous> (RatingFlowScreen.kt:515)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierI = PaddingKt.i(companion, Dp.g(f3));
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement.o(Dp.g(12));
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalO, companion2.k(), composer, 6);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.o(Dp.g(-2)), companion2.i(), composer, 54);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, companion);
            Function0 function0A2 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A2);
            } else {
                composer.v();
            }
            Composer composerA2 = Updater.a(composer);
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            composer.a0(-1390162580);
            for (int i4 = 0; i4 < 5; i4++) {
                IconKt.c(PainterResources_androidKt.c(R.drawable.A5, composer, 0), null, SizeKt.v(Modifier.b8, Dp.g(f3)), ComposeColorsKt.j(composer, 0).b0(), composer, 432, 0);
            }
            composer.U();
            composer.y();
            TextKt.c(StringResources_androidKt.b(userReview.a(), composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65530);
            TextKt.c(userReview.b(), null, ComposeColorsKt.j(composer, 0).b(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).i(), composer, 0, 0, 65530);
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
    public static final Unit S(UserReview userReview, int i3, Composer composer, int i4) {
        Q(userReview, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void u(final androidx.navigation.NavHostController r18, final kotlin.jvm.functions.Function1 r19, java.lang.String r20, java.lang.String r21, androidx.compose.runtime.Composer r22, final int r23, final int r24) {
        /*
            Method dump skipped, instruction units count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.activity.rating.RatingFlowScreenKt.u(androidx.navigation.NavHostController, kotlin.jvm.functions.Function1, java.lang.String, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(final String str, final String str2, final NavHostController navHostController, final Function1 function1, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        NavGraphBuilderKt.c(NavHost, RatingDialogActivity.Companion.RatingFlowNavItem.RatingOnboarding.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1431015389, true, new Function4() { // from class: cz.mobilesoft.coreblock.activity.rating.a1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return RatingFlowScreenKt.w(str, str2, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        NavGraphBuilderKt.c(NavHost, RatingDialogActivity.Companion.RatingFlowNavItem.RatingReview.getRoute(), null, null, null, null, null, null, null, ComposableLambdaKt.c(-1179204212, true, new Function4() { // from class: cz.mobilesoft.coreblock.activity.rating.b1
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return RatingFlowScreenKt.z(function1, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(String str, String str2, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1431015389, i3, -1, "cz.mobilesoft.coreblock.activity.rating.NavigationHost.<anonymous>.<anonymous>.<anonymous> (RatingFlowScreen.kt:125)");
        }
        Object objG = composer.G();
        Composer.Companion companion = Composer.f23746a;
        if (objG == companion.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.activity.rating.d1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return RatingFlowScreenKt.x();
                }
            };
            composer.w(objG);
        }
        BackHandlerKt.a(false, (Function0) objG, composer, 48, 1);
        boolean zI = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI || objG2 == companion.a()) {
            objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.activity.rating.e1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return RatingFlowScreenKt.y(navHostController);
                }
            };
            composer.w(objG2);
        }
        G(str, str2, (Function0) objG2, composer, 0, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(NavHostController navHostController) {
        NavController.P(navHostController, RatingDialogActivity.Companion.RatingFlowNavItem.RatingReview.getRoute(), null, null, 6, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(Function1 function1, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(-1179204212, i3, -1, "cz.mobilesoft.coreblock.activity.rating.NavigationHost.<anonymous>.<anonymous>.<anonymous> (RatingFlowScreen.kt:138)");
        }
        Object objG = composer.G();
        if (objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.activity.rating.c1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return RatingFlowScreenKt.A();
                }
            };
            composer.w(objG);
        }
        BackHandlerKt.a(false, (Function0) objG, composer, 48, 1);
        M(function1, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }
}
